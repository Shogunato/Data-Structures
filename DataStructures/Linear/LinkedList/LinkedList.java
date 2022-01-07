package Linear.LinkedList;

public class LinkedList<Thing>{

    private Node<Thing> refNode;
    private int listSize;

    public LinkedList(){
        this.refNode = null;
        this.listSize = 0;
    }
   
    public void remove(int index){

        if(index == 0){
            refNode = refNode.getRefNode();
            return;
        }
        Node<Thing> tempNode = getNode(index-1);
        tempNode.setRefNode(tempNode.getRefNode().getRefNode());

    }

    public Thing get(int index){
        return getNode(index).getData();
    }

    private Node<Thing> getNode(int index){

        if(index >= listSize){
            throw new IndexOutOfBoundsException("Index out of range.");
        }

        Node<Thing> tempNode = refNode;
        for(int i=0; i<index; i++){
            tempNode = tempNode.getRefNode();
        }
        return tempNode;
    }

    public void add(Thing newData){
        Node<Thing> newNode = new Node<Thing>(newData);
        Node<Thing> tempNode = refNode;
        listSize++;

        if(tempNode==null){
            refNode = newNode;
            return;
        }
        while(tempNode.getRefNode() != null){
            tempNode = tempNode.getRefNode();
        }
        tempNode.setRefNode(newNode);

    }    

    public int size(){
        return listSize;
    }

    public boolean isEmpty(){
        return refNode == null? true:false;
    }

    @Override
    public String toString(){
        
         String returnString = "----------------\n     LinkedList\n----------------\n";

         if(!this.isEmpty()){
             Node<Thing> tempNode = refNode;
             while(tempNode != null){
                 returnString+= tempNode.toString()+" -> ";
                 tempNode = tempNode.getRefNode();
             }
         }
 
         //Change "Null" to whatever makes more sense for you
         returnString+=" Null\n----------------";
         return returnString;
         
    }
    
}
