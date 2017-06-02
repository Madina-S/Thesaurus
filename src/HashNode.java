public class HashNode<T>{
    private BSTNode<T> node;
    private HashNode<T> next;

    public HashNode(BSTNode<T> node){
        this.node = node;
        next = null;
    }

    public BSTNode<T> getNode() {
        return node;
    }

    public void setNode(BSTNode<T> node) {
        this.node = node;
    }

    public HashNode<T> getNext() {
        return next;
    }

    public void setNext(HashNode<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return node.toString();
    }
}
