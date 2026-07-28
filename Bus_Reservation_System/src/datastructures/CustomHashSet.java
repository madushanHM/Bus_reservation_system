package datastructures;

/**
 * Custom Set ADT (Member 6 Assignment)
 *
 * Built directly on top of CustomHashTable, storing each element as a KEY
 * (the value is just a placeholder). This gives us O(1) average-time
 * duplicate checking, which is exactly what a Set needs.
 *
 * Use case in this project: preventing the same seat on the same bus from
 * being booked twice (e.g. key = "BUS12_SEAT5").
 *
 * Complexity:
 *   Average case: O(1) for add / contains / remove
 *   Worst case:   O(n) (same reasoning as the underlying hash table)
 *   Space:        O(n)
 */
public class CustomHashSet<T> {

    private final CustomHashTable<T, Boolean> table;

    public CustomHashSet() {
        table = new CustomHashTable<>();
    }

    // Returns true if the element was newly added,
    // returns false if it was already present (duplicate detected)
    public boolean add(T element) {
        if (table.containsKey(element)) {
            return false; // duplicate - reject
        }
        table.put(element, Boolean.TRUE);
        return true;
    }

    public boolean contains(T element) {
        return table.containsKey(element);
    }

    public boolean remove(T element) {
        return table.remove(element);
    }

    public int size() {
        return table.getSize();
    }
}
