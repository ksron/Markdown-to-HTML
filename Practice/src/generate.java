package mdconverter;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileNotFoundException;

/*
 Call Generate �ϴ� Ŭ�����Դϴ�.
 ���߿� �ܼ��̶� ��ĥ ��,
 �ļ� ���̿� �ȾƼ� ������ �� �� ���ƿ�!!
 �ļ�: Document -> Node (generate)-> Token (generate)
 �̷��� ������ �� �� �����ϴ�.
 */
/*
public class generate{

	public static void main(String[] args){

	System.out.println("Call Generator\n");
	try{
		FileWriter w_file = new FileWriter("test.html");
		w_file.write("<html>\n");
		w_file.write("<body>\n");
		w_file.close();

		MDElement c = new MDConstruct();
		c.accept(new generator());

		FileWriter w_file2 = new FileWriter("test.html",true);
		w_file2.write("</body>\n");
		w_file2.write("</html>\n");
		w_file2.close();

		w_file.close();
	}catch(IOException e){
		e.printStackTrace();
	}

	}

}
*/