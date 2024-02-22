import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Iterator;


public class DictionaryTest {
    // Do not modify this function. All your tests should use newDictionary() to generate the dictionary reference.
    public Dictionary<Integer,String> newDictionary() {
        return new LinkedListDictionary<Integer,String>();
    }
    /**
     * TEST getSize()
     */
    //***   TEST EmptyGetSize
    @Test
    void testEmptyGetSize(){
        Dictionary<Integer, String> dict = newDictionary();
        assertEquals(0, dict.getSize());
    }
    //***   TEST SingleGetSize
    @Test
    void testSingleGetSize(){
        Dictionary<Integer, String> dict = newDictionary();
        dict.insert(3, "three");
        assertEquals(1, dict.getSize());
    }
    //***   TEST SingleGetSize
    @Test
    void testMultipleGetSize(){
        Dictionary<Integer, String> dict = newDictionary();
        int size = 0;
        for(int i=0; i<10; i++){
            dict.insert(i, "value");
            size++;
            assertEquals(size, dict.getSize(), "Incorrect multiple element getSize behavior");
        }
    }
    /**
     * TEST find()
     */
    //***   TEST EmptyFind
    @Test
    void testEmptyFind(){
        Dictionary<Integer,String> dict = newDictionary();
        assertNull(dict.find(3),"Incorrect empty find behavior");
    }
    //***   TEST SingleFind
    @Test
    void testSingleFind(){
        Dictionary<Integer,String> dict = newDictionary();
        dict.insert(3,"three");
        assertEquals("three",dict.find(3),"Incorrect single element find behavior");
    }
    //***   TEST ManyFind
    @Test
    void multipleFind(){
        Dictionary<Integer, String> dict = newDictionary();
        dict.insert(3,"three");
        dict.insert(4, "four");
        dict.insert(5, "five");
        dict.insert(6, "six");
        dict.insert(7, "seven");

        for(int i=3; i<=7; i++){
            assertNotNull(dict.find(i), "Incorrect many element find behavior");
        }
    }
    /**
     * TEST delete()
     */
    //***   TEST EmptyDelete
    @Test
    void emptyDelete(){
        Dictionary<Integer,String> dict = newDictionary();
        assertFalse(dict.delete(3));
        assertEquals(0, dict.getSize(),"Incorrect emptyDelete behavior");
    }
    //***   TEST SingleDelete
    @Test
    void testSingleDelete(){
        Dictionary<Integer,String> dict = newDictionary();
        dict.insert(3,"three");
        assertTrue(dict.delete(3));
        assertNull(dict.find(3),"Incorrect single element delete behavior");
    }
    //***   TEST ManyDelete
    @Test
    void testManyDelete(){
        Dictionary<Integer, String> dict = newDictionary();
        dict.insert(3,"three");
        dict.insert(4, "four");
        dict.insert(5, "five");
        dict.insert(6, "six");
        dict.insert(7, "seven");
        int size = dict.getSize();

        for(int i=3; i<=7; i++){
            assertTrue(dict.delete(i), "Incorrect multiple delete behavior");
            assertEquals(size-1, dict.getSize(), "Incorrect size for multiple delete");
            size--;
        }

    }
    //** TEST EmptyDeleteInsert
    @Test
    void testRandomDelete(){
        Dictionary<Integer, String> dict = newDictionary();
        dict.insert(3,"three");
        dict.insert(4, "four");
        dict.insert(5, "five");
        dict.insert(6, "six");
        dict.insert(7, "seven");

        for(int i=3; i<=7; i++){
            if( i % 2 != 0){
                dict.delete(i);
            }
        }
        assertEquals(2, dict.getSize(), "Incorrect random delete behavior");

        Iterator<Integer> iter = dict.iterator();
        assertEquals(4, iter.next(),"Incorrect first element in random delete test");

        int last = -1;
        while(iter.hasNext()){
            last = iter.next();
        }
        assertEquals(6,last, "Incorrect last element in random delete test");

    }
    //*** TEST DeleteLastElement with insertion for single element
    @Test
    void testDeleteLastElementSingle(){
        Dictionary<Integer, String> dict = newDictionary();
        dict.insert(3,"three");
        assertTrue(dict.delete(3), "Incorrect delete of last element");

        dict.insert(4, "four");
        Iterator<Integer> iter = dict.iterator();
        // check last/first element in list
        assertEquals(4, iter.next(), "Incorrect list order after last element delete");
    }
    //*** TEST DeleteLastElement with Insertion for 2 element
    @Test
    void testDeleteLastElement(){
        Dictionary<Integer, String> dict = newDictionary();
        dict.insert(3,"three");
        dict.insert(4, "four");
        assertTrue(dict.delete(4),"Incorrect delete of last element");
        dict.insert(5,"five");

        Iterator<Integer> iter = dict.iterator();
        iter.next();   // set cursor to last element in a list of 2
        assertEquals(5, iter.next(), "Incorrect list order after last element delete");
    }
    /**
     * TEST insert()
     */
    //***   TEST EmptyInsert
    @Test
    void testEmptyInsert(){
        Dictionary<Integer, String> dict = newDictionary();
        assertEquals(0, dict.getSize(), "Incorrect size for empty insert");

    }
    //*** TEST SingleInsert
    @Test
    void testSingleInsert(){
        Dictionary<Integer, String> dict = newDictionary();
        assertEquals(0, dict.getSize(), "Incorrect size for single insert");
        dict.insert(3, "three");
        assertEquals(1, dict.getSize(), "Incorrect size for single insert");
        assertNotNull(dict.find(3), "Incorrect single element find for previous single insert");
    }
    //*** TEST MultipleInsert
    @Test
    void testMultipleInsert(){
        Dictionary<Integer, String> dict = newDictionary();
        dict.insert(3,"three");
        dict.insert(4, "four");
        dict.insert(5, "five");
        dict.insert(6, "six");
        dict.insert(7, "seven");
        int size = dict.getSize();

        assertEquals(5, size, "Incorrect size for multiple insert");
        for(int i=3; i<=7; i++){
            assertNotNull(dict.find(i), "Incorrect multiple element insert behavior");
        }
    }
    //*** TEST Insert after delete of last element
    @Test
    void testInsertAfterLastElementDelete(){
        Dictionary<Integer, String> dict = newDictionary();
        dict.insert(3,"three");
        dict.insert(4, "four");
        dict.insert(5, "five");
        assertTrue(dict.delete(5), "Incorrect delete of last element after insertion");

        dict.insert(6,"six");
        assertEquals("six",dict.find(6), "Incorrect behavior of list insertion after deletion of last element");
    }
    /**
     * TEST Iterator
     */
    //***   TEST IteratorEmpty
    @Test
    void testIteratorEmpty(){
        Dictionary<Integer, String> dict = newDictionary();
        assertEquals(0, dict.getSize());
        Iterator<Integer> iter = dict.iterator();
        assertFalse(iter.hasNext(), "Incorrect empty element hasNext Iterator behavior");

    }
    //***   TEST IteratorSingle
    @Test
    void testIteratorSingle(){
        Dictionary<Integer,String> dict = newDictionary();
        dict.insert(3,"three");
        Iterator<Integer> iter = dict.iterator();
        assertTrue(iter.hasNext(), "Incorrect single element hasNext Iterator behavior");
        assertEquals(3,iter.next(), "Incorrect single element iterator behavior");
        assertFalse(iter.hasNext(), "Incorrect emptied hasNext Iterator behavior");
    }
    //***   TEST IteratorMultiple
    @Test
    void testIteratorMultiple(){
        Dictionary<Integer, String> dict = newDictionary();
        dict.insert(3,"three");
        dict.insert(4, "four");
        dict.insert(5, "five");
        dict.insert(6, "six");
        dict.insert(7, "seven");
        int size = dict.getSize();
        int count = 0;
        int val = 3;

        Iterator<Integer> iter = dict.iterator();
        while(iter.hasNext()){
            count++;
            assertEquals(val, iter.next());
            val++;
        }
        assertEquals(size, count);
    }
}