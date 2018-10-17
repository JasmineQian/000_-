package Excel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WriteExcel {

    Date dt = new Date();
    SimpleDateFormat format = new SimpleDateFormat("YYYYMMddHHmmss");
    String time = format.format(dt);

    public void WriteExcelxls() {

        FileOutputStream out = null;
        try {
            out = new FileOutputStream(new File(".\\Log\\旧的EXCEL文件_"+time+".xls"));
            HSSFWorkbook workxls = new HSSFWorkbook();
            HSSFSheet sheet = workxls.createSheet(time);
            HSSFRow row = workxls.getSheet(time).createRow(0);


            for (short i = 0; i < 10; i++) {
                HSSFCell cell = row.createCell(i);
                cell.setCellValue("测试" + i);
            }

            sheet.createRow(1).createCell(1).setCellValue("1234567890");
            sheet.createRow(2).createCell(0).setCellValue(Calendar.getInstance());
            sheet.createRow(3).createCell(0).setCellValue("字符串");
            sheet.createRow(4).createCell(0).setCellValue(true);
            sheet.createRow(5).createCell(0).setCellType(CellType.ERROR);
            workxls.write(out);
            out.close();
            System.out.println("旧的EXCEL文件_.xls written successfully on disk.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void WriteExcelxlsx() {

        File file = new File(".\\Log\\新的EXCEL文件_"+time+".xlsx");
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFRow row = workbook.createSheet(time).createRow(0);
            XSSFSheet sheet = workbook.getSheet(time);

            for (short i = 0; i < 10; i++) {
                XSSFCell cell = row.createCell(i);
                cell.setCellValue("新的EXCEL文件" + i);
            }

            sheet.createRow(1).createCell(1).setCellValue("1234567890");
            sheet.createRow(2).createCell(0).setCellValue(Calendar.getInstance());
            sheet.createRow(3).createCell(0).setCellValue("字符串");
            sheet.createRow(4).createCell(0).setCellValue(true);
            sheet.createRow(5).createCell(0).setCellType(CellType.ERROR);
            workbook.write(out);
            out.close();
            System.out.println("新的EXCEL文件_.xlsx written successfully on disk.");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

