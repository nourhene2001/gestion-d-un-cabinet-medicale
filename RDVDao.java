package dao;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Patient;
import model.RDV;

public class RDVDao {
            private static final String INSERT_RDV_SQL= "INSERT INTO RDV" + "(id,DateRDV,HeureRDV,CINPatient) VALUES" +" (?, ?, ?,?)";
		    private static final String SELECT_RDV_BY_ID = "select Id,DateRDV,HeureRDV,CINPatient from RDV where Id =?";
		    private static final String SELECT_ALL_RDV = "select * from RDV";
		    private static final String DELETE_RDV_SQL = "delete from RDV where id = ?";
		    private static final String UPDATE_RDV_SQL = "update RDV set DateRDV= ? where id = ?";

		    
		    protected Connection getConnection() {
		        Connection connection = null;
		        try {
		        	Class.forName("oracle.jdbc.driver.OracleDriver");
		            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","prepa");
		        } catch (SQLException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        } catch (ClassNotFoundException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
		        return connection;
		    }
		    
		    
		    public void insertRDV(RDV r) throws SQLException {
		    	System.out.println(INSERT_RDV_SQL);
		        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RDV_SQL)) {
		            preparedStatement.setString(1,r.getID());
		            preparedStatement.setString(2,r.getCINPatient());
		            preparedStatement.setString(3,r.getHeureRDV());
		            preparedStatement.setString(4,r.getDateRDV());
		            System.out.println(preparedStatement);
		            preparedStatement.executeUpdate();
		        } catch(Exception e){ 
		  	      System.out.println(e); 
			    }
		    }
		    
		    public RDV selectRDV(String Id) {
		        RDV rdv = null;
		        // Step 1: Establishing a Connection
		        try (Connection connection = getConnection();
		            // Step 2:Create a statement using connection object
		            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RDV_BY_ID);) {
		            preparedStatement.setString(1, Id);
		            System.out.println(preparedStatement);
		            // Step 3: Execute the query or update query
		            ResultSet rs = preparedStatement.executeQuery();

		            // Step 4: Process the ResultSet object.
		            while (rs.next()) {
		                String DateRDV = rs.getString("DateRDV");
		                String HeureRDV = rs.getString("HeureRDV");
		                String CINPatient = rs.getString("CINPatient");
		                
		               rdv= new RDV(Id,DateRDV,HeureRDV,CINPatient);
		            }
		        } catch(Exception e){ 
			  	      System.out.println(e); 
				    }
		        return rdv;
		    }      
		    
		    public List < RDV > selectAllRDV() { 
		        List < RDV > r = new ArrayList < > ();
		        try {
		        	Connection connection = getConnection();
		        	Statement st = connection.createStatement();
		            ResultSet rs = st.executeQuery(SELECT_ALL_RDV);
		            while (rs.next()) {
		                String id =rs.getString("id");
		                String DateRDV = rs.getString("DateRDV");
		                String HeureRDV = rs.getString("HeureRDV");
		                String CINPatient= rs.getString("CINPatient");
		                r.add(new RDV(id,DateRDV,HeureRDV,CINPatient));
		            }
		        }catch(Exception e){ 
			  	      System.out.println(e); 
				    }
		        return r;
		    }
 
		    public boolean deleteRDV(String id) throws SQLException {
		        boolean rowDeleted;
		        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_RDV_SQL);) {
		            statement.setString(1,id);
		            rowDeleted = statement.executeUpdate() > 0;
		        }
		        return rowDeleted;
		    }
		    public boolean updateRDV(RDV r) throws SQLException {
		        boolean rowUpdated;
		        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_RDV_SQL);) {
		            statement.setString(1,r.getDateRDV());
		            statement.setString(2,r.getID());
		            rowUpdated = statement.executeUpdate() > 0;
		        }
		        return rowUpdated;
		    }

}