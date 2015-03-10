package io.github.sangmin.BasicJava;

import java.io.InputStream;
import java.util.Scanner;

public class RelativeFileReader {

	public static void main(String[] args) {
//		InputStream is = RelativeFileReader.class.getClassLoader().getResourceAsStream(
//				"io/github/sangmin/BasicJava/relative_file.txt");
		InputStream is = RelativeFileReader.class.getResourceAsStream(
				"relative_file.txt");
		Scanner scaner = new Scanner(is);
		System.out.println(scaner.nextLine());
	}

}
