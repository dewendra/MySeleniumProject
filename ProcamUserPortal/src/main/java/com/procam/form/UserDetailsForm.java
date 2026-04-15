package com.procam.form;

public class UserDetailsForm {
	
private String firstName;
private String middleName;
private String lastName;
private String mobileNumber;
private String userGender;
private String dateOfBirth;
private String userAddress;
private String searchNationality;
private String nationality;
private String state;




public UserDetailsForm() {
	super();
	// TODO Auto-generated constructor stub
}


public UserDetailsForm(String firstName, String middleName, String lastName, String mobileNumber, String userGender,
		String dateOfBirth, String userAddress, String searchNationality, String nationality, String state) {
	super();
	this.firstName = firstName;
	this.middleName = middleName;
	this.lastName = lastName;
	this.mobileNumber = mobileNumber;
	this.userGender = userGender;
	this.dateOfBirth = dateOfBirth;
	this.userAddress = userAddress;
	this.searchNationality = searchNationality;
	this.nationality = nationality;
	this.state = state;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getMiddleName() {
	return middleName;
}

public void setMiddleName(String middleName) {
	this.middleName = middleName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getMobileNumber() {
	return mobileNumber;
}

public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
}

public String getUserGender() {
	return userGender;
}

public void setUserGender(String userGender) {
	this.userGender = userGender;
}

public String getDateOfBirth() {
	return dateOfBirth;
}

public void setDateOfBirth(String dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}

public String getUserAddress() {
	return userAddress;
}

public void setUserAddress(String userAddress) {
	this.userAddress = userAddress;
}

public String getSearchNationality() {
	return searchNationality;
}

public void setSearchNationality(String searchNationality) {
	this.searchNationality = searchNationality;
}

public String getNationality() {
	return nationality;
}

public void setNationality(String nationality) {
	this.nationality = nationality;
}
public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

@Override
public String toString() {
	return "UserDetailsForm [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
			+ ", mobileNumber=" + mobileNumber + ", userGender=" + userGender + ", dateOfBirth=" + dateOfBirth
			+ ", userAddress=" + userAddress + ", searchNationality=" + searchNationality + ", nationality="
			+ nationality + ", state=" + state + "]";
}




}
