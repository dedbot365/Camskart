package model;

import java.io.Serializable;
import java.time.LocalDate;

public class UserModel {
	//private String userid;
    private String username;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String gender;
    private String email;
    private String phoneNumber;
    private String password;
    private String usertype;
    private String street;
    private String city;
    private String zone;
    private String postcode;
    private String country;
    
    
    

    //Constructor with all the attributes   
	public UserModel(String username, String firstName, String lastName, LocalDate dob, String gender, String email,
                     String phoneNumber, String password, String usertype, String street, String city, String zone,
                     String postcode, String country) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.usertype = usertype;
        this.street = street;
        this.city = city;
        this.zone =  zone;
        this.postcode = postcode;
        this.country = country;
        
    }
	//Constructor without any usertype
	public UserModel(String username, String firstName, String lastName, LocalDate dob, String gender, String email,
            String phoneNumber, String password, String street, String city, String zone,
            String postcode, String country) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.street = street;
		this.city = city;
		this.zone = zone;
		this.postcode = postcode;
		this.country = country;
	}
	
	//Default Constructor created
	public UserModel() {};

	
	
	
	//Getter and setter methods
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    
}
