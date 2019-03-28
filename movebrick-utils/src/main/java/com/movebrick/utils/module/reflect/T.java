package com.movebrick.utils.module.reflect;

import java.lang.reflect.Field;
import java.util.List;

public class T {
	/**
	 * 转义
	 */
	public void translate(List<?> list) {
		list.forEach(obj -> {
			reflect(obj);
		});
	}
	
	public void reflect(Object obj) {
		{
			Field[] declaredFields = obj.getClass().getDeclaredFields();
			for (Field f : declaredFields) {
				f.setAccessible(true);
				// 获取属性的名字
				f.getName();
				// 获取属性类型
				String type = f.getGenericType().toString();
				//判断类型是否是对象
				if (type.contains("class com.model.bean"))
					try {
						reflect(f.get(obj));
					} catch (IllegalArgumentException | IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				if (type.contains(List.class.getName())) {
					try {
						List<?> dlist = (List<?>) f.get(obj);
						translate(dlist);
					} catch (IllegalArgumentException | IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				DicCode dica = f.getAnnotation(DicCode.class);
				// 扫描到字段带有注解标识
				if (dica != null) {
					try {
						String value = dica.value();
						Field field = obj.getClass().getDeclaredField(value);
						field.setAccessible(true);
						@SuppressWarnings("unused")
						String code = field.get(obj).toString();
						// 通过Key拿到字典对象
						TCommonDictionary dicByCode = null;// getDicByKey(code);
						f.set(obj, dicByCode != null ? dicByCode.getSITEMVALUE() : "");
					} catch (NoSuchFieldException | SecurityException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}

		}
	}
}
