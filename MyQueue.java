
public interface MyQueue {

	boolean add(Integer data);

	Integer remove();

	int size();

	Integer peek();

	void clear();

	boolean isFull();

	boolean isEmpty();

}