package e2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;

public class IterateColumns implements Iterator <Integer> {
    private final Matrix matrix;
    private int col;
    private int row;
    private final int totalSize;

    public IterateColumns( Matrix matrix){
        this.matrix=matrix;
        this.col=0;
        this.row=0;
        this.totalSize=matrix.getCol()* matrix.getRow();
    }

    @Override
    public boolean hasNext() {
        return col*row < totalSize;
    }


    @Override
    public Integer next() {

        if (hasNext()){
            updatePosition();
            return matrix.getMatrix()[row][col];
        }
        throw new NoSuchElementException();
    }

    public void updatePosition(){
        if(++row> matrix.getRow()){
            col++;
            row=0;
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove isn't implemented, do not call it");
    }

    @Override
    public void forEachRemaining(Consumer<? super Integer> action) {
        Objects.requireNonNull(action);
        while (hasNext())
            action.accept(next());
    }
}
