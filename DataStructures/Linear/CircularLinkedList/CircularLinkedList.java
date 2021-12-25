package Linear.CircularLinkedList;

public class CircularLinkedList<Thing> {
    
    private Node<Thing> refNode;
    private int listSize;

    CircularLinkedList(){
        this.refNode = null;
        this.listSize = 0;
    } 

    public void add(Thing data){
        Node<Thing> newNode = new Node<Thing>(data);
        listSize++;
        if(refNode == null){
            refNode = newNode;
            newNode.setRefNode(refNode);
        }else if(refNode.getRefNode()==null){
            refNode.setRefNode(newNode);
            newNode.setRefNode(refNode);
            refNode = newNode;
        }else{
            newNode.setRefNode(refNode);
            Node<Thing> tempNode = refNode;
            while(tempNode.getRefNode() != refNode){
                tempNode = tempNode.getRefNode();
            }
            tempNode.setRefNode(newNode);
            refNode = newNode;
        }

    }

    public void remove(int index){

        if(index == 0){
            if(listSize == 1){
                refNode = null;
                return;
            }
            Node<Thing> tempNode = refNode;
            while(tempNode.getRefNode()!=refNode){
                tempNode = tempNode.getRefNode();
            }
            tempNode.setRefNode(tempNode.getRefNode().getRefNode());
            refNode = tempNode.getRefNode();
        }else{
            Node<Thing> tempNode = getNode(index-1);
            tempNode.setRefNode(tempNode.getRefNode().getRefNode());
        }

    }

    public Thing get(int index){
        return getNode(index).getData();
    }

    private Node<Thing> getNode(int index){
        
        Node<Thing> tempNode = refNode;
        for(int i=0; i<index; i++){
            tempNode = tempNode.getRefNode();
        }
        return tempNode;
    }

    public boolean isEmpty(){
        return refNode == null? true:false;
    }

    public int size(){
        return listSize;
    }

    @Override
    public String toString(){
        String returnString = "------------------------\n  Circular Linked List\n------------------------\nStart ->";
        if(refNode == null){
            return returnString+= " Null.";
        }
        Node<Thing> tempNode = refNode;
        while(tempNode.getRefNode() != refNode){
            returnString += tempNode.toString()+" -> ";
            tempNode = tempNode.getRefNode();
        }
        return returnString+tempNode.toString()+" -> Start.";
    }

}
