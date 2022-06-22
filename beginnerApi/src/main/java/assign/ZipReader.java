package assign;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipReader {
	public static void main(String[] args) throws Exception{
	    ZipFile zipfile = new ZipFile(".\\demoJson\\resumee.zip");

	    Enumeration<? extends ZipEntry> entries = zipfile.entries();
	    

	    BufferedReader input = new BufferedReader(new InputStreamReader(
	            System.in));
	        while (entries.hasMoreElements()) {
	          ZipEntry ze = (ZipEntry) entries.nextElement();
	         // System.out.println("Read " + ze.getName() + "?");
	         // String inputLine = input.readLine();
	         // if (inputLine.equalsIgnoreCase("yes")) {
	            long size = ze.getSize();
	            if (size > 0) {
	              System.out.println("Length is " + size);
	              BufferedReader br = new BufferedReader(
	                  new InputStreamReader(zipfile.getInputStream(ze)));
	              String line;
	              
	              while ((line = br.readLine()) != null) {
	                System.out.println(line.toString());
	                
	              }
	              br.close();
	            }
	          }
	        }
	        
	    
	}


