package assign;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.FilenameUtils;
//import org.apache.commons.text.similarity.CosineDistance;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.testng.annotations.Test;


public class FirstAssi {
	static String Path="C:\\Users\\FRCABRAL\\OneDrive - Capgemini\\Documents\\46120591_FrancyCabral.pdf";
	//static String Path=".\\demoJson\\resumee.docx";

	public static void main(String[] args) throws Exception {
	
		docReader dr=new docReader();
		PdfFile pr=new PdfFile();
		String p1="docx";
		String p2="pdf";


		String ext1 = FilenameUtils.getExtension(Path);
		
		//System.out.println(ext1);
		if (ext1.equals(p1)) {
			System.out.println(ext1);
			dr.docFile();


		}
		if (ext1.equals(p2)) {
			System.out.println(ext1);
			pr.PdfRead();

		}



		




	}


}
