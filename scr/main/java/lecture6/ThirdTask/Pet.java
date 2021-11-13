package lecture6.ThirdTask;


import java.util.HashSet;

public class Pet {
    public static void main(String[] args) {

        HashSet<String> pets = new HashSet<>();
        pets.add("Cat 1");
        pets.add("Cat 2");
        pets.add("Cat 3");
        pets.add("Dog 1");
        pets.add("Dog 2");
        pets.add("Dog 3");

        System.out.println(pets);
    }
}
