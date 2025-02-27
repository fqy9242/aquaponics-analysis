package com.aquaponics.server.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author qht
 * @date 2025/2/21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FishFeed {
    // 月份
    private String month;
    // 饵料总投喂量
    private String feedTotal;
    // 饵料平均投喂量
    private String feedAverage;
}