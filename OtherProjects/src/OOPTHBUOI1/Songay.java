package OOPTHBUOI1;

import java.util.Scanner;

public class Songay {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month, year;

        while (true) {
            String m = sc.next();
            year = sc.nextInt(); 
            month = thang(m);

            if (month != -1 && year >= 0) break;
            System.out.println("Nhập sai");
        }

        int days;
        switch (month) {
            case 2:
                days = (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) ? 29 : 28;
                break;
            case 4: case 6: case 9: case 11: days = 30; break;
            default: days = 31;
        }

        System.out.println(days);
        sc.close();
    }



    public static int thang(String m) {
        m = m.toLowerCase();
        try {
            int num = Integer.parseInt(m);
            if (num >= 1 && num <= 12) return num;
        } catch (NumberFormatException e) {

        }

        String[] full = {"january","february","march","april","may","june","july","august","september","october","november","december"};
        String[] short3 = {"jan","feb","mar","apr","may","jun","jul","aug","sep","oct","nov","dec"};

    for (int i = 0; i < 12; i++) {
        if (m.equals(full[i]) || m.equals(short3[i])) return i + 1;
    }

    return -1;
}

}