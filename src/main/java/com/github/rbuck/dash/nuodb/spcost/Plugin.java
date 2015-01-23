package com.github.rbuck.dash.nuodb.spcost;

import com.github.rbuck.dash.junit.annotations.Case;
import com.github.rbuck.dash.junit.common.Dialect;
import com.github.rbuck.dash.junit.runners.MixRunner;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * A benchmark of the stored procedure implementation.
 */
@RunWith(MixRunner.class)
public class Plugin {

    private static Dialect dialect;

    @BeforeClass
    public static void setup() {
        dialect = new Dialect(Plugin.class);
    }

    @Case(name = "SPC")
    public void doSpc(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(dialect.getSqlStatement("EXEC_TABLES_PROCEDURE"))) {
                while (resultSet.next()) {
                    resultSet.getString(1);
                }
            }
        }
    }

    @Case(name = "LIS")
    public void doLis(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(dialect.getSqlStatement("LIST_TABLES_STATEMENT"))) {
                while (resultSet.next()) {
                    resultSet.getString(1);
                }
            }
        }
    }

    @AfterClass
    public static void tearDown() {
    }
}
