import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HE_RotateArray {
    
    static void rotateArray(int[] input, int d, int n){
        d = d % n;  // Handle d > n
        
        // For LEFT rotation:
        // Step 1: Reverse first d elements
        reverse(input, 0, d - 1);
        
        // Step 2: Reverse remaining n-d elements
        reverse(input, d, n - 1);
        
        // Step 3: Reverse entire array
        reverse(input, 0, n - 1);
    }
    
    private static void reverse(int[] input, int start, int end){
        while(start < end){
            int temp = input[start];
            input[start] = input[end];
            input[end] = temp;
            start++;
            end--;
        }
    }
    
    private static void print(int[] input, int n){
        for(int i = 0; i < n; i++){
            System.out.print(input[i]);
            if(i < n - 1) {
                System.out.print(" ");  // Space between elements
            }
        }
        System.out.println();  // Newline at end
    }
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read n
        int n = Integer.parseInt(br.readLine().trim()); 
        
        // Read array elements from a single line separated by spaces
        String[] elements = br.readLine().trim().split("\\s+");
        int[] input = new int[n];
        for(int i = 0; i < n; i++){
            input[i] = Integer.parseInt(elements[i]); 
        }
        
        // Read d
        int d = Integer.parseInt(br.readLine().trim()); 
        
        // Rotate and print
        rotateArray(input, d, n);
        print(input, n);
    }
}