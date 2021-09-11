/*
 * Copyright (c) 2021 Tander, All Rights Reserved.
 */


import query.SQLQueryImpl;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		SQLQueryImpl sqlQuery = new SQLQueryImpl();
sqlQuery.totalSalary();
	}
}