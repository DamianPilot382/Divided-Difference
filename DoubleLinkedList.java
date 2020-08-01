public class DoubleLinkedList {
    
    protected Node head;
    protected Node tail;

    protected int size;

    public Node getLast(){
        return this.tail;
    }

    public Node getFirst(){
        return this.head;
    }

    public void addFirst(Double data){

        this.size++;

        Node node = new Node(data);

        if(head == null){
            this.head = node;
            this.tail = node;
            return;
        }
        node.next = head;
        this.head.previous = node;
        this.head = node;
    }

    public void addLast(Double data){

        this.size++;

        Node node = new Node(data);

        if(this.tail == null){
            this.head = node;
            this.tail = node;
            return;
        }
        node.previous = tail;
        this.tail.next = node;
        this.tail = node;
    }

    public void print(){
        Node node = this.head;

        while(node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public void multiply(double n){
        Node node = this.head;

        while(node != null){
            node.data *= n;
            node = node.next;
        }
    }

    public void add(DoubleLinkedList list, double n){
        Node otherTail = list.getLast();
        Node node = this.tail;

        while(node != null && otherTail != null){
            node.data = node.data + n * otherTail.data;

            node = node.previous;
            otherTail = otherTail.previous;
        }
    }

}