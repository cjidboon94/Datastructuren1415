import java.util.*
import java.lang.*

public class QueueTimer {

	private Queue<Integer> queue;

	public void addElement(int elem) {
		queue.add(elem);
	}

	public void removeElement {
		try {
			queue.remove();
		} 
		catch (java.util.NoSuchElementException) {
		}
	}

	public int getSize {

		return queue.size();

	}

	public boolean isEmpty {

		return queue.isEmpty();
	}

}