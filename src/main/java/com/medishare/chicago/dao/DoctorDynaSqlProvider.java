package com.medishare.chicago.dao;

import com.medishare.chicago.domain.member.Doctor;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

/**
 * Created by liuy on 2018/4/14.
 */
public class DoctorDynaSqlProvider {

    public String selectDoctorCount(String[] ids) {
        String str = new SQL() {{
            SELECT("COUNT(*)");
            FROM("member_doctor md");
//            if (doctor.getUsername() != null) {
//                WHERE("md.username=#{username}");
//            }
//            if(doctor.getRealname() != null){
//                WHERE("md.realname=#{realname}");
//            }
            WHERE("specialty in "
                    + "<foreach item='item' index='index' collection='ids'"
                    + "open='(' separator=',' close=')'>"
                    + "#{item}"
                    + "</foreach>");
//            WHERE("id in #{specialtyIds}");
        }}.toString();
        System.out.println("生成sql语句！！！！");
        System.out.println(str);
        return "<script>" + str + "</script>";
    }

    public String selectPersonLike(final String id, final String firstName, final String lastName) {
        return new SQL() {{
            SELECT("P.ID, P.USERNAME, P.PASSWORD, P.FIRST_NAME, P.LAST_NAME");
            FROM("PERSON P");
            if (id != null) {
                WHERE("P.ID like ${id}");
            }
            if (firstName != null) {
                WHERE("P.FIRST_NAME like ${firstName}");
            }
            if (lastName != null) {
                WHERE("P.LAST_NAME like ${lastName}");
            }
            ORDER_BY("P.LAST_NAME");
        }}.toString();
    }

    public static void main(String[] args) {
        String id = "id";
        String firstName = "firstName";
        String lastName = "lastName";
        DoctorDynaSqlProvider d = new DoctorDynaSqlProvider();
        System.out.println(d.selectPersonLike(id, firstName, lastName));
    }
}
