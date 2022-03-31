import java.util.Arrays;
import java.util.Scanner;

public class MyArray {
    public static void main(String[] args) {
        int n, sum = 0;
        double average;

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter no. of elements: ");
        n = scan.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter all the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
            sum += arr[i];
        }
        average = (double) sum / n;

        System.out.println("Original numeric array: "
                        + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("Sorted numeric array: "
                        + Arrays.toString(arr));
        
        System.out.println("Sum = " + sum);
        System.out.println("Average = " + average);
        scan.close();
    }
}