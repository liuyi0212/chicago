package com.medishare.chicago.service;

import com.medishare.chicago.domain.member.Patient;
import com.medishare.chicago.domain.PatientRequest;
import com.medishare.chicago.domain.request.DoctorRequest;
import com.medishare.chicago.utils.JSONRet;

import java.util.List;
import java.util.Map;

/**
 * Created by liuy on 2018/3/31.
 */
public interface PatientService {

    /**
     * 根据医生信息搜索患者
     * @param patientRequest
     * @return
     */
    JSONRet searchSignedPatientsByDoctorJsonType(PatientRequest patientRequest);

    List<PatientRequest> searchSignedPatientsByDoctor(PatientRequest patientRequest, int page);

}
