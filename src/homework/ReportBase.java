package homework;

import homework.file.MonthlyReport;
import homework.file.YearlyReport;

import java.util.ArrayList;

public class ReportBase {
    public static void printYearlyReport (YearlyReport yearlyReport) {
        System.out.println("Годовой отчёт за год: " + yearlyReport.getYear() );
        System.out.println("Средний доход за все месяцы: " + yearlyReport.getYearAverageIncome());
        System.out.println("Средний расход за все месяцы: " + yearlyReport.getYearAverageExpense());
        yearlyReport.printProfitAllMonth();
    }

    public static void printMonthlyReports(ArrayList<MonthlyReport> monthlyReports) {
        for (int i = 0; i < monthlyReports.size(); i++) {
            System.out.println("Месяц: " + YearlyReport.getMonthName(i+1));
            monthlyReports.get(i).getBiggestExpense();
            monthlyReports.get(i).getProfitableProduct();
            System.out.println("Самый прибыльный товар: " + monthlyReports.get(i).getNameOfTheMaxSumItem() + " на сумму: " + monthlyReports.get(i).getMaxSum());
            System.out.println("Самая большая трата: " + monthlyReports.get(i).getNameOfTheMaxExpense() + " на сумму: " + monthlyReports.get(i).getMaxExpense());
            System.out.println("--------------------------------------------");
        }
    }

    private static boolean checkData (ArrayList<MonthlyReport> monthlyReports, YearlyReport yearlyReport, int i) {
        boolean isAllRight = true;
        boolean isIncomesIncorrect = monthlyReports.get(i).getIncomeSumOfTheMonth() != yearlyReport.getSumOfIncomesByMonth(i+1);
        boolean isExpensesInCorrect = monthlyReports.get(i).getExpensesSumOfTheMonth() != yearlyReport.getSumOfExpensesByMonth(i+1);
        if (isIncomesIncorrect || isExpensesInCorrect) isAllRight = false;
        return isAllRight;
    }

    public static void printCheckingData(ArrayList<MonthlyReport> monthlyReports, YearlyReport yearlyReport) {
        boolean isDataCorrect = true;
        for (int i = 0; i < monthlyReports.size(); i++ ) {
            isDataCorrect = checkData(monthlyReports,yearlyReport, i);
           if (!isDataCorrect)
            System.out.println("Во время проверки месяца : " + YearlyReport.getMonthName(i+1) + " произошла ошибка!");
        }
        if (isDataCorrect) System.out.println("Проверка прошла успешно!");
    }
}
