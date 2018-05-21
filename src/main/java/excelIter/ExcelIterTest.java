package excelIter;

import org.apache.http.client.methods.HttpGet;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @title: edu-cloud-network-learning
 * @copyright: Copyright © 2017-2020 汉博德信息技术有限公司 All Rights Reserved
 * @company: http://www.hanboard.com
 * @author: Young
 * @desc: Excel导入遍历查询再导出测试
 * @date: Created at 1/25 0025 17:27
 */
public class ExcelIterTest {
    private final static String excel2003L =".xls";    //2003- 版本的excel
    private final static String excel2007U =".xlsx";   //2007+ 版本的excel
    public static void main(String[] args) {
        //  用于接收信息的List
        List<String> list = new ArrayList<String>();
        //  读取文件信息
        File file = new File("C::\\Administrator\\Desktop\\ttt.xlsx");
        try {
            // 创建输入流
            InputStream is = new FileInputStream(file);
            //  创建工作簿
            Workbook workbook = new HSSFWorkbook(is);
            //  设置sheet,row,cell及style
            Sheet sheet = null;
            Row row = null;
            Cell cell = null;

            //  遍历工作簿所有的sheet
            for (int i = 0; i < workbook.getNumberOfSheets(); i++){
                sheet = workbook.getSheetAt(i);
                //  判空
                if (null == sheet){
                    continue;
                }
                //  遍历sheet中所有的行
                for (int j = sheet.getFirstRowNum(); j < sheet.getLastRowNum() + 1; j++){
                    //  赋值row
                    row = sheet.getRow(j);
                    //  判定row是否为空或者row是否为第一行(留第一行)
                    if (null == row || row.getFirstCellNum() == j){
                        continue;
                    }

                    String str = "";
                    //  遍历所有列
                    for (int k = row.getFirstCellNum(); k < row.getLastCellNum(); k++){
                        //  赋值cell
                        cell = row.getCell(k);
                        //  获取cell的值
                        str = cell.getRichStringCellValue().getString();
                        list.add(str);
                    }
                }
            }
            //  关闭
            workbook.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 导出excel
     * @param str
     */
    public static void exportResult(String str){
        //  获取文件信息
        File file = new File("C:\\Administrator\\Desktop\\Result.xls");
        try {
            //  读取输入流
            InputStream is = new FileInputStream(file);
            //  创建工作簿
            HSSFWorkbook workbook = new HSSFWorkbook(is);
            //  确定sheet表
            HSSFSheet sheet = workbook.getSheetAt(0);
            //  获取读取表的最后一行
            int lastRowNum = sheet.getLastRowNum();
            //  进行数据插入(从最后一行开始)
            HSSFRow row = sheet.createRow(lastRowNum + 1);
            //  创建单元格,设置样式
            HSSFCellStyle style = workbook.createCellStyle();
            //  居中样式
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            //  赋值单元格数据
            HSSFCell cell = row.createCell(0);
            cell.setCellValue(str);
            cell.setCellStyle(style);
            //  将新的数据表重新写回文件
            OutputStream os = new FileOutputStream(file);
            workbook.write(os);
            //  关闭
            workbook.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
