package lecture;

import java.util.Scanner;

public class lectureTask {
    public static void main(String[] args) {

        Scanner height = new Scanner("'height'");
        Scanner count = new Scanner("'count'");
        String a = height.nextLine();
        String b = count.nextLine();

        System.out.print("The height building "  + a + " m and " + b + " floors");
    }
}
