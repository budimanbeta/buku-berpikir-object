package com.latihan.myapp.core.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.latihan.myapp.core.persistence.exception.DatabaseException;



public class DatabaseHelper {
	protected static String userDb = "root";
	protected static String passwordDb = "";
	protected static String jdbcUrl = "jdbc:mysql://localhost/latihan";

	public static Connection getConnection() throws DatabaseException {
		Connection conn;
		try {
			conn = DriverManager.getConnection(jdbcUrl, userDb, passwordDb);
		} catch (SQLException e) {
			throw new DatabaseException("server not connected");
		}
		return conn;
	}
	
	public static void beginTransaction(Connection conn) throws DatabaseException {
		try {
			if (conn != null) conn.setAutoCommit(false);
		} catch (SQLException e) {
			throw new DatabaseException("failed to begin transaction");
		}
	}
	 
	public static void closeConnection(Connection conn) throws DatabaseException {
		try {
			if (conn != null) conn.close();
		} catch (SQLException e) {
			throw new DatabaseException("failed to close connection");
		}
	}
	
	public static void commitTransaction(Connection conn) throws DatabaseException {
		try {
			if (conn != null) conn.commit();
		} catch (SQLException e) {
			throw new DatabaseException("failed to commit transaction");
		}
	}
	
	public static void rollbackTransaction(Connection conn) throws DatabaseException {
		try {
			if (conn != null) conn.rollback();
		} catch (SQLException e) {
			throw new DatabaseException("failed to rollback transaction");
		}
	}
}
