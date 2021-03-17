public class LinkedQueue implements MyQueue {
	private Node head = null;
	private Node tail = null;
	private int count;
	
	public boolean add(Integer data) {
		Node nn = new Node();
		nn.setData(data);
		
		// If the queue was empty it now contains 1 element, both head and tail should
		// refer to it.
		if (count == 0) {
			head = tail = nn;
			count = 1;
			return true;
		}
		
		tail.setNext(nn);
		tail = nn;
		count++;
		
		return true;
	}

	public Integer remove() {
		if (isEmpty()) {
			return null;
		}
		
		Integer rtn = head.getData();
		head = head.getNext();
		count--;
		
		// If we removed the last thing in the queue
		if (count == 0) {
			tail = null;
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
		
		// TODO Auto-generated method stub
		return head.getData();
	}

	public void clear() {
		head = tail = null;
		count = 0;
		
	}

	public boolean isFull() {
		return false;
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

		Node tmp = head;
		for (int i = 0; i < count; i++) {
			
			if (tmp == head) {
				rtn += "head -> ";
			} else {
				rtn += "        ";
			}
			rtn += tmp.getData() + "\n";
			
			tmp = tmp.getNext();
		}
		return rtn;
	}


}
