package com.aquaponics.server.domain.vo;

import lombok.Data;


/**
 * @author qht
 * @date 2025/2/19
 */
@Data
public class HarvestVo {
    private String name;
    // 重量
    private Double weight;
    // 描述
    private String description;
    // 采摘时间
    private String harvestDataTime;
    // 采摘质量 不及格,及格,优秀
    private String harvestQuality;
}