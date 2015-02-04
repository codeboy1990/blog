package com.blog.common.utils;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;
import org.apache.poi.ss.usermodel.Cell;

/**
 * 生成EXCEL报表
 * 
 * @author sfit0086
 * 
 */
@SuppressWarnings("deprecation")
public class ExportExcel {

	/**
	 * 生成无标题 通用格式excel
	 * @param head
	 * @param column
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static HSSFWorkbook exportExcel(Object[] head, Object[] column, Object[] columnType,
			List<?> data) throws Exception {
		HSSFWorkbook workbook = new HSSFWorkbook(); // 创建Excel文件
		/*if(data == null || data.size()==0) {
			workbook.createSheet(); // 创建工作薄
			return workbook;
		}*/
		HSSFSheet sheet = workbook.createSheet(); // 创建工作薄
		HSSFRow row = null; // 行计录
		HSSFCell cell = null; // 单元格
		int rowIndex = 0;
		// 增加头文件信息
		if (head != null) {
			row = sheet.createRow(rowIndex);
			for (int i = 0; i < head.length; i++) {
				cell = row.createCell(i);
				cell.setCellValue(head[i].toString());
			}
			rowIndex++;
		}

		// 写入内容
		for (int i = 0; i < data.size(); i++) {
			row = sheet.createRow(rowIndex++);
			Object obj = data.get(i);
			for (int j = 0; j < column.length; j++) {
				String col = column[j].toString();
				if (col.charAt(1) >= 'a' && col.charAt(1) <= 'z')
					col = col.substring(0, 1).toUpperCase() + col.substring(1);
				try {
					Object result = obj.getClass().getMethod("get" + col)
							.invoke(obj);
					HSSFCell cellj = row.createCell(j);
					Object cType = columnType[j] == null ? Cell.CELL_TYPE_STRING : columnType[j];
					cellj.setCellType((Integer)cType);
					cellj.setCellValue(
							result == null ? "" : result.toString());
				} catch (Exception e) {
					throw e;
				}
			}
		}

