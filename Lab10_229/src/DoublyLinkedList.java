public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;
    
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public void add(Object value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }
    
    public Object[] toArray() {
        Object[] arr = new Object[size];
        Node current = head;
        int i = 0;
        while (current != null) {
            arr[i] = current.value;
            current = current.next;
            i++;
        }
        return arr;
    }
    
    public int indexOf(Object value) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.value.equals(value)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }
    
    public int sumOfLastMElements(int m) {
        if (m <= 0 || m > size) {
            throw new IllegalArgumentException();
        }
        int sum = 0;
        Node current = tail;
        for (int i = 0; i < m; i++) {
            sum += (int) current.value;
            current = current.prev;
        }
        return sum;
    }
}
