package linkedLists;

public class DoublyLinkedList<T> {
    private final Node<T> headSentinel;
    private final Node<T> tailSentinel;

    private int size = 0;

    public DoublyLinkedList() {
        headSentinel = new Node<>(null, null, null);
        tailSentinel = new Node<>(null, null, null);

        headSentinel.setNextNode(tailSentinel);
        tailSentinel.setPreviousNode(headSentinel);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T first() {
        return headSentinel.getNextNode().element;
    }

    public T last() {
        return tailSentinel.getPreviousNode().element;
    }

    public void addFirst(T element) {
        addBetween(element, headSentinel, headSentinel.getNextNode());
    }

    public void addLast(T element) {
        addBetween(element, tailSentinel.getPreviousNode(), tailSentinel);

    }

    public T removeFirst() {
        if (size == 0) return null;

        return remove(headSentinel.getNextNode());
    }

    public T removeLast() {
        if (size == 0) return null;

        return remove(tailSentinel.getPreviousNode());
    }

    private void addBetween(T element, Node<T> predecessor, Node<T> successor) {
        Node<T> newest = new Node<>(element, predecessor, successor);

        predecessor.setNextNode(newest);
        successor.setPreviousNode(newest);

        size++;
    }

    private T remove(Node<T> node) {
        Node<T> previous = node.getPreviousNode();
        Node<T> next = node.getNextNode();

        previous.setNextNode(next);
        next.setPreviousNode(previous);

        size--;

        return node.getElement();
    }

    private static class Node<T> {
        private final T element;
        private DoublyLinkedList.Node<T> nextNode;
        private DoublyLinkedList.Node<T> previousNode;

        public Node(T element, DoublyLinkedList.Node<T> previousNode, DoublyLinkedList.Node<T> nextNode) {
            this.element = element;
            this.nextNode = nextNode;
            this.previousNode = previousNode;
        }

        public T getElement() {
            return element;
        }

        public DoublyLinkedList.Node<T> getNextNode() {
            return nextNode;
        }

        public void setNextNode(DoublyLinkedList.Node<T> nextNode) {
            this.nextNode = nextNode;
        }

        public DoublyLinkedList.Node<T> getPreviousNode() {
            return previousNode;
        }

        public void setPreviousNode(DoublyLinkedList.Node<T> previousNode) {
            this.previousNode = previousNode;
        }

    }

}
