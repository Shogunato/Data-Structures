package Linear.DoublyLinkedList;

public class DoublyLinkedList<Thing> {
    
    private Node<Thing> lastNode;
    private Node<Thing> firstNode;
    private int listSize;

    DoublyLinkedList(){
        this.lastNode = this.firstNode = null;
        this.listSize = 0;
    }

    public Node<Thing> remove(int index){
        Node<Thing> tempNode = getNode(index);
        listSize--;

        if(index == 0){
            firstNode = tempNode.getRefNode();
            if(tempNode.getRefNode() == null){
                lastNode = null;
                return tempNode;
            }else{
                tempNode.getRefNode().setPrevNode(null);
                return tempNode;
            }
        }else if(tempNode.getRefNode() == null){
            lastNode = tempNode.getPrevNode();
            tempNode.getPrevNode().setRefNode(null);
            return tempNode;
        }

        tempNode.getPrevNode().setRefNode(tempNode.getRefNode());
        tempNode.getPrevNode().getRefNode().setPrevNode(tempNode.getPrevNode());
        return tempNode;
    }
    
    public void add(Thing newData, int index){
        Node<Thing> newNode = new Node<Thing>(newData);
        Node<Thing> tempNode = getNode(index);
        listSize++;

        if(index == 0){
            firstNode.setPrevNode(newNode);
            newNode.setRefNode(firstNode);
            firstNode = newNode;
            return;
        } else if(tempNode.getRefNode() == null){
            lastNode.setRefNode(newNode);
            newNode.setPrevNode(tempNode);
            lastNode = newNode;
            return;
        }

        newNode.setPrevNode(tempNode.getPrevNode());
        tempNode.getPrevNode().setRefNode(newNode);
        newNode.setRefNode(tempNode);
        tempNode.setPrevNode(newNode);

    }

    public void add(Thing newData){
        Node<Thing> newNode = new Node<Thing>(newData);

        newNode.setRefNode(null);
        newNode.setPrevNode(lastNode);
        if (firstNode==null){
            firstNode = newNode;
        }
        if(lastNode != null){
            lastNode.setRefNode(newNode);
        }
        lastNode = newNode;
        listSize++;
        
    }

    public Thing get(int index){
        return getNode(index).getData();
    }

    private Node<Thing> getNode(int index){
        
        if(index == 0){
            return firstNode;
        }else if(index+1>listSize){
            throw new IndexOutOfBoundsException();
        }
        
        Node<Thing> tempNode = firstNode;
        for(int i=0; i<index; i++){
            tempNode = tempNode.getRefNode();
        }
        return tempNode;
    }

    public int size(){
        return this.listSize;
    }

    @Override
    public String toString(){
        String returnString = "----------------------\n Doubly LinkedList\n----------------------\nNull <- ";
        if(listSize == 0){
            return returnString+="-> Null";
        }
        Node<Thing> tempNode = firstNode;
        while(tempNode.getRefNode() != null){
            returnString += tempNode.toString()+ " <-> ";
            tempNode = tempNode.getRefNode();
        }

        return returnString+tempNode.toString()+" -> Null";
    }

}
