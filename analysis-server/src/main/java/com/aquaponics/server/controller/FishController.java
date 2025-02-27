package com.aquaponics.server.controller;
import com.aquaponics.server.domain.vo.GetFishFeedGraphListVo;
import com.aquaponics.server.domain.vo.listFishingRecordVo;
import com.aquaponics.server.pojo.vo.ResultVO;
import com.aquaponics.server.service.FishService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author qht
 * @date 2025/2/21
 */
@RestController
@Slf4j
@Api(tags = "渔业模块")
@RequestMapping("/analysis/fish")
public class FishController {
    @Autowired
    private FishService fishService;
    /**
     * 获取饵料投喂统计图表数据
     */
    @GetMapping("/feedGraphData")
    @ApiOperation("获取饵料投喂统计图表数据")
    public ResultVO<GetFishFeedGraphListVo> feedList() {
        GetFishFeedGraphListVo vo = fishService.feedGraphData();
        return ResultVO.succeed(vo);
    }

    /**
     * 获取捕捞记录(最近100条)
     */
    @GetMapping("/listFishingRecord")
    @ApiOperation("获取捕捞记录")
    public ResultVO<List<listFishingRecordVo>> listFishingRecord() {
        List<listFishingRecordVo> list = fishService.listFishingRecord();
        return ResultVO.succeed(list);
    }
}