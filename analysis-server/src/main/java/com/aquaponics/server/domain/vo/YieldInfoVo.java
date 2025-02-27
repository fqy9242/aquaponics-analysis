package com.aquaponics.server.domain.vo;

import lombok.Data;

/**
 * @author qht
 * @date 2025/2/20
 */
@Data
public class YieldInfoVo {
    // 月份
    private String month;
    // 目标产量
    private Double targetYield;
    // 实际产量
    private Double yield;

}