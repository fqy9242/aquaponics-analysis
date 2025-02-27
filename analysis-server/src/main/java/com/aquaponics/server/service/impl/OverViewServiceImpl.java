package com.aquaponics.server.service.impl;

import com.aquaponics.server.domain.entity.AgricultureBaseInfo;
import com.aquaponics.server.domain.entity.DeviceWarning;
import com.aquaponics.server.domain.vo.*;
import com.aquaponics.server.mapper.OverviewMapper;
import com.aquaponics.server.service.OverViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * @author qht
 * @date 2025/2/17
 */
@Service
public class OverViewServiceImpl implements OverViewService {
    @Autowired
    private OverviewMapper overviewMapper;

    /**
     * 获取设备信息;
     *
     * @return 包括总在线数, 在线设备数, 在线率
     */
    @Override
    public DeviceInfoVo deviceInfo() {
        DeviceInfoVo deviceInfoVo = overviewMapper.countDeviceInfo();
        // 计算在线率
        deviceInfoVo.setOnlineRate(String.format("%.2f", (float) deviceInfoVo.getOnlineDevice() / deviceInfoVo.getTotalDevice() * 100) + "%");
        return deviceInfoVo;
    }

    /**
     * 获取农业区域概况;
     *
     * @return 包括种植面积, 养殖面积
     */
     @Override
    public AgriculturalAreaSummaryVo agriculturalAreaSummary() {
        AgriculturalAreaSummaryVo vo = new AgriculturalAreaSummaryVo();
        vo.setCultivationTotal(overviewMapper.sumCultivationArea());
        vo.setBreedingTotal(overviewMapper.sumBreedingArea());
        return vo;
    }

    /**
     * 获取今年农业区域概况;
     *
     * @return 包括今年总种植面积, 年同比, 今年总养殖面积, 年同比
     */
    @Override
    public AgriculturalAreaSummaryThisYearVo agriculturalAreaSummaryThisYear() {
        // 获取今年的种植总面积
        Integer thisYearTotalCultivation = overviewMapper.sumCultivationAreaByYear(String.valueOf(LocalDate.now().getYear()));
        // 获取去年的种植总面积
        Integer lastYearTotalCultivation = overviewMapper.sumCultivationAreaByYear(String.valueOf(LocalDate.now().getYear() - 1));
        String yearOnYearCultivationRate;
        // 如果去年的种植总面积为0，那么年同比为0
        if (lastYearTotalCultivation == null) {
            yearOnYearCultivationRate = "0.00%";
        } else {
            // 计算种植面积年同比
            yearOnYearCultivationRate = String.format("%.2f", (float) (thisYearTotalCultivation - lastYearTotalCultivation) / lastYearTotalCultivation * 100) + "%";
        }
        // 获取去年的养殖总面积
        Integer lastYearTotalBreeding = overviewMapper.sumBreedingAreaByYear(String.valueOf(LocalDate.now().getYear() - 1));
        // 获取今年的养殖总面积
        Integer thisYearTotalBreeding = overviewMapper.sumBreedingAreaByYear(String.valueOf(LocalDate.now().getYear()));
        // 如果去年的养殖总面积为0，那么年同比为0
        String yearOnYearBreedingRate;
        if (lastYearTotalBreeding == null) {
            yearOnYearBreedingRate = "0.00%";
        } else {
            // 计算养殖面积年同比
            yearOnYearBreedingRate = String.format("%.2f", (float) (thisYearTotalBreeding - lastYearTotalBreeding) / lastYearTotalBreeding * 100) + "%";
        }
        // 创建一个VO对象
        AgriculturalAreaSummaryThisYearVo vo = new AgriculturalAreaSummaryThisYearVo();
        vo.setThisYearTotalCultivation(thisYearTotalCultivation);
        vo.setYearOnYearCultivationRate(yearOnYearCultivationRate);
        vo.setThisYearTotalBreeding(thisYearTotalBreeding);
        vo.setYearOnYearBreedingRate(yearOnYearBreedingRate);
        return vo;
    }

    /**
     * 获取种植地块分布热力值
     *
     * @return
     */
    @Override
    public List<LandGeoHeatmapVo> getLandGeoHeatmap() {
        List<LandGeoHeatmapVo> list = overviewMapper.getLandGeoHeatmapVo();
        return list;
    }

    /**
     * 获取鱼的养殖地块分布热力值
     *
     * @return
     */
    @Override
    public List<FishPastureGeoHeatmapVo> getFishPastureGeoHeatmap() {
        List<FishPastureGeoHeatmapVo> list = overviewMapper.getFishPastureGeoHeatmapVo();
        return list;
    }

    /**
     * 获取今年的采摘列表
     *
     * @return
     */
    @Override
    public List<HarvestVo> listHarvest() {
        List<HarvestVo> list = overviewMapper.listHarvest();
        return list;
    }
    /**
     * 获取总览词云数据
     *
     * @return
     */
    @Override
    public List<WordCloudVo> getWordCloudData() {
        List<WordCloudVo> list = overviewMapper.getWordCloudData();
        return list;
    }

    /**
     * 获取鱼菜共生基地分布信息
     *
     * @return
     */
    @Override
    public List<AgricultureBaseInfo> getBaseInfo() {
        return overviewMapper.selectAll();
    }

    /**
     * 获取鱼菜共生运营基地信息
     */
    @Override
    public BaseInfoOverviewVo baseInfoOverview() {
        // 获取基地数量
        Integer baseNumber = overviewMapper.countBase();
        // 获取运营天数
        // 从2024-9-10开始算
        LocalDate startDate = LocalDate.of(2024, 9, 10);
        LocalDate currentDate = LocalDate.now();
        int operationDays = (int)ChronoUnit.DAYS.between(startDate, currentDate);
        // 资源循环率
        String resourceCycleRate = "90%";
        return BaseInfoOverviewVo.builder()
                .baseNumber(baseNumber)
                .operationDays(operationDays)
                .resourceCycleRate(resourceCycleRate)
                .build();
    }

    /**
     * 获取设备告警信息
     *
     * @return
     */
    @Override
    public List<DeviceWarning> getDeviceWarningInfoLimit300() {
        return overviewMapper.SelectdeviceWarningInfoAll();
    }
}