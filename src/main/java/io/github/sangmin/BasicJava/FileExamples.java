package io.github.sangmin.BasicJava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Hello world!
 * 
 */
public class FileExamples {

	public static void main(String[] args) throws IOException {

		ClassLoader loader = FileExamples.class.getClassLoader();
		InputStream is = loader.getResourceAsStream("absolute_file.txt");

		/*
		 * scanner 는 자바 1.5부터 등장했습니다.
		 */
		Scanner scanner = new Scanner(is);
		while (scanner.hasNext()) {
			System.out.println(scanner.next());
		}
		scanner.close();

		/*
		 * 1.5 이전(1.4까지는) 아래와 같은 식으로 파일을 읽어들였습니다.
		 */
		is = loader.getResourceAsStream("absolute_file.txt");
		InputStreamReader reader = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(reader);
		
		/*
		 * 
		 * doGet ( HttpServletRequest req, Http... response ) {
		 *     PrintWriter writer = new PrintWriter(response.getWriter("utf-8"));
		 *     writer.println("<html><....</html>");
		 *     writer.flush();
		 *     
		 */
		/*
		 * stream 과 reader의 차이
		 * 
		 * Reader, Wirter - java 1.2부터 등장 1.1 까지는 stream - 무조건 1바이트가 1글자라고 가정하고
		 * 스트림을 처리.
		 * 
		 * Reader, Writer 같은 경우는 encoding을 지정해줄 수 있음. ksc5601, euc-kr, utf-8
		 * 
		 * Rader나 Writer는 모두 stream을 통해서 데이터를 읽거나 씁니다.
		 * 
		 * 그래서 최상위에서 이를 받아주는 어떤 구현체가 있어야 합니다.
		 * 
		 * 스트림에서 데이터를 읽어들일때 - InputStreamReader, 데이트를 쓸 때 - OutputStreamWriter
		 */

		/*
		 * buffered reader는 읽기 속도를 높이기 위해서 자기가 참조하는 스트림에서 데이터를 몽땅 읽어다 놓습니다.
		 */

		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}

		br.close();

		/**
		 * 데이터(문자)를 파일에 쓸때
		 */

		OutputStreamWriter ow = new OutputStreamWriter(System.out, "utf-8");
		BufferedWriter bw = new BufferedWriter(ow);
		PrintWriter pw = new PrintWriter(bw);
		
		
		Socket socket = new Socket("", 80);
		InputStream in = socket.getInputStream();
		
		OutputStream out = socket.getOutputStream();
		
		OutputStreamWriter wout = new OutputStreamWriter(out, "utf-8");
		wout.write("야야야"); // 실제로 가는 바이트가 뭐냐?
		

	}
}
