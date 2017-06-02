public class Dictionary {
    private BST<String> bst;
    private HashTable<String> hashTable;

    public Dictionary(){
        bst = new BST<>();
        hashTable = new HashTable<>();
    }

    public boolean insert(String word, String key){
        int hashkey = HashTable.getHashKey(key);
        BSTNode<String> node = bst.add(word, hashkey);
        bst.display();
        if(node != null){
            hashTable.add(node);
            return true;
        }

        return false;
    }

    public boolean remove(String word){
        BSTNode<String> removed = bst.remove(word);
        if(removed != null){
            hashTable.remove(removed);
            return true;
        }

        return false;
    }

    public HashNodeList<String> search(String word){
        BSTNode<String> found = bst.search(word);
        if(found != null)
            return hashTable.getAtIndex(found.getHashkey());
        else
            return null;
    }
}
