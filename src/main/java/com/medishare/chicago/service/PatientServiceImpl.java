package com.medishare.chicago.service;

import com.github.promeg.pinyinhelper.Pinyin;
import com.medishare.chicago.dao.PatientDAO;
import com.medishare.chicago.domain.PatientRequest;
import com.medishare.chicago.domain.member.Patient;
import com.medishare.chicago.domain.request.DoctorRequest;
import com.medishare.chicago.utils.JSONRet;
import com.medishare.chicago.utils.JSONRet.Pager;
import com.medishare.chicago.utils.JSonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by liuy on 2018/3/31.
 */
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    DoctorService doctorService;

    @Autowired
    PatientDAO patientDAO;

    @Override
    public JSONRet searchSignedPatientsByDoctorJsonType(PatientRequest patientRequest) {
        JSONRet ret = new JSONRet();
        Map<String, Object> map = new HashMap<>();



        ret.setData(map);
        return ret;
    }



    @Override
    public List<PatientRequest> searchSignedPatientsByDoctor(PatientRequest patientRequest, int page) {

        Pager pager = new Pager();
        List<PatientRequest> patients = new ArrayList<>();
        if(patientRequest.getTags() == null && patientRequest.getTags().isEmpty()){
            patients = patientDAO.searchSignedPatientsByDoctor(patientRequest.getDoctorIds());
        }else{
            //获取患者

            //获取患者标签


        }

//        List<String> docLists = Arrays.asList("100369","100357");
//        List<PatientRequest> patients = patientDAO.searchSignedPatientsByDoctor(docLists.toArray(new String[docLists.size()]));

//        pager.setHasNextPage(doctorRequestList);
//        pager.setCount(count);
//        pager.setCurrent(page);
        return patients;
    }

    @Override
    public Patient findPatientLimit1() {
        return patientDAO.findPatientLimit1();
    }

    public void getPatientTags(){
    }

    @Override
    public void update(Patient patient) {
        if (patient == null || patient.getId() == null) {
            return;
        }
        patientDAO.updatePatient(patient);
    }
}
