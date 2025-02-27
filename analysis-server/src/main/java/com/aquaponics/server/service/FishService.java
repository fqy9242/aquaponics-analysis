package com.aquaponics.server.service;


import com.aquaponics.server.domain.vo.GetFishFeedGraphListVo;
import com.aquaponics.server.domain.vo.listFishingRecordVo;

import java.util.List;

/**
 * @author qht
 * @date 2025/2/21
 */
public interface FishService {
    /**
     * 获取饵料投喂量图表数据
     * @return
     */
    GetFishFeedGraphListVo feedGraphData();
    /**
     * 获取捕捞记录 (最近100条)
     * @return
     */
    List<listFishingRecordVo> listFishingRecord();
}
