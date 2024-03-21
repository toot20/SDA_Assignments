package testng.Week6_Assignments;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testng.ExcelDataProvider;
import testng.Tests;

import java.io.FileInputStream;
import java.io.IOException;

public class Task2Test extends Tests {
      /*
Go to https://testpages.eviltester.com/styled/apps/notes/simplenotes.html
Add 10 notes using data provider with excel
Run it with 3 different browsers using XML file
Run it parallel with 3 threads
 */
      public static Object[][] readDataFromExcel(String filePath, String sheetName) throws IOException {
          FileInputStream fileInputStream = new FileInputStream(filePath);
          Workbook workbook = WorkbookFactory.create(fileInputStream);
          Sheet sheet = workbook.getSheet(sheetName);

          int rowCount = sheet.getPhysicalNumberOfRows();
          int colCount = sheet.getRow(0).getLastCellNum();

          Object[][] data = new Object[1][rowCount * colCount]; // Create a 2D array to hold all data at once

          int k = 0; // Counter for the data array

          for (int i = 1; i < rowCount; i++) {
              Row row = sheet.getRow(i);
              for (int j = 0; j < colCount; j++) {
                  Cell cell = row.getCell(j);
                  data[0][k++] = cell.getStringCellValue(); // Add data to the array
              }
          }

          workbook.close();
          fileInputStream.close();

          return data;
      }

    @DataProvider(name = "excelData")
    public Object[][] testData() throws IOException {

        return readDataFromExcel("C:\\Users\\سعيد علي\\Desktop\\Book1.xlsx", "Sheet1");
    }
    @Test(dataProvider = "excelData")
    public void testWithDataFromExcel(String[] data) {
        bot.navigate("https://testpages.eviltester.com/styled/apps/notes/simplenotes.html");

        By TitleInput = By.id("note-title-input");
        By NoteInput = By.id("note-details-input");
        By addButton = By.id("add-note");

        for (int i = 0; i < data.length; i += 2) {
            String title = data[i];
            String details = i + 1 < data.length ? data[i + 1] : ""; // Check if details is null
            if (title != null) {
                driver.findElement(TitleInput).sendKeys(title);
            }
            if (details != null) {
                driver.findElement(NoteInput).sendKeys(details);
            }
            driver.findElement(addButton).click();
            System.out.println("Data from Excel: " + title + ", " + details);
        }
    }
}

