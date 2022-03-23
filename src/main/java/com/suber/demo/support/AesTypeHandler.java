package com.suber.demo.support;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author liangwang
 * @create 2022/3/22 4:36 下午
 */
/** 数据库中的数据类型 */
@MappedJdbcTypes(JdbcType.VARCHAR)
/** 处理后的数据类型 */
@MappedTypes(value = String.class)
public class AesTypeHandler extends BaseTypeHandler {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, AESUtil.encrypt((String) parameter));
    }

    @Override
    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return StringUtils.isBlank(rs.getString(columnName)) ? rs.getString(columnName) : AESUtil.decrypt(rs.getString(columnName));
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return StringUtils.isBlank(rs.getString(columnIndex)) ? rs.getString(columnIndex) : AESUtil.decrypt(rs.getString(columnIndex));
    }

    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return StringUtils.isBlank(cs.getString(columnIndex)) ? cs.getString(columnIndex) : AESUtil.decrypt(cs.getString(columnIndex));
    }
}
