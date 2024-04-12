package controller.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DatabaseController;
import model.UserModel;
import util.StringUtils;

/**
 * Serve let implementation class MyFirstServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = {StringUtils.REGISTER_SERVLET})
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    DatabaseController dbController = new DatabaseController();
    
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter printOut = response.getWriter();
		response.setContentType("text/html");
		printOut.print("Hello World!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    /* doGet(request, response);
	    response.setContentType("text/html");
	    PrintWriter printout = response.getWriter();
	    
	    String name = request.getParameter("userName");
	    String age = request.getParameter("userAge"); */
		
		  	String username = request.getParameter(StringUtils.USER_NAME);
	        String firstName = request.getParameter(StringUtils.FIRST_NAME);
	        String lastName = request.getParameter(StringUtils.LAST_NAME);
	        String dobString = request.getParameter(StringUtils.BIRTHDAY);
	        LocalDate dob = LocalDate.parse(dobString);
	        String gender = request.getParameter(StringUtils.GENDER);
	        String email = request.getParameter(StringUtils.EMAIL);
	        String phoneNumber = request.getParameter(StringUtils.PHONE_NUMBER);
	        String password = request.getParameter(StringUtils.PASSWORD);
	        String retypePassword = request.getParameter(StringUtils.RETYPE_PASSWORD);

	        // Additional parameters for UserModel constructor
	        String userType = request.getParameter(StringUtils.USER_TYPE);
	        String street = request.getParameter(StringUtils.STREET);
	        String city = request.getParameter(StringUtils.CITY);
	        String postalCode = request.getParameter(StringUtils.POSTAL_CODE);
	        String zone = request.getParameter(StringUtils.ZONE);
	        String country = request.getParameter(StringUtils.COUNTRY);
		
	        UserModel userModel = new UserModel(username, firstName, lastName, dob, gender, email, phoneNumber, password, userType, street, city, postalCode, zone, country);
		
	        int result = dbController.addUser(userModel);
		
		/* if (result == 1 ) {
			request.setAttribute(StringUtils.SUCCESS_MESSAGE, StringUtils.SUCCESS_REGISTER_MESSAGE);
			response.sendRedirect(request.getContextPath() + StringUtils.LOGIN_PAGE);
		} else if (result == 0) {
			request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.REGISTER_ERROR_MESSAGE);
			request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
			
		} else {
			request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.SERVER_ERROR_MESSAGE);
			request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
		} */
		
		if(password.equals(retypePassword)) {
			switch(result) {
			case 1 -> {
				request.setAttribute(StringUtils.SUCCESS_MESSAGE, StringUtils.SUCCESS_REGISTER_MESSAGE);
				response.sendRedirect(request.getContextPath() + StringUtils.PAGE_URL_LOGIN);
			}
			case 0 -> {
				request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.REGISTER_ERROR_MESSAGE);
				request.getRequestDispatcher(StringUtils.PAGE_URL_REGISTER).forward(request, response);
			}
			case -1 -> {
				request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.SERVER_ERROR_MESSAGE);
				request.getRequestDispatcher(StringUtils.PAGE_URL_REGISTER).forward(request, response);
			}
			case -2 -> {
				request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.USERNAME_ERROR_MESSAGE);
				request.getRequestDispatcher(StringUtils.PAGE_URL_REGISTER).forward(request, response);
			}
			case -3 -> {
				request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.EMAIL_ERROR_MESSAGE);
				request.getRequestDispatcher(StringUtils.PAGE_URL_REGISTER).forward(request, response);
			}
			case -4 -> {
				request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.PHONE_NUMBER_ERROR_MESSAGE);
				request.getRequestDispatcher(StringUtils.PAGE_URL_REGISTER).forward(request, response);
			}
			default -> {
				request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.SERVER_ERROR_MESSAGE);
				request.getRequestDispatcher(StringUtils.PAGE_URL_REGISTER).forward(request, response);
			}
			}
		}else {
			request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.PASSWORD_UNMATCHED_ERROR_MESSAGE);
			request.getRequestDispatcher(StringUtils.PAGE_URL_REGISTER).forward(request, response);
		}
	    
	 
	    }
		
	}
