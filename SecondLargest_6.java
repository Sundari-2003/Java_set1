import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SecondLargest_6{
    public static void main(String[] args) {

        // ***********************************
        //          Approach - 1
        // ***********************************

        // List<Integer> input = new ArrayList<>();
        // input.add(50);
        // input.add(40);
        // input.add(30);
        // input.add(20);
        // input.add(10);

        // Collections.sort(input , Collections.reverseOrder());
        // System.out.println("The Second largest element is : " + input.get(1));


        int[] input = new int[]{5 , 4 , 3 , 2 , 1};
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for(int num : input){
            if(num > largest){
                secondLargest = largest;
                largest = num;
            }

            else if(num > secondLargest && num != largest){
                secondLargest = num;
            }
        }
        System.out.println("Second largest :" + secondLargest);

    }


}