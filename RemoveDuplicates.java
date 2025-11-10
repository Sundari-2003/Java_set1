import java.util.*;

public class RemoveDuplicates {
    
    // Method 1: Using HashSet (doesn't preserve order)
    public static int[] removeDuplicatesUnordered(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        
        int[] result = new int[set.size()];
        int i = 0;
        for (int num : set) {
            result[i++] = num;
        }
        
        return result;
    }
    
    // Method 2: Using LinkedHashSet (preserves insertion order)
    public static int[] removeDuplicatesOrdered(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        
        int[] result = new int[set.size()];
        int i = 0;
        for (int num : set) {
            result[i++] = num;
        }
        
        return result;
    }
    
    // Method 3: Using Stream API (preserves order)
    public static int[] removeDuplicatesStream(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        
        return Arrays.stream(arr)
                     .distinct()
                     .toArray();
    }
    
    // Method 4: In-place for sorted array (Two Pointer technique)
    public static int removeDuplicatesSorted(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        
        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[j]) {
                j++;
                arr[j] = arr[i];
            }
        }
        
        return j + 1; // Returns new length
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 4, 1, 5, 3, 6};
        
        System.out.println("Original Array: " + Arrays.toString(arr));
        
        // Test Method 1
        int[] result1 = removeDuplicatesUnordered(arr);
        System.out.println("Method 1 (HashSet): " + Arrays.toString(result1));
        
        // Test Method 2
        int[] result2 = removeDuplicatesOrdered(arr);
        System.out.println("Method 2 (LinkedHashSet): " + Arrays.toString(result2));
        
        // Test Method 3
        int[] result3 = removeDuplicatesStream(arr);
        System.out.println("Method 3 (Stream): " + Arrays.toString(result3));
        
        // Test Method 4 (requires sorted array)
        int[] sortedArr = {1, 1, 2, 2, 3, 4, 4, 5, 6, 6};
        System.out.println("\nSorted Array: " + Arrays.toString(sortedArr));
        int newLength = removeDuplicatesSorted(sortedArr);
        System.out.println("Method 4 (Two Pointer): " + 
                          Arrays.toString(Arrays.copyOf(sortedArr, newLength)));
    }
}