package dataStructures;

public class ArrayList <T> implements IStack<T> {

	private SingleNode<T> head;
	private int count;
	public SingleNode<T> getHead() {
		return head;
	}
	public void setHead(SingleNode<T> head) {
		this.head = head;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public ArrayList() {
		head=null;
	}
	@Override
	public void push(T value) {
		// TODO Auto-generated method stub
		SingleNode<T> newNode = new SingleNode<T>(value);
		if (IsEmpty()) {
			head=newNode;
		}
		else {
			newNode.setNext(newNode);
			head=newNode;
		}
		count++;
	}

	@Override
	public T pull() {
		// TODO Auto-generated method stub
		if (Count() == 0) {
			return null;
		} else if (count==1) {
			SingleNode<T> temp=head;
			head=null;
			count--;
			return temp.getValue();
		}else {
			SingleNode<T> temp = head;
			head = temp.getNext();
			count--;
			return temp.getValue();
		}
		
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		if (IsEmpty()) {
			return null;
		} else {
			return head.getValue();
		}
	}

	@Override
	public int Count() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public boolean IsEmpty() {
		// TODO Auto-generated method stub
		return (head == null);
	}

}
