class Heap<E> {
    int lastposition;
    int size;
    E[] heapArray;

    @SuppressWarnings("unchecked")
    Heap(int size) {
        lastposition = 0;
        this.size = size;
        heapArray = (E[])new Object[this.size];
    }

    public void add(E obj) {
        heapArray[++lastposition] = obj;
        trickleUp(lastposition);
    }

    public E remove() {
        E temp = heapArray[0];

        swap(0, lastposition--);
        trickleDown(0);

        return temp;
    }

    public void swap(int from, int to) {
        E temp = heapArray[from];
        heapArray[from] = heapArray[to];
        heapArray[to] = temp;
    }

    @SuppressWarnings("unchecked")
    public void trickleUp(int position) {
        if(position == 0)
            return;
        
        int parent = (int)Math.floor((position - 1)/2);
        
        if(((Comparable<E>)heapArray[position]).compareTo(heapArray[parent]) > 0) {
            swap(position, parent);
            trickleUp(parent);
        }
    }

    @SuppressWarnings("unchecked")
    public void trickleDown(int parent) {
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;

        if(left == lastposition && (((Comparable<E>)heapArray[parent]).compareTo(heapArray[left]) < 0)) {
            swap(parent, left);
            return;
        }

        if(right == lastposition && (((Comparable<E>)heapArray[parent]).compareTo(heapArray[right]) < 0)) {
            swap(parent, right);
            return;
        }

        if(left >= lastposition || right >= lastposition)
            return;
        
        if((((Comparable<E>)heapArray[left]).compareTo(heapArray[right]) > 0) && (((Comparable<E>)heapArray[parent]).compareTo(heapArray[left]) < 0)) {
            swap(parent, left);
            trickleDown(left);
        }

        if((((Comparable<E>)heapArray[parent]).compareTo(heapArray[right]) < 0)) {
            swap(parent, right);
            trickleDown(right);
        }
    }
}