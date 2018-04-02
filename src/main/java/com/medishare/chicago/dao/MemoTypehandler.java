package com.medishare.chicago.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.medishare.chicago.utils.JSonUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(value = List.class)
public class MemoTypehandler extends BaseTypeHandler<List<String>> {

  @Override
  public void setNonNullParameter(PreparedStatement ps, int i, List<String> parameter,
      JdbcType jdbcType) throws SQLException {
    String text = null;
    if (parameter != null) {
      text = JSonUtils.toJsonString(parameter);
    }
    ps.setString(i, text);
  }

  @Override
  public List<String> getNullableResult(ResultSet rs, String columnName) throws SQLException {
    String text = rs.getString(columnName);
    List<String> v = null;
    if (text != null) {
      v = JSonUtils.toObject(text, List.class);
    }
    return v;
  }

  @Override
  public List<String> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
    String text = rs.getString(columnIndex);
    List<String> v = null;
    if (text != null) {
      v = JSonUtils.toObject(text, List.class);
    }
    return v;
  }

  @Override
  public List<String> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
    String text = cs.getString(columnIndex);
    List<String> v = null;
    if (text != null) {
      v = JSonUtils.toObject(text, List.class);
    }
    return v;
  }
}
