package linkedLists;

import java.util.Objects;

public class SinglyLinkedList<T> {
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    public SinglyLinkedList() {
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public T first() {
        return head.getElement();
    }

    public T last() {
        return tail.getElement();
    }

    public T addFirst(T element) {
        Node<T> newHead = new Node<>(element, head);
        head = newHead;
        if (isEmpty())
            tail = head;

        size++;

        return newHead.getElement();
    }

    public T addLast(T element) {
        Node<T> newTail = new Node<>(element, null);
        if (isEmpty())
            head = newTail;
        else
            tail.setNextNode(newTail);

        tail = newTail;
        size++;

        return newTail.getElement();
    }

    public T removeFirst() {
        if (isEmpty()) return null;

        Node<T> elementRemoved = head;

        head = head.getNext();
        size--;

        if (isEmpty()) {
            tail = null;
        }

        return elementRemoved.getElement();
    }

    public T removeLast() {
        if (isEmpty()) return null;

        Node<T> nodeRemoved = tail;

        Node<T> currentNode = head;

        while (currentNode.getNext().getNext() != null) {
            //currentNode represents second last node
            currentNode = currentNode.getNext();
        }

        currentNode.setNextNode(null);
        tail = currentNode;
        size--;

        return nodeRemoved.getElement();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (this == o) return true;

        SinglyLinkedList<?> that = (SinglyLinkedList<?>) o;
        if (that.getSize() != size) return false;

        Node<?> walkA = head;
        Node<?> walkB = that.head;

        while (walkA != null) {
            if (!walkA.getElement().equals(walkB.getElement())) return false;
            walkA = walkA.getNext();
            walkB = walkB.getNext();
        }

        return true;
    }



    private static class Node<T> {
        private final T element;
        private SinglyLinkedList.Node<T> nextNode;

        public Node(T element, SinglyLinkedList.Node<T> nextNode) {
            this.element = element;
            this.nextNode = nextNode;
        }

        public T getElement() {
            return element;
        }

        public SinglyLinkedList.Node<T> getNext() {
            return nextNode;
        }

        public void setNextNode(SinglyLinkedList.Node<T> nextNode) {
            this.nextNode = nextNode;
        }
    }
}
