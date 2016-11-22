package mdconverter;

public class Mconvert implements MDElement{

	String a;
	
	public Mconvert(){
		
	}

	public Mconvert(String convert) {
		// TODO Auto-generated constructor stub
		a=convert;
		System.out.println("In convert"+a);
	}
	
	public String generate(){
		return a;
	}

	public void accept(MDElementVisitor visitor){
		visitor.visit(this);
	}
}
