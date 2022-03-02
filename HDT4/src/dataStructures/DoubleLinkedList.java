package dataStructures;

public class DoubleLinkedList<T> implements IStack<T>, IList<T> {
	
	private DoubleNode<T> start;
	private DoubleNode<T> end;
	private int count;
	
	/**
	 * Es para inicializar una lista doblemente encadenada vacia.
	 * @category public
	 */
	public DoubleLinkedList() {
		start = null;
		end = null;
		count = 0;
	}
	/**
	 * Es el append inverso
	 * @category append
	 * @param value
	 */
	@Override
	public void InsertAtStart(T value) {
		DoubleNode<T> newNode = new DoubleNode<T>(value);
		
		if (IsEmpty()) {
		
			start = newNode;
			end = newNode;
			start.setNext(start);
			start.setPrevious(start);
		} else {
			
			newNode.setNext(start);
			start.setPrevious(newNode);
			newNode.setPrevious(end);
			end.setNext(newNode);
			start = newNode;
		}
		
		count++;
	}
	/**
	 * Es el append normal
	 * @category append
	 * @param value, newNode
	 */
	@Override
	public void InsertAtEnd(T value) {
		
	DoubleNode<T> newNode = new DoubleNode<T>(value);
		
		if (IsEmpty()) {
		
			start = newNode;
			end = newNode;
			start.setNext(start);
			start.setPrevious(start);
		} else {
			
			newNode.setPrevious(end);
			newNode.setNext(start);
			start.setPrevious(newNode);
			end.setNext(newNode);
			end = newNode;
		}
		
		count++;
		
	}

	@Override
	public void Insert(T value, int index) {
		
		if (IsEmpty()) //if the list is empty then insert at start
        {
            InsertAtStart(value);
        }
        else 
        {
            if (index >= Count()) //if the index is equal or greater than count then insert at end
            {
                InsertAtEnd(value);
            } 
            else if (index == 0) //If the index to insert is 0 and the list is not empty
            {
                InsertAtStart(value);
            }
            else if ((index > 0) && (index < Count())) //Index between 1 (second element) and Count() - 1 previous the last one
            {
                DoubleNode<T> newNode = new DoubleNode<T>(value);
                DoubleNode<T> temp = start;
                int i = 0;

                //Search the position where the node will be inserted
                while ((temp != null) && (i < index)) {
                    temp = temp.getNext();
                    i++;
                }

                //doing the insertion
                newNode.setNext(temp);
                newNode.setPrevious(temp.getPrevious());
                temp.setPrevious(newNode);
                newNode.getPrevious().setNext(newNode);
                count++;
            }
        }
		
	}

	@Override
	public T Delete(int index) {
		// TODO Auto-generated method stub
		if (!IsEmpty()) {
			
			if ((index<=0)) {
				return DeleteAtStart();
				
			} else if (index>=Count()-1) {
				return DeleteAtEnd();
				
				
			} else {
				if (count/2>=index) { //Para empezar en el start
					DoubleNode<T> temp= start;
					int k=0;
					while(k<index) {
						temp = temp.getNext();
						k++;
					}
					temp.getPrevious().setNext(temp.getNext());
					temp.getNext().setPrevious(temp.getPrevious());
					count--;
					return temp.getValue();
				} else { //Para empezar en el end
					DoubleNode<T> temp = end;
					int l=count-1;
					while (l>index) {
						temp=temp.getPrevious();
						l--;
					}
					temp.getPrevious().setNext(temp.getNext());
					temp.getNext().setPrevious(temp.getPrevious());
					count--;
					return temp.getValue();
				}
				
					
			}
			
				
		} else {
			return null;
		}
	}

	@Override
	public T DeleteAtStart() {
		// TODO Auto-generated method stub
		if (IsEmpty()) {
			return null;
		} else if (Count()==1){
			DoubleNode<T> temp = start;
			start = null;
			end = null;
			count--;
			return temp.getValue();
		}else {
			DoubleNode<T> temp=start;
			start=start.getNext();
			start.setPrevious(end);
			end.setNext(start);
			count--;
			return temp.getValue();
		}
		
		
	}

	@Override
	public T DeleteAtEnd() {
		// TODO Auto-generated method stub
		if (IsEmpty()) {
			return null;
		}else if (Count()==1) {
			DoubleNode<T> temp = end;
			end = null;
			start= null;
			count--;
			return temp.getValue();
		}else {
			DoubleNode<T> temp = end;
			end = end.getPrevious();
			start.setPrevious(end);
			end.setNext(start);
			count--;
			return temp.getValue();			
		}
	}

	@Override
	public T Get(int index) {
	    if (!IsEmpty())
        {
            if (index == 0)
            {
                return start.getValue();
            }
            else if (index == (Count() - 1))
            {
                return end.getValue();
            }
            else if ((index > 0) && (index < (Count() - 1)))
            {
                DoubleNode<T> temp = start;
                int i = 0;
                while ((temp != null) && (i != index))
                {
                    temp = temp.getNext();
                    i++;
                }

                if (temp != null)
                {
                    return temp.getValue();
                }
                else
                {
                    return null;
                }
            }
            else
            {
                return null;
            }
        }

        return null;

	}

	@Override
	public boolean IsEmpty() {
		return isEmpty();
	}

	@Override
	public int Count() {
		return count();
	}
	

	@Override
	public T pull() {
		// TODO Auto-generated method stub
		return DeleteAtStart();
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return start.getValue();
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return count==0;
	}
	@Override
	public void push(T value) {
		// TODO Auto-generated method stub
		InsertAtStart(value);
	}


}
