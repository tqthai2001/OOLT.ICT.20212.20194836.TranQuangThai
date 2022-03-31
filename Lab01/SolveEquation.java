import java.util.Scanner;
import java.lang.Math;

public class SolveEquation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // The first-degree equation (linear equation) with one variable
        System.out.println("The first-degree equation (linear equation) with one variable");
        double a, b;
        System.out.println("a * x + b = 0");
        
        do {
            System.out.print("Enter a = ");
            a = scan.nextDouble();
            if (a == 0) System.out.print("Can not enter a = 0!\n");
        } while (a == 0);
        System.out.print("Enter b = ");
        b = scan.nextDouble();

        double x = 0 - (b/a);
        System.out.printf("%f * x + %f = 0\n=> x = %f\n", a, b, x);

        // The system of first-degree equations (linear system) with two variables
        System.out.println("The system of first-degree equations (linear system) with two variables");
        double a11, a12, a21, a22, b1, b2;
        System.out.print("a11 * x1 + a12 * x2 = b1\na21 * x1 + a22 * x2 = b2\n");
        
        System.out.print("Enter a11 = ");
        a11 = scan.nextDouble();
        System.out.print("Enter a12 = ");
        a12 = scan.nextDouble();
        System.out.print("Enter a21 = ");
        a21 = scan.nextDouble();
        System.out.print("Enter a22 = ");
        a22 = scan.nextDouble();
        System.out.print("Enter b1 = ");
        b1 = scan.nextDouble();
        System.out.print("Enter b2 = ");
        b2 = scan.nextDouble();

        double d = a11 * a22 - a12 * a21;
        double d1 = b1 * a22 - b2 * a12;
        double d2 = b2 * a11 - b1 * a21;

        System.out.println(a11 + " * x1 + " + a12 + " * x2 = " + b1);
        System.out.println(a21 + " * x1 + " + a22 + " * x2 = " + b2);

        if (d != 0) {
            double x1 = d1 / d;
            double x2 = d2 / d;
            System.out.println("=> x1 = " + x1 + " ; x2 = " + x2);
        }
        else {
            if (d1 == d2) System.out.println("Infinitely many solutions!");
            else if (d1 != 0 || d2 != 0) System.out.println("No solution!");
        }

        // The second-degree equation with one variable
        System.out.println("The second-degree equation with one variable");
        double a0, b0, c0;
        System.out.println("a * x * x + b * x + c = 0");

        System.out.print("Enter a = ");
        a0 = scan.nextDouble();
        System.out.print("Enter b = ");
        b0 = scan.nextDouble();
        System.out.print("Enter c = ");
        c0 = scan.nextDouble();

        System.out.println(a0 + " * x * x + " + b0 + " * x + " + c0 + " = 0");

        double delta = b0 * b0 - 4 * a0 * c0;
        if (delta < 0) System.out.println("No solution!");
        else if (delta == 0) {
            double x0 = (0 - b0) / (2 * a0);
            System.out.println("=> x = " + x0);
        }
        else {
            double x01 = ((0 - b0) + Math.sqrt(delta)) / (2 * a0);
            double x02 = ((0 - b0) - Math.sqrt(delta)) / (2 * a0);
            System.out.println("=> x1 = " + x01 + " ; x2 = " + x02);
        }
        scan.close();
    }
}