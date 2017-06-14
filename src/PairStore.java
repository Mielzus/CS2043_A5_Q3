/**
 * Created by Jason on 2017-06-13.
 */

public class PairStore {

    /** Total capacity of the arrays **/
    private int capacity;
    /** Number of pairs currently stored **/
    private int position;

    /** The left hand values **/
    private String[] keys;
    /** The right hand values **/
    private String[] values;

    /**
     * Creates a new array pair with a fixed length of 10
     */
    public PairStore() {
        capacity = 10;
        position = 0;
        keys = new String[capacity];
        values = new String[capacity];
    }

    /**
     * Creates a new array pair with a length of the input value
     * @param capacity How big to create the initial array storage
     */
    public PairStore(int capacity) {
        this.capacity = capacity;
        keys = new String[capacity];
        values = new String[capacity];
    }

    /**
     * Doubles the length of the array pair and copies the existing entries
     */
    private void increaseCapacity() {
        String[] tempKeys = keys;
        String[] tempValues = values;
        if(capacity == 0) {
            capacity = 5;
            keys = new String[capacity];
            values = new String[capacity];
        }
        else {
            capacity *= 2;
            keys = new String[capacity];
            values = new String[capacity];
            System.arraycopy(tempKeys, 0, keys, 0, position);
            System.arraycopy(tempValues, 0, values, 0, position);
        }
    }

    /**
     * Deletes all values
     */
    public void clear() {
        keys = new String[capacity];
        values = new String[capacity];
        position = 0;
    }

    /**
     * Returns how many pairs are stored
     * @return The number of pairs stored in the arrays
     */
    public int size() {
        return position;
    }

    /**
     * Adds a new pair to the arrays
     * @param s1 The left hand value to store
     * @param s2 The right hand value to store
     * @return whether the insert operation was successful
     */
    public boolean put (String s1, String s2) {
        if(position >= capacity) {
            increaseCapacity();
        }
        keys[position] = s1;
        values[position] = s2;
        position++;
        return true;
    }

    /**
     * Searches for a pair value based on the left or right hand value
     * @param s1 The left hand value. If null it will be searched for using the right value
     * @param s2 The right hand value. If null it will be searched for using the left value
     * @return The found string, "No value found" if none found
     */
    public String get(String s1, String s2) {
        String value;
        for(int i = 0; i < capacity; i++) {
            if(s1 == null && s2 != null) {
                value = values[i];
                if(value.equals(s2)) {
                    value = keys[i];
                    System.out.print("Searching for " + s2 + ", found ");
                    return value;
                }
            }
            else if (s2 == null && s1 != null) {
                value = keys[i];
                if(value.equals(s1)) {
                    value = values[i];
                    System.out.print("Searching for " + s1 + ", found ");
                    return value;
                }
            }
        }
        return null;
    }
}
