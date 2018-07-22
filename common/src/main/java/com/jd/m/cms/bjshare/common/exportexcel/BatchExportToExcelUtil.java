package com.jd.m.cms.bjshare.common.exportexcel;

import com.jd.m.cms.bjshare.common.utils.DateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: zhaoxiaoguang
 * @Description:  大批量导出报表的方法
 * @Date: created in 2018/5/14
 * @Modidied By:
 **/
public class BatchExportToExcelUtil {

    private static final Log log = LogFactory.getLog(BatchExportToExcelUtil.class);
    private static final boolean logInfoEnabled = log.isInfoEnabled();

    private static final Pattern p = Pattern.compile("^//d+(//.//d+)?$");

    /**
     * 导出Excel的方法
     *
     * @param workbook excel中的sheet名称
     * @param columns  每列显示的字段
     * @param result   结果集
     * @throws Exception
     */
    public static <T> Workbook exportExcel(Workbook workbook, String[] columns, List<T> result, Map<String, BigDecimal>columnssum) throws Exception {

        Long startTime = System.currentTimeMillis();
        if (logInfoEnabled) {
            log.info("报表条数：" + (result != null ? result.size()  : 0));
        }
        if (workbook == null) {
            return null;
        }
        if (columns == null) {
            return workbook;
        }
        Sheet sheet = workbook.getSheetAt(0);

        // 遍历集合数据，产生数据行
        if (result != null && result.size() > 0) {
            int rowNum = sheet.getLastRowNum() + 1;
            for (T t : result) {
                Row row = sheet.createRow(rowNum);
                rowNum++;

                //序号
                Cell cellNum = row.createCell(0);
                CellStyle style = cellContent(workbook);
                cellNum.setCellStyle(style);
                cellNum.setCellValue(rowNum - 1);
                for (short i = 1; i < columns.length; i++) {
                    Cell cell = row.createCell(i);

                    //文件样式
                    cell.setCellStyle(style);
                    String fieldName = columns[i];
                    String getMethodName = "get"
                            + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    Class tCls = t.getClass();
                    Method getMethod = tCls.getMethod(getMethodName, new Class[]{});
                    Object value = getMethod.invoke(t, new Class[]{});
                    String textValue = null;
                    if (value == null) {
                        textValue = "";
                    } else if (value instanceof Date) {
                        Date date = (Date) value;
                        textValue = DateUtil.formatDateToString(date, DateUtil.YYMMDDHHMMSS);
                        if(textValue.contains("00:00")){
                            textValue=textValue.substring(0,10);
                        }
                    } else if (value instanceof byte[]) {

                        // 图片处理
                    } else {

                        //其它数据类型都当作字符串简单处理
                        textValue = value.toString();
                    }
                    if (textValue != null) {
                        Matcher matcher = p.matcher(textValue);
                        if (matcher.matches()) {
                            //是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            cell.setCellValue(textValue);
                        }
                        if (columnssum != null && columnssum.containsKey(columns[i])) {//判断是否是求和字段
                            columnssum.put(columns[i], columnssum.get(columns[i]).add(new BigDecimal(textValue)));
                        }
                    }
                }
            }
            if (columnssum != null) {
                //添加最后一行统计值
                int sumNum = sheet.getLastRowNum() + 1;
                Row row = sheet.createRow(sumNum);
                Cell cellNum = row.createCell(0);//第一列
                CellStyle style = cellContent(workbook);
                cellNum.setCellStyle(style);
                cellNum.setCellValue("总计：");
                for (short i = 1; i < columns.length; i++) {
                    Cell cellCol = row.createCell(i);
                    cellCol.setCellStyle(style);
                    if (columnssum.containsKey(columns[i])) {//判断是否是求和字段
                        cellCol.setCellValue(columnssum.get(columns[i]).toString());
                    }
                }
            }
        }
        Long endTime = System.currentTimeMillis();
        if (logInfoEnabled) {
            log.info("导出时间消耗时间：" + (endTime-startTime)/1000);
        }
        return workbook;

    }

    /**
     * 创建一个工作簿
     *
     * @param title   报表头文件
     * @param headers 报表列信息
     * @return
     */
    public static Workbook createWorkBook(String title, String[] headers) {

        // 声明一个工作薄
        Workbook workbook = new SXSSFWorkbook(1000);

        // 生成一个表格
        Sheet sheet = workbook.createSheet(title);
        // 设置表格默认列宽度为20个字节
        sheet.setDefaultColumnWidth(18);
        sheet.setDefaultRowHeightInPoints(15);

        //头文件样式
        CellStyle style = cellHead(workbook);

        // 产生表格标题行
        Row row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellStyle(style);
            RichTextString text = new XSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        return workbook;
    }

    /**
     * 文件头样式展示
     *
     * @param workbook
     * @return
     */
    private static CellStyle cellHead(Workbook workbook) {

        // 生成一个 表格标题行样式
        CellStyle style = workbook.createCellStyle();

        // 生成一个字体
        Font font = workbook.createFont();
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setFontHeightInPoints((short) 12);
        font.setBold(true);

        // 把字体应用到当前的样式
        style.setFont(font);

        // 设置这些样式
        style.setFillForegroundColor(IndexedColors.ORCHID.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setAlignment(HorizontalAlignment.CENTER);
        return style;
    }

    /**
     * 内容样式展示
     *
     * @param workbook
     * @return
     */
    private static CellStyle cellContent(Workbook workbook) {

        // 生成并设置另一个样式 内容的背景
        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);

        // 生成另一个字体
        Font font = workbook.createFont();

        // 把字体应用到当前的样式
        style.setFont(font);
        return style;
    }
}
