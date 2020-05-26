package Task21.LinkedList;

import org.junit.*;

import java.util.Iterator;

public class MyLinkedListTest {
    MyLinkedList<Integer> myLinkedList;

    @Before
    public void init(){
        myLinkedList = new MyLinkedList<Integer>();
        for (int i = 0; i < 5; i++) {
            myLinkedList.add(i);
        }
    }

    @Test
    public void size(){
        int size = myLinkedList.size();
        Assert.assertEquals(5,size);
    }

    @Test
    public void sizeAfterAdd(){
        myLinkedList.add(5);
        int size = myLinkedList.size();
        Assert.assertEquals(6,size);
    }

    @Test
    public void get(){
        int result = myLinkedList.get(1);
        Assert.assertEquals(1,result);
    }

    @Test
    public void getAfterAdd(){
        myLinkedList.add(6);
        int result = myLinkedList.get(myLinkedList.size()-1);
        Assert.assertEquals(6,result);
    }



    @Test
    public void add(){
        myLinkedList.add(5);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < myLinkedList.size(); i++) {
            sb.append(myLinkedList.get(i));
        }
        Assert.assertEquals("012345", sb.toString());
    }

    @Test
    public void addAfterAdd(){
        myLinkedList.add(5);
        myLinkedList.add(6);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < myLinkedList.size(); i++) {
            sb.append(myLinkedList.get(i));
        }
        Assert.assertEquals("0123456", sb.toString());
    }

    @Test
    public void addFirst(){
        myLinkedList.addFirst(5);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < myLinkedList.size(); i++) {
            sb.append(myLinkedList.get(i));
        }
        Assert.assertEquals("501234", sb.toString());
    }

    @Test
    public void equalsTrue(){
        MyLinkedList<Integer> myLinkedList2 = new MyLinkedList<Integer>();
        for (int i = 0; i < 5; i++) {
            myLinkedList2.add(i);
        }
        Assert.assertTrue(myLinkedList.equals(myLinkedList2));
    }

    @Test
    public void equalsFalse(){
        MyLinkedList<Integer> myLinkedList2 = new MyLinkedList<Integer>();
        for (int i = 0; i < 6; i++) {
            myLinkedList2.add(i);
        }
        Assert.assertFalse(myLinkedList.equals(myLinkedList2));
    }

    @Test
    public void indexOf(){
        int result = myLinkedList.indexOf(4);
        Assert.assertEquals(4, result);
    }

    @Test
    public void remove(){
        myLinkedList.remove(2);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < myLinkedList.size(); i++) {
            sb.append(myLinkedList.get(i));
        }
        Assert.assertEquals("0123", sb.toString());
    }

    @Test
    public void removeAfterAdd(){
        myLinkedList.add(5);
        myLinkedList.remove(myLinkedList.size()-1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < myLinkedList.size(); i++) {
            sb.append(myLinkedList.get(i));
        }
        Assert.assertEquals("01234", sb.toString());
    }

    @Test
    public void removeAfterRemove(){
        myLinkedList.remove(myLinkedList.size()-1);
        myLinkedList.remove(myLinkedList.size()-1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < myLinkedList.size(); i++) {
            sb.append(myLinkedList.get(i));
        }
        Assert.assertEquals("012", sb.toString());
    }
}
