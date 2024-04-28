package genericUtility;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class consists of method related to excel file
 */
public class ExcelFileUtility {
/**
 * this file contains excel file data
 * @param sheetname
 * @param row
 * @param cell
 * @return
 * @throws IOException 
 * @throws EncryptedDocumentException 
 */
	public String toReadDataFromExcelFile(String sheetname,int row,int cell) throws IOException {
		FileInputStream fis= new FileInputStream(IconstantUtility.excelfilepath);
		Workbook wb=WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetname).getRow(row).getCell(cell).toString();
		return value;
		
	}
	
	public int toGetRowCount(String sheetname) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream(IconstantUtility.excelfilepath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet=wb.getSheet(sheetname);
		int count=sheet.getLastRowNum();
		return count;
	}


}

