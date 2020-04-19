import java.util.Arrays;

public class MyVector <E> extends MyAbstractList<E>  {


    private E array[];
    private int increment;
    private int capacity;

    @SuppressWarnings("unchecked")
    public MyVector() {
        array = (E[]) new Object[10];
        size = 0;
        increment = 5;
        this.capacity = 10;
    }

    @SuppressWarnings("unchecked")
    public MyVector(int initCapacity) {
        array = (E[]) new Object[initCapacity];
        size = 0;
        increment = 5;
        this.capacity = initCapacity;
    }

    @SuppressWarnings("unchecked")
    public MyVector(int initCapacity, int capIncrement) {
        array = (E[]) new Object[initCapacity];
        size = 0;
        increment = capIncrement;
        this.capacity = initCapacity;
    }

    public String getId() {
        return "Program 6, FullNameHere";
    }

    public int getCapacity() {
        return array.length;
    }


    public int getIncrement() {
        return increment;
    }

    public boolean add(E data) {
        return this.add(size, data);
    }

    @Override
    public boolean add(int index, E data) {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException("Index out of bounds: " + index + ", size: " + size);

        int capacity = getCapacity();
        if (size >= capacity) {
            System.out.println("Capacity was increased");
            int newsize = array.length*2;
            if(this.increment != -1) {
                newsize = array.length + this.increment;
            }
            Object [] copyarr = new Object[newsize];
            for(int i = 0; i < size; i++) {
                copyarr[i] = array[i];
            }
            E [] castedcopy = (E[])copyarr;
            this.array = castedcopy;
            this.capacity = this.array.length;
        }


        for (int i = size - 1; i >= index; i--)
            array[i + 1] = array[i];

        array[index] = data;
        size += 1;

        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void clear() {

        int capacity = getCapacity();
        array = (E[]) new Object[capacity];
        size = 0;
    }

    public boolean contains(E data) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(data))
                return true;
        }
        return false;
    }
    @Override
    public E get(int index) {
        return array[index];
    }


    public int indexOf(E data) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(data))
                return i;
        }
        return -1;
    }

    public int lastIndexOf(E data) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(data))
                return i;
        }
        return -1;
    }
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException("Index out of bounds: " + index + ", size: " + size);

        E data = array[index];

        for (int i = index; i < size - 1; i++)
            array[i] = array[i + 1];

        array[size] = null;
        size -= 1;

        return data;
    }

    @Override
    public void trimToSize() {
        if (size < getCapacity()) {
            array = Arrays.copyOf(array, size);
        }
    }
    @Override
    public int size() {
        return super.size();
    }

    @Override
    public String toString() {
        String rs = "[";
        for(int i = 0; i < size; i++) {
            rs = rs + this.array[i].toString();
            if(i < size - 1) {
                rs = rs + ", ";
            }
        }
        rs = rs + "]";
        return rs;
    }
}