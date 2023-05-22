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
import java.util.Date;
import java.util.List;

public class Transactions {
    private final  List<Transaction> transactionList;
    private int transactionCounter;
    private final Account associatedAccount;

    public Transactions(Account associatedAccount) {
        this.transactionList = new ArrayList<>();
        this.transactionCounter = 1;
        this.associatedAccount = associatedAccount;
    }

    public void recordDeposit(double amount, Date transactionDate) {
        String transactionID = generateTransactionID();
        String accountNumber = getAccountNumber();
        TransactionType transactionType = TransactionType.DEPOSIT;

        Transaction transaction = new Transaction(transactionID, accountNumber, amount, transactionDate, transactionType);
        transactionList.add(transaction);
    }

    public void recordWithdrawal(double amount, Date transactionDate) {
        String transactionID = generateTransactionID();
        String accountNumber = getAccountNumber();
        TransactionType transactionType = TransactionType.WITHDRAWAL;

        Transaction transaction = new Transaction(transactionID, accountNumber, amount, transactionDate, transactionType);
        transactionList.add(transaction);
    }

    public List<Transaction> getTransactionsByAccount(String accountNumber) {
        List<Transaction> accountTransactions = new ArrayList<>();

        for (Transaction transaction : transactionList) {
            if (transaction.getAccountNumber().equals(accountNumber)) {
                accountTransactions.add(transaction);
            }
        }

        return accountTransactions;
    }

    public List<Transaction> getTransactionsByType(TransactionType transactionType) {
        List<Transaction> typeTransactions = new ArrayList<>();

        for (Transaction transaction : transactionList) {
            if (transaction.getTransactionType() == transactionType) {
                typeTransactions.add(transaction);
            }
        }

        return typeTransactions;
    }

    public List<Transaction> getTransactionsByDateRange(Date startDate, Date endDate) {
        List<Transaction> rangeTransactions = new ArrayList<>();

        for (Transaction transaction : transactionList) {
            Date transactionDate = transaction.getTransactionDate();
            if (transactionDate.after(startDate) && transactionDate.before(endDate)) {
                rangeTransactions.add(transaction);
            }
        }

        return rangeTransactions;
    }

    private String generateTransactionID() {
        String accountNumber = getAccountNumber();
        String transactionID = accountNumber + "-" + transactionCounter;
        transactionCounter++;
        return transactionID;
    }

    private String getAccountNumber() {
        return associatedAccount.getAccountNumber();
    }
}
