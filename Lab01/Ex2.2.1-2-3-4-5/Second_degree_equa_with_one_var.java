package test;
import java.util.Scanner; 

public class Second_degree_equa_with_one_var {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a, b, c;
		System.out.println("Enter 3 coefficents of the equation: ");
		a = sc.nextDouble();
		b = sc.nextDouble();
		c = sc.nextDouble();
		
		if (a == 0) {
			System.out.println("The 2nd-degree coefficent is equal to 0, not a second degree equation");
			System.exit(0);
		}
		double D = b * b - 4 * a * c;
		if (D < 0) {
			System.out.println("The equation has no real root");	
		}
		else if(D == 0) {
			System.out.println("The equation has double root equal to " + ((-b / (2 * a))));
		}
		else {
			System.out.println("The equation has two roots \n 1st root is: " + ((-b + Math.pow(D, 0.5)) / (2 * a)) + "\n 2nd root is: " + ((-b - Math.pow(D, 0.5)) / (2 * a)));
		}
		
	}
	
}
