package lecture3;

import java.util.Random;
//HOMEWORK: RANDOM NUMBERS GENERATOR
public class lectureTask2 {
    public static void main(String[] args) {
        int[] arrNumber = {15, 8, 24, 41, 9, 84};
        Random random = new Random();
        int randomNumber = random.nextInt(arrNumber.length);
        System.out.println(arrNumber[randomNumber]);

        //FIXED: DEFINE THAT RANDOM NUMBER IS EVEN
        if (arrNumber[randomNumber]%2 == 0){
            System.out.print("I am lucky");
        } else {
            System.out.print("Run again");
        }
    }
}