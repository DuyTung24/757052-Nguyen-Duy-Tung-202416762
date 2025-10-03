import java.util.Scanner;

public class Add_mul_maxtrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows of first matrix: ");
        int r1 = sc.nextInt();
        System.out.print("Enter number of columns of first matrix: ");
        int c1 = sc.nextInt();

        System.out.print("Enter number of rows of second matrix: ");
        int r2 = sc.nextInt();
        System.out.print("Enter number of columns of second matrix: ");
        int c2 = sc.nextInt();

        int[][] matrix1 = new int[r1][c1];
        int[][] matrix2 = new int[r2][c2];

        System.out.println("Enter elements of first matrix:");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                matrix1[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter elements of second matrix:");
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                matrix2[i][j] = sc.nextInt();
            }
        }


        if (r1 == r2 && c1 == c2) {
            int[][] sum = new int[r1][c1];
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c1; j++) {
                    sum[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            }
            System.out.println("\nResult of Matrix Addition:");
            printMatrix(sum);
        } else {
            System.out.println("\nMatrix addition not possible (different sizes).");
        }

        // Day la phan nhan ma tran (bai tap bo sung de cong diem)
        if (c1 == r2) {
            int[][] product = new int[r1][c2];
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c2; j++) {
                    product[i][j] = 0;
                    for (int k = 0; k < c1; k++) {
                        product[i][j] += matrix1[i][k] * matrix2[k][j];
                    }
                }
            }
            System.out.println("\nResult of Matrix Multiplication:");
            printMatrix(product);
        } else {
            System.out.println("\nMatrix multiplication not possible (columns of A != rows of B).");
        }

        sc.close();
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
