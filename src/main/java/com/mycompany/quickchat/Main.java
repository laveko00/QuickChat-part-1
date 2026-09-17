/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("   QUICKCHAT REGISTRATION");
        System.out.println("================================");

        System.out.print("Enter First Name: ");
        String firstName = input.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = input.nextLine();

        System.out.print("Enter Username: ");
        String username = input.nextLine();

        System.out.print("Enter Password: ");
        String password = input.nextLine();

        System.out.print("Enter Cell Number (+27): ");
        String cellNumber = input.nextLine();

        Login user = new Login(
                firstName,
                lastName,
                username,
                password,
                cellNumber);

        if (user.checkUserName()) {

            System.out.println(
                    "Username successfully captured.");

        } else {

            System.out.println(
                    "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
        }

        if (user.checkPasswordComplexity()) {

            System.out.println(
                    "Password successfully captured.");

        } else {

            System.out.println(
                    "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
        }

        if (user.checkCellPhoneNumber()) {

            System.out.println(
                    "Cell phone number successfully added.");

        } else {

            System.out.println(
                    "Cell phone number incorrectly formatted or does not contain international code.");
        }

        if (user.checkUserName()
                && user.checkPasswordComplexity()
                && user.checkCellPhoneNumber()) {

            System.out.println(
                    "\nUser successfully registered.");

            System.out.println("\nLOGIN");

            System.out.print("Username: ");
            String loginUsername = input.nextLine();

            System.out.print("Password: ");
            String loginPassword = input.nextLine();

            boolean loginSuccess =
                    user.loginUser(
                            loginUsername,
                            loginPassword);

            System.out.println(
                    user.returnLoginStatus(loginSuccess));

        } else {

            System.out.println(
                    "\nRegistration failed.");
        }
    }
}