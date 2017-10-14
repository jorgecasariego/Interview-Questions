
public class MyStack {
	private int stackSize;
	private int[] stackArray;
	private int top;
	
	// Constructor
	public MyStack(int size){
		this.stackSize = size;
		this.stackArray = new int[stackSize];
		this.top = -1;
	}
	
	/*
	 * This method adds element to the top of the stack
	 */
	public void push(int entry) throws Exception {
		if(isStackFull()){
			throw new Exception("Stack is already full. Can not add elements.");
		}
		
		System.out.println("Adding :" + entry);
		stackArray[++top] = entry;
	}
	
	/*
	 * This method remove an element from the top of the stack
	 */
	public int pop() throws Exception{
		if(isStackEmpty()){
			throw new Exception("Stack is empty. Can not remove element.");
		}
		
		int entry = stackArray[top--];
		System.out.println("Element remove: " + entry);
		return entry;
	}
	
	/*
	 * This method return top of the stack without removing it
	 */
	public int peek(){
		return stackArray[top];
	}
	
	public boolean isStackEmpty(){
		return (top == -1);
	}
	
	public boolean isStackFull(){
		return (top == stackSize - 1);
	}
	
	public static void main(String[] args) {
		MyStack stack = new MyStack(10);
		try {
			stack.push(10);
			stack.push(5);
			stack.push(3);
			stack.push(40);
			stack.push(53);
			stack.push(32);
			stack.push(14);
			stack.push(85);
			stack.push(3);
			stack.push(40);
			stack.push(15);
			stack.push(33);
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		System.out.println("Peek: " + stack.peek());
		
		try{
			for(int i=0; i<stack.stackSize; i++){
				stack.pop();
			}
			stack.pop();
			
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
	}

}
