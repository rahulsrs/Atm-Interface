import java.util.Scanner;
public class ATM {
    Scanner scan = new Scanner(System.in);
    Scanner stringScanner = new Scanner(System.in);
    public Account auth(Account[] DB){
        System.out.println("Enter your Card info");
        String info = stringScanner.nextLine();
        Account tempAcc = null;
        for(var acc:DB){
            if(acc.cardInfo.equals(info)) {
                tempAcc = acc;
                break;
            }
        }
        if (tempAcc == null){
            System.out.println("Card not found");
            return null;
        }
        System.out.println("Enter your CVV");
        int tempCVV = scan.nextInt();
        if(tempCVV == tempAcc.CVV){
            System.out.println("Authentication Successful");
            return tempAcc;
        }
        System.out.println("Authentication Failed");
        System.out.println("Retrying");
        return null;
    }

    public void deposit(Account X, int val){
        System.out.println("Deposited " + val + " rupees");
        X.bal += val;
    }
    public void withdraw(Account X, int val){
        if(X.bal>val){
            X.bal -= val;
            System.out.println("Withdrew " + val + " rupees");
        }
    }
    public void checkBal(Account X){
        System.out.println("The current balance in this account is " + X.bal);
    }
}
