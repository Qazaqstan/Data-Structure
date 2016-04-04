
package ArrayList;

public class MyList <T> {
    
    private T[] data;
    private int size;
    private int currentSize;
    private static final int DEFAULT_SIZE = 10;
    
    public MyList () {
        this(DEFAULT_SIZE);
    }
    
    public MyList (int size) {
        this.size = size;
        data = (T[]) new Object[size];
        currentSize = 0;
    }
    
    public int size () {
        return currentSize;
    }
    
    public void update (int index, T d) {
        if (index < 0 || currentSize <= index) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        data[index] = d;
    }
    
    
    public T get (int index) {
        if (index < 0 || currentSize <= index) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return data[index];
    }
    
    public void remove (int index) {
        if (index < 0 || currentSize <= index) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        else if (currentSize == 0) {
                throw new RuntimeException("List is empty");
        }
        else {
            T o = data[index];
            while (index < currentSize - 1) {
                data[index] = data[index + 1];
                index++;
            }
            data[index] = null;
            currentSize--;
        }
    }
    
    public void removeLastElement () {
        if (currentSize == 0) {
            throw new RuntimeException("List is empty");
        }
        remove(currentSize - 1);
    }
    
    public void removeFirstElement () {
        remove(0);
    }
    
    public void add (T a) {
        if (currentSize == size) {
            size *= 2;
            T[] datanew = (T[]) new Object[size];
            for (int i = 0; i < currentSize; i++) {
                datanew[i] = data[i];
            }
            data = datanew;
            size = size + 1;
        }
        data[currentSize] = a;
        currentSize++;
    }
    
    public static void main(String[] args) {
        MyList<Integer> ml = new MyList();
        ml.add(1);
        ml.add(2);
        ml.add(3);
        ml.add(4);
        ml.add(99);
        ml.add(6);
        ml.add(7);
        ml.add(8);
        ml.add(9);
        ml.add(10);
        ml.add(11);
        for (int i = 0; i < ml.size(); i++) {
            System.out.print(ml.get(i) + " ");
        }
        System.out.println();
        ml.remove(9);
        for (int i = 0; i < ml.size(); i++) {
            System.out.print(ml.get(i) + " ");
        }
        System.out.println();
        ml.removeFirstElement();
        for (int i = 0; i < ml.size(); i++) {
            System.out.print(ml.get(i) + " ");
        }
        System.out.println();
        ml.removeLastElement();
        for (int i = 0; i < ml.size(); i++) {
            System.out.print(ml.get(i) + " ");
        }
        System.out.println();
        ml.removeFirstElement();
        for (int i = 0; i < ml.size(); i++) {
            System.out.print(ml.get(i) + " ");
        }
        System.out.println();
        ml.removeLastElement();
        for (int i = 0; i < ml.size(); i++) {
            System.out.print(ml.get(i) + " ");
        }
        System.out.println();
    }
}
