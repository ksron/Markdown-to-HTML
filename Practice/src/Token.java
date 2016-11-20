public class Token implements MDElement{

	public String generate(){

	String token1 = "Token Practice";
	
	return token1;
	}

	public void accept(MDElementVisitor mdelementVisitor){
		mdelementVisitor.visit(this);
		}

}