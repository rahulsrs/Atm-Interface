import java.util.Scanner;
public class Main {
    public static void printMenu(){
        System.out.println("Enter 1 to Deposit money");
        System.out.println("Enter 2 to Withdraw money");
        System.out.println("Enter 3 to check Balance");
        System.out.println("Enter 4 to exit Account");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account acc1 = new Account(50000, 123, "6015445608372707");
        Account acc2 = new Account(20000, 134, "9273204020342626");
        Account acc3 = new Account(40000, 456, "206631952025391");
        Account acc4 = new Account(15000, 326, "3974803154992603");
        Account[] dataBase = {acc1, acc2, acc3, acc4};
        ATM atm = new ATM();
        try {
            while (true) {
                Account acc = atm.auth(dataBase);
                if (acc != null) {
                    boolean flag = true;
                    while (flag) {
                        printMenu();
                        System.out.println("Enter your choice");
                        int choice = scanner.nextInt();
                        scanner.nextLine();
                        int val;
                        switch (choice) {
                            case 1 -> {
                                System.out.println("Enter the amount of money you would like to deposit");
                                val = scanner.nextInt();
                                atm.deposit(acc, val);
                            }
                            case 2 -> {
                                System.out.println("Enter the amount of money you would like to withdraw");
                                val = scanner.nextInt();
                                atm.withdraw(acc, val);
                            }
                            case 3 -> atm.checkBal(acc);
                            case 4 -> flag = false;
                            default -> System.out.println("Invalid Choice, Try again");
                        }

                    }
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
            System.exit(1);
        }
    }
}
