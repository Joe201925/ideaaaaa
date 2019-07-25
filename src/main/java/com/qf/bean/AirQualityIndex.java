package com.qf.bean;

public class AirQualityIndex {
    private Integer id;

    private Integer districtId;

    private String monitorTime;

    private Integer pm10;

    private Integer pm2_5;

    private String monitoringStation;

    private String lastModifyTime;

    private District district;

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public String getMonitorTime() {
        return monitorTime;
    }

    public void setMonitorTime(String monitorTime) {
        this.monitorTime = monitorTime == null ? null : monitorTime.trim();
    }

    public Integer getPm10() {
        return pm10;
    }

    public void setPm10(Integer pm10) {
        this.pm10 = pm10;
    }

    public Integer getPm2_5() {
        return pm2_5;
    }

    public void setPm2_5(Integer pm2_5) {
        this.pm2_5 = pm2_5;
    }

    public String getMonitoringStation() {
        return monitoringStation;
    }

    public void setMonitoringStation(String monitoringStation) {
        this.monitoringStation = monitoringStation == null ? null : monitoringStation.trim();
    }

    public String getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(String lastModifyTime) {
        this.lastModifyTime = lastModifyTime == null ? null : lastModifyTime.trim();
    }
}