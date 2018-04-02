package com.medishare.chicago.service;

import com.medishare.chicago.dao.EssayDAO;
import com.medishare.chicago.domain.Essay;
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
    public List<Essay> searchEssay() {
        return essayDAO.find();
    }
}
