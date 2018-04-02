package com.medishare.chicago.service;

import com.medishare.chicago.domain.Patient;
import com.medishare.chicago.domain.PatientRequest;

import java.util.List;

/**
 * Created by liuy on 2018/3/31.
 */
public interface PatientService {

    List<Patient> searchPatient(PatientRequest patientRequest);
}
