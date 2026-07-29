package datastructures;

public class CustomHashSet<T> {

    private final CustomHashTable<T, Boolean> table;

    public CustomHashSet() {
        table = new CustomHashTable<>();
    }

    public boolean add(T element) {
        if (table.containsKey(element)) {
            return false;
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
