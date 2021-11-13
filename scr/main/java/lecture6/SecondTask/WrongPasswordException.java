package lecture6.SecondTask;

public class WrongPasswordException extends Exception{
    public String notValid(){
        return "password is not valid";
    }
}
