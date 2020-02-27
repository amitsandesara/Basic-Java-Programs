public class StackSort {
   private int maxSize;
   private int[] stackArray;
   private int top;

   public StackSort(int s) {
      maxSize = s;
      stackArray = new int[maxSize];
      top = -1;
   }

   public void push(int j) {
      stackArray[++top] = j;
   }

   public int pop() {
      return stackArray[top--];
   }

   public int peek() {
      return stackArray[top];
   }

   public boolean isEmpty() {
      return (top == -1);
   }

   public boolean isFull() {
      return (top == maxSize - 1);
   }

   private static void SortStack(int elem, StackSort a, StackSort b) {
      if (b.isEmpty() || elem > b.peek())
         b.push(elem);
      else {
         a.push(b.pop());
         SortStack(elem, a, b);
      }
   }

   public static void main(String[] args) {
      StackSort theStack = new StackSort(15);
      StackSort sortedStack = new StackSort(15);
      int arr[] = {10, 5, 12, -4, 45, 22, 34, -2, 25};
      int elem;
      for (Integer i : arr)
         theStack.push(i);
      while (!theStack.isEmpty()) {
         elem = theStack.pop();
         SortStack(elem, theStack, sortedStack);
      }

      System.out.print("Sorted Stack in descending order:- ");
      while (!sortedStack.isEmpty()) {
         int n = sortedStack.pop();
         System.out.print(n + " ");
         theStack.push(n);
      }
      System.out.print("\nSorted Stack in ascending order:- ");
      while (!theStack.isEmpty()) {
         System.out.print(theStack.pop() + " ");
      }
      System.out.println("");
   }
}
