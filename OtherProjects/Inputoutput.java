package OOP.OOPTHBUOI1;

import java.util.Scanner;

public class Inputoutput {
    public static void main(String args[]) {
        Scanner keyboard1 = new Scanner(System.in);
        System.out.println("What's your name?");
        String strName = keyboard1.nextLine();
        System.out.println("How old are you?");
        int iAge = keyboard1.nextInt();
        System.out.println("How tall are you (m)?");
        double dHeight = keyboard1.nextDouble();
        System.out.println("Mrs/Ms. " + strName + ", " + iAge + " years old. "
                + "Your height is " + dHeight + ".");
        keyboard1.close();
    }
}
