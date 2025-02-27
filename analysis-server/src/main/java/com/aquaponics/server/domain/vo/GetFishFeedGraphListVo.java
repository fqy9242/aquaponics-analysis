package com.aquaponics.server.domain.vo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author qht
 * @date 2025/2/21
 */
@Data
@Builder
public class GetFishFeedGraphListVo {
    // 月份列表
    private List<String> mouthList;
    // 饵料总投喂量列表
    private List<String> feedTotalList;
    // 饵料平均投喂量列表
    private List<String> feedAverageList;
}