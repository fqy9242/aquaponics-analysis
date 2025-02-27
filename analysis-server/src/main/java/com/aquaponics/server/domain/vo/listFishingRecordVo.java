package com.aquaponics.server.domain.vo;

import lombok.Data;

/**
 * @author qht
 * @date 2025/2/21
 */
@Data
public class listFishingRecordVo {
    private String fishName;
    private Double weight;
    // 质量如何?(0不及格 1及格 2优秀)
    private String quality;
    // 捕捞时间
    private String fishingTime;
}