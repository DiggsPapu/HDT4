package dataStructures;

public class Vector<T> extends Stack<T> {
	private SingleNode<T> head;
	private SingleNode<T> end;
	private int count;
	private int size;
	
	public Vector(int tamanio) {
		size = tamanio;
	}
	
	@Override
	public void push(T value) {
		// TODO Auto-generated method stub
		SingleNode<T> newNode = new SingleNode<T>(value);

        if (IsEmpty())
        {
            head = newNode;
            end = newNode;

            count++;
        }
        else if (count<size){
            end.setNext(newNode);
            end = newNode;

            count++;
        }else {
        	System.out.print("No se pueden ingresar mas valores");
        }

		
	}
		
	

	@Override
	public T pull() {
		if (!IsEmpty()) 
        {

            if (Count() == 1) //Only one node then delete
            {
                SingleNode<T> temp = head;
                head = null;
                end = null;
                count--;
                return temp.getValue();
            }
            else
            {
                SingleNode<T> pretemp = head;
                SingleNode<T> temp = head.getNext();

                //Search the position where the node will be inserted
                while (temp != end)
                {
                    pretemp = temp;
                    temp = temp.getNext();
                }

                //Delete the node
                end = pretemp;
                end.setNext(null);
                count--;
                return temp.getValue();
            }

        }

        return null;
	}
	@Override
	public T peek() {
	    if (!IsEmpty()){
         return end.getValue();
           
        }else {
        	return null;
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
		return Count()==0;
	}
	
public T Get(int index) {
		
	    if (!IsEmpty())
        {
            if (index == 0)
            {
                return head.getValue();
            }
            else if (index == (Count() - 1))
            {
                return end.getValue();
            }
            else if ((index > 0) && (index < (Count() - 1)))
            {
                SingleNode<T> temp = head;
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

}
