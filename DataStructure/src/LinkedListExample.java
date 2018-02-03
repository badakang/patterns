
public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList numbers = new LinkedList();
        // numbers.addFirst(30);
        // numbers.addFirst(20);
        // numbers.addFirst(10);

        numbers.addLast(10);
        numbers.addLast(20);
        numbers.addLast(30);
        numbers.add(2, 25);

        System.out.println(numbers.node(0));
        System.out.println(numbers);
        numbers.removeFirst();
        System.out.println(numbers);
        System.out.println(numbers.remove(2));

    }
}

class LinkedList {
    private Node head;
    private Node tail;
    private int size = 0;

    public Object get(int k) {
        Node temp = node(k);
        return temp.data;
    }
    
    public int size(){
        return size;
    }
    public Object removeLast() {
        return remove(size - 1);
    }

    public Object remove(int k) {
        if (k == 0) {
            return removeFirst();
        }
        Node temp = node(k - 1);
        Node todoDeleted = temp.next;
        temp.next = temp.next.next;
        Object returnData = todoDeleted.data;
        if (todoDeleted == tail) {
            tail = temp;
        }
        todoDeleted = null;
        size--;
        return returnData;

    }

    public Object removeFirst() {
        Node temp = head;
        head = head.next;
        Object returnData = temp.data;
        temp = null;
        size--;
        return returnData;
    }

    public void add(int k, Object input) {
        if (k == 0) {
            addFirst(input);
        } else {
            Node temp1 = node(k - 1);
            Node temp2 = temp1.next;
            Node newNode = new Node(input);
            temp1.next = newNode;
            newNode.next = temp2;
            size++;
            if (newNode.next == null) {
                tail = newNode;
            }
        }
    }

    public Node node(int index) {
        Node x = head;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    public void addLast(Object input) {
        Node newNode = new Node(input);
        if (size == 0) {
            addFirst(input);
        } else {
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    public void addFirst(Object input) {
        Node newNode = new Node(input);
        newNode.next = head;
        head = newNode;
        size++;
        if (head.next == null) {
            tail = head;
        }
    }

    private class Node {
        private Object data;
        private Node next;

        public Node(Object input) {
            this.data = input;
            this.next = null;
        }

        public String toString() {
            return String.valueOf(this.data);
        }

    }

    public String toString() {
        if (head == null) {
            return "[]";
        }
        Node temp = head;
        String str = "[";
        while (temp.next != null) {
            str += temp.data + ",";
            temp = temp.next;
        }
        str += temp.data;
        return str + "]";
    }

}