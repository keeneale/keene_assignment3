package keene_problem2;

public class SavingsAccount {
	private static double annualInterestRate;
	private double savingsBalance;
	
	// Sets account balance
	public SavingsAccount(double inputBalance)
	{
		savingsBalance = inputBalance;
	}
	
	// Calculates new balance after monthly interest
	public double calculateMonthlyInterest()
	{
		int monthsPerYear = 12;
		
		this.savingsBalance += ((savingsBalance * annualInterestRate) / monthsPerYear);
		return this.savingsBalance;
	}
	
	// Changes interest rate
	public static void modifyInterestRate(double newInterestRate)
	{
		annualInterestRate = newInterestRate;
	}
	
	// Prints calculated balance per month
	public void printBalance(int month)
	{
		System.out.printf("Month %d:%s %.2f%n", month, (month >= 10) ? "" : " ", savingsBalance);
	}
}

