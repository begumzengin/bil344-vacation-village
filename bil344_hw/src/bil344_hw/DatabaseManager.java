package bil344_hw;

import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DatabaseManager {
    private static final String DB_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/vacation_village";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "tedankaraBego1";
    
    private static Connection connection;

  
    public DatabaseManager() {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void CloseConnections() {
        try {
            connection.close();
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }

    private static void connect() {
    	if(connection != null)
    		return;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException exc) {
            exc.printStackTrace();
            System.exit(0);
        }
    }

    // Disconnect from the database
    public void disconnect() {
    	if(connection == null)
    		return;
        try {
            connection.close();
            connection = null;
        } catch (SQLException exc) {
            exc.printStackTrace();
            System.exit(0);
        }
    }
    
    public static void insertCustomer(AddCustomer customer) {
    	Statement stmt = null;
    	try {
    		connect();
    		System.out.println("Opened database successfully");
    		
    		stmt = connection.createStatement();
    		String sql = "INSERT INTO CUSTOMER (CUSTOMER_NAME, AGE, CONTACT_PHONE)"
    				+ "VALUES ('" + customer.getCustomer_name() + "', " + customer.getAge() 
    				+ ", '" + customer.getContact_phone() + "');";
    		stmt.executeUpdate(sql);
    		
    		stmt.close();
    		connection.commit();
    	}
    	
    	catch (SQLException exc) {
    		exc.printStackTrace();
    		System.exit(0);
    	}
    	System.out.println("Records created successfully");
    }
    
    
    public static void insertAnimator(AddAnimator animator){
    	Statement stmt = null;
    	try {
    		connect();
    		System.out.println("Opened database successfully");
    		
    		stmt = connection.createStatement();
    		String sql = "INSERT INTO ANIMATOR (EMPLOYEE_NAME, EXPERTISE_AREA, PHONE_NUMBER)"
    				+ "VALUES ('" + animator.getEmployee_name() + "', '" + animator.getExpertise_area() 
    				+ "', '" + animator.getPhone_number() + "');";
    		stmt.executeUpdate(sql);
    		
    		stmt.close();
    		connection.commit();
    	}
    	
    	catch (SQLException exc) {
    		exc.printStackTrace();
    		System.exit(0);
    	}
    	System.out.println("Records created successfully");
    }
    
    public static void insertEquipPerson(AddEquipPerson equip_person){
    	Statement stmt = null;
    	try {
    		connect();
    		System.out.println("Opened database successfully");
    		
    		stmt = connection.createStatement();
    		String sql = "INSERT INTO EQUIP_PERSON (SSN, EP_NAME, EP_SURNAME, EP_CONTACT_PHONE)"
    				+ "VALUES (" + equip_person.getSsn() + ", '" + equip_person.getEp_name() 
    				+ "', '" + equip_person.getEp_surname() + "', '" + equip_person.getEp_contactphone() + "');";
    		stmt.executeUpdate(sql);
    		
    		stmt.close();
    		connection.commit();
    	}
    
    	catch (SQLException exc) {
    		exc.printStackTrace();
    		System.exit(0);
    	}
    	System.out.println("Records created successfully");
    }
    
    public static boolean checkCustomer(String customerPhone, int customerPassword) {
    	Statement stmt = null;
    	
    	try {
    		connect();
    		System.out.println("Opened database successfully");
    		
    		stmt = connection.createStatement();
    		ResultSet rs = stmt.executeQuery( "SELECT * FROM customer_view");
    		while(rs.next()) {
    			if(rs.getString("contact_phone").equals(customerPhone) && rs.getInt("c_password") == customerPassword) {
    				CustomerMainPage customer_gui = new CustomerMainPage();
        			
        			customer_gui.setTitle("Zengin Vacation Village - Customer");
        			customer_gui.setSize(480, 300);
        			customer_gui.setVisible(true);
        			customer_gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        			
        			rs.close();
        			stmt.close();
        			return true;
    			}
    			else {
    				JOptionPane.showMessageDialog(null, "Phone number or password incorrect!", "ERROR", JOptionPane.ERROR_MESSAGE);
    			}
    			
    		}
    	}
    	catch(SQLException exc){
    		exc.printStackTrace();
    		
    		System.exit(0);
    	}
    	
    	return false;
    }
    
    public static boolean checkAnimator(String animatorPhone, int animatorPassword) {
    	Statement stmt = null;
    	
    	try {
    		connect();
    		System.out.println("Opened database successfully");
    		
    		stmt = connection.createStatement();  		
    		ResultSet rs = stmt.executeQuery( "SELECT * FROM animator");
    		while(rs.next()) {
    			if(rs.getString("phone_number").equals(animatorPhone) && rs.getInt("e_password") == animatorPassword) {
    				AnimatorPage animator_gui = new AnimatorPage();
        			
    				animator_gui.setTitle("Zengin Vacation Village - Animator");
    				animator_gui.setSize(480, 300);
    				animator_gui.setVisible(true);
    				animator_gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    				
    				rs.close();
        			stmt.close();
        			return true;
    			}
    			/*
    			else {
    				JOptionPane.showMessageDialog(null, "Phone number or password incorrect!", "ERROR", JOptionPane.ERROR_MESSAGE);
    			}
    			*/
    		}
    	}
    	catch(SQLException exc){
    		exc.printStackTrace();
    		
    		System.exit(0);
    	}
    	return false;
    }
    
}
