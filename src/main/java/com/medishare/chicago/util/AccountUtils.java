package com.medishare.chicago.util;

import com.medishare.chicago.domain.finance.Account;
import com.medishare.chicago.domain.member.Company;
import com.medishare.chicago.domain.member.Member;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: liuy
 * @date: 2018/8/20
 * @time: 上午11:03
 * @descripttion: com.medishare.chicago.util
 */
public class AccountUtils {

    static Account medishare_finance;
    static Account medishare_runner;
    /**
     * 米喜财务冲账（金钱）
     */
    static Account medishare_finance_money;


    /**
     * 米喜财务冲账（业务）
     */
    static Account medishare_finance_business;

    static {
        medishare_finance = new Account();
        medishare_finance.setUserTypeId("100001");
        medishare_finance.setUserTypeClass(Company.class.getName());
        medishare_finance.setId(
                AccountUtils.fromMemberTypeId(medishare_finance.getUserTypeId(), medishare_finance.getUserTypeClass()));
        medishare_finance.setName("米喜财务");
        medishare_runner = new Account();
        medishare_runner.setUserTypeId("100002");
        medishare_runner.setUserTypeClass(Company.class.getName());
        medishare_runner.setId(
                AccountUtils.fromMemberTypeId(medishare_runner.getUserTypeId(), medishare_runner.getUserTypeClass()));
        medishare_runner.setName("米喜运营");

        medishare_finance_money = new Account();
        medishare_finance_money.setUserTypeId("100003");
        medishare_finance_money.setUserTypeClass(Company.class.getName());
        medishare_finance_money.setId(
                AccountUtils.fromMemberTypeId(medishare_finance_money.getUserTypeId(), medishare_finance_money.getUserTypeClass()));
        medishare_finance_money.setName("米喜财务冲账（金钱）");

        medishare_finance_business = new Account();
        medishare_finance_business.setUserTypeId("100004");
        medishare_finance_business.setUserTypeClass(Company.class.getName());
        medishare_finance_business.setId(
                AccountUtils.fromMemberTypeId(medishare_finance_business.getUserTypeId(), medishare_finance_business.getUserTypeClass()));
        medishare_finance_business.setName("米喜财务冲账（业务）");

    }

    static public Account getMedishareFinance() {
        return medishare_finance;
    }

    static public Account getMedishareRunner() {
        return medishare_runner;
    }

    static public Account getMedishareFinanceMoney() {
        return medishare_finance_money;
    }

    static public Account getMedishareFinanceBusiness() {
        return medishare_finance_business;
    }

    static public Member getUserAccount(Account acct) {
        try {
            Class clazz = Class.forName(acct.getUserTypeClass());
            Member ret = (Member) clazz.newInstance();
            ret.setId(acct.getUserTypeId());
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static public Account getTinyAccount(Member user) {
        if (user == null || user.getId() == null) {
            return null;
        }
        Account ret = new Account();
        ret.setUserTypeClass(user.getClass().getName());
        ret.setUserTypeId(user.getId());
        String id = fromMemberTypeId(ret.getUserTypeId(), ret.getUserTypeClass());
        ret.setId(id);
        return ret;
    }

    public static String fromMemberTypeId(String id, String type) {
        return "acc_" + id + "_" + type;
    }

    public static String getGlobalMemberId(String id, String type) {
        return type + "_" + id;
    }

    public static String getGlobalMemberId(Account acc) {
        return acc.getUserTypeClass() + "_" + acc.getUserTypeId();
    }

    public static boolean AccountEqauls(Account acc1, Account acc2) {
        if (StringUtils.equals(acc1.getId(), acc2.getId())) {
            return true;
        }
        return false;
    }

    public static boolean AccountEquals2(Account acc, String id) {
        if (StringUtils.equals(acc.getId(), id)
                && StringUtils.equals(fromMemberTypeId(acc.getUserTypeId(), acc.getUserTypeClass()), id)) {
            return true;
        }
        return false;
    }

}
