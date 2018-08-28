package com.medishare.chicago.dao;

import com.medishare.chicago.domain.member.Doctor;
import com.medishare.chicago.domain.request.DoctorRequest;
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
                    "from member_doctor_copy1 md " +
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
                    "from member_doctor_copy1 md " +
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

    @Results(value = { @Result(column = "province_id", property = "provinceId", javaType = String.class),
            @Result(column = "city_id", property = "cityId", javaType = String.class),
            @Result(column = "district_id", property = "districtId", javaType = String.class),
            @Result(column = "town_id", property = "townId", javaType = String.class),
            @Result(column = "community_id", property = "communityId", javaType = String.class),
            @Result(column = "username", property = "username", javaType = String.class),
            @Result(column = "realname", property = "realname", javaType = String.class),
            @Result(column = "gender", property = "gender", javaType = String.class),
//            @Result(column = "mydesc", property = "description", javaType = String.class),
//            @Result(column = "portrait", property = "portrait", javaType = String.class),
//            @Result(column = "check_portrait", property = "checkPortrait", javaType = String.class),
//            @Result(column = "personal_page_background_img", property = "personalPageBackgroundImg", javaType = String.class),
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
//            @Result(column = "pwdsalt", property = "pwdsalt", javaType = String.class),
//            @Result(column = "hospital_id", property = "hospitalId", javaType = String.class),
//            @Result(column = "hospital_name", property = "hospitalName", javaType = String.class),
//            @Result(column = "dept_id", property = "departmentId", javaType = String.class),
//            @Result(column = "title_type", property = "titleType", javaType = String.class),
//            @Result(column = "doctor_type", property = "doctorType", javaType = String.class),
//            @Result(column = "certified", property = "certifiedDate", javaType = Date.class),
//            @Result(column = "star", property = "star", javaType = String.class),
//            @Result(column = "certified_link_bak", property = "certifiesBak", typeHandler = MemoTypehandler.class),
//            @Result(column = "certified_link", property = "certifies", typeHandler = MemoTypehandler.class),
//            @Result(column = "specialty", property = "specialtyIds", typeHandler = MemoTypehandler.class),
//            @Result(column = "in_serve", property = "inService", typeHandler = BooleanTypeHandler.class),
//            @Result(column = "pro_time", property = "proTime", javaType = String.class),
//            @Result(column = "formal_doctor_no", property = "formalDoctor", javaType = String.class),
//            @Result(column = "education", property = "education", javaType = String.class),
//            @Result(column = "career_time", property = "careerTime", javaType = String.class),
//            @Result(column = "card_url", property = "cardUrl", javaType = String.class),
//            @Result(column = "vocational_area", property = "vocationalArea", javaType = String.class),
//            @Result(column = "token", property = "token", javaType = String.class),
//            @Result(column = "hospital_level", property = "hospitalLevel", javaType = String.class),
//            @Result(column = "school_id", property = "schoolId", javaType = String.class),
//            @Result(column = "latitude", property = "latitude", javaType = Double.class),
//            @Result(column = "longitude", property = "longitude", javaType = Double.class),
//            @Result(column = "id_card", property = "idCard", javaType = String.class),
//            @Result(column = "post", property = "post", javaType = String.class),
//            @Result(column = "clinic_operation_flag", property = "clinicOperationFlag", javaType = String.class),
//            @Result(column = "medical_org", property = "medicalOrg", javaType = String.class),
//            @Result(column = "wx_qrcode", property = "wxQrcode", javaType = String.class),
//            @Result(column = "medical_org_grade", property = "medicalOrgGrade", javaType = String.class),
//            @Result(column = "practice_place", property = "practicePlace", javaType = String.class),
//            @Result(column = "practice_category", property = "practiceCategory", typeHandler = MemoTypehandler.class),
//            @Result(column = "practice_scope", property = "practiceScope", typeHandler = MemoTypehandler.class),
//            @Result(column = "remarks", property = "remarks", javaType = String.class),
//            @Result(column = "doctor_flag", property = "doctorFlag", javaType = String.class),
//            @Result(column = "department_category", property = "departmentCategory", javaType = String.class),
//            @Result(column = "response_speed", property = "responseSpeed"),
//            @Result(column = "service_attitude", property = "serviceAttitude"),
//            @Result(column = "satisficing", property = "satisficing"),
//            @Result(column = "professional", property = "professional"),
//            @Result(column = "award", property = "award"),
//            @Result(column = "article_published", property = "articlePublished"),
//            @Result(column = "expect_quantity", property = "expectQuantity"),
//            @Result(column = "plus_sign", property = "plusSign"),
//            @Result(column = "doc_level", property = "docLevel", javaType = String.class),
//            @Result(column = "contract_doctor_title", property = "contractDoctorTitle", javaType = String.class),
//            @Result(column = "wyy_accid", property = "wyyAccid", javaType = String.class),
//            @Result(column = "wyy_pwd", property = "wyyPwd", javaType = String.class),
//            @Result(column = "gpa_name", property = "gpaName"),
//            @Result(column = "ma_name", property = "maName"),
//            @Result(column = "wyy_accid", property = "wyyAccid", javaType = String.class),
//            @Result(column = "wyy_pwd", property = "wyyPwd", javaType = String.class),
//            @Result(column = "certify_refuse_reason", property = "certifyRefuseReason", typeHandler = MemoTypehandler.class)
    })
    @Select({ "select md.* from member_doctor_copy1 md where md.id = #{id}" })
    Doctor findDoctorById(@Param("id") String id);

    @Results(value = { @Result(column = "province_id", property = "provinceId", javaType = String.class),
            @Result(column = "city_id", property = "cityId", javaType = String.class),
            @Result(column = "district_id", property = "districtId", javaType = String.class),
            @Result(column = "town_id", property = "townId", javaType = String.class),
            @Result(column = "community_id", property = "communityId", javaType = String.class),
            @Result(column = "username", property = "username", javaType = String.class),
            @Result(column = "realname", property = "realname", javaType = String.class),
            @Result(column = "gender", property = "gender", javaType = String.class),
    })
