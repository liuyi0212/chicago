package com.medishare.chicago.dao;

import com.medishare.chicago.domain.member.Doctor;
import com.medishare.chicago.domain.request.DoctorRequest;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by liuy on 2018/3/31.
 */
@Component
public interface DoctorDAO {

    @Results(value = {@Result(column = "provinceId", property = "provinceId", javaType = String.class),
            @Result(column = "cityId", property = "cityId", javaType = String.class),
            @Result(column = "cityName", property = "cityName", javaType = String.class),
            @Result(column = "districtId", property = "districtId", javaType = String.class),
            @Result(column = "districtName", property = "districtName", javaType = String.class),
            @Result(column = "townId", property = "townId", javaType = String.class),
            @Result(column = "townName", property = "townName", javaType = String.class),
            @Result(column = "communityId", property = "communityId", javaType = String.class),
            @Result(column = "communityName", property = "communityName", javaType = String.class),
            @Result(column = "hospitalId", property = "hospitalId", javaType = String.class),
            @Result(column = "hospitalName", property = "hospitalName", javaType = String.class),
            @Result(column = "username", property = "userName", javaType = String.class),
            @Result(column = "realname", property = "realName", javaType = String.class),

            })
    @Select({"<script>",
            "select md.id, " +
                    "md.username, " +
                    "md.realname, " +
                    "md.portrait, " +
                    "gp.id as provinceId, " +
                    "gp.name as provinceName, " +
                    "gc.id as cityId, " +
                    "gc.name as cityName, " +
                    "gd.id as districtId, " +
                    "gd.name as districtName, " +
                    "gt.id as townId, " +
                    "gt.name as townName, " +
                    "gcomm.id as communityId, " +
                    "gcomm.name as communityName, " +
                    "gh.id as hospitalId, " +
                    "gh.name as hospitalName " +
                    "from member_doctor md " +
                    "left join `geo_province` gp on md.`province_id` = gp.id " +
                    "left join `geo_city` gc on md.`city_id` = gc.`id` " +
                    "left join `geo_district` gd on md.`district_id` = gd.id " +
                    "left join `geo_town` gt on md.`town_id` = gd.id " +
                    "left join `geo_community` gcomm on md.`community_id` = gd.id " +
                    "left join `geo_hospital` gh on md.`hospital_id` = gh.id " +
                    "where md.certified is not null and ( md.disabled = 0 or md.disabled is null) and md.doctor_flag is null " +
                    "<if test=\"doctorRequest.provinceId != null and doctorRequest.provinceId != '' \">and md.province_id = #{doctorRequest.provinceId} </if>" +
                    "<if test=\"doctorRequest.cityId != null and doctorRequest.cityId != '' \">and md.city_id = #{doctorRequest.cityId} </if>" +
                    "<if test=\"doctorRequest.districtId != null and doctorRequest.districtId != '' \">and md.district_id = #{doctorRequest.districtId} </if>" +
                    "<if test=\"doctorRequest.townId != null and doctorRequest.townId != '' \">and md.town_id = #{doctorRequest.townId} </if>" +
                    "<if test=\"doctorRequest.communityId != null and doctorRequest.communityId != '' \">and md.community_id = #{doctorRequest.communityId} </if>" +
                    "<if test=\"doctorRequest.hospitalId != null and doctorRequest.hospitalId != '' \">and md.hospital_id = #{doctorRequest.hospitalId} </if>" +
                    "order by md.id desc limit #{start}, #{limit}" +
            "</script>"})
    List<DoctorRequest> findDoctorList(@Param("doctorRequest") DoctorRequest doctorRequest, @Param("start") int start, @Param("limit") int limit);


    @Select({"<script>",
            "select count(*) " +
                    "from member_doctor md " +
                    "left join `geo_province` gp on md.`province_id` = gp.id " +
                    "left join `geo_city` gc on md.`city_id` = gc.`id` " +
                    "left join `geo_district` gd on md.`district_id` = gd.id " +
                    "left join `geo_town` gt on md.`town_id` = gd.id " +
                    "left join `geo_community` gcomm on md.`community_id` = gd.id " +
                    "left join `geo_hospital` gh on md.`hospital_id` = gh.id " +
                    "where md.certified is not null and ( md.disabled = 0 or md.disabled is null) and md.doctor_flag is null " +
                    "<if test=\"doctorRequest.provinceId != null and doctorRequest.provinceId != '' \">and md.province_id = #{doctorRequest.provinceId} </if>" +
                    "<if test=\"doctorRequest.cityId != null and doctorRequest.cityId != '' \">and md.city_id = #{doctorRequest.cityId} </if>" +
                    "<if test=\"doctorRequest.districtId != null and doctorRequest.districtId != '' \">and md.district_id = #{doctorRequest.districtId} </if>" +
                    "<if test=\"doctorRequest.townId != null and doctorRequest.townId != '' \">and md.town_id = #{doctorRequest.townId} </if>" +
                    "<if test=\"doctorRequest.communityId != null and doctorRequest.communityId != '' \">and md.community_id = #{doctorRequest.communityId} </if>" +
                    "<if test=\"doctorRequest.hospitalId != null and doctorRequest.hospitalId != '' \">and md.hospital_id = #{doctorRequest.hospitalId} </if>" +
                    "</script>"})
    int findDoctorListCount(@Param("doctorRequest") DoctorRequest doctorRequest);

//            "select md.*, gh.level as level, gh.name as hospital_name,  gd.name as departmentname from member_doctor md, geo_department gd ,geo_hospital gh where md.dept_id = gd.id and md.hospital_id=gh.id  and  md.id in ",
//            "<foreach item='item' index='index' collection='ids'", "open='(' separator=',' close=')'>", "#{item}",
//            "</foreach>",
//            List<Doctor> findDoctorsByIds(@Param("ids") String[] ids);


    @SelectProvider(type=DoctorDynaSqlProvider.class, method="selectDoctorCount")
    int finDoctorCount(@Param("ids") String[] ids);
}
