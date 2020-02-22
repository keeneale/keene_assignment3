package keene_problem1;

import java.util.Random;
import java.util.Scanner;

public class CAI2 {
	static Scanner scn = new Scanner(System.in);
	static Random rand = new Random();
	
	// Contains the program logic
	public static void quiz() 
	{
		// Generate random numbers in the range of 0 to 9 (inclusive)
		int num1 = rand.nextInt(10);
		int num2 = rand.nextInt(10);
		
		int x = 0;
		int userResponse;
		
		// Continue to prompt question until correct answer is given
		while (x == 0) 
		{
			askQuestion(num1, num2);
			userResponse = readResponse();
			x = isAnswerCorrect(num1, num2, userResponse);
		}
		
		// The program shall terminate when a correct response is provided by the student
		System.exit(0);		
	}
	
	// Prints the problem to the screen
	public static void askQuestion(int num1, int num2)
	{
		// The program shall ask the student to solve a multiplication problem
		System.out.printf("What is %d times %d?%n", num1, num2);
	}
	
	// Reads answer from the student
	public static int readResponse()
	{
		int userResponse = scn.nextInt();
		
		return userResponse;
	}
	
	// Checks to see if the student's answer matches the correct answer
	public static int isAnswerCorrect(int num1, int num2, int userResponse)
	{
		int correctAnswer = num1 * num2;
		int randomResponseNum = rand.nextInt(4) + 1;
		
		if (correctAnswer == userResponse)
		{
			displayCorrectResponse(randomResponseNum);
			return 1;
		}
		
		else
		{
			displayIncorrectResponse(randomResponseNum);
			return 0;
		}
	}
	
	// Prints out the response when student answers correct answer
	public static void displayCorrectResponse(int randomResponseNum)
	{
		switch(randomResponseNum)
		{
			case 1:
				System.out.println("Very good!");
				break;
				
			case 2:
				System.out.println("Excellent!");
				break;
			
			case 3:
				System.out.println("Nice Work!");
				break;
				
			case 4:
				System.out.println("Keep up the good work!");
				break;
		}
	}
	
	// Prints out the response when student answers incorrect answer
	public static void displayIncorrectResponse(int randomResponseNum)
	{
		switch(randomResponseNum)
		{
			case 1:
				System.out.println("No. Please try again.");
				break;
				
			case 2:
				System.out.println("Wrong. Try once more.");
				break;
				
			case 3:
				System.out.println("Don't give up!");
				break;
		
			case 4:
				System.out.println("No. Keep trying.");
		}
	}
	
	public static void main(String[] args)
	{
		quiz();
	}
}
