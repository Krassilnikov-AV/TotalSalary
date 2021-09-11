/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */

package query;

import java.sql.*;

public class SQLQueryImpl implements SQLQuery {

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DATABASE_URL_COMPANY = "jdbc:mysql://localhost:3306/company";
	static final String USER = "root";
	static final String PASSWORD = "alex159sql";

	Connection connection = null;
	Statement statement = null;

	@Override
	public void totalSalary() throws SQLException, ClassNotFoundException {

		System.out.println("Registering JDBC driver...");

		Class.forName(JDBC_DRIVER );

		System.out.println("Creating database connection...");
		connection = DriverManager.getConnection(DATABASE_URL_COMPANY, USER, PASSWORD);

		System.out.println("Executing statement...");
		statement = connection.createStatement();
		String sql = "select department, SUM(salary) FROM company.employee GROUP BY department";
		String department = null;
		String salary = null;
		int id = 0;
		String name = null;
		ResultSet resultSet = statement.executeQuery(sql);
		System.out.println("Department and salary data from database...");

		while (resultSet.next()) {
			department = resultSet.getString("department");
			salary = resultSet.getString(2);

			System.out.println("================");
			System.out.println("Specialty: " + department + "  Salary: $" + salary);
		}
		System.out.println("Closing connection and releasing resources...");
		resultSet.close();
		statement.close();
		connection.close();
	}

}