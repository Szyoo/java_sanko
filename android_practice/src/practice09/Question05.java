package practice09;

import java.io.IOException;

public class Question05 {

	public static void main(String[] args) {
		Calc calc = new Calc();
		try {
			calc.division(); 
		 } catch (NumberFormatException | IOException | ArithmeticException e) {
			 System.out.println("例外が起きました");
		 }	

	}

}
