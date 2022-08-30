package com.codeup.barndoor.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    This code was adapted from: https://mkyong.com/regular-expressions/how-to-validate-password-with-regular-expression/
 */
public class Password {

    private static final String PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    public static boolean isValid(final String password) {
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    }




//    public static void main(String[] args) {
//        System.out.println("A4wt1234");
//
//    }


