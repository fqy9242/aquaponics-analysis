package com.aquaponics.server.domain.entity;

import lombok.Data;

/**
 * @author qht
 * @date 2025/2/23
 */
@Data
public class AgricultureBaseInfo {
    // 主键
    private Integer id;
    // 城市
    private String city;
    // 数量
    private Integer cnt;
}