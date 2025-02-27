package com.aquaponics.server.domain.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * @author qht
 * @date 2025/2/25
 */
@Data
public class Fertilization {
    private Integer id;
    // 统计时间
    private String datetime;
    // 肥料名
    private String fertilizeName;
    // 总施肥量
    private Double sumWeight;
    // 计划施肥量
    private Double planWeight;
}