package com.medishare.chicago.service;

import com.medishare.chicago.domain.Doctor;
import com.medishare.chicago.domain.DoctorRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liuy on 2018/3/31.
 */

@Service
public class DoctorServiceImpl implements DoctorService {
    @Override
    public List<Doctor> searchDoctor(DoctorRequest doctorRequest) {
        return null;
    }
}
