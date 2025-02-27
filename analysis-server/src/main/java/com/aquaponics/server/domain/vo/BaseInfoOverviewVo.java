package com.aquaponics.server.domain.vo;

import lombok.Builder;
import lombok.Data;

/**
 * @author qht
 * @date 2025/2/26
 */
@Data
@Builder
public class BaseInfoOverviewVo {
    // 基地数量
    private Integer baseNumber;
    // 运营天数
    private Integer operationDays;
    // 资源循环率
    private String resourceCycleRate;
}