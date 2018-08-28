package com.medishare.chicago.dao;

import com.medishare.chicago.domain.PatientRequest;
import com.medishare.chicago.domain.member.Patient;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.BooleanTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by liuy on 2018/3/31.
 */
@Component
public interface PatientDAO {



    @Select({
            "<script>" +
            "select " +
                    "oc.doctor_id as doctorId, " +
                    "md.realname as doctorName, " +
                    "md.username as doctorUserName, " +
                    "oc.patient_id as patientId, " +
                    "mp.realname as patientName, " +
                    "md.username as patientUserName, " +
                    "oc.id as orderId, " +
                    "gp.name as provinceName, " +
                    "gc.name as cityName, " +
                    "gd.name as districtName, " +
                    "gt.name as townName, " +
                    "gcomm.name as communityName, " +
                    "mp.address as patientAddress " +
                    "from order_contract oc " +
                    "left join member_patient mp on oc.patient_id = mp.id " +
                    "left join member_doctor md on oc.doctor_id = md.id " +
                    "left join `geo_province` gp on mp.`province_id` = gp.id " +
                    "left join `geo_city` gc on mp.`city_id` = gc.`id` " +
                    "left join `geo_district` gd on mp.`district_id` = gd.id " +
                    "left join `geo_town` gt on mp.`town_id` = gd.id " +
                    "left join `geo_community` gcomm on mp.`community_id` = gd.id " +
                    "where oc.disabled = '0' " +
                    "and oc.doctor_id in " +
                    "<foreach item='item' index='index' collection='doctorIds'", "open='(' separator=',' close=')'>", "#{item}",
                    "</foreach>"+
                    "order by oc.id desc limit 0, 10;" +
            "</script>"
    })
    List<PatientRequest> searchSignedPatientsByDoctor(@Param("doctorIds")List<String> doctorIds);



    @Select({
            "<script>" +
                    "select " +
                    "md.id as doctorId, " +
                    "md.realname as doctorName, " +
                    "md.username as doctorUserName, " +
                    "mp.id as patientId, " +
                    "mp.realname as patientName, " +
                    "md.username as patientUserName, " +
                    "sa.contract_id as orderId, " +
                    "gp.name as provinceName, " +
                    "gc.name as cityName, " +
                    "gd.name as districtName, " +
                    "gt.name as townName, " +
                    "gcomm.name as communityName, " +
                    "mp.address as patientAddress " +
                    "from sign_apply sa " +
                    "left join member_patient mp on sa.patient_id = mp.id " +
                    "left join member_doctor md on sa.doctor_id = md.id " +
                    "left join `geo_province` gp on mp.`province_id` = gp.id " +
                    "left join `geo_city` gc on mp.`city_id` = gc.`id` " +
                    "left join `geo_district` gd on mp.`district_id` = gd.id " +
                    "left join `geo_town` gt on mp.`town_id` = gd.id " +
                    "left join `geo_community` gcomm on mp.`community_id` = gd.id " +
                    "where 1=1 " +
                    "and sa.status = 4 " +
                    "and mp.id in " +
                    "<foreach item='item' index='index' collection='patientIds'", "open='(' separator=',' close=')'>", "#{item}",
                    "</foreach>"+
                    "order by mp.created desc limit 0, 10;" +
                    "</script>"
    })
    List<PatientRequest> searchSignedPatientsByPatient(@Param("patientIds")List<String> patientIds);

    @Results(value = { @Result(column = "province_id", property = "provinceId", javaType = String.class),
            @Result(column = "city_id", property = "cityId", javaType = String.class),
            @Result(column = "district_id", property = "districtId", javaType = String.class),
            @Result(column = "town_id", property = "townId", javaType = String.class),
            @Result(column = "community_id", property = "communityId", javaType = String.class),
            @Result(column = "username", property = "username", javaType = String.class),
            @Result(column = "realname", property = "realname", javaType = String.class),
//            @Result(column = "gender", property = "gender", javaType = String.class),
//            @Result(column = "mydesc", property = "description", javaType = String.class),
//            @Result(column = "portrait", property = "portrait", javaType = String.class),
//            @Result(column = "activeStatus", property = "activeStatus", javaType = String.class),
//            @Result(column = "phone", property = "phone", javaType = String.class),
//            @Result(column = "email", property = "email", javaType = String.class),
//            @Result(column = "created", property = "created", javaType = Date.class),
//            @Result(column = "updated", property = "updated", javaType = Date.class),
//            @Result(column = "disabled", property = "disabled", javaType = Boolean.class, jdbcType = JdbcType.VARCHAR, typeHandler = BooleanTypeHandler.class),
//            @Result(column = "birthday", property = "birthday", javaType = Date.class),
//            @Result(column = "source", property = "source", javaType = String.class),
//            @Result(column = "address", property = "address", javaType = String.class),
//            @Result(column = "passwd", property = "password", javaType = String.class),
//            @Result(column = "weight", property = "weight", javaType = String.class),
//            @Result(column = "height", property = "height", javaType = String.class),
//            @Result(column = "pwdsalt", property = "pwdsalt", javaType = String.class),
//            @Result(column = "nickname", property = "nickname", javaType = String.class),
//            @Result(column = "BMI", property = "BMI", javaType = String.class),
//            @Result(column = "id_card", property = "idCard", javaType = String.class),
//            @Result(column = "id_type", property = "idType", javaType = String.class),
//            @Result(column = "focus", property = "focusIds", typeHandler = MemoTypehandler.class),
//            @Result(column = "contract_id", property = "contractId", javaType = String.class),
//            @Result(column = "origin_name", property = "originName", javaType = String.class),
//            @Result(column = "full_address", property = "fullAddress", javaType = String.class),
//            @Result(column = "wyy_accid", property = "wyyAccid", javaType = String.class),
//            @Result(column = "wyy_pwd", property = "wyyPwd", javaType = String.class),
//            @Result(column = "medicare_card", property = "medicareCard", javaType = String.class)
    })
    @Select({ "select mp.* from member_patient mp where mp.id=#{id}" })
    Patient findPatientById(@Param("id") String id);

