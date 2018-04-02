package com.medishare.chicago.service;

import com.medishare.chicago.Application;
import com.medishare.chicago.config.DatabaseConfig;
import com.medishare.chicago.config.MybatisConfig;
import com.medishare.chicago.domain.Essay;
import com.medishare.chicago.utils.JSonUtils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * Created by liuy on 2018/3/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { Application.class, DatabaseConfig.class, MybatisConfig.class })
@WebAppConfiguration
@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class })
public class DoctorServiceTest {

	@Autowired
	EssayService essayServiceImpl;

	@Test
	public void testCase() {
		System.out.println("测试案例");
	}

	@Test
	public void testCase01() {
		List<Essay> list = essayServiceImpl.searchEssay();
		System.out.println(JSonUtils.toJsonString(list));
	}
}
