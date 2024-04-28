package practice;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ToReadDataFromExcelSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook workbook= WorkbookFactory.create(fis);
		String value = workbook.getSheet("Contacts").getRow(1).getCell(2).toString();
		System.out.println(value);
	}

}
