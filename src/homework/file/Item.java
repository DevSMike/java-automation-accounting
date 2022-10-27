package homework.file;

public class Item {
    String itemName;
    boolean isExpense;
    int quantity;
    int sumOfOne;
    int monthNumber;
    int amount;

    // for monthlyReport
    public Item(String itemName, boolean isExpense, int quantity, int sumOfOne) {
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;
    }


    // for yearlyReport
    public Item(int monthNumber, int amount, boolean isExpense) {
        this.monthNumber = monthNumber;
        this.amount = amount;
        this.isExpense = isExpense;
    }
}
