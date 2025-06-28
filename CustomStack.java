public class CustomStack {
    private int[] stack;
    private int top;
    private int capacity;

    public CustomStack(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
        top = -1;
    }

    public void push(int val) {
        if (isFull()) {
            throw new RuntimeException("Stack Overflow");
        }
        stack[++top] = val;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }
        return stack[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public static void main(String[] args) {
        CustomStack stack = new CustomStack(3);
        
        System.out.println("Is Empty: " + stack.isEmpty()); 
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        System.out.println("Is Full: " + stack.isFull());   
        System.out.println("Top Element: " + stack.peek()); 
        System.out.println("Popped: " + stack.pop());       
        System.out.println("Top Element: " + stack.peek()); 
        System.out.println("Is Full: " + stack.isFull());   
    }
}
