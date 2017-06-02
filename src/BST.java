public class BST<T> {
    private BSTNode<T> root;

    public BST(){
        root = null;
    }

    public BSTNode<T> search(T value){
        BSTNode<T> current = root;
        while(current!=null){
            if(((Comparable)current.getValue()).compareTo(value) > 0)
                current = current.getLeft();
            if(current.getValue() == value)
                return current;
            else
                current = current.getRight();
        }

        return null;
    }

    public BSTNode<T> remove(T value){
        BSTNode<T> parent = root;
        BSTNode<T> current = root;
        boolean isLeftChild = false;
        while(!current.getValue().equals(value)){
            parent = current;
            if(((Comparable)current.getValue()).compareTo((Comparable)value) > 0){
                isLeftChild = true;
                current = current.getLeft();
            }else{
                isLeftChild = false;
                current = current.getRight();
            }
            if(current == null){
                return null;
            }
        }

        //if i am here that means we have found the node
        //Case 1: if node to be deleted has no children
        if(current.getLeft() == null && current.getRight() == null){
            if(current == root){
                root = null;
            }

            if(isLeftChild ==true){
                parent.setLeft(null);
            }else{
                parent.setRight(null);
            }
        }
        //Case 2 : if node to be deleted has only one child
        else if(current.getRight() == null){
            if(current==root){
                root = current.getLeft();
            }else if(isLeftChild){
                parent.setLeft(current.getLeft());
            }else{
                parent.setRight(current.getLeft());
            }
        }
        else if(current.getLeft() == null){
            if(current==root){
                root = current.getRight();
            }else if(isLeftChild){
                parent.setLeft(current.getRight());
            }else{
                parent.setRight(current.getRight());
            }
        }else if(current.getLeft() != null && current.getRight() != null){

            //now we have found the minimum element in the right sub tree
            BSTNode<T> successor = getSuccessor(current);
            if(current == root){
                root = successor;
            }else if(isLeftChild){
                parent.setLeft(successor);
            }else{
                parent.setRight(successor);
            }

            successor.setLeft(current.getLeft());
        }

        return current;
    }

    private BSTNode<T> getSuccessor(BSTNode<T> deleleNode){
        BSTNode<T> successsor =null;
        BSTNode<T> successsorParent =null;
        BSTNode<T> current = deleleNode.getRight();
        while(current!=null){
            successsorParent = successsor;
            successsor = current;
            current = current.getRight();
        }
        //check if successor has the right child, it cannot have left child for sure
        // if it does have the right child, add it to the left of successorParent.
//		successsorParent
        if(successsor != deleleNode.getRight()){
            successsorParent.setLeft(successsor.getRight());
            successsor.setRight(deleleNode.getRight());
        }
        return successsor;
    }

    public BSTNode<T> add(T value, int hashkey){
        BSTNode<T> newNode = new BSTNode<T>(value, hashkey);
        if(root==null){
            root = newNode;
            return newNode;
        }

        BSTNode<T> current = root;
        BSTNode<T> parent = null;
        while(true){
            parent = current;
            if(current.getValue().equals(value)){
                System.out.println("\nThere is such a word already");
		return null;
	    }

            if(((Comparable)value).compareTo(current.getValue()) < 0){
                current = current.getLeft();
                if(current == null){
                    parent.setLeft(newNode);
                    return newNode;
                }
            }else{
                current = current.getRight();
                if(current==null){
                    parent.setRight(newNode);
                    return newNode;
                }
            }
        }
    }

    public void display(){
        display(root);
        System.out.println();
    }

    private void display(BSTNode<T> root){
        if(root != null){
            display(root.getLeft());
            System.out.print(" " + root.getValue());
            display(root.getRight());
        }
    }
}
