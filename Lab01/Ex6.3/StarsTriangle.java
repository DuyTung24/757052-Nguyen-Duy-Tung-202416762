import java.util.Scanner;

public class StarsTriangle {
	public static void main(String[] args) {
		System.out.println("Enter the height of the triangle: ");
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < 2 * i + 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
