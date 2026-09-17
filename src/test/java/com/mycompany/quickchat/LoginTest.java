/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.quickchat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class LoginTest {

    @Test
    public void testCorrectUsername() {

        Login login = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976");

        assertTrue(login.checkUserName());
    }

    @Test
    public void testIncorrectUsername() {

        Login login = new Login(
                "Kyle",
                "Smith",
                "kyle!!!!!!!",
                "Ch&&sec@ke99!",
                "+27838968976");

        assertFalse(login.checkUserName());
    }

    @Test
    public void testCorrectPassword() {

        Login login = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976");

        assertTrue(login.checkPasswordComplexity());
    }

    @Test
    public void testIncorrectPassword() {

        Login login = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "password",
                "+27838968976");

        assertFalse(login.checkPasswordComplexity());
    }

    @Test
    public void testCorrectPhoneNumber() {

        Login login = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976");

        assertTrue(login.checkCellPhoneNumber());
    }

    @Test
    public void testIncorrectPhoneNumber() {

        Login login = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&&sec@ke99!",
                "08966553");

        assertFalse(login.checkCellPhoneNumber());
    }

    @Test
    public void testSuccessfulLogin() {

        Login login = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976");

        assertTrue(
                login.loginUser(
                        "kyl_1",
                        "Ch&&sec@ke99!"));
    }

    @Test
    public void testFailedLogin() {

        Login login = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976");

        assertFalse(
                login.loginUser(
                        "wrong",
                        "wrong"));
    }
}