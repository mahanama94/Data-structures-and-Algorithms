//140381E	
//140381E
//R.B. Mahanama
//CS 2022 - Lab 2

/*
*	 CLASS Node
*/

class Node <E>{
	
	private E  element;
	private Node<E> next;

	
	public void setElement(E element) {
		this.element = element;
	}

	public E getElement() {
		return element;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}

	public Node<E> getNext() {
		return next;
	}
}

/*
*	CLASS CS2022LinkedList
*/
class CS2022LinkedList <E> {

	private Node<E> head;
	private int length;
	
	//initialize the list object to an empty list
	public void init_list(){ 
		setHead(null);
		this.length = 0;
	}
	
	//check and see if the list is empty
	//true - if empty, false - otherwise
	public boolean is_empty(){
		return (length == 0);
		
	}
	
	//return the first node object which contains the search item if it is present in the list
	//If not present returns null
	public Node<E> search(E element){
		Node<E> current = head;
		while(current != null){
			if( current.getElement() == element){
				return current;
			}
			else{
				current = current.getNext();
			}
		}
		return null;
	}
	
	//remove the first instance of the item from the list if the item is present in the list at least once
	//if not present returns null
	public E delete(E element){
		
		Node<E> current = head;
		
		//item found at the begining of the list
		if(current.getElement() == element){
			head = current.getNext();
			return current.getElement();
		}
		
		//item not at the begining
		else{	
			Node<E> previous = current;
			current = current.getNext();
			while(current!= null){

				//item found 
				if( current.getElement() == element){
					previous.setNext(current.getNext());
					return current.getElement();
				}

				//item not found - move next
				else{
					previous = current;
					current = current.getNext();
				}
			}
			//not found - return
			return null;
		}
	}
	
	
	//node in the i th location of the list and return the item that is removed
	//indexing starts from 1.
	//If the specified position is higher than the actual amount of items in the list,returns null
	public E deleteNodeAt(int i){
		
		// given position > length
		if(i> length){
            return null;
        }

        else{
            Node<E> current = head;
            Node<E> previous = head;

			//loopin for i th location
			for( int j =1; j < i; j++){
                previous = current;
                current = current.getNext();
            }

			//delete
            previous.setNext(current.getNext());
            this.decrementLength();
            return current.getElement();
        }
	}
	
	
	//places element at the end of the list and return whether insert was successful or not
	//successful - true, otherwise - false
	public boolean insert(E element){
			try{
			//list is empty
			if (is_empty()){
				Node<E> temp = new Node<E>();
				temp.setElement(element);
				setHead(temp);
				incrementLength();
				return true;
				
			}

			else{
				Node<E> current = head;
				
				//go to the end of list
				while(current.getNext()!= null){
					current = current.getNext();
				}

				//insert node
				Node<E> temp = new Node<E>();
				temp.setElement(element);
				temp.setNext(current.getNext());
				current.setNext(temp);
				incrementLength();
				return true;
			}
		}
		catch(Exception e){
			return false;
		}
	}
	
	//lace element in the ith location of the list and return whether insert was successful or not
	//successful - true, otherwise - false
	//If specified location i is higher than actual number of elements in the list, the item will be added to the end of the list.
	public boolean insertAt(E element, int i){
		
		try{
			//given position > length
			if(i>length){
				return insert(element);
			}

			else{
				Node<E> current = head;
				//go to i th position
				for(int j = 1; j < i-1; j++){
					current = current.getNext();
				}
				
				//insert node
				Node<E> temp = new Node<E>();
				temp.setElement(element);
				temp.setNext(current.getNext());
				current.setNext(temp);
				return true;
			}
		}
		catch (Exception e){
			return false;
		}
	}

	//sets head of Linked list
	public void setHead(Node<E> head) {
		this.head = head;
	}

	//returns head
	public Node<E> getHead() {
		return head;
	}

	
	public void incrementLength() {
		this.length++;
	}
	
	public void decrementLength() {
		this.length--;
	}

	public int getLength() {
		return length;
	}
	
	//prints the linked list
	public void show(){
        
		Node<E> current = head;
		System.out.print("head ");
    
		while(current!= null){
            System.out.print(" -> "+current.getElement());
            current = current.getNext();
        }
		System.out.print("\n");
    }

}

/*
*	CLASS Main
*/
class Main{

   
    public static void main(String[] args) {
        
		//create a link list
        CS2022LinkedList<Integer> myList = new CS2022LinkedList<Integer>();
        myList.init_list();
		
        //check whether the link list is empty
        
        if(myList.is_empty()){
            System.out.println("List is Empty");
        }
        else{
            
            System.out.println("List is not Empty");
        }
        
		
        //add 5 nodes to link list
        
        myList.insert(5);
        myList.insert(10);
        myList.insert(15);
        myList.insert(20);
        myList.insert(25);
        
        myList.show();
        
        //check whether the link list is empty
        
         if(myList.is_empty()){
            System.out.println("List is Empty");
        }
        else{
            
            System.out.println("List not is Empty");
        }
         
        //print the length of the link list
         
         System.out.println("Length of list :"+ myList.getLength());
         
        //delete two elements from the link list
        
        System.out.println("Deleting 4th node");
		myList.deleteNodeAt(4);
        myList.show();
         
        System.out.println("Deleting 15 ");
		myList.delete(15);
        myList.show();
        
		
		//search link list for an existing elements
         
        System.out.println("Searching for 25");
		
		if( myList.search(25)!= null){
			System.out.println("25 found in Linked List");
		}
		else{
			System.out.println("25 not found in Linked List");
		}
		
		//search link list for a deleted element
		
		System.out.println("Searching for 15");
		
		if( myList.search(15)!= null){
			System.out.println("15 found in Linked List");
		}
		else{
			System.out.println("15 not found in Linked List");
		}
		
        
		//use insertAt() to insert a new element between 2nd and 3rd elements of list
         
		System.out.println("insert 100 between 2nd and 3rd ");
		myList.insertAt(100, 3);
        myList.show();

    }
    
}
