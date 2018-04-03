package com.medishare.chicago.service;

import com.medishare.chicago.Application;
import com.medishare.chicago.config.DatabaseConfig;
import com.medishare.chicago.config.MybatisConfig;
import com.medishare.chicago.dao.DoctorDAO;
import com.medishare.chicago.domain.Essay;
import com.medishare.chicago.utils.JSonUtils;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuy on 2018/3/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { Application.class, DatabaseConfig.class, MybatisConfig.class })
@WebAppConfiguration
@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class })
public class DoctorServiceTest {

	@Autowired
	Datastore ds;

	@Autowired
	EssayService essayServiceImpl;

	@Autowired
	DoctorDAO doctorDAO;

	@Test
	public void testCase() {
		System.out.println("测试案例");
	}

	@Test
	public void testCase01() {
		List<Essay> list = essayServiceImpl.searchEssay();
		System.out.println(JSonUtils.toJsonString(list));
	}

	@Test
	public void testDoctorTagListWithCount() {
//		List<String> doctors = Arrays.asList("100359","100358","100357");
//		BasicDBList values = new BasicDBList();
//	    values.add("100359");
//	    values.add("100358");
//	    values.add("100357");

		List<String> listd = doctorDAO.findDoctors();
		System.out.println(JSonUtils.toJsonString(listd));
		// 查询集合
		DBCollection col = ds.getMongo().getDB("liuliang").getCollection("tag");
		// 过滤条件
		BasicDBObject filter = new BasicDBObject();
		filter.put("tag_master", new BasicDBObject("$in", listd));
		filter.put("ns", 101); // 签约
		System.out.println(JSonUtils.toJsonString(filter));
		DBCursor dBCursor = col.find(filter);
		List<Map<String, Object>> list = new ArrayList<>();
		for (DBObject obj : dBCursor) {
			Map<String, Object> returnMap = new HashMap<>();
			returnMap.put("tag_master", obj.get("tag_master"));
			returnMap.put("tag_list", obj.get("tag_list"));
			list.add(returnMap);
		}
		System.out.println(JSonUtils.toJsonString(list));
	}
}
