package assign;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheet {

	
	public static void main(String[] args) throws Exception {
		
		FileInputStream ExcelFile1 =new FileInputStream(new File("C:\\Users\\FRCABRAL\\Downloads\\Test1.xlsx"));
		FileInputStream ExcelFile2 =new FileInputStream(new File("C:\\Users\\FRCABRAL\\Downloads\\Test2.xlsx"));

        // Create Workbook instance holding reference to .xlsx file
        XSSFWorkbook workbook1 = new XSSFWorkbook(ExcelFile1);
        
        XSSFWorkbook workbook2 = new XSSFWorkbook(ExcelFile2);

        // Get first/desired sheet from the workbook
        XSSFSheet sheet1 = workbook1.getSheetAt(0);
        XSSFSheet sheet2 = workbook2.getSheetAt(0);
        
        int length1=sheet1.getPhysicalNumberOfRows();
        int length2=sheet2.getPhysicalNumberOfRows();
       // if (length1 == length2) {
        try {



        	for (int i = 1; i < length1; i++) {



        	XSSFRow row1 = sheet1.getRow(i);
        	XSSFRow row2 = sheet2.getRow(i);



        	String idstr1 = "";
        	XSSFCell id1 = row1.getCell(0);
        	if (id1 != null) {
        	id1.setCellType(CellType.STRING);
        	idstr1 = id1.getStringCellValue();
        	}
        	else {
        		System.out.println("no data available ");
        	}



        	String idstr2 = "";
        	XSSFCell id2 = row2.getCell(0);
        	if (id2 != null) {
        	id2.setCellType(CellType.STRING);
        	idstr2 = id2.getStringCellValue();
        	}
        	else {
        		System.out.println("no data available");
        	}



        	if (!idstr1.equals(idstr2)) {
        	System.out.println("[ERROR] : Mismatch in ID " + idstr1 + "'s id -----> " + "Test1 ID = " + idstr1
        	+ " Test2 ID = " + idstr2);
        	System.out.println("Difference is  "+StringUtils.difference(idstr1, idstr2));
        	
        	}



        	String namestr1 = "";
        	XSSFCell name1 = row1.getCell(1);
        	if (name1 != null) {
        	name1.setCellType(CellType.STRING);
        	namestr1 = name1.getStringCellValue();
        	}
        	else {
        		System.out.println("no data available at  ID "+idstr1);
        	}



        	String namestr2 = "";
        	XSSFCell name2 = row2.getCell(1);
        	if (name2 != null) {
        	name2.setCellType(CellType.STRING);
        	namestr2 = name2.getStringCellValue();
        	}
        	else {
        		System.out.println("no data available at  ID "+idstr1);
        	}



        	if (!namestr1.equals(namestr2)) {
        	System.out.println("[ERROR] : Mismatch in ID " + idstr1 + "'s name ---> " + "Test1 NAME = "
        	+ namestr1 + " Test2 NAME = " + namestr2);
        	System.out.println("Difference is  "+StringUtils.difference(namestr1, namestr2));
        	
        	}



        	double salarystr1 = 0;
        	XSSFCell salary1 = row1.getCell(2);
        	if (salary1 != null) {
        	salary1.setCellType(CellType.NUMERIC);
        	salarystr1 = salary1.getNumericCellValue();
        	}
        	else {
        		System.out.println("no data available at  ID "+idstr1);
        	}



        	double salarystr2 =0;
        	XSSFCell salary2 = row2.getCell(2);
        	if (salary2 != null) {
        	salary2.setCellType(CellType.NUMERIC);
        	salarystr2 = salary2.getNumericCellValue();
        	}
        	else {
        		System.out.println("no data available at  ID "+idstr1);
        	}



        	if (salarystr1!=salarystr2) {
        	System.out.println("[ERROR] : Mismatch in ID " + idstr1 + "'s salary-> " + "Test1 salary = "
        	+ salarystr1 + " Test2 salary = " + salarystr2);
        	System.out.println("Difference is   "+ (salarystr1-salarystr2));
        	} 
        	
        	
        	}
        }
        	
        	catch(NullPointerException ne) {
        		System.out.println("no data available");
        	}



        	/*} else {



        	System.out.println(
        	"ERROR : rows are not matching --> " + " Row count 1 = " + length1 + " and Row count 2 = " + length2);
        	} */
        	
        
       
	
}
}

	
