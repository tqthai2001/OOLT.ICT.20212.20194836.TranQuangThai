package hust.soict.globalict.Lab01;
import java.util.Scanner;

public class StarsTriangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int i, j, n, k = 0;
        System.out.print("Enter n = ");
        n = scan.nextInt();

        for (i = 1; i <= n; i++, k = 0) {
            for (j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            while (k != 2 * i - 1) {
                System.out.print("*");
                k++;
            }
            System.out.print("\n");
        }
    }
}