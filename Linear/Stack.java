package Fundamentals;

public class Stack {
    //We'll be implemented using arrays
    private int arr[], capacity, top;

    Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1; // To declare the stack is empty
    }
    boolean isEmpty() {
        return top == -1;
    }
    boolean isFull() {
        return top == capacity-1;
    }
    void push (int x) {
        if(isFull()) {
            System.out.println("Overflow\nProgram Terminated\n");
            System.exit(1);
        }
        arr[top += 1] = x;
    }

    public int pop() {
        if(isEmpty()) {
            System.out.println("STACK EMPTY");
            System.exit(1);
        }
        System.out.println("Popping: " + arr[top]);
        return arr[top--];
    }

    public int size() {
        System.out.print("Stack size is: ");
        return top+1;
    }

    public int peek() {
        System.out.print("Stack top is: ");
        return arr[top];
    }

    void printStack() {
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Stack st = new Stack(5);
        st.push(1);
        st.push(22);
        st.push(3);
        st.push(10);
        st.push(34);
        st.printStack();
        st.pop();
        System.out.println(st.size());
        System.out.println(st.peek());
        st.printStack();

    }
}
