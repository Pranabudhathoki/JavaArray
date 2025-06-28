public class Stack {
    private int[] stack;
    private int top;
    private int capacity;

    public Stack(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
        top = -1;
    }

    public void push(int element) {
        if (top == capacity - 1) {
            throw new RuntimeException("Stack overflow");
        }
        stack[++top] = element;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        return stack[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        System.out.println("Popped: " + stack.pop());    // Output: 30
        System.out.println("Top Element: " + stack.peek()); // Output: 20
        System.out.println("Current Size: " + stack.size()); // Output: 2
        System.out.println("Is Empty: " + stack.isEmpty()); // Output: false
    }
}
