package week5_Assignments;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TaskFiveTest extends Tests{
    @Test
    public void ExcelTest() {
        try {

        //Store the path of the file as string and open the file.
        String filePath = "C:\\Users\\سعيد علي\\Desktop\\worksheet.xlsx";
        //Open the workbook.
        FileInputStream fis = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(fis);
        //Open the first worksheet.
        Sheet sheet = workbook.createSheet("new sheet");
        //Go to the first row.
        Row firstRow = sheet.createRow(0);
        //Create a cell on the 3rd column (2nd index) on the first row.
        Cell cell = firstRow.createCell(2);
        //Write “POPULATION” on that cell.
        cell.setCellValue("POPULATION");
        //Create a cell on the 2nd row 3rd cell(index2), and write data.
        //Create a cell on the 3rd row 3rd cell(index2), and write data.
        //Create a cell on the 4th row 3rd cell(index2), and write data.
        for (int i = 1; i <= 3; i++) {
            Row row = sheet.getRow(i);
            if (row == null) {
                row = sheet.createRow(i);
            }
            Cell dataCell = row.createCell(2);
            dataCell.setCellValue("Data " + i);
        }
        //Write and save the workbook.
        FileOutputStream fos = new FileOutputStream(filePath);
        workbook.write(fos);
        //Close the file.
        fis.close();
        fos.close();
        workbook.close();
        //Close the workbook.
        System.out.println("Excel file updated successfully!");
    } catch (IOException e) {
        e.printStackTrace();
    }

//The 3rd column on excel file must be empty before running.
// Otherwise, new data will be written on the old data

    }
}
