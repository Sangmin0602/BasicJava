package io.github.sangmin.BasicJava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class NormalFileReader {
	public static void main(String[] args) throws IOException {
		
		/*
		 * File 은 절대 File이 아닙니다!!!!
		 * File 은 그냥 file path를 의미합니다. 이게 진짜 파일을 가리키는지는 알 수 없음.
		 * 
		 */
		File file = new File ( "normal000.txt");
		if ( file.exists() ) {
			
		}
		
		FileReader fr = new FileReader(file);
		
		
		
		
		
		
		
		
		
		
		
		
		
		BufferedReader br  = new BufferedReader(fr);
		
		System.out.println(br.readLine());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		br.close();
		
		
		
	}
}
