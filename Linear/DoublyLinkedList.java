package DS;

public class DoublyLinkedList {
    Node head;
    Node tail;

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    public void addNode(int newData) {
        Node newNode = new Node(newData);

        if(head == null ) {
            head = tail = newNode; // Since there is only one node we make both head tail same node
            head.prev = null;  // head prev will point to null
            tail.next =null; // tail next will point to null since we are yet to add more Nodes
        } else{
            tail.next = newNode;  //newNode will be added after tail such that tail's next will point to newNode
            newNode.prev = tail;  //newNode's previous will point to tail
            tail = newNode;    //newNode will become new tail
            tail.next = null;  //As it is last node, tail's next will point to null
        }
    }

    void display() {
        Node current = head;

        while(current != null) {
            System.out.print(current.value + "-> ");
            current = current.next;
        }
        System.out.println();
    }

    void displayPrev() {
        Node current = tail;

        while(current != null) {
            System.out.print(current.value + "-> ");
            current = current.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.addNode(5);
        dll.addNode(10);
        dll.addNode(15);
        dll.addNode(20);
        dll.addNode(25);
        System.out.println("Display Next");
        dll.display();
        System.out.println("Display Prev");
        dll.displayPrev();
    }
}
