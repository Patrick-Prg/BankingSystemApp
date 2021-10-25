package banking;

import java.util.LinkedHashMap;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts;
	private Long nextAccNum = new Long("0");

	public Bank() {
		accounts = new LinkedHashMap<Long, Account>();
	}

	private Account getAccount(Long accountNumber) {
		return accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		nextAccNum += 1;
		CommercialAccount a = new CommercialAccount(company, nextAccNum, pin, startingDeposit);
		accounts.put(nextAccNum,a);

		return nextAccNum;
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		nextAccNum += 1;
		ConsumerAccount a = new ConsumerAccount(person, nextAccNum, pin, startingDeposit);
		accounts.put(nextAccNum, a);

        return nextAccNum;
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		return accounts.get(accountNumber).validatePin(pin);
	}

	public double getBalance(Long accountNumber) {
		return accounts.get(accountNumber).getBalance();
	}

	public void credit(Long accountNumber, double amount) {
		accounts.get(accountNumber).creditAccount(amount);
	}

	public boolean debit(Long accountNumber, double amount) {
        return accounts.get(accountNumber).debitAccount(amount);
	}
}
