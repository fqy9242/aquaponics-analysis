package com.aquaponics.server.domain.vo;

import lombok.Data;

/**
 * @author qht
 * @date 2025/2/20
 */
@Data
public class GetPlantingTaskOverviewVo {
    // 未分配占比
    private Double nonDistributeRatio;
    // 已分配占比
    private Double distributedRatio;
    // 进行中占比
    private Double actingRatio;
    // 已完成占比
    private Double finishRatio;
    // 未分配总数
    private Integer nonDistributeSum;
    // 已分配总数
    private Integer distributedSum;
    // 进行中总数
    private Integer actingSum;
    // 已完成总数
    private Integer finishSum;
    // 任务总数
    private Integer totalTask;
}