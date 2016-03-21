import java.util.*;
public class Stack {
	private int maxSize;
	private char[] stackArray;
	   
	   private int top;
	   public Stack(int s) {
	      maxSize = s;
	      stackArray = new char[maxSize];
	      top = -1;
	   }
	   public void push(char j) {
//		   System.out.println("Adding:- "+ j);   
		   stackArray[++top] = j;
	   }
	   public char pop() {
//		   System.out.print("Poping:- ");   
		   return stackArray[top--];
	   }
	   public long peek() {
	      return stackArray[top];
	   }
	   public boolean isEmpty() {
	      return (top == -1);
	   }
	   public boolean isFull() {
	      return (top == maxSize - 1);
	   }
	   public static void main(String[] args) {
		   Scanner sc = new Scanner(System.in);
		   System.out.println("Enter Brackets: ");
		   String ip = sc.next();
		   sc.close();
		   Boolean flag = true;
		   Stack theStack = new Stack(ip.length()); 
		   for (int i = 0; i < ip.length(); i++){
			   if (ip.charAt(i) == '(')
				   theStack.push('(');
			   else if (ip.charAt(i) == ')'){
				   if (!theStack.isEmpty()){
					   theStack.pop();
				   }
				   else{
					   flag = false;
					   break;
				   }				   
			   }
		   }
		   if (flag == true && theStack.isEmpty())
			   System.out.println("Valid Paranthesis");
		   else{
			   System.out.println("Not a valid paranthesis");
		   }

		   
		   System.out.println("");
	   }
	}

