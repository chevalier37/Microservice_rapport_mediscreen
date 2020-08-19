package com.mediscreen.model;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

public class Patient {

	private int id;

	private String firstName;

	private String familyName;

	private LocalDate dateOfBirth;

	private Gender gender;

	private String address;

	private String phone;

	public Patient(@NotBlank(message = "First Name is mandatory") String firstName,
			@NotBlank(message = "Family Name is mandatory") String familyName,
			@NotBlank(message = "Date of birth is mandatory") LocalDate dateOfBirth,
			@NotBlank(message = "Gender is mandatory") Gender gender, String address, String phone) {
		this.firstName = firstName;
		this.familyName = familyName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", firstName=" + firstName + ", familyName=" + familyName + ", dateOfBirth="
				+ dateOfBirth + ", gender=" + gender + ", address=" + address + ", phone=" + phone + "]";
	}

}
