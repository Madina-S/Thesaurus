public class HashTable<T> {
    private final static int A = 31;
    private final static int B = 71;
    private final static int SIZE = 9973;
    private HashNodeList<T> hashTable[] = new HashNodeList[SIZE];

    HashNodeList<T> getAtIndex(int hashKey){
        return hashTable[hashKey];
    }

    public static int getHashKey(String key){
        long hashCode = getHashCode(key);
        int hashkey = h1(hashCode);

        return hashkey;
    }

    private static long getHashCode(String key){
        long p = key.charAt(key.length() - 1);
        int i = key.length() - 2;

        int a = 33;
        while (i >= 0){
            p = p * a + key.charAt(i);
            i--;
        }

        return Math.abs(p);
    }

    private static int h1(long key){
        int d = (int)Math.abs((A * key + B) % SIZE);
        return d;
    }

    boolean add(BSTNode<T> value){
        if(value == null)
           return false;

        int key = value.getHashkey();
        if (hashTable[key] == null)
            hashTable[key] = new HashNodeList<T>();

        hashTable[key].add(value);
        return true;
    }

    boolean remove(BSTNode<T> value){
        int key = value.getHashkey();
        if(hashTable[key] != null){
            HashNode<T> removed = hashTable[key].remove(value);
            removed = null;
            return true;
        }

        return false;
    }
}
