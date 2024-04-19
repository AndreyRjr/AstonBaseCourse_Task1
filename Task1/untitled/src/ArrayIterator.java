import java.util.Iterator;

public class ArrayIterator<E> implements Iterator {

    private int inndex = 0;
    private E[] values;

    ArrayIterator(E[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return inndex < values.length;
    }

    public E next() {
        return values[inndex++];
    }

}
