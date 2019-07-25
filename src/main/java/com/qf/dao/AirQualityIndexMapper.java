package com.qf.dao;

import com.qf.bean.AirQualityIndex;

import java.util.List;
import java.util.Map;

public interface AirQualityIndexMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AirQualityIndex record);

    int insertSelective(AirQualityIndex record);

    AirQualityIndex selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AirQualityIndex record);

    int updateByPrimaryKey(AirQualityIndex record);

    //查询所有空气情况
    List<AirQualityIndex> findall(Map map);
}