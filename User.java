/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment1fx;

import java.time.LocalDate;
import java.util.Arrays;

/**
 *
 * @author MS
 */
public class User {
    private String firstName;
    private String lastName;
    private String id;
    private String eMail;
    private String phone;
    private String password;
    private String confirm;
    private String passwordVerification;
    private String gender;
    private String[] language;
    private Address address;
    private LocalDate dateOfBirth;
    
    public User(){
        
    }
    public User(String firstName, String lastName, String id, LocalDate dateOfBirth, String eMail, String phone, String password, String confirm, String passwordVerification, String country, String gender, String[] language, Address address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.eMail = eMail;
        this.phone = phone;
        this.password = password;
        this.confirm = confirm;
        this.passwordVerification = passwordVerification;
        this.gender = gender;
        this.language = language;
        this.address = address;
    }

    public String getPasswordVerification() {
        return passwordVerification;
    }

    public void setPasswordVerification(String passwordVerification) {
        this.passwordVerification = passwordVerification;
    }

    public String getId() {
        return id;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfrim(String confrim) {
        this.confirm = confrim;
    }

    public String getGender() {
        return gender;
    }

    public String[] getLanguage() {
        return language;
    }

    public void setLanguage(String[] language) {
        this.language = language;
    }

    public Address getAddress() {
        return address;
    }
    
    @Override
    public String toString() {
        return "User{" + "First Name=" + firstName + ", Last Name=" + lastName + ", eMail=" + eMail + ", phone=" + phone + ", password=" + password + ", confrim=" + confirm + ", gender=" + gender + ", language=" + Arrays.toString(language) + ", address=" + address + '}';
    }
    
}
