
	class LNode
	{
		// reference to the next node in the chain,
		// or null if there isn't one.
		LNode next;
		// data carried by this node.
		// could be of any type you need.
		int value;
		
		LNode(){
			this.next = null;
		}
		
		public LNode(int _data)
		{
			next = null;
			value = _data;
		}
		
		
	}
	public class ReverseSecondHalf
	{
		// reference to the head node.
		private LNode head;
		public static int listCount;
		
		// LinkedList constructor
		public ReverseSecondHalf()
		{
			listCount = 0;			
		}
		
		public void add(int data)
		// post: appends the specified element to the end of this list.
		{
			LNode temp = new LNode(data);
			LNode current = head;
			
			if (head == null)
				head = temp;
			else{
			while(current.next != null)
			{
				current = current.next;
			}			
			current.next = temp;
			}
			listCount++;// increment the number of elements variable
		}

		public boolean remove(int index)
		// post: removes the element at the specified position in this list.
		{
			// if the index is out of range, exit
			if(index < 1 || index > size())
				return false;
			
			LNode current = head;
			for(int i = 1; i < index; i++)
			{
				if(current.next == null)
					return false;
				
				current = current.next;
			}
			current.next = current.next.next;
			listCount--; // decrement the number of elements variable
			return true;
		}
		
		public static int size()
		// post: returns the number of elements in this list.
		{
			return listCount;
		}
		
		public static int middle(LNode n){
			int m = size();
			if (m%2 == 0)
				m = m/2;
			else
				m = ((m+1)/2);

			return m;			
		}
		
		public void print(){
			LNode temp = this.head;
			while(temp.next != null){
				System.out.print(temp.value +"->");
				temp = temp.next;
			}
			System.out.print(temp.value);
			System.out.println();
		}
		
		public static LNode reverse(LNode head){
			LNode temp = head;
//			int count = 0;
			int mid = middle(head);
			Stack1 s1 = new Stack1(size());
			System.out.println("Middle:- " +mid);
			LNode prev = null;
			for (int i = 0; i< size() &&  temp != null; i++){
				{
					if(i<mid){
						prev = temp;
					}
					if (i >= mid){
						s1.push(temp.value);
						prev.next = temp.next;
					}
//					System.out.println("i:-" +i+ " " +temp.value);
					temp = temp.next;					
				}
			}
						
			LNode revTemp = head;	

			System.out.println("Head value:- " + revTemp.value);
			
			while(revTemp.next != null){
				revTemp = revTemp.next;
			}
			System.out.println("Pointr value:- " + revTemp.value);
			
			while (!s1.isEmpty()){

				LNode newNode = new LNode(s1.pop());
				revTemp.next = newNode;
				revTemp = revTemp.next;
			}
			
			return (head);
		}
		
		
		public static void main(String args[]){
			ReverseSecondHalf ln = new ReverseSecondHalf();
			ln.add(10);
			ln.add(20);
			ln.add(7);
			ln.add(18);
			ln.add(34);
			ln.add(190);
			ln.add(44);
			ln.add(89);
			System.out.println("Size:- "+ ReverseSecondHalf.size());
			
			System.out.println("Head:- "+ ln.head.value);
			ln.print();
			ln.head = reverse(ln.head);
			ln.print();
		}
	}
	class Stack1{
		public int[] stackArray;
		public int top;
		Stack1(int n){
			top = -1;
			stackArray = new int[n];
		}
		public void push(int j) {
			System.out.println("Pushing:- " + j);
			   stackArray[++top] = j;
		}
		public int pop() {
			int v = stackArray[top--];
			System.out.println("Poping:- " + v);
			   
			   return v;
		}
		public int peek() {
		      return stackArray[top];
		}
		public boolean isEmpty() {
		      return (top == -1);
		}
	    public boolean isFull() {
	    	  return (top ==  - 1);
		}
	}
