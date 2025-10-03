package test;
import javax.swing.JOptionPane;

public class ShowTwoNumbers {
	public static void main(String[] args) {
		String strNum1, strNum2;
		String strNotification = "You've just entered: ";
		
		strNum1 = JOptionPane.showInputDialog(null, 
				"Please input the first number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
		strNotification += strNum1 + " and ";
		
		strNum2 = JOptionPane.showInputDialog(null, 
				"Please input the first number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
		
		strNotification += strNum2 + '\n';
		
		//JOptionPane.showMessageDialog(null, strNotification, "Show two numbers", JOptionPane.INFORMATION_MESSAGE);
		
		double num1 = Double.parseDouble(strNum1);
		double num2 = Double.parseDouble(strNum2);
		
		strNotification += "Sum of two number is: " + (num1 + num2) + "\n";
		strNotification += "Difference of two number is: " + (num1 - num2) + "\n";
		strNotification += "Product of two number is: " + (num1 * num2) + "\n";
		
		if (num2 != 0) strNotification += "Quotient of two number is: " + (num1 / num2) + "\n"; 
		else strNotification += "The divisor is equal to 0, can't make the division";
		
		JOptionPane.showMessageDialog(null, strNotification, "The answer is:", JOptionPane.INFORMATION_MESSAGE);
		
		
		System.exit(0);
	}
}
