package keene_problem1;

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI5 {
	static Scanner scn = new Scanner(System.in);
	static SecureRandom rand = new SecureRandom();

	// Contains the program logic
	public static void quiz()
	{
		double exitResponse = 1;

		// Continue to present user with problem sets until they wish to exit
		while (exitResponse == 1)
		{
			double questionCount = 0;
			double numCorrectResponses = 0;

			// Prompt user to enter a difficulty level
			double userDifficulty = (int)readDifficulty();
			double difficultyFactor = (int)generateQuestionArgument(userDifficulty);
			// Prompt user to enter a problem type
			double userProblemType = (int)readProblemType();


			// Randomly selects a problem type if "All of the above" option selected
			if (userProblemType == 5)
			{
				// Continue to ask questions until 10 are answered
				while (questionCount < 10)
				{
					userProblemType = rand.nextInt(4) + 1;

					// Generate random numbers in the range
					double num1 = rand.nextInt((int) difficultyFactor);
					double num2 = rand.nextInt((int) difficultyFactor);
					
					// If division problem and a number is 0, randomly pick a new number
					if (userProblemType == 4 && num1 == 0)
						num1 = rand.nextInt((int) difficultyFactor);
					if (userProblemType == 4 && num2 == 0)
						num2 = rand.nextInt((int) difficultyFactor);

					askQuestion(num1, num2, userProblemType);
					double userResponse = readResponse();
					numCorrectResponses += isAnswerCorrect(num1, num2, userResponse, userProblemType);
					questionCount++;
				}
			}
			else
			{
				// Continue to ask questions until 10 are answered
				while (questionCount < 10)
				{
					// Generate random numbers in the range
					double num1 = rand.nextInt((int) difficultyFactor);
					double num2 = rand.nextInt((int) difficultyFactor);
					
					// If division problem and a number is 0, randomly pick a new number
					if (userProblemType == 4 && num1 == 0)
						num1 = rand.nextInt((int) difficultyFactor);
					if (userProblemType == 4 && num2 == 0)
						num2 = rand.nextInt((int) difficultyFactor);

					askQuestion(num1, num2, userProblemType);
					double userResponse = readResponse();
					numCorrectResponses += isAnswerCorrect(num1, num2, userResponse, userProblemType);
					questionCount++;
				}
			}

			// Calculate and display user score
			double userScore = numCorrectResponses * 10;
			displayCompletionMessage(userScore);
			
			// Ask user if they want another problem set
			System.out.println("Would you like to try another problem set?");
			System.out.println("Enter 0 to exit or 1 to continue");

			exitResponse = readResponse();
		}

		// Terminate program
		System.exit(0);
	}

	// Reads the difficulty level from user
	public static double readDifficulty()
	{
		System.out.println("Please select a difficulty level");
		System.out.println("1 - Problem set with numbers 0 - 9");
		System.out.println("2 - Problem set with numbers 0 - 99");
		System.out.println("3 - Problem set with numbers 0 - 999");
		System.out.println("4 - Problem set with numbers 0 - 9999");

		// Read user difficulty choice
		double userDifficulty = (int)readResponse();
		System.out.printf("You have selected difficultly level %d%n", (int)userDifficulty);

		return userDifficulty;
	}

	// Reads the problem type from user
	public static double readProblemType()
	{
		System.out.println("Please select a problem type");
		System.out.println("1 - Addition problems");
		System.out.println("2 - Multiplication problems");
		System.out.println("3 - Subtraction problems");
		System.out.println("4 - Division problems");
		System.out.println("5 - All of the above");
		
		// Read user problem choice
		double userProblemType = (int)readResponse();
		System.out.printf("You have selected problem type %d%n", (int)userProblemType);

		return userProblemType;
	}

	// Uses the difficulty level to generate a random number
	public static double generateQuestionArgument(double userDifficulty)
	{
		// Translate difficulty level into number range
		if ((int)userDifficulty == 1)
			return 10;
		else if ((int)userDifficulty == 2)
			return 100;
		else if ((int)userDifficulty == 3)
			return 1000;
		else if ((int)userDifficulty == 4)
			return 10000;
		else
		{
			System.out.println("Incorrect difficulty level entered");
			System.exit(0);
			return 0;
		}
	}

	// Prints out the student's score and appropriate score response
	public static void displayCompletionMessage(double userScore)
	{

		System.out.printf("%nYour score is %d%%%n", (int)userScore);

		if ((int)userScore > 75)
			System.out.printf("Congratulations, you are ready to go to the next level!%n%n");
		else
			System.out.printf("Please ask your teacher for extra help.%n%n");
	}

	// Prints the problem to the screen
	public static void askQuestion(double num1, double num2, double userProblemType)
	{
		// Asks student to solve a problem of their selection choice
		if ((int)userProblemType == 1)
			System.out.printf("%nWhat is %d plus %d?%n", (int)num1, (int)num2);
		else if ((int)userProblemType == 2)
			System.out.printf("%nWhat is %d times %d?%n", (int)num1, (int)num2);
		else if ((int)userProblemType == 3)
			System.out.printf("%nWhat is %d minus %d?%n", (int)num1, (int)num2);
		else if ((int)userProblemType == 4)
			System.out.printf("%nWhat is %d divided by %d?%n", (int)num1, (int)num2);
	}

	// Reads answer from the student
	public static double readResponse()
	{
		double userResponse = scn.nextDouble();

		return userResponse;
	}

	// Checks to see if the student's answer matches the correct answer
	public static int isAnswerCorrect(double num1, double num2, double userResponse, double userProblemType)
	{
		double correctAnswer = -1;

		// Determine what kind of problem to calculate
		if (userProblemType == 1)
			correctAnswer = num1 + num2;
		else if (userProblemType == 2)
			correctAnswer = num1 * num2;
		else if (userProblemType == 3)
			correctAnswer = num1 - num2;
		else if (userProblemType == 4)
			correctAnswer = num1 / num2;


		double randomResponseNum = rand.nextInt(4) + 1;

		// Checks if user answer is within 0.01 of the correct answer
		if (Math.abs(correctAnswer - userResponse) < 0.01)
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
	public static void displayCorrectResponse(double randomResponseNum)
	{
		switch((int) randomResponseNum)
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
	public static void displayIncorrectResponse(double randomResponseNum)
	{
		switch((int) randomResponseNum)
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
