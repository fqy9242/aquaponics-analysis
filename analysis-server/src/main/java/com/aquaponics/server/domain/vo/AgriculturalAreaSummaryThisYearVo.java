package com.aquaponics.server.domain.vo;

import lombok.Data;

/**
 * @author qht
 * @date 2025/2/17
 */
@Data
public class AgriculturalAreaSummaryThisYearVo {
    // 今年总种植面积
    private Integer thisYearTotalCultivation;
    // 年同比
    private String yearOnYearCultivationRate;
    // 今年总养殖面积
    private Integer thisYearTotalBreeding;
    // 年同比
    private String yearOnYearBreedingRate;
}