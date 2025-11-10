import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseANumber  {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(reader.readLine());
        System.out.println("The number is :" + number);
        int  result = 0;
        while(number != 0){
            int digit = number % 10;
            result = result * 10 + digit;
            number = number / 10;
        }

        System.out.println("The reverse is : " + result);
    }
}
