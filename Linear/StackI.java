package Linear;
import java.util.Iterator;
import java.util.Stack;

public class StackI {

    public static void main(String[] args) {
        // ********Built-in Stack Class******
        Stack<Integer> s1 = new Stack<>(); // Instance of Stack class
        s1.push(1);
        s1.push(2);
        s1.push(3);
        System.out.println(s1);
        s1.pop();
        System.out.println(s1);
        System.out.println(s1.peek()); // Check the top of Stack
        System.out.println(s1.isEmpty()); //Checking is empty
        System.out.println(s1.search(2)); //Searching

        s1.push(5);
        //how to iterate over a Stack
        Iterator it = s1.iterator();
        while(it.hasNext()) {
            Object s2 = it.next();
            System.out.println(s2);
        }
        System.out.println(s1.size()); // check the size
    }
}
