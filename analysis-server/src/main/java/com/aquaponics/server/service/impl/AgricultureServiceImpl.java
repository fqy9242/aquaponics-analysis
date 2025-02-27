package com.aquaponics.server.service.impl;

import com.aquaponics.server.constants.MessageConstant;
import com.aquaponics.server.domain.entity.Fertilization;
import com.aquaponics.server.domain.vo.*;
import com.aquaponics.server.mapper.AgricultureMapper;
import com.aquaponics.server.pojo.exception.BaseException;
import com.aquaponics.server.service.AgricultureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * @author qht
 * @date 2025/2/19
 */
@Service
public class AgricultureServiceImpl implements AgricultureService {
    @Autowired
    private AgricultureMapper agricultureMapper;

    /**
     * 获取优秀采摘率排名前十的农产品
     */
    @Override
    public AnalysisTop10GraphVo pickingExcellenceRateTop10() {
        // 从数据库中获取top10的数据 格式为 name value, name value
        List<AnalysisTop10Vo> list = agricultureMapper.pickingExcellenceRateTop10();
        // 检查list是否为null
        if (list == null) {
            throw new BaseException(MessageConstant.NO_STATISTICS_DATA);
        }
        List<String> names = new ArrayList<>();
        List<Double> values = new ArrayList<>();
        // 转换成前端需要的格式 格式为name1 name2... value1 value2...
        AnalysisTop10GraphVo vo = new AnalysisTop10GraphVo();
        list.forEach(obj -> {
            names.add(obj.getName());
            values.add(obj.getValue());
        });
        // 满足前端需求
/*        Collections.reverse(names);
        Collections.reverse(values);*/
        vo.setName(names);
        vo.setValue(values);
        return vo;
    }

    /**
     * 获取种植任务概览
     */
    @Override
    public GetPlantingTaskOverviewVo getPlantingTaskOverview(String batchId) {
        // 从数据库中获取种植任务概览
        GetPlantingTaskOverviewVo vo = agricultureMapper.getPlantingTaskOverview(batchId);
        // 检查vo是否为null
        if (vo == null) {
            throw new BaseException(MessageConstant.NO_STATISTICS_DATA);
        }
        return vo;
    }

    /**
     * 获取产量信息
     */
    @Override
    public List<YieldInfoVo> yieldInfo() {
        // 从数据库中获取产量信息
        List<YieldInfoVo> list = agricultureMapper.yieldInfo();
        return list;
    }

    /**
     * 获取过去七天施肥信息
     */
    @Override
    public List<Fertilization> getRecentSevenDaysFertilizationRecords() {
        return agricultureMapper.selectLimit7();
    }

    /**
     * 获取过去七天施肥信息图表数据
     */
    @Override
    public FertilizationGraphVo getRecentSevenDaysFertilizationRecordsGraph() {
        List<Fertilization> fertilizationList = getRecentSevenDaysFertilizationRecords();
        // 转换成图表展示需要的格式
        List<String> dataList = new ArrayList<>();
        List<Double> sumWightList = new ArrayList<>();
        List<Double> planWeightList = new ArrayList<>();
        List<String> finishingRateList = new ArrayList<>();
        fertilizationList.forEach(fertilization -> {
            dataList.add(fertilization.getDatetime().substring(5));
            sumWightList.add(fertilization.getSumWeight());
            planWeightList.add(fertilization.getPlanWeight());
            finishingRateList.add(NumberFormat.getPercentInstance().format(fertilization.getSumWeight() / fertilization.getPlanWeight()));
        });
        return FertilizationGraphVo.builder()
                .dateList(dataList)
                .sumWeightList(sumWightList)
                .planWeightList(planWeightList)
                .finishingRate(finishingRateList)
                .build();
    }
}