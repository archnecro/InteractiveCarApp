package com.example.interactivecarapp;

public class User
{
    private String email;
    private String password;
    private String address;
    private int zip;
    private String phone;
    private String vin;
    private String firstName;
    private String lastName;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
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

    public User(String email, String password, String address, int zip, String phone, String vin,
            String firstName, String lastName)
    {
        setEmail(email);
        setPassword(password);
        setAddress(address);
        setZip(zip);
        setPhone(phone);
        setVin(vin);
        setFirstName(firstName);
        setLastName(lastName);
    }
}
