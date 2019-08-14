
public class Queue {
	private int capacity;
	int queueArray[];
	int front = 0;
	int rear = -1;
	int currentSize = 0;
	
	public Queue(int queueSize){
		this.capacity = queueSize;
		this.queueArray = new int[this.capacity];
	}
	
	/*
	 * This method add elements to the end of the queue
	 */
	public void enqueue(int item){
		if(queueIsFull()){
			System.out.println("The queue is full of elements");
		} else {
			rear++;
			queueArray[rear] = item;
			currentSize++;
			System.out.println("Element " + item + " is pushed to Queue!");
		}
	}
	
	/*
	 * This method removes an element from the top of the queue
	 */
	public void dequeue(){
		if(isQueueEmpty()){
			System.out.println("Underflow! Unable to remove element from Queue");
		} else{
			front++;
			if(front == capacity-1){
				System.out.println("Pop operation done! removed: " + queueArray[front - 1]);
				front = 0;
			} else {
				System.out.println("Pop operation done! removed: " + queueArray[front -1]);
			}
			currentSize--;
		}
	}
	
	public boolean isQueueEmpty(){
		return currentSize == 0;
	}
	
	public boolean queueIsFull(){
		return (queueArray.length == currentSize);
	}
	
	public static void main(String[] args){
		Queue queue = new Queue(4);
		queue.enqueue(5);
		queue.enqueue(10);
		queue.enqueue(15);
		queue.enqueue(20);
		queue.enqueue(25);
		queue.enqueue(30);
		
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		
	}
}
