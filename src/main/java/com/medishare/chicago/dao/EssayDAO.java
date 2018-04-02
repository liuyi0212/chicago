package com.medishare.chicago.dao;

import com.medishare.chicago.domain.Essay;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by liuy on 2018/3/31.
 */
@Component
public interface EssayDAO {

    @Select({ "select * from essay_artical where 1=1 and category = '一键宣教' order by id desc" })
    List<Essay> find();
}
