package com.jd.m.cms.bjshare.common.exportexcel;

import com.jd.m.cms.bjshare.common.utils.DateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: zhaoxiaoguang
 * @Description: 导出报表的方法
 * @Date: created in 2018/5/14
 * @Modidied By:
 **/
public class ExportToExcelUtil {

    private static final Log log = LogFactory.getLog(BatchExportToExcelUtil.class);
    private static final boolean logInfoEnabled = log.isInfoEnabled();
    private static final Pattern  p = Pattern.compile("^//d+(//.//d+)?$");

    /**
     * 导出Excel的方法
     * @param workbook excel中的sheet名称
     * @param columns  每列显示的字段
     * @param result 结果集
     * @throws Exception
     */
    public static <T> Workbook exportExcel(Workbook workbook, String[] columns, List<T> result) throws Exception{

        if (logInfoEnabled) {
            log.info("报表条数：" + (result != null ? result.size()  : 0));
        }
        Long startTime = System.currentTimeMillis();
        if(workbook == null) {
            return null;
        }
        if(columns == null) {
            return workbook;
        }
        HSSFSheet sheet = (HSSFSheet)workbook.getSheetAt(0);

        // 声明一个画图的顶级管理器
        Drawing patriarch = sheet.createDrawingPatriarch();

        // 遍历集合数据，产生数据行
        if(result != null && result.size() > 0){
            int rowNum =  sheet.getLastRowNum() + 1;
            for(T t : result) {
                HSSFRow row = sheet.createRow(rowNum);
                rowNum++;
                for(short i = 0; i < columns.length; i++) {
                    HSSFCell cell = row.createCell(i);
                    String fieldName = columns[i];
                    String getMethodName = "get"
                            + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    Class tCls = t.getClass();
                    Method getMethod = tCls.getMethod(getMethodName, new Class[]{});
                    Object value = getMethod.invoke(t, new Class[]{});
                    String textValue = null;
                    if(value == null) {
                        textValue = "";
                    } else if (value instanceof Date) {
                        Date date = (Date) value;
                        textValue = DateUtil.formatDateToString(date, DateUtil.YYMMDDHHMMSS);
                    }  else if (value instanceof byte[]) {

                        // 有图片时，设置行高为60px;
                        row.setHeightInPoints(60);

                        // 设置图片所在列宽度为80px,注意这里单位的一个换算
                        sheet.setColumnWidth(i, (short) (35.7 * 80));
                        byte[] bsValue = (byte[]) value;
                        ClientAnchor anchor = new HSSFClientAnchor(0, 0, 1023, 255, (short) 6, rowNum, (short) 6, rowNum);
                        anchor.setAnchorType(ClientAnchor.AnchorType.MOVE_DONT_RESIZE);
                        patriarch.createPicture(anchor, workbook.addPicture(bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));
                    } else {

                        //其它数据类型都当作字符串简单处理
                        textValue = value.toString();
                    }
                    if(textValue != null) {
                        //头文件样式
                        CellStyle style = cellContent(workbook);
                        cell.setCellStyle(style);
                        Matcher matcher = p.matcher(textValue);
                        if(matcher.matches()) {

                            //是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            cell.setCellValue(textValue);
                        }
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
     *  创建一个工作簿
     * @param title 报表头文件
     * @param headers 报表列信息
     * @return
     */
    public static Workbook createWorkBook(String title, String[] headers) {

        // 声明一个工作薄
        Workbook workbook = new HSSFWorkbook();

        // 生成一个表格
        HSSFSheet sheet = (HSSFSheet) workbook.createSheet(title);

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
            RichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        return workbook;
    }

    /**
     *  文件头样式展示
     * @param workbook
     * @return
     */
    private static CellStyle cellHead(Workbook workbook) {

        // 生成一个 表格标题行样式
        CellStyle style = workbook.createCellStyle();

        // 设置这些样式
        style.setFillForegroundColor(IndexedColors.ORCHID.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setAlignment(HorizontalAlignment.CENTER);

        // 生成一个字体
        Font font = workbook.createFont();
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setFontHeightInPoints((short) 12);
        font.setBold(true);

        // 把字体应用到当前的样式
        style.setFont(font);
        return style;
    }

    /**
     *  内容样式展示
     * @param workbook
     * @return
     */
    private static CellStyle cellContent(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();

        // 生成另一个字体
        Font font2 = workbook.createFont();

        // 把字体应用到当前的样式
        style.setFont(font2);
        style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);


        return style;
    }
}
