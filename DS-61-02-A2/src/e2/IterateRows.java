package e2;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class IterateRows implements Iterator<Integer> {

    private final Matrix matrix;
    private int col;
    private int row;

    public IterateRows( Matrix matrix){
        this.matrix=matrix;
        this.col=-1;
        this.row=0;
    }

    @Override
    public boolean hasNext() {
        return (col+1)*(row+1) < (matrix.getCol())* (matrix.getRow());
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
        if(++col == matrix.getCol()){
            row++;
            col=0;
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove isn't implemented, do not call it");
    }


}
