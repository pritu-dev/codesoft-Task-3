import java.util.Scanner;

abstract class ATMMachine {
    abstract void deposit();

    abstract void withdrawn();

    abstract void balance();
}

class bankservice extends ATMMachine {
    private int pwd;
    private int bal;
    private int money;

    Scanner sc = new Scanner(System.in);

    @Override
    void deposit() {
        System.out.println("Enter Your Password : ");
        pwd = sc.nextInt();
        System.out.println();
        if (pwd == 123) {
            System.out.println("Choose Account  : ");
            System.out.println("1. Saving A/C " + "\n" + "2. Current A/C" + "\n");
            int type = sc.nextInt();
            System.out.println();
            System.out.println("Enter Deposit Amount : ");
            money = sc.nextInt();
            bal = bal + money;
            System.out.println();
            System.out.println("Deposited Amount : " + money);
            System.out.println("Total Balance : " + bal + "\n");
        } else {
            System.out.println("Wrong Password !! Please Try Again... ");
        }
    }

    @Override
    void withdrawn() {
        System.out.println("Enter Password : ");
        pwd = sc.nextInt();
        if (pwd == 123) {
            if (bal > 0) {
                if (money <= bal) {
                    System.out.println("Enter Your Withdrew Amount :");
                    money = sc.nextInt();
                    bal = bal - money;
                    System.out.println("Withdraw Amount : " + money);
                    System.out.println("Total Balance : " + bal);
                } else {
                    System.out.println("Insufficient Balance!");
                }
            } else {
                System.out.println("No balance available for withdrawal!");
            }
        } else {
            System.out.println("Wrong Password !! Please Try Again... ");
        }
    }

    @Override
    void balance() {
        System.out.println("Enter Your Password : ");
        pwd = sc.nextInt();
        if (pwd == 123) {
            System.out.println("Total Balance Availble in Your Account : " + bal);
        } else {
            System.out.println("Wrong Password !! Please Try Again... ");
        }

    }
}

class customer extends bankservice {
    public static void main(String[] args) {
        System.out.println("1. Deposit Money");
        System.out.println("2. Withdrawn Money");
        System.out.println("3. Balance Money");
        System.out.println();

        customer ob = new customer();

        for (int i = 0; i <= 10; i++) {
            int ch;
            System.out.println("Enter Your Choice : ");
            Scanner sc = new Scanner(System.in);
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    ob.deposit();
                    break;
                case 2:
                    ob.withdrawn();
                    break;
                case 3:
                    ob.balance();
                    break;
                default:
                    System.out.println("Invalid Responce !!");
            }
        }

    }
}