package lectureTwo;

import java.util.Random;
//HOMEWORK: RANDOM NUMBERS GENERATOR
public class lectureTaskTwo {
    public static void main(String[] args) {
        int[] arrNumber = {15, 8, 24, 41, 9, 84};
        Random random = new Random();
        int randomNumber = random.nextInt(arrNumber.length);

        if (arrNumber[randomNumber] > 10){
            System.out.print("I am lucky");
        } else {
            System.out.print("Run again");
        }
    }
}