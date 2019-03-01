package com.movebrick.elasticsearch.module.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class Esutil {
	public static TransportClient client;

	Esutil() throws Exception {
		try {
			client = clientsart();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	// client init
	public static TransportClient clientsart() throws Exception {
		Settings settings = Settings.builder().put("cluster.name", "cluster").put("client.transport.sniff", false)
				.build();
		// Add transport addresses and do something with the client...
		@SuppressWarnings("resource")
		TransportClient client = new PreBuiltTransportClient(settings)
				// http://172.18.251.122:9200
				//InetSocketTransportAddress
				.addTransportAddress(new TransportAddress(InetAddress.getByName("10.28.132.20"), 9300));
		// .addTransportAddress(new
		// InetSocketTransportAddress(InetAddress.getByName("172.18.251.122"), 9200));
		// on shutdown

		// client.close();
		return client;
	}

	/**
	 * 新建索引
	 * 
	 * @param index
	 * @param type
	 * @param map
	 * @return
	 */
	public static String addIndex(TransportClient client, String index, String type, HashMap<String, ?> map) {
		/*
		 * HashMap<String, Object> hashMap = new HashMap<String, Object>();
		 * hashMap.put("id", filedao.getFileid()); hashMap.put("title",
		 * filedao.getFileName()); hashMap.put("describe", filedao.getFileContent());
		 * hashMap.put("author", filedao.getFileType());
		 */
		IndexResponse response = null;
		try {
			response = client.prepareIndex(index, type).setSource(map).execute().actionGet();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response.getId();
	}

	/**
	 * 修改增加rowkey 和 列族
	 * 
	 * @param key
	 * @param index
	 * @param type
	 * @param start
	 * @param row
	 * @return
	 */
	public static Map<String, Object> search(TransportClient client, String key, String index, String type, int start,
			int row) {

		// 创建查询索引,要查询的索引库为index
		SearchRequestBuilder builder = client.prepareSearch(index);

		builder.setTypes(type);
		builder.setFrom(start);
		builder.setSize(row);

		// 设置查询类型：1.SearchType.DFS_QUERY_THEN_FETCH 精确查询； 2.SearchType.SCAN 扫描查询,无序
		builder.setSearchType(SearchType.DFS_QUERY_THEN_FETCH);
		//StringUtils.isNotBlank(key)
		if (!StringUtils.isEmpty(key)) {
			// 设置查询关键词所在的文件
			builder.setQuery(QueryBuilders.multiMatchQuery(key, "fileName", "fileContent"));
		}

		// 设置是否按查询匹配度排序
		builder.setExplain(true);

		// 设置高亮显示查询关键词
		HighlightBuilder highlightBuilder = new HighlightBuilder().field("*").requireFieldMatch(false);
		highlightBuilder.preTags("<span style=\"color:red\">");
		highlightBuilder.postTags("</span>");
		builder.highlighter(highlightBuilder);

		// 执行搜索,返回搜索响应信息
		SearchResponse searchResponse = builder.get();
		SearchHits searchHits = searchResponse.getHits();

		// 总命中数
		long total = searchHits.getTotalHits();
		Map<String, Object> map = new HashMap<String, Object>();
		SearchHit[] hits = searchHits.getHits();
		map.put("count", total);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (SearchHit hit : hits) {
			Map<String, HighlightField> highlightFields = hit.getHighlightFields();
			// 文档名回传
			HighlightField fileField = highlightFields.get("fileName");
			//Map<String, Object> source = hit.getSource();
			Map<String, Object> source = hit.getSourceAsMap();
			if (fileField != null) {
				Text[] fragments = fileField.fragments();
				String name = "";
				for (Text text : fragments) {
					name += text;
				}
				source.put("fileName", name);
			}
			// fileContent 文档内容回传
			HighlightField describeField = highlightFields.get("fileContent");
			if (describeField != null) {
				Text[] fragments = describeField.fragments();
				String describe = "";
				for (Text text : fragments) {
					describe += text;
				}
				source.put("fileContent", describe);
			}
			list.add(source);

		}
		map.put("dataList", list);
		return map;
	}

	public static void main(String[] args) {
//		Map<String, Object> search = Esutil.search("hbase", "tfjt", "doc", 0, 10);
//		List<Map<String, Object>> list = (List<Map<String, Object>>) search.get("dataList");
		try {
			// System.out.println(clientsart()+"连接成功");
			search(client, "TDH", "file", "fileType", 0, 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
