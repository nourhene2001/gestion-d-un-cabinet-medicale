package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;


import model.Ordonnance;

public class OrdonnanceDao {
	private static final String INSERT_ordonnance_SQL = "INSERT INTO ordonnance" + "(numord,nompatient,prenompatient,nommedicament,dosagemedicament) VALUES " +
	        " (?,?,?,?,?)";

	    private static final String SELECT_ordonnance_BY_NUMORD = "select numord,nompatient,prenompatient,nommedicament,dosagemedicament from ordonnance where numord =?";
	    private static final String SELECT_ALL_ordonnance = "select * from ordonnance";
	    private static final String DELETE_ordonnance_SQL = "delete from ordonnance where numord = ?";
	    private static final String UPDATE_ordonnance_SQL = "update ordonnance set nompatient=? , prenompatient=? ,nommedicament= ?, dosagemedicament= ? where numord = ?";

	    
	    protected static  Connection getConnection() {
	        Connection connection = null;
	        try {
	        	Class.forName("oracle.jdbc.driver.OracleDriver");
	            connection = DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","prepa");
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return connection;
	    }
	    
	    
	    
	    public void insertord(Ordonnance ord) throws SQLException {
	        System.out.println(INSERT_ordonnance_SQL);
	        // try-with-resource statement will auto close the connection.
	        try (Connection connection = getConnection(); 
	       PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ordonnance_SQL)) {
	            preparedStatement.setString(1,ord.getNumord());
	            preparedStatement.setString(2, ord.getNompatient());
	            preparedStatement.setString(3, ord.getPrenompatient());
	            preparedStatement.setString(4, ord.getNommedicament());
	            preparedStatement.setString(5, ord.getDosagemedicament());
	            System.out.println(preparedStatement);
	            preparedStatement.executeUpdate();}
	        catch(Exception e){ 
		  	      System.out.println(e); 
			    }
	     
	    }
	    
	    
	    public Ordonnance selectOrdonnance(String numord) {
	        Ordonnance ord = null;
	        // Step 1: Establishing a Connection
	        try (Connection connection = getConnection();
	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ordonnance_BY_NUMORD);) {
	            preparedStatement.setString(1, numord);
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	                String nompatient = rs.getString("nompatient");
	                String prenompatient = rs.getString("prenompatient");
	                String nommedicament = rs.getString("nommedicament");
	                String dosagemedicament = rs.getString("dosagemedicament");
	               ord= new Ordonnance(numord,nompatient,prenompatient,nommedicament,dosagemedicament);
	            }
	        } catch(Exception e){ 
		  	      System.out.println(e); 
			    }
	        return ord;
	    }    
	    
	    public static List < Ordonnance > selectAllordonnance() {

	        // using try-with-resources to avoid closing resources (boiler plate code)
	        List < Ordonnance > ord = new ArrayList < > ();
	        // Step 1: Establishing a Connection
	        try (Connection connection = getConnection();

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ordonnance);) {
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	                String numord = rs.getString("numord");
	                String nompatient = rs.getString("nompatient");
	                String prenompatient = rs.getString("prenompatient");
	                String nommedicament = rs.getString("nommedicament");
	                String dosagemedicament = rs.getString("dosagemedicament");
	                ord.add(new Ordonnance(numord,nompatient,prenompatient,nommedicament,dosagemedicament));
	            }
	        }catch(Exception e){ 
		  	      System.out.println(e); 
			    }
	        return ord;
	    }

	    public boolean deleteord(String numord) throws SQLException {
	        boolean rowDeleted;
	        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_ordonnance_SQL);) {
	            statement.setString(1,numord);
	            rowDeleted = statement.executeUpdate() > 0;
	        }
	        return rowDeleted;
	    }
	    public boolean updateord(Ordonnance ord) throws SQLException {
	        boolean rowUpdated;
	        try (Connection connection = getConnection(); 
	        		PreparedStatement statement = connection.prepareStatement(UPDATE_ordonnance_SQL);) {
	        	
	        	statement.setString(1,ord.getNumord());
	        	statement.setString(2,ord.getNompatient());
	        	statement.setString(3,ord.getPrenompatient());
	        	statement.setString(4,ord.getNommedicament());
	        	statement.setString(5,ord.getDosagemedicament());

	            rowUpdated = statement.executeUpdate() > 0;
	            
	        }
	        return rowUpdated;
	    }



		

}


