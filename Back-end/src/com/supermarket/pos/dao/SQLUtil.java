package com.supermarket.pos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/
public class SQLUtil {
    private static PreparedStatement getPreparedStatement(Connection connection, String sql, Object... params) throws SQLException, ClassNotFoundException {
        PreparedStatement pStm = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            pStm.setObject((i + 1), params[i]);
        }
        return pStm;
    }

    public static boolean executeUpdate(Connection connection, String sql, Object... params) throws SQLException, ClassNotFoundException {
        return getPreparedStatement(connection, sql, params).executeUpdate() > 0;
    }

    public static ResultSet executeQuery(Connection connection, String sql, Object... params) throws SQLException, ClassNotFoundException {
        return getPreparedStatement(connection, sql, params).executeQuery();
    }
}
