package Linear.Queue;

public class Queue <Thing>{
    
    private Node<Thing> refNode;

    Queue(){
        this.refNode = null;
    }

    public void enqueue(Thing data){
        Node<Thing> newNode = new Node<Thing>(data);
        newNode.setRefNode(refNode);
        refNode = newNode;
    }

    public Thing dequeue(){

        if(!this.isEmpty()){
            Node<Thing> tempNode = refNode;
            Node<Thing> newFirstNode = refNode;

            while(tempNode.getRefNode() !=null){
                newFirstNode = tempNode; 
                tempNode = tempNode.getRefNode();
            }
            newFirstNode.setRefNode(null);
            return tempNode.getData();

        }
        return null;

    }

    public Thing first(){
        if(!this.isEmpty()){
            Node<Thing> tempNode = refNode;
            while(tempNode.getRefNode() != null){
                tempNode = tempNode.getRefNode();
            }
            return tempNode.getData();
        }
        return null;
    }

    public boolean isEmpty(){
        return refNode == null? true: false;
    }

    @Override
    public String toString(){

        //Just fancy stuff...
        String returnString = "----------------\n     Queue\n----------------\n";

        if(!this.isEmpty()){
            Node<Thing> tempNode = refNode;
            while(tempNode != null){
                returnString+= tempNode.toString()+" -> ";
                tempNode = tempNode.getRefNode();
            }
        }

        //Change "Null" to whatever makes more sense for you
        return returnString+=" Null\n----------------";
    }

}
