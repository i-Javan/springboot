package com.movebrick.hbase.controller;

import com.movebrick.hbase.domain.City;
import com.movebrick.hbase.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bysocket on 07/02/2017.
 */
@RestController
public class CityRestController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/api/city/save", method = RequestMethod.GET)
    public City save() {
        cityService.saveOrUpdate();
        City city = new City();
        city.setAge(1);
        return city;
    }

    @RequestMapping(value = "/api/city/get", method = RequestMethod.GET)
    public City getCity() {
        return cityService.query("135xxxxxx");
    }
}
