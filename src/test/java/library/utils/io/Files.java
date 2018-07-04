/*
 *  @Author: AShutosh Mishra
 */
package library.utils.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Files {
	
	//Global Vars
		PrintWriter pw 		= null;
		BufferedReader br 	= null;
		FileReader fr 		= null;
		File file 			= null;
		String filename 	= null;
		
	// Constructor
	public Files() throws Exception {
		//pw = new PrintWriter(new File(file));
	}
	
	public Files(String file) throws Exception {
		pw = new PrintWriter(new File(file));
	}
	
	// Set file.
	public void setFile(File file) throws Exception {
		this.file = file;
		pw = new PrintWriter(this.file);
	}
	
	// Get file
	public File getFile() throws Exception {
		return this.file;
	}
	
	//Write content inside a file.
	public void writeFile(String text) throws Exception {
		// If you want this file in a specific location then give absolute path along with the filename.
		if(!pw.equals(null)) pw.write(text);
		return;
	}
	
	//Read the files
	public List<String> readFile(File fileObj) throws Exception {
		System.out.println("Reading a file....");
		// Vars
			List<String> texts 		= new ArrayList<String>();
			String sCurrentLine 	= "";
			
		//Initiating file reader and buffer reader.
			this.fr = new FileReader(fileObj);
			this.br = new BufferedReader(fr);
			
		//Reading file now, line by line.
			while ((sCurrentLine = br.readLine()) != null) {
				//trim all the gaps and tabs
				//String line = sCurrentLine.replaceAll("[\t]+", "");
				//add each line to array bucket
					texts.add(sCurrentLine);
			}
			
			
		
		//Close the stream now.
			if (br != null) br.close();
			if (fr != null) fr.close();
			
		// return the data
			return texts;
	}
	
	// Close the file.
	public void closeFile() throws Exception { if(!pw.equals(null)) pw.close(); }
}
