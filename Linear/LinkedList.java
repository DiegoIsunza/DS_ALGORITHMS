package Fundamentals;

public class LinkedList<T> {
    Node head; // null

    public class Node<T> {
        T data;
        Node next;

        Node(T x) {
            data = x;
            next = null;
        }
    }

    public void insertAtBeginning(T newData) {
        Node newNode = new Node(newData); // create new node
        newNode.next= head; // make the new node point to the current head
        head = newNode; //now head will point to new node
    }

    public void insertAtEnd(T newData) {
        Node newNode = new Node(newData);

        if(head == null) {
            head = new Node(newData);
            return;
        }

            Node last = head;

            while(last.next != null) {
                last = last.next;
            }
            last.next = newNode; // Make the previous last element point to the new last element
            return;
    }

    public void insertAfter(Node prevNode, T newData) {
        if(prevNode == null) {
            System.out.println("Previous node cannot be null");
            return;
        }
        Node newNode = new Node(newData);

        newNode.next = prevNode.next;
        prevNode.next =  newNode;
    }

    public void remove(int position) {
        if(head == null)
        {
            System.out.println("Linked List is empty");
        }

        Node temp = head;

        if (position == 0) // if it's the first node
        {
            head = temp.next; // skip to first.next
            return;
        }
        //find key to be deleted
        for(int i = 0; temp !=null && i <position-1; i++)
        {
            temp = temp.next;
        }

        //If key not present
        if(temp == null || temp.next == null)
        {
            return;
        }

        //Remove the node
        Node next = temp.next.next;
        temp.next = next;
    }

    public boolean search(Node head, T key) {
        Node current = head;

        while(current != null) {
            if(current.data == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void printList() {
        Node current = head;

        while(current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.insertAtBeginning(1);
        ll.insertAtEnd(2);
        ll.insertAtEnd(4);
        ll.insertAfter(ll.head.next,3);
        ll.insertAtEnd(5);
        ll.printList();
        System.out.println(ll.search(ll.head, 4 ));
        ll.remove(4);
        ll.printList();
    }
}
