package hust.soict.globalict.Lab01;
import java.util.Scanner;

public class Calculate {
    public static void main(String[] args) {
        double x, y;
        double sum, difference, product, quotient;
        Scanner scan = new Scanner(System.in);
 
        System.out.print("Enter first number: ");
        x = scan.nextDouble();
        System.out.print("Enter second number: ");
        y = scan.nextDouble();

        sum = x + y;
        difference = x - y;
        product = x * y;
        
        if (y == 0) {
            System.out.print("Can not divide by 0!\n");
            System.out.printf("Sum = %f\nDifference = %f\nProduct = %f\n",
                                    sum, difference, product);
        }
        else {
            quotient = x / y;
            System.out.printf("Sum = %f\nDifference = %f\nProduct = %f\nQuotient = %f\n",
                                    sum, difference, product, quotient);
        }
        scan.close();
    }
}