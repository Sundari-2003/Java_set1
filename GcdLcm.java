import java.util.Scanner;

public class GcdLcm {
    static int findGCD(int a, int b) {
        int gcd = 1;
        int min = Math.min(a, b);

        for (int i = 1; i <= min; i++) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }

        return gcd;
    }

    static int findLCM(int a , int b){
        int lcm = (a * b) / findGCD(a , b);
        return lcm;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();
        System.out.println("The GCD is : " + findGCD(number1, number2));
        System.out.println("The LCM is : " + findLCM(number1, number2));
        sc.close();
    }
}
