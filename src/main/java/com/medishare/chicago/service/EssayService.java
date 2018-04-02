package com.medishare.chicago.service;

import com.medishare.chicago.domain.Essay;

import java.util.List;

/**
 * Created by liuy on 2018/3/31.
 */
public interface EssayService {
    /**
     * 获取所有一键宣教文章
     * @return
     */
    List<Essay> searchEssay();
}
