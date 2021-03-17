
public class ArrayQueue implements MyQueue {
	private Integer[] queue;
	private int head;
	private int tail;
	private int count;
	
	private static final int QUEUE_SIZE = 32;
	
	public ArrayQueue() {
		queue = new Integer[32];
		count = head = tail = 0;
	}
	
	public boolean add(Integer data) {
		if (isFull()) {
			return false;
		}
		
		queue[tail++] = data;
		if (tail == QUEUE_SIZE) {
			tail = 0;
		}
		count++;
		return true;
	}
	
	public Integer remove() {
		if (isEmpty() ) {
			return null;
		}
		Integer rtn = queue[head++];
		if (head == QUEUE_SIZE) {
			head = 0;
		}
		
		count--;
		
		if (count == 0) {
			head = tail = 0;
		}
		return rtn;
	}
	
	public int size() {
		return count;
	}
	
	public Integer peek() {
		if (isEmpty()) {
			return null;
		}
		
		return queue[head];
	}
	
	public void clear() {
		count = head = tail = 0;
		queue = new Integer[32];

	}
	
	public boolean isFull() {
		return (count == QUEUE_SIZE);
	}
	
	public boolean isEmpty() {
		return (count == 0);
	}
	
	public String toString() {
		String rtn = "";
		rtn += "Queue count: " + count + "\n";
		rtn += "Queue head : " + head + "\n";
		rtn += "Queue tail : " + tail + "\n\n";
		
		if (isEmpty()) {
			rtn +=  "<Empty>";
			return rtn;
		}

		int tmpIndex = head;
		for (int i = 0; i < count; i++) {
			
			if (tmpIndex == head) {
				rtn += "head -> ";
			} else {
				rtn += "        ";
			}
			rtn += queue[tmpIndex++] + "\n";
			if (tmpIndex == QUEUE_SIZE) {
				tmpIndex = 0;
			}
		}
		return rtn;
	}
}
