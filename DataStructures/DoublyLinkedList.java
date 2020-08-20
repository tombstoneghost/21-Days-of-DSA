class DoubleLinkedList<E> {
    class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T obj) {
            data = obj;
            next = null;
            prev = null;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int currentSize;

    DoubleLinkedList() {
        head = null;
        tail = null;
        currentSize = 0;
    }

    //Adding Node at Front
    public void addFirst(E obj) {
        Node<E> node = new Node<E>(obj);

        node.next = head;
        node.prev = null;
        
        if(head != null) {
            head.prev = node;
        }

        head = node;

        currentSize++;
    }

    //Adding Node at Last
    public void addLast(E obj) {
        Node<E> node = new Node<E>(obj);

        if(head == null) {
            head = tail = node;
            currentSize++;

            return;
        }

        tail.next = node;
        node.prev = tail;

        tail = node;
        tail.next = null;

        currentSize++;
    }

    //Remove Node from Front
    public E removeFirst() {
        if(head == null)
            return null;

        E temp = head.data;

        if(head == tail) {
            head = tail = null;
            return null;
        }

        head = head.next;
        head.prev = null;

        currentSize--;

        return temp;
    }

    //Remove Node from Last
    public E removeLast() {
        if(head == null)
            return null;

        if(head == tail)
            return removeFirst();
        
        E temp = tail.data;

        tail = tail.prev;
        tail.next = null;

        currentSize--;

        return temp;
    }

    //Remove a Particular Node
    public E remove(E obj) {
        if(head == null)
            return null;

        Node<E> current = head;

        while(current != null) {
            if(obj.equals(current.data)) {
                if(head == current) {
                    return removeFirst();
                }

                if(tail == current) {
                    return removeLast();
                }

                currentSize--;

                current.prev.next = current.next;
                
                return current.data;
            }
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

public class DoublyLinkedList {
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

        /*for(int i : list) {
            System.out.println(i);
        }*/

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