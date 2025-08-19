//Problem statement
//You want to buy a ticket for a well-known concert which is happening in your city. But the number of tickets available is limited. Hence the sponsors of the concert decided to sell tickets to customers based on some priority.
//
//A queue is maintained for buying the tickets and every person is attached with a priority (an integer, 1 being the lowest priority).
//
//The tickets are sold in the following manner -
//
//1. The first person (pi) in the queue requests for the ticket.
//2. If there is another person present in the queue who has higher priority than pi, then ask pi to move at end of the queue without giving him the ticket.
//3. Otherwise, give him the ticket (and don't make him stand in queue again).
//Giving a ticket to a person takes exactly 1 second and it takes no time for removing and adding a person to the queue. And you can assume that no new person joins the queue.
//
//Given a list of priorities of N persons standing in the queue and the index of your priority (indexing starts from 0). Find and return the time it will take until you get the ticket.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//Time Limit: 1 sec
//Sample Input 1 :
//3
//3 9 4
//2
//Sample Output 1 :
//2
//Sample Output 1 Explanation :
//Person with priority 3 comes out. But there is a person with higher priority than him. So he goes and then stands in the queue at the end. Queue's status :  {9, 4, 3}. Time : 0 secs.
//Next, the person with priority 9 comes out. And there is no person with higher priority than him. So he'll get the ticket. Queue's status :  {4, 3}. Time : 1 secs.
//Next, the person with priority 4 comes out (which is you). And there is no person with higher priority than you. So you'll get the ticket. Time : 2 secs.
//Sample Input 2 :
//5
//2 3 2 2 4
//3
//Sample Output 2 :
//4

package PriorityQueue;

import java.util.Scanner;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.Collections;

public class BuyTheTicket {
	
	public static int buyTicket(int input[], int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		Queue<Integer> queue = new LinkedList<>();
		int Time = 0;
		for(int i =0;i<input.length;i++) {
			queue.add(i);
			maxHeap.add(input[i]);
		}
		while(!maxHeap.isEmpty()) {
			int maxPr = maxHeap.peek();
			int queueIndex = queue.poll();
			if(queueIndex==k && maxPr==input[queueIndex]) {
				Time++;
				maxHeap.poll();
				return Time;
			}
			while(maxPr!=input[queueIndex]) {
				queue.add(queueIndex);
				queueIndex=queue.poll();
			}
			if(maxPr==input[queueIndex]) {
				Time++;
				maxHeap.poll();
			}
		}
		return Time;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] input = new int[n];
		for(int i = 0;i<n;i++) {
			input[i]=s.nextInt();
		}
		int k = s.nextInt();
		System.out.println(buyTicket(input,k));
	}
}
