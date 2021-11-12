package lecture6.SecondTask;

import java.util.Scanner;

public class Credentials {

    public static void main(String[] args) {
        Scanner credentialsInput = new Scanner(System.in);
        String login = credentialsInput.nextLine();
        String password = credentialsInput.nextLine();
        String confirmPassword = credentialsInput.nextLine();
    }

    public static boolean isLoginValid(String login) {
        if (login.matches("[A-Za-z0-9_]*" ) || login.length() > 1 || login.length() < 20){
            return true;
        }
        else
            return false;
        }

        public static boolean isPasswordValid(String password){
            if (password.matches("[A-Za-z0-9_]*" ) || password.length() > 1 || password.length() < 20){
                return true;
            }
            else
                return false;
        }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static boolean ifValid(String login, String password, String confirmPassword){
        try {
            if (!isLoginValid(login)) {
                throw new WrongLoginException();
            } else if (!isPasswordValid(password) || password.equals(confirmPassword)) {
                throw new WrongPasswordException();
            }
        } catch (WrongLoginException e) {
            System.out.println(e.notValid());
        }
        catch (WrongPasswordException e) {
            System.out.println(e.notValid());
        }
        return true;
    }

}

