public interface Dictionary<K ,V> extends Iterable<K>{
    /**
     * Inserts a key, value pair into the dictionary
     * @param key the key to be inserted
     * @param value the value to be inserted paired with the key
     */
    public void insert(K key, V value);

    /**
     * Returns the value associated with a given key. Should return null if the key is not found
     * @param key the key to be searched for
     * @return the associated value or null if the key is not found
     */
    public V find(K key);

    /**
     * Removes the first instance of a given key K found in the dictionary and its corresponding value
     * @param key the key to be removed
     * @return true if the delete is successful, false if the key is not found.
     */
    public boolean delete(K key);

    /*
     * @return the number of elements in the dictionary
     */
    public int getSize();
}
