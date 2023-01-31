public class Week6 {
    public static void main(String[] args){
        Customer customer = new Customer();
        Item item = new Item(1000);
        
        try
        {
            customer.purchase(item);
        }catch(Exception e)
        {
            System.out.println("There is an exception! " + e);
            System.out.println("The casue is: " + e.getCause());
        }
        finally 
        {
            System.out.println("Finished.");
        }
    }
}

class Item
{
    Item(int price)
    {
        this.price = price;
    }

    int price = 1000;
}

class Customer 
{
    int money = 100;

    void purchase(Item item) throws PurchaseException
    {
        System.out.println("Pay the money!");
        try 
        {
            spendMoney(item.price);
        }
        catch (OutOfMoneyException e)
        {
            throw new PurchaseException("Don't have enough money!", e);
        }
        System.out.println("Got the item!");
    }

    void spendMoney(int money) throws OutOfMoneyException
    {
        if(money > this.money)
        {
            throw new OutOfMoneyException("Out of money!");
        }
        this.money = this.money - money;
    }
}

class OutOfMoneyException extends Exception {
    public OutOfMoneyException(String message)
    {
        super(message);
    }
}

class PurchaseException extends Exception {
    public PurchaseException(String message)
    {
        super(message);
    }

    public PurchaseException(String message, Exception cause)
    {
        super(message, cause);
    }
}