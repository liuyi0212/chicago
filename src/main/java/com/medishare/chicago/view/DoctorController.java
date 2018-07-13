package com.medishare.chicago.view;

import com.medishare.chicago.domain.PatientRequest;
import com.medishare.chicago.domain.request.DoctorRequest;
import com.medishare.chicago.service.DoctorService;
import com.medishare.chicago.service.EssayService;
import com.medishare.chicago.service.PatientService;
import com.medishare.chicago.utils.JSONRet;
import com.medishare.chicago.utils.JSonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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


    /**
     * 根据
     * 省
     * 市
     * 区
     * 街道
     * 医院
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(path = "/search/doctors/", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    String searchDoctors(DoctorRequest doctorRequest, @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        JSONRet ret = doctorService.searchDoctorsJsonType(doctorRequest, page);
        return JSonUtils.toJsonString(ret);
    }


    @ResponseBody
    @RequestMapping(path = "/search/signed/patient/", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    String searchSignedPatient(DoctorRequest doctorRequest, @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        JSONRet ret = new JSONRet();
        List<PatientRequest> list =  doctorService.searchSignedPatient(doctorRequest, page);
        ret.setData(list);
        return JSonUtils.toJsonString(ret);
    }
}
