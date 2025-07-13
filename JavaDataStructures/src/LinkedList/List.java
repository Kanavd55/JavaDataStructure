package LinkedList;
import java.util.ArrayList;

public class List {
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(10);
		arr.add(20);
		arr.add(30);
		arr.set(1, 15);
		arr.add(1, 50);
		System.out.println(arr.size());
		System.out.println(arr.get(0));
		System.out.println(arr.get(1));
		System.out.println(arr.get(2));
		System.out.println(arr.get(3));
		arr.remove(1);
		System.out.println(arr.size());
	}
}
