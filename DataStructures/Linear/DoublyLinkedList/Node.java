package Linear.DoublyLinkedList;

public class Node<Thing> {
    private Node<Thing> refNode;
    private Node<Thing> prevNode;
    private Thing data;

    Node(Thing data){
        this.prevNode = this.refNode = null;
        this.data = data;
    }

    public Thing getData(){
        return data;
    }

    public void setData(Thing newData){
        this.data = newData;
    }

    public Node<Thing> getRefNode(){
        return this.refNode;
    }

    public void setRefNode(Node<Thing> newRefNode){
        this.refNode = newRefNode;
    }

    public Node<Thing> getPrevNode(){
        return this.prevNode;
    }

    public void setPrevNode(Node<Thing> newRefNode){
        this.prevNode = newRefNode;
    }

    @Override
    public String toString(){
        return "Node{data='"+data+"'}";
    }
}
