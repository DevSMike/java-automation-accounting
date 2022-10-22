import java.util.ArrayList;

public class YearlyReport {
    ArrayList<Item> itemsFromFile = new ArrayList<>();

    int year;
    private final int monthCount = 3;

    public static String getMonthName(int month) {
        if (month == 1) return "Январь";
        else if (month == 2) return "Февраль";
        else if (month == 3) return "Март";
        return "";
    }
    public int getYearAverageIncome() {
        int sum = 0;
        for (Item item : itemsFromFile) {
            if (!item.isExpense) sum += item.amount;
        }
        return sum / monthCount;
    }

    public int getYearAverageExpense() {
        int sum = 0;
        for (Item item : itemsFromFile) {
            if (item.isExpense) sum += item.amount;
        }
        return sum / monthCount;
    }

    public int getProfit(int month) {
        return getSumOfIncomesByMonth(month) - getSumOfExpensesByMonth(month);
    }

    public void printProfitAllMonth() {
        for (int i = 0; i < itemsFromFile.size() / 2; i++) {
            System.out.println("Прибыль за " + getMonthName(i+1) + " : " + getProfit(i+1));
        }
    }

    public int getSumOfExpensesByMonth(int month) {
        int sumOfExpenses = 0;
        for (Item item : itemsFromFile) {
            if (month == item.monthNumber) {
                if (item.isExpense) sumOfExpenses = item.amount;
            }
            if (sumOfExpenses != 0)
                break;
        }
        return sumOfExpenses;
    }
    public int getSumOfIncomesByMonth(int month) {
        int sumOfIncomes = 0;
        for (Item item : itemsFromFile) {
            if (month == item.monthNumber) {
                if (!item.isExpense) sumOfIncomes = item.amount;
            }
            if (sumOfIncomes != 0)
                break;
        }

        return sumOfIncomes;
    }

}
