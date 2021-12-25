package NonLinear.BinaryTree;

public class Node<Thing extends Comparable<Thing>>{
    
    private Node<Thing> leftNode;
    private Node<Thing> rightNode;
    private Thing data;

    Node(Thing data){
        this.leftNode = this.rightNode = null;
        this.data = data;
    }

    public Thing getData(){
        return data;
    }

    public void setRightNode(Node<Thing> newRightNode){
        this.rightNode = newRightNode;
    }

    public Node<Thing> getRightNode(){
        return rightNode;
    }

    public void setLeftNode(Node<Thing> newLeftNode){
        this.leftNode = newLeftNode;
    }

    public Node<Thing> getLeftNode(){
        return leftNode;
    }

    @Override
    public String toString(){
        return "Node{data='"+data+"'}";
    }
    
}