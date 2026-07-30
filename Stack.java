public class Stack<T> {
  private class Node {
    T data;
    Node next;

    public Node(T data) {
      this.data = data;
      this.next = null;
    }
  }
  
  private Node top;
  private int count;

  public Stack() {
    this.top = null;
    this.count = 0;
  }
}  
