package NonLinear.BinaryTree;

public class BinaryTree<Thing extends Comparable<Thing>> {
    
    private Node<Thing> refNode;

    public BinaryTree(){
        this.refNode = null;
    }

    public void setRefNode(Node<Thing> newNode){
        this.refNode = newNode;
    }

    public Node<Thing> getRefNode(){
        return refNode;
    }

    public void insert(Thing data){
        Node<Thing> newNode = new Node<Thing>(data);
        this.refNode = insert(refNode, newNode);
    }

    private Node<Thing> insert(Node<Thing> currentNode, Node<Thing> newNode){
        if(currentNode == null){
            return newNode;
        }else if(newNode.getData().compareTo(currentNode.getData()) < 0){
            currentNode.setLeftNode(insert(currentNode.getLeftNode(), newNode));
        }else{
            currentNode.setRightNode(insert(currentNode.getRightNode(), newNode));
        }
        return currentNode;
    }
    
    public void printInOrder(){
        System.out.println("\n Printing in Order.");
        printInOrder(this.refNode);
    }

    private void printInOrder(Node<Thing> currentNode){
        if(currentNode != null){
            printInOrder(currentNode.getLeftNode());
            System.out.print(currentNode.getData()+", ");
            printInOrder(currentNode.getRightNode());
        }
    }

    public void printPostOrder(){
        System.out.println("\n Printing in Post-Order.");
        printPostOrder(this.refNode);
    }

    private void printPostOrder(Node<Thing> currentNode){
        if(currentNode != null){
            printPostOrder(currentNode.getLeftNode());
            printPostOrder(currentNode.getRightNode());
            System.out.print(currentNode.getData()+", ");
        }
    }

    public void printPreOrder(){
        System.out.println("\n Printing in Pre-Order.");
        printPreOrder(this.refNode);
    }

    private void printPreOrder(Node<Thing> currentNode){
        if(currentNode != null){
            System.out.print(currentNode.getData()+", ");
            printPreOrder(currentNode.getLeftNode());
            printPreOrder(currentNode.getRightNode());
        }
    }

    public void remove(Thing data){
        try{
            Node<Thing> currentNode = refNode;
            Node<Thing> tempNode = null;
            Node<Thing> parentNode = null;
            Node<Thing> childNode = null;

            //Looks for the data you're trying to remove
            while(currentNode != null && !currentNode.getData().equals(data)){
                parentNode = currentNode;
                if(data.compareTo(currentNode.getData()) < 0){
                    currentNode = currentNode.getLeftNode();
                }else{
                    currentNode = currentNode.getRightNode();
                }
            }

            //Data not found
            if(currentNode == null){
                System.out.println("Data not found.");
                return;
            }

            //Removing the first node(refNode)
            if(parentNode == null){
                if(currentNode.getRightNode() == null){
                    this.refNode = currentNode.getLeftNode();
                }else if(currentNode.getLeftNode() == null){
                    this.refNode = currentNode.getRightNode();
                }else{
                    for(tempNode = currentNode, childNode = currentNode.getLeftNode();
                        childNode.getRightNode() != null;
                        tempNode = childNode, childNode = childNode.getLeftNode()){
                            
                            if(childNode != currentNode.getLeftNode()){
                                tempNode.setRightNode(childNode.getLeftNode());
                                childNode.setLeftNode(refNode.getLeftNode());
                            }
                    }
                    childNode.setRightNode(refNode.getRightNode());
                    refNode = childNode;
                }

            //Node only has one pointer, the leftNode
            }else if(currentNode.getRightNode() == null){
                if(parentNode.getLeftNode() == currentNode){
                    parentNode.setLeftNode(currentNode.getLeftNode());
                }else{
                    parentNode.setRightNode(currentNode.getLeftNode());
                }

            //Node only has one pointer, the rightNode
            }else if(currentNode.getLeftNode() == null){
                if(parentNode.getLeftNode() == currentNode){
                    parentNode.setLeftNode(currentNode.getRightNode());
                }else{
                    parentNode.setRightNode(currentNode.getRightNode());
                }

            //Node has both pointers
            }else{
                for(tempNode = currentNode, childNode = currentNode.getLeftNode();
                    childNode.getRightNode() != null;
                    tempNode = childNode, childNode = childNode.getRightNode()){
                    if(childNode != currentNode.getLeftNode()){
                        tempNode.setRightNode(childNode.getLeftNode());
                        childNode.setLeftNode(currentNode.getLeftNode());
                    }
                    childNode.setRightNode(currentNode.getRightNode());
                    if(parentNode.getLeftNode() == currentNode){
                        parentNode.setLeftNode(childNode);
                    }else{
                        parentNode.setRightNode(childNode);
                    }
                }   
            }
        }catch(NullPointerException e){
            e.printStackTrace();
        }
    }
}