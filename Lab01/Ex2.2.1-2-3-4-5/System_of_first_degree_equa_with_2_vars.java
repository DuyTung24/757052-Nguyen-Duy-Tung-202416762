package test;
import java.util.Scanner;

public class System_of_first_degree_equa_with_2_vars {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double[][] coe = new double[2][3];
		
		System.out.println("Enter the coefficients of 1st equation in the form a1x + b1y = c1 \n");
		for (int i = 0; i < 3; i++) {
			coe[0][i] = sc.nextDouble();
		}
				
		System.out.println("Enter the coefficients of 2nd equation in the form a2x + b2y = c2 \n");
		for (int i = 0; i < 3; i++) {
			coe[1][i] = sc.nextDouble();
		}
		double a1 = coe[0][0], b1 = coe[0][1], c1 = coe[0][2];
		double a2 = coe[1][0], b2 = coe[1][1], c2 = coe[1][2];
		
		double D = a1 * b2 - a2 * b1;
		double Dx = c1 * b2 - c2 * b1;
		double Dy = a1 * c2 - a2 * c1;
		
		if (D != 0) {
			double x = Dx / D;
			double y = Dy / D;
			System.out.println("The root of the system of equation is: {" + x + ", " + y + '}');
		}
		else {
			System.out.println("The system has no solution or have infinite solutions");
		}
		
	}
}
