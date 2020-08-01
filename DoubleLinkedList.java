public class DoubleLinkedList {
    
    protected Node head;
    protected Node tail;

    public Node getLast(){
        return this.tail;
    }

    public Node getFirst(){
        return this.head;
    }

    public void addFirst(Double data){

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

}