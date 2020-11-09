package NonLinear;

public class OpenAddressedHashTable<K, V>{
    private int size;
    private double hashConst;

    private int RemHash(K key) {
        return key.hashCode() % size;
    }

    private int mulHash(K key){
        return (int)((key.hashCode() * hashConst) - Math.floor(key.hashCode() * hashConst) * size);
    }
}

class Container <K, V> {
    private K key;
    private V val;
    private boolean deleted;

    Container(K key, V val) {
        this.key = key;
        this.val = val;
        deleted = false;
    }

    public void delete() {deleted = true;}
    public boolean isDeleted() { return deleted; }
}
