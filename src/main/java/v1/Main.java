package v1;

public class Main {

    public static void main(String[] args) {

        PasswordMeterV1 passMeter = new PasswordMeterV1();

        passMeter.checkPassword("123456");

        System.out.println(passMeter);

    }

}
