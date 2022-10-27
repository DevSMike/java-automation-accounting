package homework.file;

import java.util.ArrayList;

public class MonthlyReport {
    ArrayList<Item> itemsFromFile = new ArrayList<>();

    String nameOfTheMaxSumItem = "";
    int maxSum = 0;

    String nameOfTheMaxExpense = "";
    int maxExpense = 0;

    int month;
    public String getNameOfTheMaxSumItem(){
        return nameOfTheMaxSumItem;
    }
    public String getNameOfTheMaxExpense() {
        return nameOfTheMaxExpense;
    }
    public int getMaxSum() {
        return maxSum;
    }
    public int getMaxExpense() {
        return maxExpense;
    }
    public MonthlyReport (int month) {
        this.month = month;

    }

    public void getProfitableProduct() {
        for (int i=0; i < itemsFromFile.size(); i++) {
            if (!isExpense(i) && isMaxSum(i)) {
                maxSum = getQuantityAndSum(i);
                nameOfTheMaxSumItem = itemsFromFile.get(i).itemName;
            }
        }
    }
    public int getExpensesSumOfTheMonth() {
        int sum = 0;
        for (int i = 0; i < itemsFromFile.size(); i++) {
            if (isExpense(i)) sum += getQuantityAndSum(i);
        }
        return sum;
    }

    public int getIncomeSumOfTheMonth() {
        int sum = 0;
        for (int i = 0; i < itemsFromFile.size(); i++) {
            if (!isExpense(i)) sum += getQuantityAndSum(i);
        }
        return sum;
    }
    public void getBiggestExpense() {
        for (int i = 0; i< itemsFromFile.size(); i++) {
            if (isExpense(i) && isMaxExpense(i)) {
                maxExpense = getQuantityAndSum(i);
                nameOfTheMaxExpense = itemsFromFile.get(i).itemName;
            }
        }
    }

   private boolean isExpense(int i) {
        return itemsFromFile.get(i).isExpense;
    }
    private boolean isMaxSum (int i) {
        return getQuantityAndSum(i) > maxSum;
    }
    private boolean isMaxExpense (int i) {
        return getQuantityAndSum(i) > maxExpense;
    }

    private int getQuantityAndSum(int i) {
        return itemsFromFile.get(i).quantity * itemsFromFile.get(i).sumOfOne;
    }


}
