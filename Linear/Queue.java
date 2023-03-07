package Fundamentals;



public class Queue {
    int front, rear, capacity;
    int items[];

    Queue(int size) {
        front= -1;
        rear = -1;
        capacity = size;
        items = new int[size];
    }

    boolean isFull() {
        if( front == 0 && rear == capacity -1) {
            return true;
        }
        else{
            return false;
        }
    }

    boolean isEmpty() {
        if(front == -1) {
            return true;
        } else{
            return false;
        }
    }

    void enQueue(int x) {
        if(isFull()) {
            System.out.println("Queue is full");
            System.exit(1);
        } else{
            if( front == -1){ // if Queue is empty
                front = 0; // make front 0
            }
          rear ++;
          items[rear] = x;
            System.out.println("Inserted: " + x);
        }
    }

    int deQueue() {
        int element;
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else{
            element = items[front];
            if( front >= rear) { // Queue has only one element
                front = -1;
                rear = -1;
            }
            else{
                front++;
            }
            System.out.println("Deleted: " + element);
            return(element);
        }
    }

    void display() {
        /* Function to display elements of Queue */
        int i;
        if (isEmpty()) {
            System.out.println("Empty Queue");
        } else {
            System.out.println("\nFront index-> " + front);
            System.out.println("Items -> ");
            for (i = front; i <= rear; i++)
                System.out.print(items[i] + "  ");

            System.out.println("\nRear index-> " + rear);
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(6);

        // deQueue is not possible on empty queue
        q.deQueue();

        // enQueue 5 elements
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.enQueue(5);

        // 6th element can't be added to because the queue is full
        q.enQueue(6);

        q.display();

        // deQueue removes element entered first i.e. 1
        q.deQueue();

        // Now we have just 4 elements
        q.display();

    }
}
