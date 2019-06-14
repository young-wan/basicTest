package excelIter;

import org.apache.http.client.methods.HttpGet;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.FormulaParseException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.ResourceUtils;

import javax.swing.text.html.parser.Parser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @title: edu-cloud-network-learning
 * @copyright: Copyright © 2017-2020 汉博德信息技术有限公司 All Rights Reserved
 * @company: http://www.hanboard.com
 * @author: Young
 * @desc: Excel导入遍历查询再导出测试
 * @date: Created at 1/25 0025 17:27
 */
public class ExcelIterTest {
    private final static String excel2003L = ".xls";    //2003- 版本的excel
    private final static String excel2007U = ".xlsx";   //2007+ 版本的excel

    private final static Pattern pattern = Pattern.compile("\\{[^\\}]+\\}");

    public static void main(String[] args) throws FileNotFoundException {
        String a = "0012-8975";
        System.out.println(a.length());
        int num = 15 - a.length();
        System.out.println(num);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; i++) {
            sb.append("0");
        }
        System.out.println(sb);
        String res = "WP";
        System.out.println(res + sb + "X" + a);
    }

    /**
     * 导出excel
     *
     * @param list
     */
    public static boolean exportResult(List<List<String>> list, File file) throws FileNotFoundException {
        //  获取文件信息
        Boolean flag = true;
        String formulaStr = "";
        try {

            //  创建工作簿
            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(file));
            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
            //  确定sheet表
            HSSFSheet sheet = workbook.getSheetAt(0);
            //  创建单元格,设置样式
            HSSFCellStyle style = workbook.createCellStyle();
            int rowNum = list.size();
            HSSFRow row;
            for (int i = 1; i < rowNum; i++) {
                row = sheet.createRow(i);
                //  居中样式
                style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                for (int j = 0; j < list.get(i).size(); j++) {
                    //  赋值单元格数据
                    HSSFCell cell = row.createCell(j);
                    cell.setCellStyle(style);
                    cell.getAddress();
                    if (j == 3) {
                        //  处理公式中add的位置
                        CellAddress curCellAdd = cell.getAddress();
                        CellAddress regCellAdd = new CellAddress(curCellAdd.getRow(), 1);
                        formulaStr = list.get(i).get(j).replaceAll("\\{add\\}", regCellAdd.toString());
                        try {
                            cell.setCellFormula(formulaStr);
                            int res = evaluator.evaluateFormulaCell(cell);
                            System.out.println(cell.getNumericCellValue());
                            System.out.println("res: " + res);
                        } catch (Exception e) {
//                            e.printStackTrace();
                            System.out.println("公式错误");
                            return false;
                        }
                    } else {
                        cell.setCellValue(list.get(i).get(j));
                    }
                }
            }
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
        return flag;
    }

    /**
     * 读取excel值
     */
    public static void readExport(File file) {
        //  用于接收信息的List
        List<String> list = new ArrayList<String>();
        try {
            // 创建输入流
            InputStream is = new FileInputStream(file);
            //  创建工作簿
            Workbook workbook = new HSSFWorkbook(is);
            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
            //  设置sheet,row,cell及style
            Sheet sheet = null;
            Row row = null;
            Cell cell = null;

            //  遍历工作簿所有的sheet
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                sheet = workbook.getSheetAt(i);
                //  判空
                if (null == sheet) {
                    continue;
                }
                //  遍历sheet中所有的行
                for (int j = sheet.getFirstRowNum(); j < sheet.getLastRowNum() + 1; j++) {
                    //  赋值row
                    row = sheet.getRow(j);
                    //  判定row是否为空或者row是否为第一行(留第一行)
                    if (null == row) {
                        continue;
                    }

                    String str = "";
                    //  遍历所有列
                    for (int k = row.getFirstCellNum(); k < row.getLastCellNum(); k++) {
                        //  赋值cell
                        cell = row.getCell(k);
                        //  获取cell的值
                        if (null != cell) {
                            if (cell.getCellType() == 2) {
                                System.out.println("cell: " + cell);
                                evaluator.evaluateFormulaCell(cell);
                                try {
                                    str = String.valueOf(cell.getNumericCellValue());
                                } catch (IllegalStateException e) {
                                    str = String.valueOf(cell.getRichStringCellValue());
                                }
                            } else {
                                str = cell.toString();
                            }
                            list.add(str);
                        }
                    }
                }
            }
            System.out.println("list: " + list);
            //  关闭
            workbook.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
