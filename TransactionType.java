/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment1fx;

/**
 *
 * @author MS
 */
public enum TransactionType {
    DEPOSIT("Deposit"),
    WITHDRAWAL("Withdrawal"),
    TRANSFER("Transfer");
    
    private final String name;
    
    // Constructor
    TransactionType(String name) {
        this.name = name;
    }
    
    // Getter method for name attribute
    public String getName() {
        return name;
    }
}

