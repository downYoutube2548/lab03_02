public class MainApp {
    public static void main(String[] args) {
        Account acc = new Account("1234-0001", 100.);

        System.out.printf("Account %s has been created with a balance of %.2f baht.\n",
                acc.getAccountNumber(), acc.getBalance());

        acc.deposit(500.);
        acc.withdraw(400.);

        System.out.printf("Account %s now has a balance of %.2f baht.\n",
                acc.getAccountNumber(), acc.getBalance());

        acc.suspend();
        System.out.printf("Account is %s.\n", acc.isActive() ? "active" : "suspended");

        try {
            System.out.println("Trying to deposit...");
            acc.deposit(100.);
            System.out.println("This part should not be reached.");
        } catch (IllegalStateException e) {
            System.out.printf("Illegal state: %s\n", e.getMessage());
        }

        try {
            System.out.println("Trying to withdraw...");
            acc.withdraw(100.);
            System.out.println("This part should not be reached.");
        } catch (IllegalStateException e) {
            System.out.printf("Illegal state: %s\n", e.getMessage());
        }

        acc.reactivate();
        System.out.printf("Account is %s.\n", acc.isActive() ? "active" : "suspended");

        System.out.printf("Account %s now has a balance of %.2f baht.\n",
                acc.getAccountNumber(), acc.getBalance());

        acc.deposit(100.);

        System.out.printf("Account %s now has a balance of %.2f baht.\n",
                acc.getAccountNumber(), acc.getBalance());

        acc = null; // not actually needed if the program is ending anyway
    }
}
