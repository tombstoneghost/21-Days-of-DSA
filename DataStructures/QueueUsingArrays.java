class QueueArray<E> {
    private int queueSize;
    private E[] queue;
    private int front;

    @SuppressWarnings("unchecked")
    QueueArray(int size) {
        queueSize = size;
        queue = (E[]) new Object[queueSize];
        front = 0;
    }

    //Check if Queue is Empty
    public boolean isQueueEmpty() {
        return (front == 0);
    }

    //Check if Queue is Full
    public boolean isQueueFull() {
        return (front == queueSize - 1);
    }

    //Add Object to Queue
    public void enqueue(E obj) {
        if(isQueueFull()) {
            System.out.println("Queue is Full!");
            return;
        }
        queue[front++] = obj;
    }

    //Remove Object from Queue
    public E dequeue() throws Exception {
        if(isQueueEmpty()) {
            throw new Exception("Queue is Empty");
        }

        E temp = queue[0];

        for(int i = 0; i < (front - 1); i++)
            queue[i] = queue[i + 1];
        
        front--;

        return temp;
    }

    //Peeking at the frontmost Element
    public E peek() {
        return queue[front];
    }

}

public class QueueUsingArrays {
    public static void main(String[] args) throws Exception {
        QueueArray<Integer> queueArray = new QueueArray<Integer>(10);

        System.out.println("Adding 10 Numbers");
        for(int i = 1; i <= 10; i++) {
            queueArray.enqueue(i);
            System.out.println("Value Added is: " + i);
        }

        System.out.println("Item at Top: " + queueArray.peek());

        System.out.println("Removing Added Numbers");
        for(int i = 1; i <=10; i++) {
            int val = queueArray.dequeue();
            System.out.println("Removed Value: " + val);
        }
    }
}