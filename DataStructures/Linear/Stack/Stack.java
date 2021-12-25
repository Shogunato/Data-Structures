package Linear.Stack;

public class Stack<Thing>{
    
    private Node<Thing> refNode;

    Stack(){
        this.refNode = null;
    }

    public Thing pop(){
        if(!this.isEmpty()){
            Node<Thing> poppedNode = refNode;
            refNode = refNode.getRefNode();
            return poppedNode.getData();
        }
        return null;
    }

    public void push(Thing data){
        Node<Thing> newNode = new Node<Thing>(data);
        Node<Thing> tempRefNode = refNode;
        refNode = newNode;
        refNode.setRefNode(tempRefNode);
    }

    public Thing peek(){
        return refNode.getData();
    }

    public boolean isEmpty(){
        return refNode == null? true: false;
    }

    @Override
    public String toString(){

        //Just fancy stuff...
        String returnString = "-------------- \n    Stack\n-------------- \n";

        Node<Thing> tempNode = refNode;

        while(tempNode != null){
            
            returnString += "Node{data='"+tempNode.getData()+"'}\n";
            tempNode = tempNode.getRefNode();
            
        }
        returnString += "-------------- \n";
        return returnString;

    }

}