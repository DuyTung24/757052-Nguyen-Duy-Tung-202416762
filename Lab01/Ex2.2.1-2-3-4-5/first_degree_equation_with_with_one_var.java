package test;

import javax.swing.JOptionPane;

public class first_degree_equation_with_with_one_var {
	public static void main(String[] args) {
		String a, b;
		String strNotification = "";

	    a = JOptionPane.showInputDialog(
	         null,
	         "Please input the first number: ",
	         "Input the first number",
	         JOptionPane.INFORMATION_MESSAGE
	     );
	    
	    b = JOptionPane.showInputDialog(
		         null,
		         "Please input the first number: ",
		         "Input the first number",
		         JOptionPane.INFORMATION_MESSAGE
		 );
	    double numa = Double.parseDouble(a);
	    double numb = Double.parseDouble(b);
	    if (numa == 0) strNotification += "a is equal to 0, not a valid linear equation with 1 variable";
	    else strNotification += "The root of the equation is " + (numb / numa);
	    
	    JOptionPane.showMessageDialog(
		         null,
		         strNotification,
		         "Answer: ",
		         JOptionPane.INFORMATION_MESSAGE
		     );

	}
}