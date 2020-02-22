package keene_problem1;

import java.util.Random;
import java.util.Scanner;

public class CAI1 {
	static Scanner scn = new Scanner(System.in);
	
	// Contains the program logic
	public static void quiz() 
	{
		// Generate random numbers in the range of 0 to 9 (inclusive)
		Random rand = new Random();
		
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
		
		if (correctAnswer == userResponse)
		{
			displayCorrectResponse();
			return 1;
		}
		
		else
		{
			displayIncorrectResponse();
			return 0;
		}
	}
	
	// Prints out the response when student answers correct answer
	public static void displayCorrectResponse()
	{
		System.out.println("Very good!");
	}
	
	// Prints out the response when student answers incorrect answer
	public static void displayIncorrectResponse()
	{
		System.out.println("No. Please try again.");
	}
	
	public static void main(String[] args)
	{
		quiz();
	}
}






