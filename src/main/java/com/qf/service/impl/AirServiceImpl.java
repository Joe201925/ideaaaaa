package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.bean.AirQualityIndex;
import com.qf.bean.District;
import com.qf.dao.AirQualityIndexMapper;
import com.qf.dao.DistrictMapper;
import com.qf.service.AirService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AirServiceImpl implements AirService {
    @Resource
    private AirQualityIndexMapper airQualityIndexMapper;

    @Resource
    private DistrictMapper districtMapper;

    @Override
    public PageInfo<AirQualityIndex> findall(int index, int size, Integer districtId) {

        PageHelper.startPage(index,size);

        Map map=new HashMap();
        map.put("districtId",districtId);

        List<AirQualityIndex> findall = airQualityIndexMapper.findall(map);
        PageInfo<AirQualityIndex> pageInfo=new PageInfo<>(findall);

        return pageInfo;
    }

    /**
     * 查询所有地区
     * @return
     */
    @Override
    public List<District> findDistricts() {
        List<District> districts = districtMapper.findall();
        if (districts!=null){
            return districts;
        }
        return null;
    }

    /**
     * 增加空气条目
     * @param airQualityIndex
     * @return
     */
    @Override
    public int addAir(AirQualityIndex airQualityIndex) {

        return airQualityIndexMapper.insert(airQualityIndex);
    }

    /**
     * 主键查询
     * @param id
     * @return
     */
    @Override
    public AirQualityIndex findbyid(Integer id) {

        return airQualityIndexMapper.selectByPrimaryKey(id);
    }

    /**
     * 修改实现
     * @param airQualityIndex
     * @return
     */
    @Override
    public int updateair(AirQualityIndex airQualityIndex) {
        return airQualityIndexMapper.updateByPrimaryKey(airQualityIndex);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public int deletebyid(Integer id) {

        return airQualityIndexMapper.deleteByPrimaryKey(id);
    }
}
