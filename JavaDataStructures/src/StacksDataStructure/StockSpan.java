package StacksDataStructure;

import java.util.Scanner;
import java.util.Stack;
public class StockSpan {
	public static int[] TakeArrayInput() {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=s.nextInt();
		}
		return arr;
	}
	public static void printArray(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]+" ");
		}
	}
	public static int[] stockSpan(int[] price) {
		//Your code goes here
		int[] stockSpan = new int[price.length];
		Stack<Integer> span = new Stack<>();
		for(int i=0;i<price.length;i++) {
			if(span.isEmpty()) {
				span.push(1);
				stockSpan[i]=1;
			}else {
				if(price[i]>price[i-1]) {
					int j = i-1;
					int count=1;
					while(j>=0 && price[j]<price[i]) {
						count++;
						j--;
					}
					span.push(count);
					stockSpan[i]=count;
				}else {
					span.push(1);
					stockSpan[i]=1;
				}
			}
		}
		return stockSpan;
	}
	
	public static void main(String[] args) {
		int[] price = TakeArrayInput();
		int[] stock=stockSpan(price);
		printArray(stock);
		
		
	}
}
