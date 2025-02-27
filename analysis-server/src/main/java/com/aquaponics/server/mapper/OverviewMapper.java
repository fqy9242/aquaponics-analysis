package com.aquaponics.server.mapper;
import com.aquaponics.server.domain.entity.AgricultureBaseInfo;
import com.aquaponics.server.domain.entity.DeviceWarning;
import com.aquaponics.server.domain.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * @author qht
 * @date 2025/2/17
 */

// TODO： 将一些能合并的查询语句合并
@Mapper
public interface OverviewMapper {
    /**
     * 获取设备信息;
     *
     * @return 包括总在线数, 在线设备数
     */
    @Select("SELECT COUNT(*) AS total_device, SUM(CASE WHEN status = 1 THEN 1 ELSE 0 END) AS online_device FROM device")
    DeviceInfoVo countDeviceInfo();

    /**
     *  获取总种植面积
     * @return
     */
    @Select("SELECT SUM(crop_area) FROM agriculture_crop_batch")
    Double sumCultivationArea();
    @Select("SELECT SUM(fish_pasture_area) FROM fish_pasture_batch")
    Double sumBreedingArea();
    // 根据年份获取种植总面积
    @Select("SELECT SUM(crop_area) FROM agriculture_crop_batch WHERE year(start_time) = #{year}")
    Integer sumCultivationAreaByYear(@Param("year") String year);
    // 根据年份获取养殖总面积
    @Select("SELECT SUM(fish_pasture_area) FROM fish_pasture_batch WHERE year(start_time) = #{year}")
    Integer sumBreedingAreaByYear(String s);
    // 获取种植地块分布热力值
    @Select("SELECT land_name, LON AS longitude, LAT AS latitude, (LON_LAT_cnt * 30000)  AS heatValue FROM alter_reform_agriculture_land")
    List<LandGeoHeatmapVo> getLandGeoHeatmapVo();
    // 获取鱼的养殖地块分布热力值
    @Select("SELECT name AS fishPastureName, longitude, latitude, (LON_LAT_cnt * 30000) AS heatValue FROM `alter_fish_pasture_lat_lng`")
    List<FishPastureGeoHeatmapVo> getFishPastureGeoHeatmapVo();
    @Select("SELECT name, weight, description, date AS harvestDataTime, CASE status WHEN 0 THEN '不及格' WHEN 1 THEN '及格' ELSE '优秀' END AS harvestQuality FROM ia_partition_food")
    List<HarvestVo> listHarvest();
    @Select("select name, cnt as count from word_cnt;")
    List<WordCloudVo> getWordCloudData();
    @Select("SELECT * FROM st_agriculture_baseinfo")
    List<AgricultureBaseInfo> selectAll();

    /**
     *  获取基地数量
     * @return
     */
    @Select("select  count(*) from st_agriculture_baseinfo")
    Integer countBase();
    @Select("SELECT * FROM warning_info LIMIT 100")
    List<DeviceWarning> SelectdeviceWarningInfoAll();
}
