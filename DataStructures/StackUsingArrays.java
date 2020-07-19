class StackArray<E> {
    private int stackSize;
    private E[] stack;
    private int top;

    @SuppressWarnings("unchecked")
    StackArray(int size) {
        stackSize = size;
        stack = (E[]) new Object[stackSize];
        top = -1;
    }

    //Check if Stack is Empty
    public boolean isStackEmpty() {
        return (top == -1);
    }

    //Check if Stack is Full
    public boolean isStackFull() {
        return (top == stackSize - 1);
    }

    //Adding Object to Stack
    public void push(E obj) {
        if(isStackFull()) {
            System.out.println("Stack is Full! Increasing Capacity");
            increaseStackCapacity();
        }
        stack[++top] = obj;
        System.out.println("Object Added.");
    }

    //Removing Object from Queue
    public E pop() throws Exception {
        if(isStackEmpty()) {
            throw new Exception("Stack is Empty. Add some values.");
        }
        E obj = stack[top--];
        System.out.println("Object Removed: " + obj);

        return obj;
    }

    //Peek at the topmost Object.
    public E peek() {
        return stack[top];
    }

    //Increasing Stack Capacity
    public void increaseStackCapacity() {
        @SuppressWarnings("unchecked")
        E[] newStack = (E[]) new Object[stackSize*2];
        
        for(int i = 0; i < stackSize; i++) {
            newStack[i] = stack[i];
        }

        stack = newStack;
        stackSize = stackSize * 2;
    }
}

public class StackUsingArrays {
    public static void main(String[] args) throws Exception {
        StackArray<Integer> stackArray = new StackArray<Integer>(10);

        System.out.println("Adding 10 Numbers");
        for(int i = 1; i <= 10; i++) {
            stackArray.push(i);
            System.out.println("Value Added is: " + i);
        }

        System.out.println("Item at Top: " + stackArray.peek());

        System.out.println("Removing Added Numbers");
        for(int i = 1; i <=10; i++) {
            int val = stackArray.pop();
            System.out.println("Removed Value: " + val);
        }
    }
}