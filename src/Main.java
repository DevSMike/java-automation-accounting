import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean isOpen = true;
        boolean isMonthsReed = false;
        boolean isYearReed = false;
        Scanner scanner = new Scanner(System.in);
        ArrayList<MonthlyReport> monthlyReports = new ArrayList<>();
        YearlyReport yearlyReport = new YearlyReport();
        int command;
        while(isOpen) {
            printMenu();
            command = scanner.nextInt();
            if (command == 1) {
                FileManager.readingMonthFromFiles(monthlyReports);
                isMonthsReed = true;
            } else if (command == 2) {
                String path = "resources/y.2021.csv";
                FileManager.readingYearFile(path, yearlyReport);
                FileManager.setYearFormPath(path,yearlyReport);
                isYearReed = true;
            } else if (command == 3) {
                if (isMonthsReed && isYearReed) ReportBase.printCheckingData(monthlyReports,yearlyReport);
                    else System.out.println("Не все файлы прочитаны!");
            } else if (command == 4) {
                if (isMonthsReed) ReportBase.printMonthlyReports(monthlyReports);
                    else System.out.println("Выполните первый пункт!");
            } else if (command == 5) {
                if (isYearReed) ReportBase.printYearlyReport(yearlyReport);
                    else System.out.println("Выполните второй пункт!");
            } else if (command == 0) {
                isOpen = false;
            } else System.out.println("Такой команды нет!");
        }
    }
   static void printMenu() {
        System.out.println("1. Считать все месячные отчёты");
        System.out.println("2. Считать годовой отчет");
        System.out.println("3. Сверить отчёты");
        System.out.println("4. Вывести информацию о всех месячных отчётах");
        System.out.println("5. Вывести информацию о годовом отчёте");
        System.out.println("0. Выход");
    }
}

