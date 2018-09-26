package com.medishare.chicago.dao;

import com.medishare.chicago.domain.Member;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: liuy
 * @date: 2018/9/6
 * @time: 下午1:50
 * @descripttion: com.medishare.chicago.dao
 */
@Component
public interface MemberDAO {

    @Select({"<script>", "SELECT *,",
            "ROUND(6378.138 * 2 * " +
                    "ASIN(SQRT(POW(SIN((#{latitude} * PI() / 180 - latitude * PI() / 180) / 2),2) + ",
            "COS(#{latitude} * PI() / 180) * COS(latitude * PI() / 180) * ",
            "POW(SIN((#{longitude} * PI() / 180 - longitude * PI() / 180) / 2),2))) * 1000) AS distance",
            "FROM member WHERE 1=1",
            "<if test='memberType != null'> and member_type = #{memberType} </if>",
            "ORDER BY distance ASC limit #{start}, #{limit}",
            "</script>"})
    List<Member> searchMemberBy(@Param("memberType") String memberType, @Param("longitude") Double longitude, @Param("latitude") Double latitude, @Param("start") int start, @Param("limit") int limit);
}
