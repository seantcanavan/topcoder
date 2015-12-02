import java.util.ArrayList;

public class CircularArrayList<E> extends ArrayList<E> {
	
	private static final long serialVersionUID = -8110817601137585983L;
	private int index = -1;
	
	public E getNext()
	{
		index++;
		if(index >= super.size())
			index = 0;
		return super.get(index);
	}
}
