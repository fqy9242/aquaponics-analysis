package com.aquaponics.server.service;


import com.aquaponics.server.domain.entity.AgricultureBaseInfo;
import com.aquaponics.server.domain.entity.DeviceWarning;
import com.aquaponics.server.domain.vo.*;

import java.util.List;

/**
 * @author qht
 * @date 2025/2/17
 */
public interface OverViewService {
    /**
     * 获取设备信息;
     * @return 包括总在线数,在线设备数,在线率
     */
    DeviceInfoVo deviceInfo();
    /**
     * 获取农业区域概况;
     * @return 包括种植面积,养殖面积
     */
    AgriculturalAreaSummaryVo agriculturalAreaSummary();
    /**
     * 获取今年农业区域概况;
     * @return 包括今年总种植面积,年同比,今年总养殖面积,年同比
     */
    AgriculturalAreaSummaryThisYearVo agriculturalAreaSummaryThisYear();

    /**
     *  获取种植地块分布热力值
     * @return
     */
    List<LandGeoHeatmapVo> getLandGeoHeatmap();
    /**
     * 获取鱼的养殖地块分布热力值
     * @return
     */

    List<FishPastureGeoHeatmapVo> getFishPastureGeoHeatmap();

    /**
     *  获取今年的采摘列表
     * @return
     */
    List<HarvestVo> listHarvest();

    /**
     *  获取总览词云数据
     * @return
     */
    List<WordCloudVo> getWordCloudData();

    /**
     * 获取鱼菜共生基地分布信息
     * @return
     */
    List<AgricultureBaseInfo> getBaseInfo();

    /**
     * 获取鱼菜共生运营基地信息
     */
    BaseInfoOverviewVo baseInfoOverview();

    /**
     *  获取设备告警信息
     * @return
     */
    List<DeviceWarning> getDeviceWarningInfoLimit300();
}
