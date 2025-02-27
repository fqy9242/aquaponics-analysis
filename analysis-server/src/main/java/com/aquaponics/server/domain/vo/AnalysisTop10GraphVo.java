package com.aquaponics.server.domain.vo;

import lombok.Data;

import java.util.List;

/**
 * @author qht
 * @date 2025/2/19
 */
@Data
public class AnalysisTop10GraphVo {
    // 名称
    private List<String> name;
    // 值
    private List<Double> value;
}