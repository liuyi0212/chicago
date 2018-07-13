package com.medishare.chicago.service;

import com.medishare.chicago.constant.PageConstant;
import com.medishare.chicago.dao.EssayDAO;
import com.medishare.chicago.domain.Essay;
import com.medishare.chicago.utils.JSONRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liuy on 2018/3/31.
 */
@Service
public class EssayServiceImpl implements EssayService {

    @Autowired
    EssayDAO essayDAO;

    @Override
    public JSONRet searchEssayJsonType(int page) {
        JSONRet ret = new JSONRet();
        List<Essay> list = searchEssay(page);
        ret.setData(list);
        return ret;
    }

    @Override
    public List<Essay> searchEssay(int page) {
        int start = page <= 1 ? 0 : ((page - 1) * PageConstant.PAGE_COUNT);
        return essayDAO.find(start, PageConstant.PAGE_COUNT);
    }


}