//    @Select({"<script>","SELECT * FROM member_doctor_copy1 WHERE id &gt;= ((SELECT MAX(id) FROM member_doctor_copy1)-(SELECT MIN(id) FROM member_doctor_copy1)) * RAND() + (SELECT MIN(id) FROM member_doctor_copy1) and tmd = '1' and source not in ('9') LIMIT 1","</script>"})
    @Select({"<script>","SELECT * FROM member_doctor_copy1 where tmd = '1' and source not in ('9') ORDER BY RAND() LIMIT 1;","</script>"})
    Doctor findDoctorLimit1();

    @Insert({ "<script>", "update member_doctor_copy1 set updated = now() ",
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
            "<if test='hospitalId != null'> , hospital_id = #{hospitalId} </if>",
            "<if test='departmentId != null'> , dept_id = #{departmentId} </if>",
            "<if test='formalDoctor != null'> , formal_doctor_no = #{formalDoctor} </if>",
            "<if test='education != null'> , education = #{education} </if>",
            "<if test='careerTime != null'> , career_time = #{careerTime} </if>",
            "<if test='vocationalArea != null'> , vocational_area = #{vocationalArea} </if>",
            "<if test='title != null'> , title = #{title} </if>",
            "<if test='cardUrl != null'> , card_url = #{cardUrl} </if>",
            "<if test='star != null'> , star = #{star} </if>",
            "<if test='hospitalLevel != null'> , hospital_level = #{hospitalLevel} </if>",
            "<if test='schoolId != null'> , school_id = #{schoolId} </if>",
            "<if test='titleType != null'> , title_type = #{titleType} </if>", "<if test='specialtyIds != null'>",
            " , specialty = #{specialtyIds,typeHandler=com.medishare.whale.dao.finance.MemoTypehandler}", " </if>",
            "<if test='certifiedDate != null'> , certified = #{certifiedDate,javaType=java.util.Date} </if>",
            "<if test='certifies != null'> ",
            ", certified_link = #{certifies,typeHandler=com.medishare.whale.dao.finance.MemoTypehandler} </if>",
            "<if test='certifiesBak != null'> ",
            ", certified_link_bak = #{certifiesBak,typeHandler=com.medishare.whale.dao.finance.MemoTypehandler} </if>",
            "<if test='doctorType != null'> , doctor_type = #{doctorType} </if>",
            "<if test='idCard != null'> , id_card = #{idCard} </if>", "<if test='post != null'> , post = #{post} </if>",
            "<if test='clinicOperationFlag != null'> , clinic_operation_flag = #{clinicOperationFlag} </if>",
            "<if test='medicalOrg != null'> , medical_org = #{medicalOrg} </if>",
            "<if test='medicalOrgGrade != null'> , medical_org_grade = #{medicalOrgGrade} </if>",
            "<if test='practicePlace != null'> , practice_place = #{practicePlace} </if>",
            "<if test='practiceCategory != null'> , practice_category = #{practiceCategory,typeHandler=com.medishare.whale.dao.finance.MemoTypehandler} </if>",
            "<if test='practiceScope != null'> , practice_scope = #{practiceScope,typeHandler=com.medishare.whale.dao.finance.MemoTypehandler} </if>",
            "<if test='remarks != null'> , remarks = #{remarks} </if>",
            "<if test=\"doctorFlag != null and doctorFlag != '' \"> ,doctor_flag = #{doctorFlag} </if>",
            "<if test=\"doctorFlag == '' \"> , doctor_flag = null </if>",
            "<if test='professional != null'> , professional = #{professional} </if>",
            "<if test='award != null'> , award = #{award} </if>",
            "<if test='articlePublished != null'> , article_published = #{articlePublished} </if>",
            "<if test='wxQrcode != null'> , wx_qrcode = #{wxQrcode} </if>",
            "<if test='gpaName != null'> , gpa_name = #{gpaName} </if>",
            "<if test='maName != null'> , ma_name = #{maName} </if>",
            "<if test='certifyRefuseReason != null'> , certify_refuse_reason = #{certifyRefuseReason,typeHandler=com.medishare.whale.dao.finance.MemoTypehandler} </if>",
            "<if test='wyyAccid != null'> , wyy_accid = #{wyyAccid} </if>",
            "<if test='wyyPwd != null'> , wyy_pwd = #{wyyPwd} </if>",
            "where id = #{id}", "</script>" })
    int updateDoctor(Doctor doc);

    @Insert({ "<script>", "update member_doctor_copy1 set updated = now() ", "</script>" })
    int updateAllDoctor();

}
