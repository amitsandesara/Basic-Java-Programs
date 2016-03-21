import java.util.*;
public class DupsInArray {
	public static void main(String args[]){
		
		int arr[] = {10, 32, 13, 32, 45, 56, 56, 75, 332, 45, 10, 32, 13, 32, 45, 56, 56, 75, 332, 45, 10, 32, 13, 32, 45, 56, 56, 75, 332, 45, 10, 32, 13, 32, 45, 56, 56, 75, 332, 45};
		long startTime = System.nanoTime();
		HashSet<Integer> s = new HashSet<Integer>();
		
		for (int i = 0; i < arr.length; i++){
			s.add(arr[i]);
		}
		
		System.out.println(s.size());
		System.out.println(s);
		
		
		//code
		long endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime)/1000+ " ms"); 
	}
	
}
