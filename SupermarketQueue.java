import java.util.Scanner;

public class SupermarketQueue {
    private String[] queue;
    private int front, rear, size, capacity;

    public SupermarketQueue(int capacity) {
        this.capacity = capacity;
        queue = new String[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }


    public void addCustomer(String customer) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot add more customers.");
        } else {
            rear = (rear + 1) % capacity;
            queue[rear] = customer;
            size++;
            System.out.println(customer + " has joined the queue.");
        }
    }


    public void serveCustomer() {
        if (isEmpty()) {
            System.out.println("No customers in the queue.");
        } else {
            String servedCustomer = queue[front];
            front = (front + 1) % capacity;
            size--;
            System.out.println(servedCustomer + " has been served.");
        }
    }


    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("The queue is empty.");
        } else {
            System.out.println("Current queue: ");
            for (int i = 0; i < size; i++) {
                System.out.println(queue[(front + i) % capacity]);
            }
        }
    }

    public void displayQueueSize() {
        System.out.println("Number of customers in the queue: " + size);
    }

    private boolean isEmpty() {
        return size == 0;
    }

   
    private boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SupermarketQueue queue = new SupermarketQueue(5); 

        while (true) {
            System.out.println("\nSupermarket Queue Management System");
            System.out.println("1. Add a customer to the queue");
            System.out.println("2. Serve the next customer");
            System.out.println("3. Display the current queue");
            System.out.println("4. Display the number of customers in the queue");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  
            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the customer: ");
                    String customer = scanner.nextLine();
                    queue.addCustomer(customer);
                    break;
                case 2:
                    queue.serveCustomer();
                    break;
                case 3:
                    queue.displayQueue();
                    break;
                case 4:
                    queue.displayQueueSize();
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
