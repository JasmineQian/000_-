package Excel;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WriteExcelMore {

    static Date dt = new Date();
    static SimpleDateFormat format = new SimpleDateFormat("YYYYMMddHHmmss");
    static String time = format.format(dt);


    public static void main(String args[]) {

        File file = new File(".\\Log\\新的EXCEL文件_" + time + ".xls");
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file);
            HSSFWorkbook workbook = new HSSFWorkbook(); //创建一个新的excel
            HSSFSheet sheet = workbook.createSheet(time);  //创建sheet页
            HSSFHeader header = sheet.getHeader();//创建header页
            header.setCenter("Title");

            HSSFRow[] row = new HSSFRow[3];
            row[0] = sheet.createRow(0);
            HSSFCell headerCell = row[0].createCell(5);
            headerCell.setCellValue(new HSSFRichTextString("标题"));
            //HSSFRow  row = workbook.getSheet(time).createRow(3);
            row[1] = sheet.createRow(1);

            for (short i = 0; i < 5; i++) {
                HSSFCell cell = row[1].createCell(i);
                cell.setCellValue("新的EXCEL文件" + i);
            }


            row[2] = sheet.createRow(2);
            String[] arr = new String[5];
            String[] arr2 = {"aa", "bb", "cc", "dd", "ee"};
            for (short i = 0; i < 5; i++) {
                HSSFCell cell = row[2].createCell(i);
                cell.setCellValue(arr2[i]);
            }
            sheet.createRow(3).createCell(0).setCellType(CellType.BLANK);
            sheet.createRow(4).createCell(0).setCellType(CellType.BOOLEAN);
            sheet.createRow(5).createCell(1).setCellValue("1234567890");
            sheet.createRow(6).createCell(0).setCellValue(Calendar.getInstance());
            sheet.createRow(7).createCell(0).setCellValue("字符串");
            sheet.createRow(8).createCell(0).setCellValue(true);
            sheet.createRow(9).createCell(0).setCellType(CellType.ERROR);

            //设置footer
            sheet.setGridsPrinted(false);
            HSSFFooter footer = sheet.getFooter();
            footer.setRight("page " + HeaderFooter.page() + "of" + HeaderFooter.numPages());

            workbook.write(out);
            out.close();
            System.out.println(file + " written successfully on disk.");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
