public class Queue<T>
{
    private class Node
    {
        private T data;
        private Node next;

        public Node(T data)
        {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;
    private int count;

    public Queue()
    {
        this.front = null;
        this.rear = null;
        this.count = 0;
    }

    public boolean isEmpty()
    {
        boolean empty = false;

        if (this.front == null)
        {
            empty = true;
        }

        return empty;
    }

    public void enqueue(T data)
    {
        Node newNode = new Node(data);

        if (this.rear == null)
        {
            this.front = newNode;
            this.rear = newNode;
        }
        else
        {
            this.rear.next = newNode;
            this.rear = newNode;
        }

        this.count++;
    }

    public T dequeue()
    {
        T dequeuedData = null;

        if (this.front != null)
        {
            dequeuedData = this.front.data;
            this.front = this.front.next;

            if (this.front == null)
            {
                this.rear = null;
            }

            this.count--;
        }

        return dequeuedData;
    }

    public T peek()
    {
        T frontData = null;

        if (this.front != null)
        {
            frontData = this.front.data;
        }

        return frontData;
    }

    public int getCount()
    {
        return this.count;
    }
}
