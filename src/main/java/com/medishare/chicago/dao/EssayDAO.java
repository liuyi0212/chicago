package com.medishare.chicago.dao;

import com.medishare.chicago.domain.Essay;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by liuy on 2018/3/31.
 */
@Component
public interface EssayDAO {


    @Results(value = {@Result(column = "id", property = "id", javaType = String.class),
            @Result(column = "title", property = "title", javaType = String.class),
            @Result(column = "icon", property = "icon", javaType = String.class),
            @Result(column = "content", property = "content", javaType = String.class),
            @Result(column = "created", property = "created", javaType = Date.class),
            @Result(column = "link", property = "link", javaType = String.class)

    })
    @Select({"select ea.id, ea.title, ea.icon, ea.content, ea.created, ea.link from essay_artical ea where 1=1 and ea.category = '一键宣教' order by ea.id desc limit #{start}, #{limit}"})
    List<Essay> find(@Param("start") int start, @Param("limit") int limit);
}
