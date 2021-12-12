package lesson12.Pages;


import java.sql.Timestamp;
import java.util.Date;

public class CustomLogger {
    public static final String PURPLE = "\033[0;95m"; // PURPLE
    public static final String GREEN = "\033[0;92m";  // GREEN
    public static final String YELLOW = "\033[0;93m"; // YELLOW
    public static final String BLUE = "\033[0;94m";   // BLUE
    public static final String CYAN = "\033[0;96m"; // CYAN


    private void printInfo(String message, String color){
        Date date = new Date();
        System.out.println(color);
        System.out.println(new Timestamp(date.getTime()));
        System.out.println(" " + message);
    }
    public void pageOpened(String message){
        printInfo(message, GREEN);
    }
    public void remove(String message){
        printInfo(message, PURPLE);
    }
    public void dataInput(String message){
        printInfo(message, YELLOW);
    }
    public void selectItem(String message){
        printInfo(message, BLUE);
    }
    public void click(String message){
        printInfo(message, CYAN);
    }
}
