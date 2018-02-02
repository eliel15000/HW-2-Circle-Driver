/*
 * Name: Eliezer Encarnacion
 * Due Date: 02/03/2018
 * Course Number: CSC-112-D01
 * Course Name: Interm Topic/Java Prgrmng
 * Problem Number: HW #2
 * Email: eeencarnacion0001@student.stcc.edu
 * To create a circle class and test it.
 */

import java.util.Scanner;

public class CircleTester {
	
	private static Circle buildCircle(Scanner sc, String prompt) {
		
		double someX, someY, someR;
		
		System.out.println(prompt);
		someX = sc.nextDouble();
		System.out.println("Enter the 'y' value");
		someY = sc.nextDouble();
		do {
			System.out.println("Enter the radius (must be positive)");
			someR = sc.nextDouble();
		}while(someR < 0);
		return new Circle(someX, someY, someR);
		
	}
	
	private static void container(Circle c1, Circle c2) {
		if (c1.contains(c2))
			System.out.println("Circle 1 contains Circle 2");
		else if (c2.contains(c1))
			System.out.println("Circle 2 contains Circle 1");
		else if (c1.overlaps(c2))
			System.out.println("Circle 1 and Circle 2 overlap.");
		else
			System.out.println("Circle 1 and Circle 2 do not overlap and neither contain each other.");
	}
	
	private static void arbitrary(Scanner sc, Circle c1, Circle c2) {
		System.out.println("\nLet's test if a point is inside a circle, Please enter 'x' and 'y' (x, y) of any point:");
		double px = sc.nextDouble();
		double py = sc.nextDouble();
		sc.nextLine();
		System.out.println("Circle 1 " + (c1.contains(px, py) ? "contains " : "does not contain") + " this point.");
		System.out.println("Circle 2 " + (c2.contains(px, py) ? "contains " : "does not contain") + " this point." );
	}
	
	private static void process(Scanner sc, String arg[]) {
		
		Circle c1 = buildCircle(sc, "Please enter the 'x' value for the center (x, y) for Circle 1");
		Circle c2 = buildCircle(sc, "\nNow enter the 'x' value for the center (x, y) for Circle 2");
		
		System.out.printf("\nCircle 1\n%s\n", c1);
		System.out.printf("Area = %.3f     Perimeter = %.3f\n", c1.getArea(), c1.getPerimeter());
		System.out.printf("\nCircle 2\n%s\n", c2);
		System.out.printf("Area = %.3f     Perimeter = %.3f\n", c2.getArea(), c2.getPerimeter());
		
		System.out.printf("\nThe distance between the center of the two circles is: %.3f\n", c1.getDistance(c2));
		
		container(c1, c2);
		
		arbitrary(sc, c1, c2);
	}
	
	private static boolean doThisAgain(Scanner sc, String prompt) {
        System.out.print(prompt);
        String doOver = sc.nextLine();
        return doOver.equalsIgnoreCase("Y");
    }
	
	
	// Action
	public static void main(String[] args) {
		
		final String TITLE = "CSC-112 Circle Homework\n";
		final String CONTINUE_PROMPT = "Do this again? [y/N] ";
		
		System.out.println("Welcome to " + TITLE);
		Scanner sc = new Scanner(System.in);
		
		do {
			process(sc, args);
		} while (doThisAgain(sc, CONTINUE_PROMPT));
		sc.close();
		System.out.println("Thank you for using " + TITLE);
	
	}

}
