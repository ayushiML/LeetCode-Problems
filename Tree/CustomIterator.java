package Tree;

import java.util.Iterator;

public class CustomIterator implements Iterable<E> {

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        Iterator<E> i = new Iterator<E>(){

            @Override
            public boolean hasNext() {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public E next() {
                // TODO Auto-generated method stub
                return null;
            }

            
        };
        return null;
    }
    
}
