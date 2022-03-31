import java.util.Scanner;

public class AddMatrices {
    public static void main(String[] args) {
        int row, col;
        
        Scanner scan = new Scanner(System.in);
        System.out.print("Input number of rows: ");
        row = scan.nextInt();
        System.out.print("Input number of columns: ");
        col = scan.nextInt();

        int array1[][] = new int[row][col];
        int array2[][] = new int[row][col];
        int sum[][] = new int[row][col];

        // Input Data
        System.out.println("Input elements of first matrix");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                array1[i][j] = scan.nextInt();
            }
        }

        System.out.println("Input elements of second matrix");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                array2[i][j] = scan.nextInt();
            }
        }

        // Print Matrix
        System.out.println("Matrix 1");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(array1[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Matrix 2");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(array2[i][j] + " ");
            }
            System.out.println();
        }

        // Add Matrices
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sum[i][j] = array1[i][j] + array2[i][j];
            }
        }

        // Print Sum
        System.out.println("Sum");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }
        scan.close();
    }
}