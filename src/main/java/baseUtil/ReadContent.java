package baseUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadContent {
	
	public static String emailcontent; 

//public static String readFileContent(String arg[]) throws IOException {
		
		public static void main(String arg[]) throws IOException {
		File file = new File(".\\test-output\\emailable-report.html");
		BufferedReader bf = new BufferedReader(new FileReader(file));
		String content = "";
		StringBuilder sb = new StringBuilder();
		while (content != null) {
			content = bf.readLine();
			//emailcontent = sb.toString();
			System.out.println(content);
			if (content == null) {
				break;
			}

			sb.append(content.trim());
		
		}

		bf.close();
		//return content;
		
	}

}
