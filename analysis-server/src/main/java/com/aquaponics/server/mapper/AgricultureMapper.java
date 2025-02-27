package com.aquaponics.server.mapper;



import com.aquaponics.server.domain.entity.Fertilization;
import com.aquaponics.server.domain.vo.AnalysisTop10Vo;
import com.aquaponics.server.domain.vo.GetPlantingTaskOverviewVo;
import com.aquaponics.server.domain.vo.YieldInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author qht
 * @date 2025/2/19
 */
@Mapper
public interface AgricultureMapper {
    @Select("SELECT name, perfect_ratio AS value FROM pick_vegt WHERE perfect_ratio IS NOT NULL ORDER BY perfect_ratio DESC LIMIT 10;")
    List<AnalysisTop10Vo> pickingExcellenceRateTop10();
    /**
     * 获取种植任务概览
     *
     * @return
     */
    @Select("SELECT *, batch_sum As total_task FROM st_agriculture_batch_task WHERE batch_id = #{batchId} LIMIT 1;")
    GetPlantingTaskOverviewVo getPlantingTaskOverview(@Param("batchId") String batchId);
    /**
     * 获取产量信息(目标产量以及实际产量)
     */
    @Select("SELECT p_month AS month, num AS yield, target as targetYield FROM statistic")
    List<YieldInfoVo> yieldInfo();

    /**
     *  过去七天施肥信息
     * @return
     */
    @Select("SELECT id, everyday AS datetime, fertilize_name, sum_weight, expect_sum_weight AS plan_weight  FROM st_ia_feeding WHERE TIMESTAMPDIFF(DAY, everyday, CURDATE()) BETWEEN 0 AND 6")
    List<Fertilization> selectLimit7();
}
