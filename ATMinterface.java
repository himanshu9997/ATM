/*
    *****************
    DONE BY:-   Himanshu And team
    *****************
    */
import java.lang.annotation.Inherited;
import java.util.Scanner;

class BankAccount
{
    int balance;
    int prevTransaxtion;
    String customerName;
    String customerId;
    int flag = 0;

    BankAccount(String cName, String cId) 
    {
        customerName = cName;
        customerId = cId;
    
    }

    public final void clrscr(){
        try{
            try{
                final String os = System.getProperty("os.name");
                
                if(os.contains("windows")) {
                    Runtime.getRuntime().exec("cls");
                }
                else{
                    Runtime.getRuntime().exec("clear");
                }
            }catch (final Exception e){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }

            }catch (final Exception es){
                //System.out.println("nothing here!")
        }
    }

    void checkId() {
        clrscr();
        System.out.println("Welcome" + customerName);
        System.out.println("");
        System.out.println("Please enter the Custome Id or PIN: ");
        Scanner id = new Scanner(System.in);
        String chk = id.nextLine();
        if (chk.equals(customerId)) {
            clrscr();
            showMenu();
        }
        else{
            System.out.println("===================================================");
            System.out.println("Wrong Login!!");
            System.out.println("===================================================");

            if (flag < 3){
                flag++;
                checkId();
            }
        }
    }
    
    void deposit(int amount) {
        if (amount != 0){
            balance = balance + amount;
            prevTransaxtion = amount;
        }
    }

    void withdraw(int amount){
        if (this.balance > amount){
            balance = balance - amount;
            prevTransaxtion = -amount;
        }else{
            clrscr();
            System.out.println("=====================================================");
            System.out.println("Sufficient Balance not available for the withdrawl!");
            System.out.println("=====================================================");
        }
    }
    /*
    *****************
    DONE BY:-   Himanshu And team
    *****************
    */

    void getPrevTransaction(){
        if (prevTransaxtion > 0) {
            System.out.println("Deposited: " + prevTransaxtion);
        }else if (prevTransaxtion < 0) {
            System.out.println("Withdraw: " + Math.abs(prevTransaxtion));
        }
        else {
            System.out.println("NO Transaction Occured ");
        }
    }

    public void transfer(Double amount, BankAccount acc) {
        if (this.balance < amount) {
            clrscr();
            System.out.println("=====================================================");
            System.out.println("Transfar Fails due to insufficient balance!");
            System.out.println("=====================================================");
        }else{
            this.balance -= amount;
            acc. balance +=amount;
            System.out.println("Account of " + this.customerName + "beomes $" + this.balance);
            System.out.println("Account of " + acc.customerName + "beomes $" + acc.balance);
            System.out.println("\n");
        }
    }
    private void showMenu() {
        char option;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is " + customerId);
        do {
            System.out.println("\n");
            System.out.println("\n");
            System.out.println("A. Check Balance");
            System.out.println("B. Deposit");
            System.out.println("c. withdraw");
            System.out.println("D. Previous Transaction");
            System.out.println("E. Transfer");
            System.out.println("F. Exit");

            System.out.println("====================================================");
            System.out.println("Enter the option");
            System.out.println("====================================================");
            option = sc.next().charAt(0);
            option = Character.toUpperCase(option);
            System.out.println("\n");

            switch (option){
                case 'A' :
                clrscr();
                System.out.println("========================================");
                System.out.println("Balance " + balance);
                System.out.println("========================================");
                System.out.println("\n");
                break;

                case 'B' :
                clrscr();
                System.out.println("========================================");
                System.out.println("Enter the amount to deposit");
                System.out.println("========================================");
                int amount = sc.nextInt();
                deposit(amount);
                System.out.println("\n");
                break;

                case 'C' :
                clrscr();
                System.out.println("========================================");
                System.out.println("Enter the amount to withdraw");
                System.out.println("========================================");
                int amount2 = sc.nextInt();
                deposit(amount2);
                System.out.println("\n");
                break;

                case 'D' :
                clrscr();
                System.out.println("========================================");
                getPrevTransaction();
                System.out.println("========================================");
                System.out.println("\n");
                break;

                case 'E' :
                clrscr();
                System.out.println("****************************************");
                System.out.println("To whom");
                BankAccount bb = new BankAccount("Raj", "1092");
                System.out.println(bb.customerName);
                System.out.println("*****************************************");
                System.out.println("Amount to Transfer");
                double am = sc.nextDouble();
                System.out.println("*****************************************");
                transfer(am, bb);
                break;
    /*
    *****************
    DONE BY:-   Himanshu And team
    *****************
    */

                case 'F' :
                clrscr();
                System.out.println("*****************************************");
                break;

                default:
                clrscr();
                System.out.println("Invalid Option!!! Please Enter Again");
            }
        }while (option != 'F');
        System.out.println("ThankYou for using our services");
    }

}

public class ATMinterface {
        public static void main(String[] args) {
            BankAccount ba = new BankAccount("Huzefa", "1001");
            ba.checkId();
        }
        
    }

/*
    *****************
    DONE BY:-   Himanshu And team
    *****************
*/
