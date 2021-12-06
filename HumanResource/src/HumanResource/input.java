package HumanResource;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
//Hàm nhập siêu thần thánh :))
public class input {
    static Scanner input = new Scanner(System.in);
    static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    public input() {
    }

    public static int inputInt() {
        boolean var0 = false;

        while(true) {
            try {
                int i = Integer.parseInt(input.nextLine());
                return i;
            } catch (Exception var2) {
                System.out.println("ban phai nhap 1 kieu so int");
            }
        }
    }

    public static double inputDouble() {
        double i = 0.0D;

        while(true) {
            try {
                i = Double.parseDouble(input.nextLine());
                return i;
            } catch (Exception var3) {
                System.out.println("ban phai nhap 1 kieu so double");
            }
        }
    }

    public static String inputString() {
        return input.nextLine();
    }

    public static String inputDate() {
        Date date = null;
        String day = null;

        while(true) {
            try {
                day = input.nextLine();
                date = formatter.parse(day);
                return day;
            } catch (Exception var3) {
                System.out.println("nhap lai dd/mm/yyyy");
            }
        }
    }

    public static int inputMenu() {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        boolean check = false;

        while(!check) {
            try {
                n = Integer.parseInt(sc.nextLine());
                check = true;
            } catch (Exception var4) {
                System.out.println("Nhập sai rồi bạn hãy nhập lại:");
                sc.nextLine();
            }
        }
        return n;
    }
}
