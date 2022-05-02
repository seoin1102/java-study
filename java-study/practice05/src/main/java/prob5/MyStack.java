package prob5;

public class MyStack {
	private int top = 0;
	private String[] buffer;
	
	public MyStack(int size) {
		buffer = new String [size];
	}
	
	public void push(String item) {
		if(top == buffer.length) {
			String[] temp = buffer;
			buffer = new String [buffer.length*2];
			for(int i = 0; i<temp.length; i++) {
				buffer[i]  = temp[i];
			}
		}
		buffer[top] = item;
		top ++;
	}
	
	public String pop() throws MyStackException{
		if(top <0 ) {
			throw new MyStackException();
		}
		
		if(buffer[top] == null) {
			top --;
		}

		String item = buffer[top];
		buffer[top] = null ;
		top --;
		return item;
	}
	
	public boolean isEmpty() {
		if(top < 0)
			return true;
		else
			return false;	
	}
}
