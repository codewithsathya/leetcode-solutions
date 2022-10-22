import java.util.LinkedList;
import java.util.PriorityQueue;

class MinStack {
	LinkedList<Integer> ll = new LinkedList<>();
	PriorityQueue<Integer> pq = new PriorityQueue<>();

	public MinStack() {
			
	}
	
	public void push(int val) {
		ll.add(val);
		pq.add(val);
	}
	
	public void pop() {
		int num = ll.removeLast();
		pq.remove(num);
	}
	
	public int top() {
		return ll.getLast();
	}
	
	public int getMin() {
		// Iterator<Integer> it = ll.iterator();
		// int min = it.next();
		// while(it.hasNext()){
		// 	int num = it.next();
		// 	if(num < min){
		// 		min = num;
		// 	}
		// }
		// return min;
		return pq.peek();
	}
}