import java.util.Scanner;

public class SummingDigits_3 {
    public static void main(String[] args) {
        
    Scanner sc = new Scanner(System.in);

    int number = sc.nextInt();

    while(number >= 10){
        int result = 0;
        while(number > 0){
        int digit = number % 10;
        result = result +  digit;
        number = number/10;
    }
    number = result;
}

System.out.println("The single digit result is : " + number);

    sc.close();
}
}