		return workbook;
	}

	/**
	 * 生成有标题 通用格式excel
	 * @param head
	 * @param column
	 * @param data
	 * @param title
	 * @return
	 * @throws Exception
	 */
	public static HSSFWorkbook exportExcelOrder(Object[] head, Object[] column,
			List<?> data, String title) throws Exception {
		
		// 注:SystemContext.EXECEL_LIMIT代表规定每个工作簿存记录条数
		HSSFWorkbook workbook = new HSSFWorkbook(); // 创建Excel文件
		if(data == null || data.size()==0) {
			workbook.createSheet(); // 创建工作薄
			return workbook;
		}
		// 设置字体样式 1
		HSSFFont headfont = workbook.createFont();
		headfont.setFontName("黑体");
		headfont.setFontHeightInPoints((short) 18);// 字体大小
		headfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 加粗
		HSSFCellStyle headstyle = workbook.createCellStyle();
		headstyle.setFont(headfont);
		headstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
		headstyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
		headstyle.setLocked(true);
		headstyle.setWrapText(true);// 自动换行
		//headstyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		//headstyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		//headstyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		//headstyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		//headstyle.setFillForegroundColor(HSSFColor.WHITE.index); 
	      
		
		// 设置字体样式 3
		HSSFFont columnHeadFont3 = workbook.createFont();
		columnHeadFont3.setFontName("黑体");
		columnHeadFont3.setFontHeightInPoints((short) 10);
		columnHeadFont3.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		HSSFCellStyle headstyle3 = workbook.createCellStyle();
		headstyle3.setFont(columnHeadFont3);
		headstyle3.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
		headstyle3.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
		//headstyle3.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		headstyle3.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		headstyle3.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		headstyle3.setBorderRight(HSSFCellStyle.BORDER_THIN);
		headstyle3.setBorderTop(HSSFCellStyle.BORDER_THIN);
		
		
		// 设置字体样式 4
		HSSFFont columnHeadFont4 = workbook.createFont();
		columnHeadFont4.setFontName("黑体");
		columnHeadFont4.setFontHeightInPoints((short) 10);
		//columnHeadFont3.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		HSSFCellStyle headstyle4 = workbook.createCellStyle();
		headstyle4.setFont(columnHeadFont4);
		headstyle4.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
		headstyle4.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
		//headstyle4.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		headstyle4.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		headstyle4.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		headstyle4.setBorderRight(HSSFCellStyle.BORDER_THIN);
		headstyle4.setBorderTop(HSSFCellStyle.BORDER_THIN);
		

				
		int sheetNum = 0;
		if (data.size() % 10000 > 0) {
			sheetNum = (data.size() / 10000 + 1);
		} else {
			sheetNum = data.size() / 10000;
		}
		for (int x = 0; x < sheetNum; x++) {

			HSSFSheet sheet = workbook.createSheet(); // 创建工作薄
//			// 设置指定列宽 第一个参数表示 第几列 第二个参数表示 列宽
//			sheet.setColumnWidth(0, 4000);
//			sheet.setColumnWidth(1, 4000);
//			sheet.setColumnWidth(2, 4000);
//			sheet.setColumnWidth(3, 5000);
//			sheet.setColumnWidth(4, 5000);
//			sheet.setColumnWidth(5, 4000);
//			sheet.setColumnWidth(6, 4000);
//			sheet.setColumnWidth(7, 4000);
//			sheet.setColumnWidth(8, 4000);
//			sheet.setColumnWidth(9, 6000);
			
			for(int i = 1; i <= head.length+1; i++){
				sheet.setColumnWidth(i, 6000);
			}
			
			// 创建第一行 索引从0开始
			HSSFRow row0 = sheet.createRow(0);
			row0.setHeight((short) 500);
			// 合并行 四个参数分别为：开始行 开始列 结束行 结束列
			sheet.addMergedRegion(new Region(0, (short) 1, 0, (short) (head.length)));
			// 在row0行里创建第一列cell0
			HSSFCell cell1 = row0.createCell(1);
			// 为第一列设置样式
			cell1.setCellStyle(headstyle);
			// 为第一列赋值
			cell1.setCellValue(new HSSFRichTextString(title));
			
			HSSFRow row = null; // 行计录
			HSSFCell cell = null; // 单元格
			int rowIndex = 2;
			// 增加头文件信息
			if (head != null) {
				row = sheet.createRow(rowIndex);
				for (int i = 0; i < head.length; i++) {
					cell = row.createCell(i+1);
					// 为第一列设置样式
					cell.setCellStyle(headstyle3);
					cell.setCellValue(head[i].toString());
				}
				//添加一行录单日期
				cell = row.createCell(head.length+1);
				cell.setCellStyle(headstyle3);
				cell.setCellValue("录单日期");
				
				rowIndex++;
				
			}
			int createTm_index = 0;
			// 写入内容
			for (int i = x * 10000; i < (x + 1) * 10000 && i < data.size(); i++) {
				row = sheet.createRow(rowIndex++);
				Object obj = data.get(i);
				for (int j = 0; j < column.length; j++) {
					String col = column[j].toString();
					if (col.charAt(1) >= 'a' && col.charAt(1) <= 'z')
						col = col.substring(0, 1).toUpperCase()
								+ col.substring(1);
					try {
						Object result = obj.getClass().getMethod("get" + col)
								.invoke(obj);
						
						HSSFCell cellj = row.createCell(j + 1);
						cellj.setCellType(Cell.CELL_TYPE_STRING);
						cellj.setCellStyle(headstyle4);
						if (col.equalsIgnoreCase("CreateTm")) {
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							result = sdf.format(result);
							createTm_index = i;
						}
							cellj.setCellValue(result == null ? "" : result.toString());
					} catch (Exception e) {
						throw e;
					}
				}
				//添加一行录单日期
				HSSFCell cellnew = row.createCell(column.length+1);
				cellnew.setCellType(Cell.CELL_TYPE_STRING);
				cellnew.setCellStyle(headstyle4);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Object objnew = data.get(createTm_index);
				Object resultnew = objnew.getClass().getMethod("getCreateTm")
						.invoke(objnew);
				resultnew = sdf.format(resultnew);
				cellnew.setCellValue(resultnew == null ? "" : resultnew.toString());
			}//for end
		}
		return workbook;
	}

	/**
	 * 生成list为Map的数据， 有标题 通用格式excel
	 * @param head
	 * @param column
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static HSSFWorkbook exportExcelByMap(Object[] head, Object[] column,
			List<?> data, String title) throws Exception {
		
		// 注:SystemContext.EXECEL_LIMIT代表规定每个工作簿存记录条数
		HSSFWorkbook workbook = new HSSFWorkbook(); // 创建Excel文件
		if(data == null || data.size()==0) {
			workbook.createSheet(); // 创建工作薄
			return workbook;
		}
		// 设置字体样式 1
		HSSFFont headfont = workbook.createFont();
		headfont.setFontName("黑体");
		headfont.setFontHeightInPoints((short) 22);// 字体大小
		headfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 加粗

		HSSFCellStyle headstyle = workbook.createCellStyle();
		headstyle.setFont(headfont);
		headstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
		headstyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
		headstyle.setLocked(true);
		headstyle.setWrapText(true);// 自动换行
		
		// 设置字体样式 3
		HSSFFont columnHeadFont3 = workbook.createFont();
		columnHeadFont3.setFontName("黑体");
		columnHeadFont3.setFontHeightInPoints((short) 10);
		columnHeadFont3.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

		HSSFCellStyle headstyle3 = workbook.createCellStyle();
		headstyle3.setFont(columnHeadFont3);
		headstyle3.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
		headstyle3.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中

				
		int sheetNum = 0;
		if (data.size() % 10000 > 0) {
			sheetNum = (data.size() / 10000 + 1);
		} else {
			sheetNum = data.size() / 10000;
		}
		for (int x = 0; x < sheetNum; x++) {

			HSSFSheet sheet = workbook.createSheet(); // 创建工作薄
			// 设置指定列宽 第一个参数表示 第几列 第二个参数表示 列宽
			sheet.setColumnWidth(0, 4000);
			sheet.setColumnWidth(1, 4000);
			sheet.setColumnWidth(2, 4000);
			sheet.setColumnWidth(3, 5000);
			sheet.setColumnWidth(4, 5000);
			sheet.setColumnWidth(5, 4000);
			sheet.setColumnWidth(6, 4000);
			sheet.setColumnWidth(7, 4000);
			sheet.setColumnWidth(8, 4000);
			sheet.setColumnWidth(9, 6000);
			// 创建第一行 索引从0开始
			HSSFRow row0 = sheet.createRow(0);
			row0.setHeight((short) 900);
			// 合并行 四个参数分别为：开始行 开始列 结束行 结束列
			sheet.addMergedRegion(new Region(0, (short) 1, 0, (short) 8));
			// 在row0行里创建第一列cell0
			HSSFCell cell1 = row0.createCell(1);
			// 为第一列设置样式
			cell1.setCellStyle(headstyle);
			// 为第一列赋值
			cell1.setCellValue(new HSSFRichTextString(title));
			
			HSSFRow row = null; // 行计录
			HSSFCell cell = null; // 单元格
			int rowIndex = 2;
			// 增加头文件信息
			if (head != null) {
				row = sheet.createRow(rowIndex);
				for (int i = 0; i < head.length; i++) {
					cell = row.createCell(i);
					// 为第一列设置样式
					cell.setCellStyle(headstyle3);
					cell.setCellValue(head[i].toString());
				}
				rowIndex++;
			}
			// 写入内容
			for (int i = x * 10000; i < (x + 1) * 10000 && i < data.size(); i++) {
				row = sheet.createRow(rowIndex++);
				Object obj = data.get(i);
				for (int j = 0; j < column.length; j++) {
					String col = column[j].toString();
					try {
						@SuppressWarnings("unchecked")
						Map<String, Object> map = (Map<String, Object>)obj;
						Object result = map.get(col.toUpperCase());
						HSSFCell cellj = row.createCell(j);
						cellj.setCellType(Cell.CELL_TYPE_STRING);
						cellj.setCellValue(
								result == null ? "" : result.toString());
					} catch (Exception e) {
						throw e;
					}
				}
			}
		}
		return workbook;
	}
}

