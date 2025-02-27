package com.aquaponics.server.domain.vo;

import lombok.Data;

/** 养殖鱼棚地理分布热力值的vo
 * @author qht
 * @date 2025/2/18
 */
@Data

public class FishPastureGeoHeatmapVo {
    // 鱼棚名
    private String fishPastureName;
    // 经度
    private Double longitude;
    // 纬度
    private Double latitude;
    // 热力值
    private Integer heatValue;
}