package Task21.ChangalbeCollection;

import org.junit.*;

import java.util.Iterator;

public class ChangeableCollectionTest {
    ChangeableCollection<Integer> collection;

    @Before
    public void init(){
        Integer[] tempData = new Integer[5];
        for (int i = 0; i < tempData.length; i++) {
            tempData[i] = i;
        }
        collection = new ChangeableCollection<Integer>(tempData);
    }

    @Test
    public void add(){
        collection.add(5);
        collection.add(6);
        Iterator<Integer> iterator = collection.iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()){
            sb.append(iterator.next());
        }
        Assert.assertEquals("0123456", sb.toString());
    }

    @Test
    public void sizeDefault(){
        int result = collection.size();
        Assert.assertEquals(5, result);
    }

    @Test
    public void sizeAfterAdd(){
        collection.add(5);
        int result = collection.size();
        Assert.assertEquals(6, result);
    }

    @Test
    public void iterator(){
        Iterator<Integer> iterator = collection.iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()){
            sb.append(iterator.next());
        }
        Assert.assertEquals("01234", sb.toString());
    }

    @Test
    public void iteratorAfterAdd(){
        collection.add(5);
        Iterator<Integer> iterator = collection.iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()){
            sb.append(iterator.next());
        }
        Assert.assertEquals("012345", sb.toString());
    }

    @Test
    public void iteratorAfterRemove(){
        collection.remove(5);
        Iterator<Integer> iterator = collection.iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()){
            sb.append(iterator.next());
        }
        Assert.assertEquals("0123", sb.toString());
    }

    @Test
    public void equalsTrue(){
        Integer[] tempArray = new Integer[5];
        for (int i = 0; i < 5; i++) {
            tempArray[i] = i;
        }
        ChangeableCollection<Integer> tempData = new ChangeableCollection<>(tempArray);
        Assert.assertTrue(collection.equals(tempData));
    }

    @Test
    public void equalsFalse(){
        Integer[] tempArray = new Integer[5];
        for (int i = 0; i < 5; i++) {
            tempArray[i] = i;
        }
        ChangeableCollection<Integer> tempData = new ChangeableCollection<>(tempArray);
        Assert.assertTrue(collection.equals(tempData));
    }

    @Test
    public void removeFirstElement(){
        collection.remove(0);
        Iterator<Integer> iterator = collection.iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()){
            sb.append(iterator.next());
        }
        Assert.assertEquals("1234", sb.toString());
    }

    @Test
    public void removeMiddleElement(){
        collection.remove(3);
        Iterator<Integer> iterator = collection.iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()){
            sb.append(iterator.next());
        }
        Assert.assertEquals("0124", sb.toString());
    }

    @Test
    public void removeLastElement(){
        collection.remove(5);
        Iterator<Integer> iterator = collection.iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()){
            sb.append(iterator.next());
        }
        Assert.assertEquals("0123", sb.toString());
    }

    @Test
    public void removeAfterAdd(){
        collection.add(5);
        collection.remove(0);
        Iterator<Integer> iterator = collection.iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()){
            sb.append(iterator.next());
        }
        Assert.assertEquals("12345", sb.toString());
    }

    @Test
    public void removeAfterRemove(){
        collection.remove(0);
        collection.remove(0);
        Iterator<Integer> iterator = collection.iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()){
            sb.append(iterator.next());
        }
        Assert.assertEquals("234", sb.toString());
    }

    @Test
    public void removeElementAfterAddThisElement(){
        collection.add(0);
        collection.remove(5);
        Iterator<Integer> iterator = collection.iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()){
            sb.append(iterator.next());
        }
        Assert.assertEquals("01234", sb.toString());
    }

    @Test
    public void removeOtherElementAfterAdd(){
        collection.add(0);
        collection.remove(3);
        Iterator<Integer> iterator = collection.iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()){
            sb.append(iterator.next());
        }
        Assert.assertEquals("01240", sb.toString());
    }
}
