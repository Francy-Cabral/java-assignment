package assign;

import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Set;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class docReader extends FirstAssi{
	public void docFile() {


		String word="vnv selenium java";
		{
			try {
				FileInputStream fis = new FileInputStream(Path);
				XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
				XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
				String full=extractor.getText();
				String caseInsensitive= full.toLowerCase();



				Set<String> mainWords = new HashSet<>();
				{
					for (String s : word.split("\\W")) {
						if (s.length() > 1) {
							mainWords.add(s);
						}
					}

					Set<String> mainWordsToFind = new HashSet<>(mainWords);
					for (String w : caseInsensitive.split("\\W")) {
						if (w.length() > 1) {
							mainWordsToFind.remove(w);
						}
					}                            //3-2/3*100
					System.out.println((double) (mainWords.size() - mainWordsToFind.size()) / mainWords.size()*100);
				}

			}
			catch(Exception e) {

			}
		}
	}
}
