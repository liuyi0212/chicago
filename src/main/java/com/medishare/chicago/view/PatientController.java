//package com.medishare.chicago.view;
//
//import com.medishare.chicago.domain.PatientRequest;
//import com.medishare.chicago.service.DoctorService;
//import com.medishare.chicago.service.PatientService;
//import com.medishare.chicago.utils.JSONRet;
//import com.medishare.chicago.utils.JSonUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
///**
// * Created by liuy on 2018/3/31.
// */
//
//@Controller
//public class PatientController {
//
//    @Autowired
//    DoctorService doctorService;
//
//    @Autowired
//    PatientService patientService;
//
//
//    @RequestMapping(path = "/order/updatePatientName/", method = {
//            RequestMethod.POST }, produces = "application/json; charset=utf-8")
//    @ResponseBody
//    public String updatePatientName(PatientRequest patientRequest) {
//        JSONRet jsonRet = null;
//        return JSonUtils.toJsonString(jsonRet);
//    }
//}
