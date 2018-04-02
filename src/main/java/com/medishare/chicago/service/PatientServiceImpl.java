package com.medishare.chicago.service;

import com.medishare.chicago.domain.Doctor;
import com.medishare.chicago.domain.DoctorRequest;
import com.medishare.chicago.domain.Patient;
import com.medishare.chicago.domain.PatientRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liuy on 2018/3/31.
 */
@Service
public class PatientServiceImpl implements PatientService {

    @Override
    public List<Patient> searchPatient(PatientRequest patientRequest) {
        /**
         *
         * 非精准条件 省市区街道医院标签
         * 精准条件 id，username，realname
         *
         *
         */


        return null;
    }
}
