/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment1fx;

/**
 *
 * @author MS
 */
public class PaymentGateway {
    // Process a payment transaction
    public static boolean processPayment(Account account, double amount) {
    double fee = account.calculateFee();
    double totalAmount = amount + fee;
    if (account.getBalance() >= totalAmount) {
        account.setBalance(account.getBalance() - totalAmount);
        return true;
    } else {
        return false;
    }
}

// Process a transfer transaction
public static boolean processTransfer(Account sourceAccount, Account destinationAccount, double amount) {
    double fee = sourceAccount.calculateFee();
    double totalAmount = amount + fee;
    if (sourceAccount.getBalance() >= totalAmount) {
        sourceAccount.setBalance(sourceAccount.getBalance() - totalAmount);
        destinationAccount.setBalance(destinationAccount.getBalance() + amount);
        return true;
    } else {
        return false;
        }
    }
}
