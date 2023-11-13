package linkedLists;

public class CircularlyLinkedList<T> {
    private Node<T> tail = null;
    private int size = 0;

    public CircularlyLinkedList() {
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public T first() {
        return tail.getNext().element;
    }

    public T last() {
        return tail.getElement();
    }

    public void addFirst(T element) {
        if (tail == null) {
            tail = new Node<>(element, null);
            tail.setNextNode(tail);
        } else {
            Node<T> previousImplicitHead = tail.getNext();
            Node<T> currentImplicitHead = new Node<>(element, previousImplicitHead);
            tail.setNextNode(currentImplicitHead);
        }

        size++;

    }

    public void addLast(T element) {
        addFirst(element);
        tail = tail.getNext();
    }

    public T removeFirst() {
        if (isEmpty()) return null;
        Node<T> head = tail.getNext();
        tail.setNextNode(head.getNext());
        size--;

        return head.getElement();
    }

    public void rotate() {
        if (tail != null) tail = tail.getNext();
    }

    private static class Node<T> {
        private final T element;
        private CircularlyLinkedList.Node<T> nextNode;

        public Node(T element, CircularlyLinkedList.Node<T> nextNode) {
            this.element = element;
            this.nextNode = nextNode;
        }

        public T getElement() {
            return element;
        }

        public CircularlyLinkedList.Node<T> getNext() {
            return nextNode;
        }

        public void setNextNode(CircularlyLinkedList.Node<T> nextNode) {
            this.nextNode = nextNode;
        }
    }

}
