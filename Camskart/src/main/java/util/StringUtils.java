package util;

public class StringUtils {
	//Start SQL Queries
	public static final String REGISTER_USER = "INSERT INTO users "
	        + "(username, first_name, last_name, dob, gender, email, phone_no, password, user_type, street, city, postal_code, zone, country) "
	        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, IFNULL(?, '2'), ?, ?, ?, ?, ?)";




	public static final String GET_LOGIN_USER_INFO = "SELECT * FROM users WHERE username = ?";

	public static final String GET_ALL_USER_INFO = "SELECT * FROM users";

	public static final String GET_USERNAME = "SELECT COUNT(*) FROM users WHERE username = ?";
	
	public static final String GET_USER_TYPE = "SELECT user_type FROM users WHERE username = ?";

	public static final String GET_PHONE = "SELECT COUNT(*) FROM users WHERE phone_no = ?";

	public static final String GET_EMAIL = "SELECT COUNT(*) FROM users WHERE email = ?";

	public static final String GET_ADDRESS = "SELECT * FROM users WHERE street = ? AND city = ? AND postal_code = ? AND zone = ? AND country = ?";


	//End SQL Queries
	
	// Start Parameter names
	public static final String USER_NAME = "username";
	public static final String FIRST_NAME = "first_name";
	public static final String LAST_NAME = "last_name";
	public static final String BIRTHDAY = "birthday";
	public static final String GENDER = "gender";
	public static final String EMAIL = "email";
	public static final String PHONE_NUMBER = "phone_no";
	public static final String PASSWORD = "password";
	public static final String RETYPE_PASSWORD =  "retypePassword";
	public static final String STREET = "street";
	public static final String CITY = "city";
	public static final String POSTAL_CODE = "postal_code";
	public static final String ZONE = "zone";
	public static final String COUNTRY = "country";
	public static final String USER_TYPE = "user_type";
	// End Parameter names

	
	
	
	// Start messages
		public static final String SUCCESS_REGISTER_MESSAGE = "Successfully Registered!";
		public static final String REGISTER_ERROR_MESSAGE = "Please correct the form data.";
		public static final String SERVER_ERROR_MESSAGE = "An unexpected server error occurred.";
		public static final String USERNAME_ERROR_MESSAGE = "Username is already registered.";
		public static final String EMAIL_ERROR_MESSAGE = "Email is already registered";
		public static final String PHONE_NUMBER_ERROR_MESSAGE = "Phone number is already registered";
		public static final String PASSWORD_UNMATCHED_ERROR_MESSAGE = "Password is not matched.";
		public static final String SUCCESS_MESSAGE = "successMessage";
		public static final String ERROR_MESSAGE = "errorMessage";
		public static final String LOGIN_FAIL ="Incorrect username or password";
		// End messages
		// Login Page Messages
		public static final String MESSAGE_SUCCESS_LOGIN = "Successfully LoggedIn!";
		public static final String MESSAGE_ERROR_LOGIN = "Either username or password is not correct!";
		public static final String MESSAGE_ERROR_CREATE_ACCOUNT = "Account for this username is not registered! Please create a new account.";

			// Other Messages
		public static final String MESSAGE_ERROR_SERVER = "An unexpected server error occurred.";
		public static final String MESSAGE_SUCCESS_DELETE = "Successfully Deleted!";
		public static final String MESSAGE_ERROR_DELETE = "Cannot delete the user!";
		public static final String MESSAGE_SUCCESS = "successMessage";
		public static final String MESSAGE_ERROR = "errorMessage";
		// End: Validation Messages
		
		// Start JSP Route
		public static final String PAGE_URL_LOGIN = "/pages/login.jsp";
		public static final String PAGE_URL_REGISTER = "/pages/register.jsp";
		public static final String PAGE_URL_WELCOME = "/pages/welcome.jsp";
		public static final String PAGE_URL_ADMIN = "/pages/admin.jsp";
		public static final String PAGE_URL_FOOTER = "pages/footer.jsp";
		public static final String PAGE_URL_HEADER = "pages/header.jsp";
		public static final String URL_LOGIN = "/login.jsp";
		public static final String URL_INDEX = "/index.jsp";
		// End: JSP Route
		// END JSP Route
		
		// Start Servlet Route
		public static final String REGISTER_SERVLET = "/RegisterServlet";
		// End Servlet Route
		// Start: Normal Text
		public static final String USER = "user";
		public static final String JSESSIONID = "JSESSIONID";
		public static final String LOGIN = "Login";
		public static final String LOGOUT = "Logout";
			// End: Normal Text
		// Start: Servlet Route
		public static final String SERVLET_URL_LOGIN = "/login";
		public static final String SERVLET_URL_REGISTER = "/registeruser";
		public static final String SERVLET_URL_LOGOUT = "/logout";
		// End: Servlet Route
}