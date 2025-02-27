package com.aquaponics.server.domain.vo;

import lombok.Builder;
import lombok.Data;
import java.util.List;

/**
 * @author qht
 * @date 2025/2/25
 */
@Data
@Builder
public class FertilizationGraphVo {
    private List<String> dateList;
    private List<Double> sumWeightList;
    private List<Double> planWeightList;
    // 完成率
    private List<String> finishingRate;
}