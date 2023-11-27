import java.util.Scanner;
import java.lang.Character;


public class BankingApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount bank1 = new BankAccount(sc.next(),sc.next());
        bank1.showMenu();
    }
    static class BankAccount {
        int balance;
        int previousTransaction;
        String customerName;
        String customerID;

        BankAccount(String cName, String cID) {
            customerName = cName;
            customerID = cID;
        }

        void deposit(int amount) {
            if (amount != 0) {
                balance += amount;
                previousTransaction = amount;
            }
        }

        void withdraw(int amount) {
            if (amount != 0) {
                balance -= amount;
                previousTransaction = amount;
            }
        }

        void getPreviousTransaction() {
            if (previousTransaction > 0) {
                System.out.println("Deposited: " + previousTransaction);
            } else if (previousTransaction < 0) {
                System.out.println("Withdrawn: " + Math.abs(previousTransaction));
            } else {
                System.out.println("No Transaction has been made!");
            }
        }

        void showMenu() {
            char option = '\0';
            Scanner sc = new Scanner(System.in);

            System.out.println("Welcome " + customerName);
            System.out.println("Your ID is: " + customerID);
            System.out.println();
            System.out.println("A. Check Balance");
            System.out.println("B. Deposit");
            System.out.println("C. Withdraw");
            System.out.println("D. Previous Transaction");
            System.out.println("E. Exit");

            do{
                System.out.println("========================================");
                System.out.println("Enter the option from A to E.");
                System.out.println("========================================");

                option = sc.next().toUpperCase().charAt(0);
                Character.toUpperCase(option); // to translate the letters to Uppercase

                switch (option) {
                    case 'A':
                        System.out.println("========================================");
                        System.out.println("Your balance is " + balance);
                        System.out.println("========================================");
                        System.out.println();
                        break;
                    case 'B':
                        System.out.println("========================================");
                        System.out.println("Enter the amount to be deposited");
                        System.out.println("========================================");
                        int amount = sc.nextInt();
                        deposit(amount);
                        break;
                    case 'C':
                        System.out.println("========================================");
                        System.out.println("Enter the amount to be withdrawn");
                        System.out.println("========================================");
                        int amount2 = sc.nextInt();
                        withdraw(amount2);
                        break;
                    case 'D':
                        System.out.println("========================================");
                        getPreviousTransaction();
                        System.out.println("========================================");
                        System.out.println();
                        break;
                    case 'E':
                        System.out.println("========================================");
                        break;
                    default:
                        System.out.println("Invalid Option! Please try again");
                        break;
                }
            } while(option != 'E');
        }
    }
}



