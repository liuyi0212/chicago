package com.medishare.chicago.service;

import com.medishare.chicago.Application;
import com.medishare.chicago.config.DatabaseConfig;
import com.medishare.chicago.config.MybatisConfig;
import com.medishare.chicago.domain.PatientRequest;
import com.medishare.chicago.domain.request.DoctorRequest;
import com.medishare.chicago.utils.JSonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by liuy on 2018/3/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { Application.class, DatabaseConfig.class, MybatisConfig.class })
@WebAppConfiguration
@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class })
public class PatientServiceImplTest {

	@Autowired
	DoctorService doctorServiceImpl;

	@Autowired
	PatientService patientServiceImpl;

	@Autowired
	EssayService essayServiceImpl;

	@Test
	public void testCase() {
		System.out.println("测试案例");
	}

	@Test
	public void testSearchSignedPatientsByDoctor() {

		DoctorRequest doctorRequest = new DoctorRequest();
		doctorRequest.setProvinceId("2");
		int page = 0;
		List<DoctorRequest> doctorRequestList = doctorServiceImpl.searchDoctorList(doctorRequest, page);
		List<String> docLists = doctorRequestList.stream().map(DoctorRequest::getId).collect(Collectors.toList());
		System.out.println("医生ids：");
		System.out.println(JSonUtils.toJsonString(docLists));

//		List<String> docLists = Arrays.asList("100358","100359");
		List<String> docTags = doctorServiceImpl.searchDoctorTags(docLists);

		System.out.println("医生标签ids：");
		System.out.println(JSonUtils.toJsonString(docTags));
		List<PatientRequest> list = doctorServiceImpl.searchSignedPatient(doctorRequest, page);

		System.out.println("患者信息：");
		System.out.println(JSonUtils.toJsonString(list));

	}


}
