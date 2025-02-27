package com.aquaponics.server.domain.vo;

import lombok.Data;

/** 获取种植地块，养殖鱼棚地理分布热力值的vo
 * @author qht
 * @date 2025/2/18
 */
@Data

public class LandGeoHeatmapVo {
    // 地块名
    private String landName;
    // 经度
    private Double longitude;
    // 纬度
    private Double latitude;
    // 热力值
    private Integer heatValue;
}