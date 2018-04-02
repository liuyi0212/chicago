package com.medishare.chicago.service;

import com.medishare.chicago.domain.Doctor;
import com.medishare.chicago.domain.DoctorRequest;

import java.util.List;

/**
 * Created by liuy on 2018/3/31.
 */
public interface DoctorService {
    List<Doctor> searchDoctor(DoctorRequest doctorRequest);

}
