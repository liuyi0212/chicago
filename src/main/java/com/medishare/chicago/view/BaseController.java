package com.medishare.chicago.view;

import com.medishare.chicago.service.DoctorService;
import com.medishare.chicago.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseController {

	/**
	 * 日志对象
	 */
	protected Logger log = LoggerFactory.getLogger(getClass());

//	@Autowired
//	DoctorService doctorService;
//
//	@Autowired
//	PatientService patientService;

}