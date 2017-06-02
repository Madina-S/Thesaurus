public class HashNodeList<T> {
    private HashNode<T> root;

    public HashNodeList(){
        root = null;
    }

    public HashNode<T> add(BSTNode<T> node){
        HashNode<T> temp = new HashNode<T>(node);
        temp.setNext(root);
        root = temp;
        return root;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public HashNode<T> remove(BSTNode<T> node){
        if(isEmpty())
            return null;

        if(root.getNode().equals(node)) {
            HashNode<T> temp = root;
            root = root.getNext();
            return temp;
        }

        return remove(root, root.getNext(), node);
    }

    private HashNode<T> remove(HashNode<T> pre, HashNode<T> curr, BSTNode<T> node){
        if(curr == null)
            return null;

        if(curr.getNode().equals(node)){
            pre.setNext(curr.getNext());
            return curr;
        }

        return remove(curr, curr.getNext(), node);
    }

    public void print(T value){
        if(isEmpty() || root.getNext() == null){
            System.out.println("Empty");
            return;
        }

        HashNode<T> temp = root;
        while(temp != null){
            if(!temp.getNode().getValue().equals(value))
                System.out.println(temp.getNode());
            temp = temp.getNext();
        }
    }
}
