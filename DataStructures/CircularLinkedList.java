class CirLinkedList<E> {
    class Node<T> {
        T data;
        Node<T> next;

        public Node(T obj) {
            data = obj;
            next = null;
        }
    }

    public Node<E> head;
    public Node<E> tail;
    public int  currentSize;

    public CirLinkedList() {
        head = null;
        currentSize = 0;
    }

    //Adding at front
    public void addFirst(E obj) {
        Node<E> node = new Node<E>(obj);

        //If List is Empty
        if(head == null) {
            head = node;
            tail = node;

            node.next = head;
        } else {
            node.next = head;
            head = node;
            tail.next = head;
        }

        currentSize++;
    }

    //Adding at last
    public void addLast(E obj) {
        Node<E> node = new Node<E>(obj);

        if(head == null) {
            head = tail = node;
            currentSize++;

            return;
        }

        node.next = tail.next;
        tail.next = node;
        tail = node;

        currentSize++;
    }

    //Remove at first
    public E removeFirst() {
        if(head == null) {
            return null;
        }

        E temp = head.data;

        if(head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }

        currentSize--;

        return temp;
    }
    
    //Remove at last
    public E removeLast() {
        if(head == null) {
            return null;
        }

        if(head == tail) {
            return removeFirst();
        }

        Node<E> current = head;

        while(current.next != tail) {
            current = current.next;
        }

        E temp = current.data;

        tail = current;
        tail.next = head;

        currentSize--;

        return temp;
    }

    //Remove a particular Element
    public E remove(E obj) {
        Node<E> current = head;
        Node<E> previous = head;

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

public class CircularLinkedList {
    public static void main(String[] args) {
        CirLinkedList<Integer> list = new CirLinkedList<Integer>();

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

        System.out.println("Peeking at head. Value: " + list.peekFirst());
        System.out.println("Peeking at tail. Value: " + list.peekLast());
    }
}