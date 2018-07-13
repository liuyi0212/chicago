package com.medishare.chicago.service;

import com.medishare.chicago.Application;
import com.medishare.chicago.config.DatabaseConfig;
import com.medishare.chicago.config.MybatisConfig;
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
import java.util.Map;

/**
 * Created by liuy on 2018/3/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { Application.class, DatabaseConfig.class, MybatisConfig.class })
@WebAppConfiguration
@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class })
public class DoctorServiceImplTest {

	@Autowired
	DoctorService doctorServiceImpl;

	@Autowired
	EssayService essayServiceImpl;

	@Test
	public void testCase() {
		System.out.println("测试案例");
	}

	@Test
	public void testCase01() {

		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("1");
		list.add("1");
		list.add("2");

//		List<Essay> list = essayServiceImpl.searchEssay();
		System.out.println(JSonUtils.toJsonString(list));
	}

	@Test
	public void testSearchDoctorTags(){
		List<String> docLists = Arrays.asList("100358","100359");


		List<String> list = doctorServiceImpl.searchDoctorTags(docLists);
		System.out.println(JSonUtils.toJsonString(list));
	}

	@Test
	public void testSearchSignedPatient(){
		List<String> tags = Arrays.asList("老年痴呆",
				"肺炎",
				"脑梗塞",
				"LApc",
				"拉去",
				"Hh",
				"幻视",
				"糖尿病患者",
				"亲戚",
				"Learning Disability",
				"肠道感染",
				"糖尿",
				"你就可以吗？",
				"黑名单",
				"潜力",
				"脑出血",
				"冠心病",
				"支气管哮喘",
				"都是",
				"高血脂哦咯",
				"Brooklyn",
				"高血脂",
				"boy",
				"糖尿病111",
				"这",
				"糖尿病",
				"低血糖",
				"梦游",
				"巨人症",
				"冠心病2",
				"你",
				"帕金森",
				"多动症",
				"b",
				"阻塞性肺气肿",
				"失能",
				"测试",
				"超能失控",
				"不寐",
				"心脏病",
				"v那好吧v吃",
				"高血压",
				"唐氏",
				"LA",
				"game b",
				"nyc",
				"阿尔茨海默症",
				"脑中风",
				"VIP",
				"Paris");
		List<String> docLists = Arrays.asList("100358","100359");
		DoctorRequest doctorRequest = new DoctorRequest();
		doctorRequest.setProvinceId("2");
		int page = 0;
		doctorServiceImpl.searchSignedPatient(doctorRequest, page);
	}
}
