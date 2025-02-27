package com.aquaponics.server.domain.vo;

import lombok.Data;

/**
 * @author qht
 * @date 2025/2/17
 */
@Data
public class AgriculturalAreaSummaryVo {
    // 种植总面积
    private Double cultivationTotal;
    // 养殖总面积
    private Double breedingTotal;
}