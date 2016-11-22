package mdconverter;
//Element
public interface MDElement{
	public void accept(MDElementVisitor mdelementVisitor);
}
