package com.ibm.dao;

import java.sql.Connection;
import com.ibm.model.Department;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class DepartmentDAO {
	
	private final static String DRIVER = "oracle.jdbc.OracleDriver";
	private final static String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final static String USER_ID = "hr";
	private final static String PASSWORD = "hr";
	
	
	public ArrayList<Department> getDeptbyLoc(int locationId){
		String sql = "select department_id,department_name from departments where "
				+ "location_id = ?";
		Department dept = null;
		Connection conn = null;
		ArrayList<Department> depList = new ArrayList<Department>();
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER_ID,PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, locationId);
			ResultSet result = stmt.executeQuery();
			while(result.next()){
				int depId = result.getInt("department_id");
				String depName = result.getString("department_name");
				dept = new Department(depId, depName, locationId);
				depList.add(dept);
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return depList;
		
	}
	

}
