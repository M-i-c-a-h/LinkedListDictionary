import java.util.Iterator;

public class LinkedListDictionary<K ,V> implements Dictionary<K,V>{

    private Node front;
    private Node back;
    private int size;

    private class Node{
        K key;
        V value;
        Node next;
        Node(K newKey, V newValue){
            super();
            key = newKey;
            value = newValue;
        }
    }

    private class LinkedListIterator implements Iterator<K> {
        Node cursor;
        private LinkedListIterator() {
            cursor = front;
        }
        @Override
        public boolean hasNext() {
            return cursor != null;
        }
        @Override
        public K next() {
            K toRet = cursor.key;
            cursor = cursor.next;
            return toRet;
        }
    }

    @Override
    public void insert(K key, V value) {
        Node toAdd = new Node(key,value);
        if(front == null){
            front = toAdd;
            back = toAdd;
            size = 1;
        } else {
            back.next = toAdd;
            back = back.next;
            size++;
        }
    }

    @Override
    public V find(K key) {
        Node cursor = front;
        while(cursor != null){
            if (cursor.key.equals(key)){
                return cursor.value;
            }
            cursor = cursor.next;
        }
        return null;
    }

    @Override
    public boolean delete(K key) {

        // if front is null return false
        if(front == null){
            return false;
        }
        // check if front of list has desired key
        if(front.key.equals(key)){
            front = front.next;
            if(size == 1){
                back = front;
            }
            size--;
            return true;
        }
        Node cursor = front;

        while(cursor != null){
            // if cursor has a next -check key value
            if (cursor.next != null && cursor.next.key.equals(key)){
                if(cursor.next == back){
                    back = cursor;
                }
                cursor.next = cursor.next.next;
                size--;
                return true;
            }
            cursor = cursor.next;
        }
        return false;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Iterator<K> iterator() {
        return new LinkedListIterator();
    }

}
