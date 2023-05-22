/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment1fx;

/**
 *
 * @author MS
 */
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private List<User> customers;
    private List<Account> accounts;
    private List<Transaction> transactions;
    
    // Constructor
    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<User>();
        this.accounts = new ArrayList<Account>();
        this.transactions = new ArrayList<Transaction>();
    }
    
    // Getter and Setter methods for all attributes
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public List<User> getCustomers() {
        return customers;
    }
    
    public void setCustomers(List<User> customers) {
        this.customers = customers;
    }
    
    public List<Account> getAccounts() {
        return accounts;
    }
    
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
    
    public List<Transaction> getTransactions() {
        return transactions;
    }
    
    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
    
    // Add new customer to the bank
    public void addCustomer(User user) {
        customers.add(user);
    }
    
    // Add new account to the bank
    public void addAccount(Account account) {
        accounts.add(account);
    }
    
    // Add new transaction to the bank
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
    
    // Get all transactions for a particular account
    public List<Transaction> getAccountTransactions(String accountNumber) {
        List<Transaction> accountTransactions = new ArrayList<Transaction>();
        for (Transaction transaction : transactions) {
            if (transaction.getAccountNumber().equals(accountNumber)) {
                accountTransactions.add(transaction);
            }
        }
        return accountTransactions;
    }
}

