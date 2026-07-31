public class Queue<T> {
  private class Node {
    T data;
    Node next;

    public Node(T data) {
      this.data = data;
      this.next = null;
    }
  }

  private Node front;
  private Node rear;
  private int count;

  public Queue() {
    this.front = null;
    this.rear = null;
    this.count = 0;
  }
}
