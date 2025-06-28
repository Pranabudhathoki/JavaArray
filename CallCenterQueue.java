import java.util.Scanner;

public class CallCenterQueue {
    private String[] queue;
    private int front, rear, size, capacity;

    public CallCenterQueue(int capacity) {
        this.capacity = capacity;
        queue = new String[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }


    public void addCall(String call) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot add more calls.");
        } else {
            rear = (rear + 1) % capacity;
            queue[rear] = call;
            size++;
            System.out.println("Incoming call: " + call + " added to the queue.");
        }
    }


    public void serveCall() {
        if (isEmpty()) {
            System.out.println("No calls in the queue.");
        } else {
            String call = queue[front];
            front = (front + 1) % capacity;
            size--;
            System.out.println("Serving call: " + call);
        }
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("The call queue is empty.");
        } else {
            System.out.println("Current Call Queue: ");
            for (int i = 0; i < size; i++) {
                System.out.println(queue[(front + i) % capacity]);
            }
        }
    }

    public void displayPendingCalls() {
        System.out.println("Number of pending calls: " + size);
    }


    private boolean isEmpty() {
        return size == 0;
    }


    private boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CallCenterQueue queue = new CallCenterQueue(5); 

        while (true) {
            System.out.println("\nCall Center Queue Management System");
            System.out.println("1. Add an incoming call to the queue");
            System.out.println("2. Serve and handle the next call");
            System.out.println("3. Display the current call queue");
            System.out.println("4. Display the number of pending calls");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  
            
            switch (choice) {
                case 1:
                    System.out.print("Enter the call ID or customer name: ");
                    String call = scanner.nextLine();
                    queue.addCall(call);
                    break;
                case 2:
                    queue.serveCall();
                    break;
                case 3:
                    queue.displayQueue();
                    break;
                case 4:
                    queue.displayPendingCalls();
                    break;
                case 5:
                    System.out.println("Exiting the program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
