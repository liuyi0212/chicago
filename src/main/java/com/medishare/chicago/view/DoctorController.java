package com.medishare.chicago.view;

import com.medishare.chicago.domain.Essay;
import com.medishare.chicago.service.DoctorService;
import com.medishare.chicago.service.EssayService;
import com.medishare.chicago.service.PatientService;
import com.medishare.chicago.utils.JSONRet;
import com.medishare.chicago.utils.JSonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by liuy on 2018/3/31.
 */
@Controller
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @Autowired
    PatientService patientService;

    @Autowired
    EssayService essayService;

    @ResponseBody
	@RequestMapping(path = "/home/page/", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    String home() {
    	System.out.println("进入");
        JSONRet ret = new JSONRet();
        List<Essay> list = essayService.searchEssay();
        ret.setData(list);
        return JSonUtils.toJsonString(ret);
    }
}
