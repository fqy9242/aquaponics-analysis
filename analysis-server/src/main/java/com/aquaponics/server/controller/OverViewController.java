package com.aquaponics.server.controller;

import com.aquaponics.server.domain.entity.AgricultureBaseInfo;
import com.aquaponics.server.domain.entity.DeviceWarning;
import com.aquaponics.server.domain.vo.*;
import com.aquaponics.server.pojo.vo.ResultVO;
import com.aquaponics.server.service.OverViewService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/** 可视化大屏所需要的纵览信息
 * @author qht
 * @date 2025/2/17
 */
@RestController
@Slf4j
@Api(tags = "总览信息")
@RequestMapping("/analysis/overview")
// TODO 加上缓存 为了保持数据的实时性 在其他模块种对应增删改的方法更新缓存
public class OverViewController {
    @Autowired
    private OverViewService overViewService;
    /**
     * 获取设备信息
     *
     * @return 设备信息
     */
    @ApiOperation("设备信息")
//    @Cacheable(value = "deviceInfo", key = "'deviceInfo'")
    @GetMapping("/deviceInfo")
    public ResultVO<DeviceInfoVo> deviceInfo() {
//        log.info("设备信息");
        DeviceInfoVo deviceInfoVo = overViewService.deviceInfo();
        return ResultVO.succeed(deviceInfoVo);
    }
    /**
     * 获取种植总面积和养殖总面积
     *
     * @return 农业区域概况
     */
    @ApiOperation("种植总面积和养殖总面积")
    @GetMapping("/agriculturalAreaSummary")
    public ResultVO<AgriculturalAreaSummaryVo>getAgriculturalAreaSummary() {
        AgriculturalAreaSummaryVo vo = overViewService.agriculturalAreaSummary();
        return ResultVO.succeed(vo);
    }
    @ApiOperation("今年农业区域概况")
    @GetMapping("/agriculturalAreaSummaryThisYear")
    public ResultVO<AgriculturalAreaSummaryThisYearVo> getAgriculturalAreaSummaryThisYear() {
        AgriculturalAreaSummaryThisYearVo vo = overViewService.agriculturalAreaSummaryThisYear();
        return ResultVO.succeed(vo);
    }

    /**
     * 获取种植地块分布热力值
     */
    @ApiOperation("获取种植面积地理分布")
    @GetMapping("/landGeoHeatmap")
    public ResultVO<List<LandGeoHeatmapVo>> landGeoHeatmap() {
        List<LandGeoHeatmapVo> list = overViewService.getLandGeoHeatmap();
        return ResultVO.succeed(list);
    }
    /**
     * 获取养殖地块分布热力值
     */
    @ApiOperation("获取鱼的养殖位置热力值分布")
    @GetMapping("/fishPastureGeoHeatmap")
    public ResultVO<List<FishPastureGeoHeatmapVo>> fishPastureGeoHeatmap() {
        List<FishPastureGeoHeatmapVo>list = overViewService.getFishPastureGeoHeatmap();
        return ResultVO.succeed(list);
    }

    /**
     *  获取采摘列表
     * @return
     */
    @ApiOperation("获取种植采摘列表")
    @GetMapping("/harvestList")
    public ResultVO<List<HarvestVo>> listHarvest() {
        List<HarvestVo> list = overViewService.listHarvest();
        return ResultVO.succeed(list);
    }

    /**
     * 获取总览词云
     * @return
     */
    @GetMapping("/wordCloud")
    @ApiOperation("获取总览词云")
    public ResultVO<List<WordCloudVo>> getWordCloud() {
        List<WordCloudVo> list = overViewService.getWordCloudData();
        return ResultVO.succeed(list);
    }

    /**
     *  获取鱼菜共生基地分布信息
     */
    @GetMapping("/baseInfo")
    @ApiOperation("获取鱼菜共生基地分布信息")
    public ResultVO<List<AgricultureBaseInfo>> baseInfo() {
        List<AgricultureBaseInfo> list = overViewService.getBaseInfo();
        return ResultVO.succeed(list);
    }

    /**
     * 获取鱼菜共生运营基地信息
     */
    @ApiOperation("获取鱼菜共生运营基地信息")
    @GetMapping("/baseInfoOverview")
    public ResultVO<BaseInfoOverviewVo> baseInfoOverview() {
        BaseInfoOverviewVo vo = overViewService.baseInfoOverview();
        return ResultVO.succeed(vo);
    }

    /**
     * 获取设备异常预警
     */
    @ApiOperation("获取设备异常预警")
    @GetMapping("/deviceWarningInfo")
    public ResultVO<List<DeviceWarning>> deviceWarningInfo() {
        List<DeviceWarning> list = overViewService.getDeviceWarningInfoLimit300();
        return ResultVO.succeed(list);
    }







}