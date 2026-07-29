package datastructures;

import java.util.Objects;

public class CustomHashTable<K, V> {

    public static class Entry<K, V> {
        public K key;
        public V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "[" + key + "=" + value + "]";
        }
    }

    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private CustomLinkedList<Entry<K, V>>[] buckets;
    private int capacity;
    private int size;

    @SuppressWarnings("unchecked")
    public CustomHashTable(int capacity) {
        this.capacity = Math.max(capacity, 1);
        this.buckets = new CustomLinkedList[this.capacity];
        this.size = 0;
    }

    public CustomHashTable() {
        this(16);
    }

    private int getBucketIndex(K key) {
        if (key == null) return 0;
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    // Helper for safe key comparisons
    private boolean keysEqual(K k1, K k2) {
        return Objects.equals(k1, k2);
    }

    // Helper to find entry in a specific bucket
    private Entry<K, V> findEntry(K key, int index) {
        if (buckets[index] == null) return null;
        for (Entry<K, V> entry : buckets[index]) {
            if (keysEqual(key, entry.key)) {
                return entry;
            }
        }
        return null;
    }

    public void put(K key, V value) {
        // Check load factor and resize if needed
        if ((float) size / capacity >= DEFAULT_LOAD_FACTOR) {
            resize();
        }

        int index = getBucketIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new CustomLinkedList<>();
        }

        Entry<K, V> existing = findEntry(key, index);
        if (existing != null) {
            existing.value = value; // Update value
            return;
        }

        buckets[index].add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        Entry<K, V> entry = findEntry(key, index);
        return (entry != null) ? entry.value : null;
    }

    public boolean remove(K key) {
        int index = getBucketIndex(key);
        Entry<K, V> entry = findEntry(key, index);

        if (entry != null) {
            buckets[index].remove(entry);
            size--;
            return true;
        }
        return false;
    }

    public boolean containsKey(K key) {
        int index = getBucketIndex(key);
        return findEntry(key, index) != null;
    }

    public int getSize() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = capacity * 2;
        CustomLinkedList<Entry<K, V>>[] oldBuckets = buckets;

        this.capacity = newCapacity;
        this.buckets = new CustomLinkedList[newCapacity];
        this.size = 0;

        for (CustomLinkedList<Entry<K, V>> bucket : oldBuckets) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    put(entry.key, entry.value);
                }
            }
        }
    }

    public void printBucketDistribution() {
        for (int i = 0; i < capacity; i++) {
            if (buckets[i] != null && !buckets[i].isEmpty()) {
                System.out.print("Bucket " + i + ": ");
                for (Entry<K, V> entry : buckets[i]) {
                    System.out.print(entry + " ");
                }
                System.out.println();
            }
        }
    }
}
