package controller.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.PasswordEncryptionWithAes;
import model.UserModel;
import util.StringUtils;

public class DatabaseController {
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/camskart_app";
		String user = "root";
		String pass = "";
		return DriverManager.getConnection(url, user, pass);
	}
	public int addUser(UserModel userModel) {
	    try (Connection con = getConnection()) {
	        // Check for existing username
	        PreparedStatement checkUsernameSt = con.prepareStatement(StringUtils.GET_USERNAME);
	        checkUsernameSt.setString(1, userModel.getUsername());
	        ResultSet checkUsernameRs = checkUsernameSt.executeQuery();
	        checkUsernameRs.next();
	        if (checkUsernameRs.getInt(1) > 0) {
	            return -2; // Username already exists
	        }

	        // Check for existing phone number
	        PreparedStatement checkPhoneSt = con.prepareStatement(StringUtils.GET_PHONE);
	        checkPhoneSt.setString(1, userModel.getPhoneNumber());
	        ResultSet checkPhoneRs = checkPhoneSt.executeQuery();
	        checkPhoneRs.next();
	        if (checkPhoneRs.getInt(1) > 0) {
	            return -4;  // Phone number already exists
	        }

	        // Check for existing email
	        PreparedStatement checkEmailSt = con.prepareStatement(StringUtils.GET_EMAIL);
	        checkEmailSt.setString(1, userModel.getEmail());
	        ResultSet checkEmailRs = checkEmailSt.executeQuery();
	        checkEmailRs.next();
	        if (checkEmailRs.getInt(1) > 0) {
	            return -3; // Email already exists
	        }

	        // Register User
	        PreparedStatement st = con.prepareStatement(StringUtils.REGISTER_USER);

	        st.setString(1, userModel.getUsername());
	        st.setString(2, userModel.getFirstName());
	        st.setString(3, userModel.getLastName());
	        st.setDate(4, Date.valueOf(userModel.getDob()));
	        st.setString(5, userModel.getGender());
	        st.setString(6, userModel.getEmail());
	        st.setString(7, userModel.getPhoneNumber());
	        st.setString(8, PasswordEncryptionWithAes.encrypt(
	                userModel.getUsername(), userModel.getPassword()));
	        st.setString(9, userModel.getUsertype());
	        st.setString(10, userModel.getStreet());
	        st.setString(11, userModel.getCity());	        
	        st.setString(12, userModel.getZone()); 
	        st.setString(13, userModel.getPostcode()); 
	        st.setString(14, userModel.getCountry());

	        int result = st.executeUpdate();
	        return result > 0 ? 1 : 0;
	    } catch (SQLException | ClassNotFoundException ex) {
	        ex.printStackTrace();
	        return -1;
	    }
	}
	public int getUserLoginInfo(String username, String password) {
	    try (Connection con = getConnection()) {
	        PreparedStatement st = con.prepareStatement(StringUtils.GET_LOGIN_USER_INFO);
	        st.setString(1, username);
	        ResultSet rs = st.executeQuery();

	        if(rs.next()) {
	            // Username exists in the database
	            String userDb = rs.getString("username");
	            String passwordDb = rs.getString("password");
	            String userType = rs.getString("user_type");

	            // Decrypt the stored password
	            String decryptedPwd = PasswordEncryptionWithAes.decrypt(passwordDb, username);

	            // Check if the username and password match
	            if (decryptedPwd != null && userDb.equals(username) && decryptedPwd.equals(password)) {
	                // Return 1 if login successful
	                return 1;
	            } else {
	                // Return 0 if password doesn't match
	                return 0;
	            }
	        } else {
	            // Username doesn't exist in the database
	            return 0;
	        }

	    } catch (SQLException | ClassNotFoundException ex) {
	        ex.printStackTrace(); // Log exception for debugging
	        return -1;
	    }
	}

}
