package mdconverter;

import java.io.FileWriter;
import java.io.IOException;

/*
 얘가 진짜 쓰는 generator 입니다.
 visitor pattern으로 node나 token마다 다 방문해서
 String return 하는 프로그램이고, 다 html 위에 덮어 쓰는걸로 작업했습니다.
 */
public class generator implements MDElementVisitor{

//String filename = new option_input.filename();
	//얘는 나중에 CLI에서 input file 체크해서 method로 return 하는 거 받아서 받아 쓰려고 만들었습니다.

	public void visit(Document doc){
		String a;
		
		a=doc.generate();
		
		try{
			FileWriter w_file = new FileWriter("Practice.html",true);
			w_file.write(a);
			w_file.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void visit(MDConstruct md){
		
	}

	@Override
	public void visit(Mconvert con) {
		
	}
}