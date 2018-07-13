package com.medishare.chicago.view;

import com.medishare.chicago.domain.request.DoctorRequest;
import com.medishare.chicago.service.EssayService;
import com.medishare.chicago.utils.JSONRet;
import com.medishare.chicago.utils.JSonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by liuy on 2018/4/3.
 */
@Controller
public class EssayController {
    @Autowired
    EssayService essayService;


    @ResponseBody
    @RequestMapping(path = "/search/essay/", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    String searchEssay(@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        JSONRet ret = essayService.searchEssayJsonType(page);
        return JSonUtils.toJsonString(ret);
    }
}
