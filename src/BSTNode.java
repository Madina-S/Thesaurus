public class BSTNode<T> {
    private T value;
    private int hashkey;
    private BSTNode<T> left;
    private BSTNode<T> right;

    public BSTNode(T value, int hashkey){
        this.value = value;
        this.hashkey = hashkey;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int getHashkey() {
        return hashkey;
    }

    public void setHashkey(int hashkey) {
        this.hashkey = hashkey;
    }

    public BSTNode<T> getLeft() {
        return left;
    }

    public void setLeft(BSTNode<T> left) {
        this.left = left;
    }

    public BSTNode<T> getRight() {
        return right;
    }

    public void setRight(BSTNode<T> right) {
        this.right = right;
    }

    @Override
    public boolean equals(Object obj) {
        BSTNode<T> node = (BSTNode<T>)obj;
        if(value.equals(node.getValue()))
            if(hashkey == node.getHashkey())
                return true;

        return false;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public String getInfo(){
        return String.format("%s - %d", value, hashkey);
    }
}
