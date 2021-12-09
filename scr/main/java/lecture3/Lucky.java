package lecture3;

import java.util.Random;
//HOMEWORK: RANDOM NUMBERS GENERATOR
public class Lucky {
    public String checkInteger(int[] array, int index) {

        if (array[index]%2 == 0)

            return "I am lucky";

            return "Run again";
    }
}