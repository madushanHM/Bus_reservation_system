package datastructures;

import java.util.LinkedList;

public class CustomHashTable<K, V> {

    private static class Entry<K, V> {
        K key;
        V value;
        Entry(K key, V value) { this.key = key; this.value = value; }
    }

    private LinkedList<Entry<K, V>>[] buckets;
    private int capacity;
    private int size;

    @SuppressWarnings("unchecked")
    public CustomHashTable(int capacity) {
        this.capacity = capacity;
        this.buckets = new LinkedList[capacity];
        this.size = 0;
    }

    public CustomHashTable() {
        this(16); // default capacity
    }

    // Hash function: converts a key into a valid bucket index
    private int getBucketIndex(K key) {
        int hash = key.hashCode();
        hash = hash & 0x7fffffff; // strip sign bit -> always non-negative
        return hash % capacity;
    }

    // Insert or update a key-value pair
    public void put(K key, V value) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        // If key already exists, update its value instead of duplicating
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        buckets[index].add(new Entry<>(key, value));
        size++;
    }

    // Retrieve a value by key -> O(1) average case lookup
    public V get(K key) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) return null;

        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null; // not found
    }

    // Remove an entry by key
    public boolean remove(K key) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) return false;

        Entry<K, V> toRemove = null;
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                toRemove = entry;
                break;
            }
        }
        if (toRemove != null) {
            buckets[index].remove(toRemove);
            size--;
            return true;
        }
        return false;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public int getSize() { return size; }

    // Shows which bucket each key landed in - useful to DEMONSTRATE collisions
    public void printBucketDistribution() {
        for (int i = 0; i < capacity; i++) {
            if (buckets[i] != null && !buckets[i].isEmpty()) {
                System.out.print("Bucket " + i + ": ");
                for (Entry<K, V> entry : buckets[i]) {
                    System.out.print("[" + entry.key + "] ");
                }
                System.out.println();
            }
        }
    }
}
