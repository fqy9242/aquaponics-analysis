package com.aquaponics.server.domain.vo;

import lombok.Data;

/**
 * @author qht
 * @date 2025/2/17
 */
@Data
public class DeviceInfoVo {
    // 总设备数
    private Integer totalDevice;
    // 在线设备数
    private Integer onlineDevice;
    // 在线率
    private String onlineRate;
}