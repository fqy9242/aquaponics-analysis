package com.aquaponics.server.service.impl;

import com.aquaponics.server.domain.entity.FishFeed;
import com.aquaponics.server.domain.vo.GetFishFeedGraphListVo;
import com.aquaponics.server.domain.vo.listFishingRecordVo;
import com.aquaponics.server.mapper.FishMapper;
import com.aquaponics.server.service.FishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qht
 * @date 2025/2/21
 */
@Service
public class FishServiceImpl implements FishService {
    @Autowired
    private FishMapper fishMapper;
    /**
     * 获取饵料投喂量图表数据
     *
     * @return
     */
    @Override
    public GetFishFeedGraphListVo feedGraphData() {
        List<FishFeed> fishFeedList = fishMapper.getFishFeedList();
        // 转成成图表需要的数据格式
        List<String> monthList = new ArrayList<>();
        List<String> totalFeedList = new ArrayList<>();
        List<String> advFeedList = new ArrayList<>();
        fishFeedList.forEach(obj -> {
            monthList.add(obj.getMonth());
            totalFeedList.add(obj.getFeedTotal());
            advFeedList.add(obj.getFeedAverage());
        });

        return GetFishFeedGraphListVo.builder()
                .mouthList(monthList)
                .feedTotalList(totalFeedList)
                .feedAverageList(advFeedList)
                .build();
    }

    /**
     * 获取捕捞记录 (最近100条)
     *
     * @return
     */
    @Override
    public List<listFishingRecordVo> listFishingRecord() {
        List<listFishingRecordVo> list = fishMapper.listFishingRecordLimit100();
        return list;
    }
}