    @Results(value = { @Result(column = "province_id", property = "provinceId", javaType = String.class),
            @Result(column = "city_id", property = "cityId", javaType = String.class),
            @Result(column = "district_id", property = "districtId", javaType = String.class),
            @Result(column = "town_id", property = "townId", javaType = String.class),
            @Result(column = "community_id", property = "communityId", javaType = String.class),
            @Result(column = "username", property = "username", javaType = String.class),
            @Result(column = "realname", property = "realname", javaType = String.class),
    })
    @Select({"<script>","select * from member_patient_copy1 where medicare_card not in ('9') LIMIT 1;","</script>"})
//    @Select({"<script>","SELECT * FROM member_patient_copy1 WHERE id &gt;= ((SELECT MAX(id) FROM member_patient_copy1)-(SELECT MIN(id) FROM member_patient_copy1)) * RAND() + (SELECT MIN(id) FROM member_patient_copy1)  LIMIT 1","</script>"})
    Patient findPatientLimit1();


    @Insert({"<script>", "update member_patient_copy1 set updated = now() ",
            "<if test='provinceId != null'> , province_id = #{provinceId} </if>",
            "<if test='cityId != null'> , city_id = #{cityId} </if>",
            "<if test='districtId != null'> , district_id = #{districtId} </if>",
            "<if test='townId != null'> , town_id = #{townId} </if>",
            "<if test='communityId != null'> , community_id = #{communityId} </if>",
            "<if test='realname != null'> , realname = #{realname} </if>",
            "<if test='gender != null'> , gender = #{gender} </if>",
            "<if test='description != null'> , mydesc = #{description} </if>",
            "<if test='portrait != null'> , portrait = #{portrait} </if>",
            "<if test='activeStatus != null'> , active_status = #{activeStatus} </if>",
            "<if test='phone != null'> , phone = #{phone} </if>", "<if test='email != null'> , email = #{email} </if>",
            "<if test='disabled != null'> , disabled = #{disabled} </if>",
            "<if test='source != null'> , source = #{source} </if>",
            "<if test='birthday != null'> , birthday = #{birthday} </if>",
            "<if test='address != null'> , address = #{address} </if>",
            "<if test='nickname != null'> , nickname = #{nickname} </if>",
            "<if test='weight != null'> , weight = #{weight} </if>",
            "<if test='height != null'> , height = #{height} </if>",
            "<if test='BMI != null'> , BMI = #{BMI} </if>",
            "<if test='idCard != null'> , id_card = #{idCard} </if>",
            "<if test='idType != null'> , id_type = #{idType} </if>",
            "<if test='focusIds != null'> , focus = #{focusIds,typeHandler=com.medishare.whale.dao.finance.MemoTypehandler} </if>",
            "<if test='contractId != null'> , contract_id = #{contractId} </if>",
            "<if test='latitude != null'> , latitude = #{latitude} </if>",
            "<if test='openid != null'> , openid = #{openid} </if>",
            "<if test='unionid != null'> , unionid = #{unionid} </if>",
            "<if test='originName != null'> , origin_name = #{originName} </if>",
            "<if test='longitude != null'> , longitude = #{longitude} </if>",
            "<if test='medicareCard != null'> , medicare_card = #{medicareCard} </if>",
            "<if test='cardUrl != null'> , card_url = #{cardUrl} </if>",
            "<if test='cardUploadTime != null'> , card_upload_time = #{cardUploadTime} </if>",
            "<if test='photoAddr != null'> , photo_addr = #{photoAddr} </if>",
            "<if test='wyyAccid != null'> , wyy_accid = #{wyyAccid} </if>",
            "<if test='wyyPwd != null'> , wyy_pwd = #{wyyPwd} </if>",
            "where id = #{id}", "</script>"})
    int updatePatient(Patient doc);







}
