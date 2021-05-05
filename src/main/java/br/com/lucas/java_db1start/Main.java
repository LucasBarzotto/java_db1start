package br.com.lucas.java_db1start;

public class Main {

    public static void main(String[] args) {

        PasswordMeterV1 myPassword = new PasswordMeterV1();

        myPassword.checkPassword("a23b#c12@a33!");
        System.out.println(myPassword);

    }

}
