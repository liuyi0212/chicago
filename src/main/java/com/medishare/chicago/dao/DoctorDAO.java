package com.medishare.chicago.dao;

import com.medishare.chicago.domain.Doctor;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.BooleanTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

/**
 * Created by liuy on 2018/3/31.
 */
public interface DoctorDAO {

    @Results(value = { @Result(column = "province_id", property = "provinceId", javaType = String.class),
            @Result(column = "city_id", property = "cityId", javaType = String.class),
            @Result(column = "district_id", property = "districtId", javaType = String.class),
            @Result(column = "town_id", property = "townId", javaType = String.class),
            @Result(column = "community_id", property = "communityId", javaType = String.class),
            @Result(column = "username", property = "username", javaType = String.class),
            @Result(column = "realname", property = "realname", javaType = String.class),
            @Result(column = "gender", property = "gender", javaType = String.class),
            @Result(column = "mydesc", property = "description", javaType = String.class),
            @Result(column = "portrait", property = "portrait", javaType = String.class),
            @Result(column = "activeStatus", property = "activeStatus", javaType = String.class),
            @Result(column = "phone", property = "phone", javaType = String.class),
            @Result(column = "email", property = "email", javaType = String.class),
            @Result(column = "created", property = "created", javaType = Date.class),
            @Result(column = "updated", property = "updated", javaType = Date.class),
            @Result(column = "disabled", property = "disabled", javaType = Boolean.class, jdbcType = JdbcType.VARCHAR, typeHandler = BooleanTypeHandler.class),
            @Result(column = "birthday", property = "birthday", javaType = Date.class),
            @Result(column = "source", property = "source", javaType = String.class),
            @Result(column = "address", property = "address", javaType = String.class),
            @Result(column = "passwd", property = "password", javaType = String.class),
            @Result(column = "pwdsalt", property = "pwdsalt", javaType = String.class),
            @Result(column = "hospital_id", property = "hospitalId", javaType = String.class),
            @Result(column = "hospital_name", property = "hospitalName", javaType = String.class),
            @Result(column = "level", property = "hospitalLevel", javaType = String.class),
            @Result(column = "dept_id", property = "departmentId", javaType = String.class),
            @Result(column = "departmentname", property = "departmentName", javaType = String.class),
            @Result(column = "title_type", property = "titleType", javaType = String.class),
            @Result(column = "doctor_type", property = "doctorType", javaType = String.class),
            @Result(column = "certified", property = "certifiedDate", javaType = Date.class),
            @Result(column = "certified_link", property = "certifies", typeHandler = MemoTypehandler.class),
            @Result(column = "specialty", property = "specialtyIds", typeHandler = MemoTypehandler.class),
            @Result(column = "in_serve", property = "inService", typeHandler = BooleanTypeHandler.class) })
    @Select({ "<script>",
            "select md.*, gh.level as level, gh.name as hospital_name,  gd.name as departmentname from member_doctor md, geo_department gd ,geo_hospital gh where md.dept_id = gd.id and md.hospital_id=gh.id  and  md.id in ",
            "<if test='ids != null'> <foreach item='item' index='index' collection='ids'", "open='(' separator=',' close=')'>", "#{item}",
            "</foreach></if>", "</script>" })
    List<Doctor> findDoctorsByIds(@Param("ids") String[] ids);

    @Select({ "<script>",
            "select id from member_doctor where province_id=2"
            , "</script>" })
    List<String> findDoctors();


}
