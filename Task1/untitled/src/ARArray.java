import java.util.Iterator;

public class ARArray<E> implements SimpleFunctions<E> {

    public static void main (String[] aer) {
        SimpleFunctions<String> myStrings = new ARArray<>();
        myStrings.add("AaA");
        myStrings.add("BbB");
        myStrings.add("CcC");
        myStrings.add("DdD");

        //myStrings.update(2, "New string");
        //myStrings.delete(0);

        System.out.println(myStrings.get(2));
        System.out.println(myStrings.size());
    }

    private E[] values;

    public ARArray() {
        values = (E[]) new Object[0];

    }


    @Override
    public boolean add(E e) {
        try {
            E[] temp =  values;
            values = (E[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, values, 0, temp.length);
            values[values.length - 1] = e;
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public void delete(int index) {
        try {
            E[] temp =  values;
            values = (E[]) new Object[temp.length - 1];
            System.arraycopy(temp, 0, values, 0, index);
            int amountElAftIndex = temp.length - index - 1;
            System.arraycopy(temp, index + 1, values, index, amountElAftIndex);
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public E get(int index) {
        return values[index];
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public void update(int index, E e) {
        values[index] = e;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>(values);
    }
}