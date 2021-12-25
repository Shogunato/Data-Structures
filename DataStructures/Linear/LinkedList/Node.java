package Linear.LinkedList;

public class Node<Thing> {
    
    private Node<Thing> refNode;
    private Thing data;

    Node(Thing data){
        this.refNode = null;
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

    @Override
    public String toString(){
        return "Node{data='"+data+"'}";
    }
    
}
