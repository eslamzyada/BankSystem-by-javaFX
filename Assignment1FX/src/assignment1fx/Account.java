/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment1fx;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;
/**
 *
 * @author MS
 */
public class Account {
    private String accountNumber;
    private  AccountType accountType;
    private double balance;
    private User owner;
    private double interestRate;
    private double fee;
    private  double minimumBalance;
    private LocalDate dateOpened;
    private LocalDate lastTransactionDate;
    private  Transactions transactions;
    private List<Transactions> transactionHistory;
    private boolean overdraftProtection;
    
    // Constructor
    public Account(AccountType accountType, User owner, LocalDate dateOpened, LocalDate lastTransactionDate, List<Transactions> transactionHistory, boolean overdraftProtection) {
        this.accountNumber = generateAccountNumber();
        this.accountType = accountType;
        this.balance = 0.0;
        this.owner = owner;
        this.fee = 0.0;
        this.interestRate = getInterestRateForAccountType(accountType);
        this.minimumBalance = getMinimumBalanceForAccountType(accountType);
        this.dateOpened = dateOpened;
        this.transactions = new Transactions(this);
        this.lastTransactionDate = lastTransactionDate;
        this.transactionHistory = transactionHistory;
        this.overdraftProtection = overdraftProtection;
    }
    public Account(){
        
    }
    // Getter and Setter methods for all attributes
    public String getAccountNumber() {
        return accountNumber;
    }
    
    private String generateAccountNumber() {
        switch (accountType) {
            case CHECKING_ACCOUNT:
                return generateCheckingAccountNumber();
            case SAVINGS_ACCOUNT:
                return generateSavingsAccountNumber();
            case MONEY_MARKET_ACCOUNT:
                return generateMoneyMarketAccountNumber();
            default:
                throw new IllegalArgumentException("Invalid account type: " + accountType);
        }
    }
    
    private String generateCheckingAccountNumber() {
        String bankCode = "PALSPS22";
        String branchCode = generateRandomBranchCode();
        String customerIdentifier = generateRandomCustomerIdentifier(6);
        String checksumDigit = calculateChecksumDigit(bankCode, customerIdentifier, branchCode);
        return bankCode + branchCode + customerIdentifier + checksumDigit;
    }
    
    private String generateSavingsAccountNumber() {
        String bankCode = "PALSPS22";
        String branchCode = generateRandomBranchCode();
        String customerIdentifier = generateRandomCustomerIdentifier(6);
        String suffix = "01"; // Suffix specific to savings accounts
        String checksumDigit = calculateChecksumDigit(bankCode, customerIdentifier, branchCode + suffix);
        return bankCode + branchCode + customerIdentifier + suffix + checksumDigit;
    }
    
    private String generateMoneyMarketAccountNumber() {
        String bankCode = "PALSPS22";
        String branchCode = generateRandomBranchCode();
        String customerIdentifier = generateRandomCustomerIdentifier(5); // 5-digit customer identifier for money market accounts
        String suffix = "02"; // Suffix specific to money market accounts
        String checksumDigit = calculateChecksumDigit(bankCode, customerIdentifier, branchCode + suffix);
        return bankCode + branchCode + customerIdentifier + suffix + checksumDigit;
    }
    
    public String generateRandomBranchCode(){
        Random random = new Random();
        int branchCode = random.nextInt(900) + 100;
        return String.valueOf(branchCode);
    }
    
    private String generateRandomCustomerIdentifier(int length) {
        Random random = new Random();
        int customerIdentifier = random.nextInt((int) Math.pow(10, length));
        return String.format("%0" + length + "d", customerIdentifier);
    }
    
    private String calculateChecksumDigit(String bankCode, String customerIdentifier, String branchCode) {
        String accountNumberWithoutChecksum = bankCode + branchCode + customerIdentifier;
        int sum = 0;
        for (int i = 0; i < accountNumberWithoutChecksum.length(); i++) {
            int digit = Character.getNumericValue(accountNumberWithoutChecksum.charAt(i));
            sum += (i % 2 == 0) ? digit : (digit * 2) % 9;
        }
        int checksum = (sum * 9) % 10;
        return String.valueOf(checksum);
    }

    
    public AccountType getAccountType() {
        return accountType;
    }
    
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    
    public Transactions getTransaction(){
        return transactions;
    }
    
    public double calculateFee() {
        switch (accountType) {
            case CHECKING_ACCOUNT:
                fee = 0.0; // Example fee calculation for a checking account
                break;
            case SAVINGS_ACCOUNT:
                fee = balance * 0.02; // Example fee calculation for a savings account
                break;
            case MONEY_MARKET_ACCOUNT:
                fee = balance * 0.03; // Example fee calculation for a money market account
                break;
            default:
                break;
        }
        return fee;
    }
    
    public void deposit(double amount) {
        balance += amount;
        Date transactionDate = new Date(); // Get the current transaction date
        transactions.recordDeposit(amount, transactionDate);
    }

    public void withdraw(double amount) {
        if (balance - amount >= minimumBalance) {
            balance -= amount;
            Date transactionDate = new Date(); // Get the current transaction date
            transactions.recordWithdrawal(amount, transactionDate);
        } else {
            System.out.println("Insufficient funds!");
        }
    }
    
    public User getOwner() {
        return owner;
    }
    
    public void setOwner(User owner) {
        this.owner = owner;
    }
    
    public double getInterestRate() {
        return interestRate;
    }
    
    private double getInterestRateForAccountType(AccountType accountType){
        switch(accountType){
            case CHECKING_ACCOUNT:
                return 0.0;
            case SAVINGS_ACCOUNT:
                return 0.10;
            case MONEY_MARKET_ACCOUNT:
                return 0.25;
            default:
                throw new IllegalArgumentException("Invalid account type: " + accountType);
        }
    }
    
    public double getMinimumBalance() {
        return minimumBalance;
    }
    
    private double getMinimumBalanceForAccountType(AccountType accountType){
        switch(accountType){
            case CHECKING_ACCOUNT:
                return 300.0;
            case SAVINGS_ACCOUNT:
                return 500;
            case MONEY_MARKET_ACCOUNT:
                return 5000.0;
            default:
                throw new IllegalArgumentException("Invalid account type: " + accountType);
        }
    }
    
    public LocalDate getDateOpened() {
        return dateOpened;
    }
    
    public void setDateOpened(LocalDate dateOpened) {
        this.dateOpened = dateOpened;
    }
    
    public LocalDate getLastTransactionDate() {
        return lastTransactionDate;
    }
    
    public void setLastTransactionDate(LocalDate lastTransactionDate) {
        this.lastTransactionDate = lastTransactionDate;
    }
    
    public List<Transactions> getTransactionHistory() {
        return transactionHistory;
    }
    
    public void setTransactionHistory(List<Transactions> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }
    
    public boolean hasOverdraftProtection() {
        return overdraftProtection;
    }
    
    public void setOverdraftProtection(boolean overdraftProtection) {
        this.overdraftProtection = overdraftProtection;
    }
}

