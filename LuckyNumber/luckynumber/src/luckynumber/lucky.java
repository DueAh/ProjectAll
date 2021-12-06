package luckynumber;

import java.util.Random;
import java.util.Scanner;

public class lucky {
   static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        //goi phương thức khơi tạo random
        Random random = new Random();
        // đặt biến
        int num;
        int guess;
        int cout = 0;
        int games = 0;
        int bestScore = 100000;
        int worstScore = 0;

        boolean start = true;
        double average = 0;
        double totalguess = 0;
        System.out.println("guess a number between 1 and 100");
        while (start) {
            num = random.nextInt(100) + 1;

            boolean won = false;
            while (!won) {
                System.out.print("guess a number");
                guess = input();
                cout++;
                if (guess == num) {
                    won = true;
                } else if (guess > num) {
                    System.out.println(guess + "is too high");
                } else if (guess < num) {
                    System.out.println(guess + "is too low");
                }
            }
            System.out.println("that right you guess a number " + cout);
            // xét điểm max min
            bestScore = Math.min(bestScore, cout);
            worstScore = Math.max(worstScore, cout);

            totalguess = totalguess + cout;
            games++;
            average = totalguess / games;
            System.out.println("would you like to play another game (y/n)");
            String sentence = sc.nextLine();
            char letter = sentence.charAt(0);
            if (letter == 'Y' || letter == 'y')
            {start = true;}
            else {
                //kết quả trò chơi
                System.out.println("Over result:");
                System.out.println("total game\t= " + games);
                System.out.println("total guess\t= " + totalguess);
                System.out.println("guess/game\t= " + average);
                System.out.println("Best game\t= " + bestScore );
            }
        }
        }
        //phương thức nhập ktra đầu vào
        public  static  int input(){
            boolean check = false;
            int n = 0;
            while(!check){
                try{
                    n = Integer.parseInt(sc.nextLine());
                    if(n >= 0 && n <= 100){
                        check = true;
                    }else{
                        System.out.println("nhap lai number trong khoan tu 1-100");
                    }}
                    catch(Exception e){
                        System.out.println("Ban phai nhap so! hay nhap lai...");
                    }
                }
            return n;
            }

        }

