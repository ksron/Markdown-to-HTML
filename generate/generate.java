import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class generate{

	public static void main(String[] args){

		Scanner scanner = new Scanner(System.in);
		File m_file = new File("test.txt");

try{
		System.out.println("exists: " + m_file.exists());
		System.out.println("getName: " + m_file.getName());
		System.out.println("length: " + m_file.length());
		System.out.println("lastModified: " + m_file.lastModified());
		System.out.println("canRead: " + m_file.canRead());
		System.out.println("canWrite: " + m_file.canWrite());
		System.out.println("isHidden: " + m_file.isHidden());
		System.out.println("isFile: " + m_file.isFile());
		System.out.println("isDirectory: " + m_file.isDirectory());
}catch(IllegalArgumentException e){
	e.printStackTrace();
	}

try{
	FileReader m_reader = new FileReader(m_file);
	System.out.print(String.valueOf((char)m_reader.read()));
	m_reader.close();

	}catch(FileNotFoundException e){
		e.printStackTrace();
	}catch(IOException e){
		e.printStackTrace();
		}


		}




}