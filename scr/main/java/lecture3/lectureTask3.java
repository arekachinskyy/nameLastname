package lecture3;

import java.util.Scanner;
//HOMEWORK: RIDDLE
public class lectureTask3 {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        int rounds = 0;
        System.out.println("If I drink, I die. If I eat, I am fine. What am I?");
        while (rounds < 3) {
            String userAnswer = scann.nextLine();
            if (userAnswer.equals("Fire")) {
                System.out.print("Great!");
                break;
            }
           else if (userAnswer.equals("I don't know")) {
                System.out.print("Answer: Fire");
                break;
            }
            else {
                System.out.println("Think again");
                rounds++;
            }
        }

    }
}
