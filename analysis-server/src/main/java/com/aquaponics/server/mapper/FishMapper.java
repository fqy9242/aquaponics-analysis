package com.aquaponics.server.mapper;


import com.aquaponics.server.domain.entity.FishFeed;
import com.aquaponics.server.domain.vo.listFishingRecordVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author qht
 * @date 2025/2/21
 */
@Mapper
public interface FishMapper {
    /**
     * 获取饵料投喂量列表
     */
    @Select("SELECT every_date AS month, cur_sum AS feedTotal, cur_avg feedAverage FROM st_fish_cost_bait ORDER BY every_date\n")
    List<FishFeed> getFishFeedList();
    @Select("SELECT name AS fish_name, weight, " +
            "CASE status WHEN 0 THEN '不及格' WHEN 2 THEN '及格' ELSE '优秀' END AS quality," +
            "`date` AS fishing_time FROM fish_partition_food ORDER BY fishing_time DESC LIMIT 100 ")
    List<listFishingRecordVo> listFishingRecordLimit100();
}
