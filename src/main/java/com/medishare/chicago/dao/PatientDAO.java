package com.medishare.chicago.dao;

import com.medishare.chicago.domain.PatientRequest;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

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
}
