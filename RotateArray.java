import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RotateArray {
    
    // Method 1: Using Extra Array (Simple approach)
    public static int[] rotateUsingExtraArray(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        
        int n = arr.length;
        k = k % n; // Handle k > n
        
        int[] result = new int[n];
        
        // Copy last k elements to front
        for (int i = 0; i < k; i++) {
            result[i] = arr[n - k + i];
        }
        
        // Copy first n-k elements to back
        for (int i = 0; i < n - k; i++) {
            result[k + i] = arr[i];
        }
        
        return result;
    }
    
    // Method 2: Using Reversal Algorithm (Most Optimal)
    public static void rotateUsingReversal(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return;
        }
        
        int n = arr.length;
        k = k % n;
        
        // Step 1: Reverse entire array
        reverse(arr, 0, n - 1);
        
        // Step 2: Reverse first k elements
        reverse(arr, 0, k - 1);
        
        // Step 3: Reverse remaining n-k elements
        reverse(arr, k, n - 1);
    }
    
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    
    // Method 3: Using Cyclic Replacement (Space Efficient)
    public static void rotateUsingCyclicReplacement(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return;
        }
        
        int n = arr.length;
        k = k % n;
        
        int count = 0;
        for (int start = 0; count < n; start++) {
            int current = start;
            int prev = arr[start];
            
            do {
                int next = (current + k) % n;
                int temp = arr[next];
                arr[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
    
    // Method 4: Using ArrayList rotation (Collection approach)
    public static int[] rotateUsingCollections(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        
        int n = arr.length;
        k = k % n;
        
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        
        Collections.rotate(list, k);
        
        for (int i = 0; i < n; i++) {
            arr[i] = list.get(i);
        }
        
        return arr;
    }
    
    // Method 5: Rotate Left (Bonus - opposite direction)
    public static void rotateLeft(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return;
        }
        
        int n = arr.length;
        k = k % n;
        
        // Rotating left by k is same as rotating right by n-k
        rotateUsingReversal(arr, n - k);
    }
    
    public static void main(String[] args) {
        // Test arrays
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        int[] arr3 = {1, 2, 3, 4, 5, 6, 7};
        int[] arr4 = {1, 2, 3, 4, 5, 6, 7};
        int[] arr5 = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        
        System.out.println("Original Array: " + Arrays.toString(arr1));
        System.out.println("Rotate right by k = " + k + " positions\n");
        
        // Test Method 1
        int[] result1 = rotateUsingExtraArray(arr1, k);
        System.out.println("Method 1 (Extra Array): " + Arrays.toString(result1));
        
        // Test Method 2
        rotateUsingReversal(arr2, k);
        System.out.println("Method 2 (Reversal): " + Arrays.toString(arr2));
        
        // Test Method 3
        rotateUsingCyclicReplacement(arr3, k);
        System.out.println("Method 3 (Cyclic): " + Arrays.toString(arr3));
        
        // Test Method 4
        rotateUsingCollections(arr4, k);
        System.out.println("Method 4 (Collections): " + Arrays.toString(arr4));
        
        // Test Method 5 (Left rotation)
        rotateLeft(arr5, k);
        System.out.println("Method 5 (Rotate Left by " + k + "): " + Arrays.toString(arr5));
        
        // Edge cases
        System.out.println("\n--- Edge Cases ---");
        int[] arr6 = {1, 2, 3};
        rotateUsingReversal(arr6, 10); // k > n
        System.out.println("k > n (k=10, n=3): " + Arrays.toString(arr6));
        
        int[] arr7 = {1, 2, 3, 4, 5};
        rotateUsingReversal(arr7, 0); // k = 0
        System.out.println("k = 0: " + Arrays.toString(arr7));
    }
}