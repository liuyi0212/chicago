package com.medishare.chicago.service;

import com.medishare.chicago.Application;
import com.medishare.chicago.config.MybatisConfig;
import com.medishare.chicago.dao.MemberDAO;

import com.medishare.chicago.domain.Essay;
import com.medishare.chicago.domain.Member;
import com.medishare.chicago.utils.JSonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by liuy on 2018/3/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(
        classes = {Application.class, MybatisConfig.class})
public class DoctorServiceTest {

	@Autowired
	EssayService essayServiceImpl;

	@Autowired
	MemberDAO memberDAO;

	@Test
	public void testCase() {
		System.out.println("测试案例");
	}

//	@Test
//	public void testCase01() {
//		List<Essay> list = essayServiceImpl.searchEssay();
//		System.out.println(JSonUtils.toJsonString(list));
//	}

	@Test
	public void searchMemberByTest(){
	    Double a = 121.51257;
	    Double b = 31.266762;
		List<Member> list = memberDAO.searchMemberBy(null, a,b, 1,10);
		System.out.println(JSonUtils.toJsonString(list));
	}
}
