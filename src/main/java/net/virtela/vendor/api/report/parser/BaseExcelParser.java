package net.virtela.vendor.api.report.parser;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import net.virtela.vendor.api.report.util.CommonHelper;

public abstract class BaseExcelParser {
	private Workbook workBook;
	public static final String XLSX_FORMAT = "xlsx";
	public static final String XLS_FORMAT = "xls";
	public static final String XLMS_FORMAT = "xlsm";

	private static final String ERROR_FORMULA_UNREADABLE = "{Formula Error}";

	private static final int CONFIG_CONSECUTIVE_INALID_ROW_COUNT_LIMIT = 20;

	public abstract int getStartRowIndex();

	public abstract String getSheetName();

	public BaseExcelParser() {
		super();
	}

	public BaseExcelParser(InputStream input) {
		super();
		POIFSFileSystem fs;
		try {
			fs = new POIFSFileSystem(input);
			this.workBook = new HSSFWorkbook(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public BaseExcelParser(InputStream input, final String fileFormat) {
		super();

		try {
			if (fileFormat.equalsIgnoreCase(XLS_FORMAT)) {
				this.workBook = new HSSFWorkbook(input);
			} else if (fileFormat.equalsIgnoreCase(XLSX_FORMAT) || fileFormat.equalsIgnoreCase(XLMS_FORMAT)) {
				this.workBook = new XSSFWorkbook(input);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void setWorkBook(InputStream input, final String fileName) {
		try {
			final String fileFormat = CommonHelper.getFileExtension(fileName);
			if (fileFormat.equalsIgnoreCase(XLS_FORMAT)) {
				this.workBook = new HSSFWorkbook(input);
			} else if (fileFormat.equalsIgnoreCase(XLSX_FORMAT) || fileFormat.equalsIgnoreCase(XLMS_FORMAT)) {
				this.workBook = new XSSFWorkbook(input);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Identifies the cell datat type and returns the data in the correct format
	 *
	 * @param cell
	 * @return
	 */
	public Object getCellValue(Cell cell) {

		if (cell != null) {
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				return cell.getRichStringCellValue().getString().trim();
			case Cell.CELL_TYPE_NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					return cell.getDateCellValue();
				} else {
					return CommonHelper.toWholeNumber(new BigDecimal(cell.getNumericCellValue()));
				}
			case Cell.CELL_TYPE_BOOLEAN:
				return cell.getBooleanCellValue();
			case Cell.CELL_TYPE_FORMULA:
				return getCellFormulaValue(cell);
			}
		}
		return "";
	}

	private Object getCellFormulaValue(Cell cell) {
		try {
			final FormulaEvaluator evaluator = this.workBook.getCreationHelper().createFormulaEvaluator();
			final CellValue cellValue = evaluator.evaluate(cell);
			switch (cellValue.getCellType()) {
			case Cell.CELL_TYPE_BOOLEAN:
				return cellValue.getBooleanValue();
			case Cell.CELL_TYPE_NUMERIC:
				return CommonHelper.toWholeNumber(new BigDecimal(cellValue.getNumberValue()));
			case Cell.CELL_TYPE_STRING:
				return cellValue.getStringValue();
			}
		} catch (Exception e) {
			return ERROR_FORMULA_UNREADABLE;
		}

		return "";
	}

	/**
	 *
	 * @param row
	 * @param requiredFields
	 * @return
	 */
	public boolean isRowValid(Row row, Integer[] requiredFields) {

		boolean isRowValid = true;
		for (int index : requiredFields) {
			final Object rowValue = this.getCellValue(row.getCell(index));
			if (CommonHelper.hasValidValue(rowValue) == false || CommonHelper.isEqual(rowValue, ERROR_FORMULA_UNREADABLE)) {
				isRowValid = false;
			}
		}
		return isRowValid;
	}

	public long getValidRowsCount(final Integer[] requiredFields, int startRowIndex) {
		long count = 0;
		final Sheet sheet = this.getSheetInstance();
		long currentRowPos = 0;
		for (Row row : sheet) {
			if (currentRowPos >= startRowIndex && isRowValid(row, requiredFields)) {
				count += 1;
			}
			currentRowPos += 1;
		}
		return count;
	}

	/**
	 * Iteration stops if consecutive invalid rows are fetch reaches the CONFIG_CONSECUTIVE_INALID_ROW_COUNT_LIMIT
	 * 
	 * @param requiredFields
	 *            fields that are required for a row to be read
	 * @param startCol
	 * @param endCol
	 * @param rowIndex
	 * @return Array of object based on the xls file stream provided
	 */
	public List<Object[]> extratRows(final Integer[] requiredFields, final int startCol, final int endCol, final int rowIndex) {
		final List<Object[]> objectList = new ArrayList<Object[]>();
		final Sheet sheet = this.getSheetInstance();

		if (sheet == null) {
			return objectList;
		}

		int startIndex;

		if (rowIndex != -1) {
			startIndex = rowIndex;
		} else {
			startIndex = this.getStartRowIndex();
		}

		int currentRowPos = 0;
		int consecutiveInvalidRowCount = 0;
		for (Row row : sheet) {
			if (currentRowPos >= startIndex && isRowValid(row, requiredFields)) {
				Object[] arrObj = new Object[endCol - startCol];
				int objIndex = 0;
				for (int index = startCol; index < endCol; index++) {
					arrObj[objIndex] = this.getCellValue(row.getCell(index));
					objIndex += 1;
				}
				objectList.add(arrObj);
				consecutiveInvalidRowCount = 0;
			} else {
				consecutiveInvalidRowCount += 1;
				if (consecutiveInvalidRowCount == CONFIG_CONSECUTIVE_INALID_ROW_COUNT_LIMIT) {
					return objectList;
				}
			}
			currentRowPos += 1;
		}
		return objectList;
	}

	/**
	 *
	 * @param requiredFields
	 * @param startCol
	 * @param endCol
	 * @return
	 */

	public List<Object[]> extratRows(final Integer[] requiredFields, final int startCol, final int endCol) {
		return extratRows(requiredFields, startCol, endCol, -1);
	}

	/**
	 *
	 * @param requiredFields
	 * @param rowIndexs
	 * @return
	 */
	public List<Object[]> extratSpesificRows(final Integer[] requiredFields, final Integer[] rowIndexs) {

		final List<Object[]> objectList = new ArrayList<Object[]>();
		final Sheet sheet = this.getSheetInstance();

		int currentRowPos = 0;
		for (Row row : sheet) {
			if (currentRowPos >= this.getStartRowIndex() && isRowValid(row, requiredFields)) {
				Object[] arrObj = new Object[rowIndexs.length];
				int objIndex = 0;
				for (int rowIndex : rowIndexs) {
					arrObj[objIndex] = this.getCellValue(row.getCell(rowIndex));
					objIndex += 1;
				}
				objectList.add(arrObj);
			}
			currentRowPos += 1;
		}

		return objectList;

	}

	public Sheet getSheetInstance() {
		if (this.workBook.getSheet(this.getSheetName()) == null) {
			System.out.println("Has Workbook for Address!");
			final int firstSheetIndex = 0;
			return this.workBook.getSheetAt(firstSheetIndex);
		}
		return this.workBook.getSheet(this.getSheetName());
	}

	/**
	 * 
	 * @param rowIndex
	 * @param colIndex
	 * @return
	 */
	public Object extractCellValue(final int rowIndex, final int colIndex) {
		final Sheet sheet = this.getSheetInstance();
		final Row row = sheet.getRow(rowIndex);
		return this.getCellValue(row.getCell(colIndex));
	}

	public Date extractDate(String cellReff) {
		final Cell cell = getCellByReff(cellReff);
		try {
			final Object objDate = cell.getDateCellValue();
			if (objDate != null && objDate.getClass().equals(Date.class)) {
				return (Date) objDate;
			}
		} catch (IllegalStateException e) {
			return null;
		}
		return null;
	}

	public String extractString(String cellReff) {
		final Cell cell = getCellByReff(cellReff);
		final Object objStr = this.getCellValue(cell);
		if (CommonHelper.hasValidValue(objStr)) {
			return CommonHelper.getStringValue(objStr);
		}
		return null;
	}

	private Cell getCellByReff(String cellReff) {
		final Sheet sheet = this.getSheetInstance();
		CellReference ref = new CellReference(cellReff);
		final Row row = sheet.getRow(ref.getRow());
		if (row != null) {
			return row.getCell(ref.getCol());
		}
		return null;
	}

	public int getWorkSheetRowSize() {
		return this.getSheetInstance().getLastRowNum();
	}

	public List<Object[]> extratRows(final Integer[] requiredFields, final int startCol, final int endCol, final int startRow, int endRow) {
		final List<Object[]> objectList = new ArrayList<Object[]>();
		final Sheet sheet = this.getSheetInstance();

		if (sheet == null) {
			return objectList;
		}

		for (int rowIndex = startRow; rowIndex <= endRow; rowIndex++) {
			final Row row = sheet.getRow(rowIndex);
			if (isRowValid(row, requiredFields)) {
				Object[] arrObj = new Object[endCol - startCol];
				int objIndex = 0;
				for (int index = startCol; index < endCol; index++) {
					arrObj[objIndex] = this.getCellValue(row.getCell(index));
					objIndex += 1;
				}
				objectList.add(arrObj);
			}

		}

		return objectList;
	}

	public Map<String, Integer> initializeCelMapper(List<String> fieldList, int hreaderIndex) {
		final Map<String, Integer> celMapper = new HashMap<>();
		final Sheet sheet = this.getSheetInstance();
		
		final Row row = sheet.getRow(hreaderIndex);
		int cellIndex = 0;
		for (Cell cell : row) {
			final String header = CommonHelper.getStringValue(this.getCellValue(cell)).toUpperCase();
			for (String field : fieldList) {
				if (field.equals(header)) {
					celMapper.put(field, cellIndex);
				}
			}
			cellIndex++;
		}
		return celMapper;
	}

	public List<List<Object>> extractRows(int hreaderIndex) {
		final List<List<Object>> objCollection = new ArrayList<>();
		final Sheet sheet = this.getSheetInstance();
		final int startIndex = this.getStartRowIndex();
		final int cellCount = sheet.getRow(hreaderIndex).getPhysicalNumberOfCells();
		int currentRowPos = 0;
		for (Row row : sheet) {
			if (currentRowPos >= startIndex) {				
				final List<Object> objList = new ArrayList<>();
				for (int index = 0; index < cellCount; index++) {
					objList.add(this.getCellValue(row.getCell(index)));
				}
				objCollection.add(objList);
			}
			currentRowPos += 1;
		}
		return objCollection;

	}
	
	protected Long getLong(Object obj) {
		if (obj instanceof Long) {
			return (Long) obj;
		} else if (obj instanceof BigDecimal) {
			return Long.valueOf(((BigDecimal) obj).longValue());
		} 
		return CommonHelper.toNumber(obj);
	}

}
