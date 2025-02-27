package com.aquaponics.server.controller;

import com.aquaponics.server.domain.entity.Fertilization;
import com.aquaponics.server.domain.vo.AnalysisTop10GraphVo;
import com.aquaponics.server.domain.vo.FertilizationGraphVo;
import com.aquaponics.server.domain.vo.GetPlantingTaskOverviewVo;
import com.aquaponics.server.domain.vo.YieldInfoVo;
import com.aquaponics.server.pojo.vo.ResultVO;
import com.aquaponics.server.service.AgricultureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author qht
 * @date 2025/2/19
 */
@RestController
@Slf4j
@Api(tags = "农业模块")
@RequestMapping("/analysis/agriculture")
public class AgricultureController {
    @Autowired
    private AgricultureService agricultureService;
    @GetMapping("/pickingExcellenceRateTop10")
    public ResultVO<AnalysisTop10GraphVo> pickingExcellenceRateTop10() {
        AnalysisTop10GraphVo list =  agricultureService.pickingExcellenceRateTop10();
        return ResultVO.succeed(list);
    }
    /**
     * 获取种植任务概览
     *
     * @return
     */
    @GetMapping("/getPlantingTaskOverview/{batchId}")
    public ResultVO<GetPlantingTaskOverviewVo> getPlantingTaskOverview(@PathVariable(required = false) String batchId) {
//        if (batchId == null) {
//            batchId  = "-1";
//        }
        GetPlantingTaskOverviewVo vo = agricultureService.getPlantingTaskOverview(batchId);
        return ResultVO.succeed(vo);
    }
    /**
     * 获取产量信息(目标产量以及实际产量)
     */
    @GetMapping("/yieldInfoALl")
    @ApiOperation("获取产量信息")
    public ResultVO<List<YieldInfoVo>> yieldInfo() {
        List<YieldInfoVo> list = agricultureService.yieldInfo();
        return ResultVO.succeed(list);
    }

    /**
     * 获取最近七日施肥情况
     */
    @ApiOperation("获取最近七日施肥情况")
    @GetMapping("/fertilizationLimit7")
    public ResultVO<List<Fertilization>> getRecentSevenDaysFertilizationRecords() {
        List<Fertilization> list = agricultureService.getRecentSevenDaysFertilizationRecords();
        return ResultVO.succeed(list);
    }

    /**
     * 获取最近七日施肥情况图表数据
     */
    @ApiOperation("获取最近七日施肥情况图表数据")
    @GetMapping("/fertilizationLimit7/graph")
    public ResultVO<FertilizationGraphVo> getRecentSevenDaysFertilizationRecordsGraph() {
        FertilizationGraphVo vo = agricultureService.getRecentSevenDaysFertilizationRecordsGraph();
        return ResultVO.succeed(vo);
    }
}