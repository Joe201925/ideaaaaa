package com.qf.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.bean.AirQualityIndex;
import com.qf.bean.District;

import java.util.List;

public interface AirService {

    PageInfo<AirQualityIndex> findall(int index, int size, Integer districtId);

    List<District> findDistricts();

    int addAir(AirQualityIndex airQualityIndex);

    AirQualityIndex findbyid(Integer id);

    int updateair(AirQualityIndex airQualityIndex);

    int deletebyid(Integer id);

}
