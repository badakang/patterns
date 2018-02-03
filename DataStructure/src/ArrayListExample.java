public class ArrayListExample {

    public static void main(String[] args) {
        ArrayList numbers = new ArrayList();
        numbers.addLast(10);
        numbers.addLast(20);
        numbers.addLast(30);
        numbers.addLast(40);
        
        // numbers.add(1, 15);
        // numbers.addFirst(5);
        // System.out.println(numbers);
        // System.out.println(numbers.remove(1));
        // System.out.println(numbers);
        // System.out.println(numbers.removeFirst());
        // System.out.println(numbers);
        // System.out.println(numbers.removeLast());
        // System.out.println(numbers);
        // System.out.println(numbers.get(1));
        // System.out.println(numbers.size());
        // System.out.println(numbers.length());
        // System.out.println(numbers.indexOf(20));
        // System.out.println(numbers.indexOf(70));

        // for (int i = 0; i < numbers.size(); i++) {
        // System.out.println(numbers.get(i));
        // }

        ArrayList.ListIterator li = numbers.listIterator();

        // while(true) {
        while (li.hasNext()) {
            System.out.println(li.next());
        }

        // li.next();
        // li.next();
        // li.previous();

        while (li.hasPrevious()) {
            System.out.println(li.previous());
        }
        System.out.println("add ===========================");
        while (li.hasNext()) {
            int number = (int) li.next();
            if (number == 30) {
//                li.add(35);
                li.remove();
            }
            System.out.println("number:" + number);
        }
        System.out.println("numbers:" + numbers);
    }
}

class ArrayList {

    private int size = 0;
    private Object[] elementData = new Object[100];

    boolean addFirst(Object element) {
        add(0, element);
        return true;
    }

    boolean addLast(Object element) {
        elementData[size] = element;
        size++;
        return true;
    }

    boolean add(int index, Object element) {
        for (int i = size - 1; i >= index; i--) {
            elementData[i + 1] = elementData[i];
        }
        elementData[index] = element;
        size++;
        return true;
    }

    Object remove(int index) {
        Object removed = elementData[index];
        for (int i = index + 1; i < size - 1; i++) {
            elementData[i - 1] = elementData[i];
        }
        size--;
        elementData[size] = null;
        return removed;
    }

    Object removeFirst() {
        return remove(0);
    }

    Object removeLast() {
        return remove(size - 1);
    }

    Object get(int index) {
        return elementData[index];
    }

    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    int size() {
        return size;
    }

    int length() {
        return elementData.length;
    }

    public ListIterator listIterator() {
        return new ListIterator();
    }

    public String toString() {
        String str = "[";
        for (int i = 0; i < size; i++) {
            str += elementData[i];
            if (i < size - 1) {
                str += ",";
            }
        }
        return str + "]";
    }

    class ListIterator {
        private int nextIndex = 0;

        public boolean hasNext() {
            return nextIndex < size();
        }

        public Object next() {
            return elementData[nextIndex++];
        }

        public Object previous() {
            return elementData[--nextIndex];
        }

        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        public void add(Object element) {
            ArrayList.this.add(nextIndex++, element);
        }

        public void remove() {
//            ArrayList.this.remove(--nextIndex);
            ArrayList.this.remove(nextIndex-1);
            nextIndex--;
        }

    }
}
