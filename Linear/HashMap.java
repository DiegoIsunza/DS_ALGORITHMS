package DS;

public class HashMap<T> {
    private HashNode[] buckets;
    private int numOfBuckets; // capacity
    private int size; // # of key-value pairs

    public HashMap() {this(10);} // if not specified

    public HashMap(int capacity) {
        this.numOfBuckets = capacity;
        this.buckets = new HashNode[numOfBuckets];
        this.size=0;
    }

    public class HashNode<T> {
        private Integer key;
        private T value;
        private HashNode next; // ref to next hashnode

        public HashNode(Integer key, T value) {
            this.key = key;
            this.value = value;
            next = null;
        }
    }

    public int size() { return size;}

    public boolean isEmpty() { return size == 0;}

    private int getBucketIndex(Integer key) { return key % numOfBuckets;}

    public void put(Integer key, T value) {

        if(key == null || value == null) {
            throw new IllegalArgumentException("The key or the value is a null");
        }

        int bucketIndex = getBucketIndex(key); // get index
        HashNode head = buckets[bucketIndex]; // get the index value or ll structure

        while(head != null) { // Linked List loop
            if(head.key.equals( key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size ++; // new element in the HashMap

        head = buckets[bucketIndex];
        HashNode node = new HashNode(key, value);
        node.next = head;
        buckets[bucketIndex] = node;

    }

    public String remove(Integer key)
    {
        if(key == null) {
            throw new IllegalArgumentException("Key is null");
        }

        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        HashNode previous = null;

        while(head != null)
        {
            if(head.key.equals(key))
            {
                break;
            }
            previous = head;
            head = head.next;
        }
        if(head == null)
        {
            return null;
        }
        size--;
        if(previous!=null)
        {
            previous.next = head.next;
        } else{
            buckets[bucketIndex] = head.next;
        }
        return head.value + " was removed from the HashTable";
    }

    public T get(Integer key) {
        if(key == null) {
            throw new IllegalArgumentException("Key is null");
        }
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];

        while( head != null) {
            if(head.key.equals(key)) {
                return (T) head.value;
            }
            head = head.next;
        }

        return null;
    }

    public static void main(String[] args) {
        HashMap m = new HashMap(5);

        m.put(1,'A');
        m.put(2,'B');
        m.put(3,'C');
        m.put(4,'D');
        m.put(5,'E');

        System.out.println(m.get(1));


    }
}
