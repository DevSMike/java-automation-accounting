package homework.file;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileManager {
    static String readFileContentsOrNull(String path)
    {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }
    public static void setYearFormPath(String path, YearlyReport yearlyReport) {
        String[] partsOfPath = path.split("\\.");
        yearlyReport.year = Integer.parseInt(partsOfPath[1]);
    }
    public static boolean isCanReadYearFile(String path, YearlyReport yearlyReport) {
        String yearFile = readFileContentsOrNull(path);
        if (yearFile == null) {return false; }
            String[] lines = yearFile.split("\\n");
            for (int i = 1; i < lines.length; i++) {
                String[] items = lines[i].split(",");
                Item item = new Item(Integer.parseInt(items[0]), Integer.parseInt(items[1]), Boolean.parseBoolean(items[2]));
                yearlyReport.itemsFromFile.add(item);
            }
            return true;
        }

    public static boolean isCanReadMonthFromFiles(ArrayList<MonthlyReport> monthlyReports) {
        String[] monthFiles = new String[3];
        for (int i = 0; i < 3; i++) {
            monthFiles[i] = readFileContentsOrNull("resources/m.20210" + (i+1)+".csv");
            if (monthFiles[i] == null) {
                System.out.println("Не удалось прочитать файл m.20210" + (i + 1) + ".csv");
                return false;
            }
                String[] lines = monthFiles[i].split("\\n");
                MonthlyReport monthlyReport = new MonthlyReport(i+1);
                for (int j = 1; j < lines.length; j++) {
                    String[] items = lines[j].split(",");
                    Item item = new Item(items[0],Boolean.parseBoolean(items[1]), Integer.parseInt(items[2]), Integer.parseInt(items[3]));
                    monthlyReport.itemsFromFile.add(item);
                }
                monthlyReports.add(monthlyReport);
            }
        return true;
    }
}
