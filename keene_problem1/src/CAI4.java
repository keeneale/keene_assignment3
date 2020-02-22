package keene_problem1;

import java.util.Random;
import java.util.Scanner;

public class CAI4 {
	static Scanner scn = new Scanner(System.in);
	static Random rand = new Random();
	
	// Contains the program logic
	public static void quiz() 
	{
		int exitResponse = 1;
	
		// Continue to present user with problem sets until they wish to exit
		while (exitResponse == 1)
		{
			// Prompt user to enter a difficulty level
			int userDifficulty = readDifficulty();
			int difficultyFactor = generateQuestionArgument(userDifficulty);
			
			int questionCount = 0;
			int userResponse;
			int numCorrectResponses = 0;
			
			// Continue to ask questions until 10 are answered
			while (questionCount < 10) 
			{
				// Generate random numbers in the range
				int num1 = rand.nextInt(difficultyFactor);
				int num2 = rand.nextInt(difficultyFactor);
				
				askQuestion(num1, num2);
				userResponse = readResponse();
				numCorrectResponses += isAnswerCorrect(num1, num2, userResponse);
				questionCount++;
			}
			
			int userScore = numCorrectResponses * 10;
			displayCompletionMessage(userScore);	
			
			System.out.println("Would you like to try another problem set?");
			System.out.println("Enter 0 to exit or 1 to continue");
			
			exitResponse = readResponse();
		}
		
		// Terminate program
		System.exit(0);
	}
	
	// Reads the difficulty level from user
	public static int readDifficulty()
	{
		System.out.println("Please enter a difficulty level");
		System.out.println("1 - Multiplication with numbers 0 - 9");
		System.out.println("2 - Multiplication with numbers 0 - 99");
		System.out.println("3 - Multiplication with numbers 0 - 999");
		System.out.println("4 - Multiplication with numbers 0 - 9999");
		
		int userDifficulty = readResponse();
		return userDifficulty;
	}
	
	// Uses the difficulty level to generate a random number
	public static int generateQuestionArgument(int userDifficulty)
	{
		// Translate difficulty level into number range
		if (userDifficulty == 1)
			return 10;
		else if (userDifficulty == 2)
			return 100;
		else if (userDifficulty == 3)
			return 1000;
		else if (userDifficulty == 4)
			return 10000;
		else
		{
			System.out.println("Incorrect difficulty level entered");
			System.exit(0);
			return 0;
		}
	}
	
	// Prints out the student's score and appropriate score response
	public static void displayCompletionMessage(int userScore)
	{
			
		System.out.printf("%nYour score is %d%%%n", userScore);
			
		if (userScore > 75)
			System.out.printf("Congratulations, you are ready to go to the next level!%n%n");
		else
			System.out.printf("Please ask your teacher for extra help.%n%n");
	}
	
	// Prints the problem to the screen
	public static void askQuestion(int num1, int num2)
	{
		// The program shall ask the student to solve a multiplication problem
		System.out.printf("%nWhat is %d times %d?%n", num1, num2);
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
	
	// Prints out a response when student answers correct answer
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
	
	// Prints out a response when student answers incorrect answer
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
