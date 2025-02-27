package com.aquaponics.server.service;


import com.aquaponics.server.domain.entity.Fertilization;
import com.aquaponics.server.domain.vo.AnalysisTop10GraphVo;
import com.aquaponics.server.domain.vo.FertilizationGraphVo;
import com.aquaponics.server.domain.vo.GetPlantingTaskOverviewVo;
import com.aquaponics.server.domain.vo.YieldInfoVo;

import java.util.List;

/**
 * @author qht
 * @date 2025/2/19
 */
public interface AgricultureService {
    /**
     * 获取优秀采摘率排名前十的农产品
     * @return
     */
    AnalysisTop10GraphVo pickingExcellenceRateTop10();

    /**
     *  获取种植任务概览
     * @return
     */
    GetPlantingTaskOverviewVo getPlantingTaskOverview(String batchId);

    /**
     *  获取产量信息
     * @return
     */
    List<YieldInfoVo> yieldInfo();

    /**
     *  获取过去七天施肥信息
     * @return
     */
    List<Fertilization> getRecentSevenDaysFertilizationRecords();
    /**
     *  获取过去七天施肥信息图表数据
     * @return
     */
    FertilizationGraphVo getRecentSevenDaysFertilizationRecordsGraph();
}
