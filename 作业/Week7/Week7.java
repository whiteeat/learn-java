import java.util.*;

class Account
{
    String name;
    String password;
    int money;

    Account(String name, String password, int money)
    {
        this.name = name;
        this.password = password;
        this.money = money;
    }

    @Override
    public String toString()
    {
        return name + ' ' + password + ' ' + money; 
    }

    public int balance()
    {
        return money;
    }   

    public void save(int value)
    {
        money += value;
    }

    public int withdraw(int value)
    {
        int newValue = money - value;
        int returnValue = 0;
        if (newValue >= 0)
        {
            money = newValue;
            returnValue = value;
        }
        else
        {
            System.out.println("The account doesn't have enough money!");
        }

        return returnValue;
    }
}

class Bank
{
    HashMap<String, Account> accounts;
    String name;
    Bank(String name)
    {
        // accounts = new HashMap();
        accounts = new HashMap<>();
        this.name = name;
    }

    public void openAnAccount(String accountName, String password, int money)
    {
        if (ifAnAccountExists(accountName))
        {
            System.out.println("The account name already exists! Please change a name!");
        }
        else
        {
            Account account = new Account(accountName, password, money);
            accounts.put(accountName, account);
        }
    }

    public Boolean ifAnAccountExists(String accountName)
    {
        return accounts.containsKey(accountName);
    }

    public Account getAnAccount(String accountName)
    {
        if (ifAnAccountExists(accountName))
        {
            return accounts.get(accountName);
        }
        else
        {
            return null;
        }
    }

    public int numAccount()
    {
        return accounts.size();
    }
}

class Week7
{
    public static void main(String[] args)
    {
        Bank bank = new Bank("Java");
        bank.openAnAccount("a", "1", 100);
        bank.openAnAccount("b", "2", 200);
        bank.openAnAccount("a", "11", 1000);

        System.out.println(bank.numAccount()); // There should only be 2 accounts

        Account accountC = bank.getAnAccount("c");
        if (accountC == null)
        {
            System.out.println("Account c doesn't exist!"); // There should only be 2 accounts
        }

        Account accountA = bank.getAnAccount("a");
        accountA.save(100);
        System.out.println("The account's balance is " + accountA.balance()); // Should be 200
        int value = accountA.withdraw(150);
        System.out.println("The amount of money is withdrawed: " + value);
        System.out.println("The account's balance is " + accountA.balance()); // Should be 50
        value = accountA.withdraw(1000);
        System.out.println("The amount of money is withdrawed: " + value);
        System.out.println("The account's balance is " + accountA.balance()); // Should be 50

        Account accountB = bank.getAnAccount("b");
        accountB.save(50);
        System.out.println("The account's balance is " + accountB.balance()); // Should be 250
    }
}
