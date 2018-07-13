package com.medishare.chicago.service;

import com.medishare.chicago.domain.PatientRequest;
import com.medishare.chicago.domain.member.Doctor;
import com.medishare.chicago.domain.member.Patient;
import com.medishare.chicago.domain.request.DoctorRequest;
import com.medishare.chicago.utils.JSONRet;

import java.util.List;
import java.util.Map;

/**
 * Created by liuy on 2018/3/31.
 */
public interface DoctorService {



    /**
     * 查询医生集合
     * @param doctorRequest
     * @return
     */
    JSONRet searchDoctorsJsonType(DoctorRequest doctorRequest, int page);

    List<DoctorRequest> searchDoctorList(DoctorRequest doctorRequest, int page);


    /**
     * 查询医生标签
     * @param docIds
     * @return
     */
    List<String> searchDoctorTags(List<String> docIds);

    Map<String, List<String>> searchSignedPatientDBMongo(List<String> docIds, List<String> docTags);

    List<PatientRequest> searchSignedPatient(DoctorRequest doctorRequest, int page);

    /**
     * 查询医生给患者打标签记录
     * @param docIds  医生id
     * @param docTags 标签
     * @return 两者都为空返回签约状态所有标签
     */
    List<Map<String, Object>> searchDoctorTagTable (List<String> docIds, List<String> docTags);

    int finDoctorCount(Doctor doctor, String[] ids);
}
