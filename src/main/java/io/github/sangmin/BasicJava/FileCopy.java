package io.github.sangmin.BasicJava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

public class FileCopy {

	public static void main(String[] args) throws IOException {
		InputStream is = FileCopy.class.getResourceAsStream("relative_file.txt");
		
		
//		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		InputStreamReader reader = new InputStreamReader(is);
		
		File file = new File("relative_file2.txt");
		if(!file.exists()) {
			file.createNewFile();			
		}
		OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file, true));

//		String line = "";
//		while((line = reader.readLine()) != null) {
//			writer.write(line + "\n");
//		}
				
		copy(reader, writer);
		writer.flush();
		writer.close(); // 
		reader.close();
		
	}
	
	
	static void copy ( Reader reader, Writer writer) throws IOException {
//		String line = null;
		int oneChar ;
		BufferedReader br = convertToBufReader( reader);
		PrintWriter pw = convToPrintWriter(writer);
		
//		while( (oneChar = reader.read()) >= 0 ) {
//			writer.write( oneChar ); // System.getProperty("line.separator"); 0x10 x013  |  0x13
//		}
		String line = null;
		while ( (line = br.readLine()) != null  ) {
			pw.println(line);
		}
		
		pw.flush(); // 이거 꼭 써줍니다.
		
	}


	private static PrintWriter convToPrintWriter(Writer writer) {
		if ( writer instanceof PrintWriter ) {
			return (PrintWriter) writer;
		} else {
			return new PrintWriter ( new BufferedWriter(writer));
		}
	}


	private static BufferedReader convertToBufReader(Reader reader) {
		if ( reader instanceof BufferedReader ) {
			return (BufferedReader) reader;
		} else {
			return new BufferedReader(reader);
		}
	}

}
