package NonLinear;

import java.util.Arrays;

public class OpenAddressedHashTable<K, V>{
    private int size;
    private int capacity;
    private Container[] arr;

    // Constructors
    public OpenAddressedHashTable(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        arr = new Container[capacity];
    }

    // Closest prime to 1500
    public OpenAddressedHashTable() { this(1499); }

    // Methods

    // This put method will utilize linear probing, for simplicity and my sanity. Returns a boolean to indicate whether
    // the process was successful or not.
    public boolean put(K key, V value) {
        int pos = RemHash(key);

        if (arr[pos] == null || arr[pos].isDeleted()) {
            arr[pos] = new Container<>(key, value);
        } else {
            int i = 1;
            while ((pos + i) % capacity != pos) {
                int j = (pos + i) % capacity;
                if (arr[j] == null || arr[j].isDeleted()) {
                    arr[j] = new Container<>(key, value);
                    return true;
                }
                i++;
            }
        }

        return false;
    }

    // Buggy search function...search is circular -> values outside the range map to a value inside;
    public V search(K key) {
        int pos = RemHash(key);
        if (!(arr[pos] == null) && !arr[pos].isDeleted()) {
            return ((Container<K, V>)arr[pos]).val;
        } else {
            int i = 1;
            while ((pos + i) % capacity != pos) {
                int j = (pos + i) % capacity;
                if (arr[j] != null && !arr[j].isDeleted() && ((Container<K, V>)arr[j]).key == key) {
                    return ((Container<K, V>)arr[j]).val;
                }
                i++;
            }
        }
        return null;
    }

    public boolean remove(K key) {
        int pos = RemHash(key);
        if (arr[pos] != null) {
            arr[pos].delete();
            return true;
        }
        return false;
    }

    public String toString() {
        return Arrays.toString(arr);
    }

    private int RemHash(K key) { return key.hashCode() % capacity; }

    // For unit testing of the class;
    public static void main(String[] args) {
        OpenAddressedHashTable<Integer, String> ht = new OpenAddressedHashTable<>(3);
        ht.put(0, "apple");
        ht.put(1, "orange");
        ht.put(2, "cherry");
        ht.put(3, "grape");
        System.out.println(ht);
        System.out.println(ht.search(2));
        System.out.println(ht.search(3));

    }
}

class Container <K, V> {
    public K key;
    public V val;
    private boolean deleted;

    Container(K key, V val) {
        this.key = key;
        this.val = val;
        deleted = false;
    }

    public void delete() {deleted = true;}
    public boolean isDeleted() { return deleted; }

    public String toString() { return "{ " + key.toString() + ", " + val.toString() + " }";}
}
