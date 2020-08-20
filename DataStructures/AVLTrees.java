class AVLTree<E> {
    class Node<T> {
        T data;
        Node<T> left, right, parent;

        public Node(T obj) {
            data = obj;
            parent = left = right = null;
        }
    }

    Node<E> root;
    int currentSize;

    public AVLTree() {
        root = null;
        currentSize = 0;
    }

    public void add(E obj) {
        Node<E> node = new Node<E>(obj);

        if(root == null) {
            root = node;
            currentSize++;

            return;
        }
        add(root, node);
    }

    @SuppressWarnings("unchecked")
    public void add(Node<E> parent, Node<E> newNode) {
        if(((Comparable<E>)newNode.data).compareTo(parent.data) > 0) {
            if(parent.right == null) {
                parent.right = newNode;
                newNode.parent = parent;
                currentSize++;
            } else {
                add(parent.right, newNode);
            }
        } else {
            if(parent.left == null) {
                parent.left = newNode;
                newNode.parent = parent;
                currentSize++;
            } else {
                add(parent.left, newNode);
            }
        }

        checkBalance(newNode);
    }

    public void checkBalance(Node<E> node) {
        if((height(node.left) - height(node.right) > 1) || (height(node.left) - height(node.right) < -1)) {
            rebalance(node);
        } if(node.parent == null)
            return;
        
        checkBalance(node.parent);
    }

    public void rebalance(Node<E> node) {
        if(height(node.left) - height(node.right) > 1) {
            if(height(node.left.left) > height(node.left.right)) {
                node = rightRotate(node);
            } else {
                node = leftRightRotate(node);
            }
        } else {
            if(height(node.right.left) > height(node.right.right)) {
                node = leftRotate(node);
            } else {
                node = rightLeftRotate(node);
            }
        } if(node.parent == null)
            root = node;
    }

    public int height() {
        if(root == null)
            return 0;
        
        return height(root) - 1;
    }

    public int height(Node<E> node) {
        if(node == null) {
            return 0;
        }

        int leftHeight = height(node.left) + 1;
        int rightHeight = height(node.right) + 1;

        if(leftHeight > rightHeight) {
            return leftHeight;
        }

        return rightHeight;
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