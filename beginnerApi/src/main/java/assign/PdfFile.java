package assign;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PdfFile extends FirstAssi {
	public void PdfRead()   {
		{

			String word = "TestNG,Cucumber,HTML,CSS,JavaScript,Selenium,JIRA";
			try {



				PDDocument docs = PDDocument.load(new File (Path));
				PDFTextStripper pdfdata = new PDFTextStripper();



				String pdftext = pdfdata.getText(docs);
				//System.out.println(pdftext);



				//String caseInsensitive = pdftext.toLowerCase();
				//System.out.println(caseInsensitive.length());



				Set<String> keywords = new HashSet<>();
				{
					for (String s : word.split("\\W")) {
						if (s.length() > 1) {
							keywords.add(s);
						}
					}



					Set<String> mainWordsToFind = new HashSet(keywords);
					System.out.println( "Total Words , " +mainWordsToFind);
					System.out.println(mainWordsToFind.size());




					int count = 0;



					for (String w : pdftext.split("\\W")) {



						if (w.length() > 1) {
							mainWordsToFind.remove(w);
							count++;
							//System.out.println("count =" +count);



						}
						//System.out.println("count =" +count);

					}
					System.out.println( "mainWordsToFind size :" +mainWordsToFind.size());





					// Print the percent of word found 3 - 2 = 1/3 *100
					System.out.println((double) (keywords.size() - mainWordsToFind.size()) / keywords.size()*100);



				}

			}
			catch(Exception e) {

			}

		}
	}
}
