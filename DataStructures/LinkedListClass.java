class LinkedList<E>{
    
    //Initializing Node
    class Node<T> {
        T data;
        Node<T> next;

        public Node(T obj) {
            data = obj;
            next = null;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int currentSize;

    public LinkedList() {
        head = null;
        currentSize = 0;
    }

    //Adding at the Front
    public void addFirst(E obj) {
        Node<E> node = new Node<E>(obj);

        node.next = head;
        head = node;

        currentSize++;
    }

    //Adding at the Last
    public void addLast(E obj) {
        Node<E> node = new Node<E>(obj);

        if(head == null) {
            head = tail = node;
            currentSize++;

            return;
        }

        //The below code give us the complexity of O(1)
        tail.next = node;
        tail = node;
        currentSize++;
    }

    //Remove from Front
    public E removeFirst() {
        if(head == null)
            return null;
        
            E temp = head.data;

            if(head == tail) {
                head = tail = null;
            } else {
                head = head.next;
            }

            currentSize--;

            return temp;
    }

    //Remove from Last
    public E removeLast() {
        if(head == null) 
            return null;
        
        if(head == tail)
            return removeFirst();
        
            Node<E> current = head;
            Node<E> previous = null;

            while(current != tail) {
                previous = current;
                current = current.next;
            }

            previous.next = null;
            tail = previous;

            currentSize--;

            return current.data;
    }

    //Remove some object
    public E remove(E obj) {
        Node<E> current = head; 
        Node<E> previous = null;

        while(current != null) {
            if(obj.equals(current.data)) {
                if(head == current)
                    return removeFirst();
                
                if(current == tail)
                    return removeLast();
                
                currentSize--;

                previous.next = current.next;

                return current.data;
            }
            previous = current;
            current = current.next;

        }
        return null;
    }

    //To look for an Element in the List
    public boolean contains(E obj) {
        Node<E> current = head;

        while(current != null) {
            if(obj.equals(current.data)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    //To Peek at head
    public E peekFirst() {
        if(head == null) {
            return null;
        }

        return head.data;
    }

    //To Peek at tail
    public E peekLast() {
        if(tail == null) {
            return null;
        }

        return tail.data;
    }
}

public class LinkedListClass {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();

        int n = 10;
        
        System.out.println("\nAdding and Removing from Start");
        for(int i = 0; i < n; i++) {
            list.addFirst(i);
            System.out.println("Object Added: " + i);
        }

        for(int i = n-1; i >= 0; i--) {
            int x = list.removeFirst();

            System.out.println("Removed x is: " + x);
        }

        System.out.println("\nAdding and Removing from Last");
        for(int i = 0; i < n; i++) {
            list.addLast(i);
            System.out.println("Object Added: " + i);
        }

        for(int i = n-1; i >= 0; i--) {
            int x = list.removeLast();

            System.out.println("Removed x is: " + x);
        }

        System.out.println("\nInitializing List with 0 - 9");
        for(int i = 0; i < n; i++) {
            list.addFirst(i);
            System.out.println("Value Added: " + i);
        }

        System.out.println("Removing value 7");
        int r = list.remove(7);
        System.out.println("Removed Value: " + r);

        System.out.println("\nCheck if Value still exist");

        if(list.contains(r))
            System.out.println(r + " is in the list");
        else
            System.out.println(r + " is not in the list");

        System.out.println("Peeking at head. Value: " + list.peekFirst());
        System.out.println("Peeking at tail. Value: " + list.peekLast());
    }
}