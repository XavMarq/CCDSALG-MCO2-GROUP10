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

  public boolean isEmpty() {
    boolean empty = false;
    if (this.top == null) {
      empty = true;
    }
    return empty;
  }

  public void push(T data) {
    Node newNode = new Node(data);
    newNode.next = this.top;
    this.top = newNode;
    this.count++;
  }

  public T pop() {
      T poppedData = null;

      if (this.top != null){
          poppedData = this.top.data;
          this.top = this.top.next;
          this.count--;
      }

      return poppedData;
  }

  public T peek() {
      T topData = null;

      if (this.top != null) {
          topData = this.top.data;
      }

      return topData;
  }

  public int getCount() {
    return this.count;
  }
}  
