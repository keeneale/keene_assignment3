package keene_problem2;

public class SavingsAccountTest {
	public static void main(String[] args) {
		double saver1Balance = 2000.00;
		double saver2Balance = 3000.00;
		double interest4 = 0.04;
		double interest5 = 0.05;
		String saver1Name = "saver1";
		String saver2Name = "saver2";
		int monthsPerYear = 12;
		
		// Create two savings account objects
		SavingsAccount saver1 = new SavingsAccount(saver1Balance);
		SavingsAccount saver2 = new SavingsAccount(saver2Balance);
		
		// Change interest rate to 4%
		SavingsAccount.modifyInterestRate(interest4);
		
		// Calculate and print saver1's 12 month balance
		System.out.printf("%s account balance with %.2f interest rate%n", saver1Name, interest4);
		for (int i = 1; i <= monthsPerYear; i++)
		{
			saver1.calculateMonthlyInterest();
			saver1.printBalance(i);
		}

		// Calculate and print saver2's 12 month balance
		System.out.println();
		System.out.printf("%s account balance with %.2f interest rate%n", saver2Name, interest4);
		for (int i = 1; i <= monthsPerYear; i++)
		{
			saver2.calculateMonthlyInterest();
			saver2.printBalance(i);
		}
		
		// Change interest rate to 5%
		SavingsAccount.modifyInterestRate(interest5);
		
		// Calculate and print saver1, saver2 next month balance
		System.out.printf("%n%s account next month balance %.2f with %.2f interest rate%n", saver1Name, saver1.calculateMonthlyInterest(), interest5);
		System.out.printf("%s account next month balance %.2f with %.2f interest rate%n", saver2Name, saver2.calculateMonthlyInterest(), interest5);
	}
}