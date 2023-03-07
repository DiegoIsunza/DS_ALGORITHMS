package DS;

public class CircularLinkedList {
    Node head, tail; // Two reference variables pointing to beginning and end of Linked List

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    void add(int newData) {
        Node newNode = new Node(newData);
        if(head == null) { //first element
            //If list is empty, both head and tail would point to new node.
            head = newNode;
            tail = newNode;
            newNode.next = head;
        }
        else{ // not first element to be inserted
            //tail will point to new node.
            tail.next = newNode;
            //New node will become new tail.
            tail = newNode;
            //Since, it is circular linked list tail will point to head.
            tail.next = head;
        }
    }

    void display() {
        Node current = head;
        if(head == null) {
            System.out.println("Circular Linked List is empty");
        } else{
            do {
                System.out.print(" " + current.data);
                current = current.next;
            } while (current != head);
            System.out.println();
        }
    }

    void delete() {
        if(tail != head) { // there are more elements
            head= head.next;
            tail.next = head;
        } else{ // there's only one element
            head=tail=null;
        }
    }


    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.add(2);
        cll.add(7);
        cll.add(8);
        cll.display();
        System.out.println("Head: " + cll.head.data +  " Tail: " + cll.tail.data );
        cll.delete();
        cll.display();
        System.out.println("Head: " + cll.head.data +  " Tail: " + cll.tail.data );
    }

}
