package com.medishare.chicago.domain.finance;

import com.medishare.chicago.domain.Money;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: liuy
 * @date: 2018/8/20
 * @time: 下午5:24
 * @descripttion: com.medishare.chicago.domain.finance
 */
@MappedTypes(value = Money.class)
public class MoneyTypehandler extends BaseTypeHandler<Money> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Money parameter, JdbcType jdbcType)
            throws SQLException {
        double m = 0d;
        if (parameter != null) {
            m = parameter.getAmount();
        }
        ps.setDouble(i, m);
    }

    @Override
    public Money getNullableResult(ResultSet rs, String columnName) throws SQLException {
        try {
            double m = rs.getDouble(columnName);
            return new Money(m);
        } catch (Exception e) {
        }
        return new Money(0);
    }

    @Override
    public Money getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        try {
            double m = rs.getDouble(columnIndex);
            return new Money(m);
        } catch (Exception e) {
        }
        return new Money(0);
    }

    @Override
    public Money getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        try {
            double m = cs.getDouble(columnIndex);
            return new Money(m);
        } catch (Exception e) {
        }
        return new Money(0);
    }
}