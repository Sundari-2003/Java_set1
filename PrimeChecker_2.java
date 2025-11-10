import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeChecker_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        
        if(number <= 1) {
            System.out.println(number + " is not a prime number");
            return;
        }
        
        int flag = 1;
        for(int i = 2 ; i <= Math.sqrt(number) ; i++){
            if(number % i == 0 ) {
                flag = 0;
                break;
            }
        }
        
        if(flag == 1) {
            System.out.println(number + " is a prime number");
        }
        else{
            System.out.println("Factors are : ");
            for(int i = 2 ; i <= number ; i++){
                if(number % i == 0 ){
                    System.out.print(i + "\t");
                }
            }
        }
    }
}