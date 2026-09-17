/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;

public class Login {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String cellPhoneNumber;

    public Login(String firstName, String lastName,
                 String username, String password,
                 String cellPhoneNumber) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public boolean checkUserName() {

        return username.contains("_")
                && username.length() <= 5;
    }

    public boolean checkPasswordComplexity() {

        String regex =
                "^(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{8,}$";

        return password.matches(regex);
    }

    /*
     Reference:
     https://docs.oracle.com/javase/tutorial/essential/regex/

     South African number format:
     +27 followed by 9 digits.
    */
    public boolean checkCellPhoneNumber() {

        return cellPhoneNumber.matches("^\\+27\\d{9}$");
    }

    public String registerUser() {

        if (!checkUserName()) {

            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        if (!checkPasswordComplexity()) {

            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber()) {

            return "Cell phone number incorrectly formatted or does not contain international code.";
        }

        return "User has been registered successfully.";
    }

    public boolean loginUser(String enteredUsername,
                             String enteredPassword) {

        return username.equals(enteredUsername)
                && password.equals(enteredPassword);
    }

    public String returnLoginStatus(boolean loginSuccessful) {

        if (loginSuccessful) {

            return "Welcome "
                    + firstName
                    + ", "
                    + lastName
                    + " it is great to see you again.";
        }

        return "Username or password incorrect, please try again.";
    }
}