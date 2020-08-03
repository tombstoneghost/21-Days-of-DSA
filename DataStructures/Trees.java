class Tree<E> {
    class Node<T> {
        T data;
        Node<T> left, right;
        
        public Node(T obj) {
            this.data = obj;
            left = right = null;
        }
    }

    Node<E> root = null;
    int height = 0;

    @SuppressWarnings("unchecked")
    public void add(E obj, Node<E> node) {
        if(((Comparable<E>)obj).compareTo(node.data) > 0) {
            if(node.right == null) {
                node.right = new Node<E>(obj);

                return ;
            }
            add(obj, node.right);
        } if(node.left == null) {
            node.left = new Node<E>(obj);
            
            return;
        }
        add(obj, node.left);
    }

    public void add(E obj) {
        if(root == null) {
            root = new Node<E>(obj);
        } else {
            add(obj, root);
        }
        height++;
    }

    public boolean contains(E obj) {
        return contains(obj, root);
    }

    @SuppressWarnings("unchecked")
    public boolean contains(E obj, Node<E> node) {
        if(node == null)
            return false;
        
        if(((Comparable<E>)obj).compareTo(node.data) == 0) 
            return true;
        if(((Comparable<E>)obj).compareTo(node.data) > 0)
            return contains(obj, node.right);
        
        return contains(obj, node.left);
    }

    //Rotations
    public Node<E> leftRotate(Node<E> node) {
        Node<E> temp = node.right;
        node.right = temp.left;
        temp.left = node;

        return temp;
    }

    public Node<E> rightRotate(Node<E> node) {
        Node<E> temp = node.left;
        node.left = temp.right;
        temp.right = node;

        return temp;
    }

    public Node<E> rightLeftRotate(Node<E> node) {
        node.right = rightRotate(node.right);

        return leftRotate(node);
    }

    public Node<E> leftRightRotate(Node<E> node) {
        node.left = leftRotate(node.left);

        return rightRotate(node);
    }
}