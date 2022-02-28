import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class Percolation {
	
	private static final int TOP = 0;
	private final boolean opened[][]; 
	private int size;
	private final int bottom;
	private int opensites;
	private final WeightedQuickUnionUF qf;
	

	public Percolation(int n) {
		if(n <= 0) {
			throw new IllegalArgumentException();
		}
		size= n;
		bottom = size*size +1;
		qf = new WeightedQuickUnionUF(size*size+2);
		opened = new boolean[size][size]; 
		opensites=0;

		
	}

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
    	checkException(row, col);
    	opened[row-1][col-1] = true;
    	
    	// edge case : first row elements
    	if(row==1) {
    		qf.union(getQuickFindIndex(row, col), TOP);
    	}
    	
    	// edge case: bottom row elements
    	if(row==size) {
    		qf.union(getQuickFindIndex(row, col), bottom);
    	}
    	
    	if(row> 1 && isOpen(row, col)) {
    		qf.union(getQuickFindIndex(row, col), getQuickFindIndex(row-1, col));
    	}

    	if(row< size && isOpen(row, col)) {
    		qf.union(getQuickFindIndex(row, col), getQuickFindIndex(row + 1, col));
    	}
    	
    	if(col > 1 && isOpen(row, col)) {
    		qf.union(getQuickFindIndex(row, col), getQuickFindIndex(row, col-1));
    	}
    	
    	if(col < size && isOpen(row, col)) {
    		qf.union(getQuickFindIndex(row, col), getQuickFindIndex(row, col+1));
    	}
    }
    
    private int getQuickFindIndex(int row, int col) {
    	return size*(row-1) + col;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
    	checkException(row, col);
    	return opened[row-1][col-1];
    	
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
    	if((row > 0 && row <= size) && (col >0 && col <=size)) {
    		return qf.find(TOP) == qf.find(getQuickFindIndex(row, col));
    	}else throw new IllegalArgumentException();
    	
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
    	return opensites;
    }

    // does the system percolate?
    public boolean percolates() {
    	return qf.find(TOP) == qf.find(bottom);
    }

    private void checkException(int row, int col) {
    	if(row <=0 || row > size || col <=0 || col >size) {
    		throw new IllegalArgumentException();
    	}
    }

    public static void main(String[] args) {
    	new Percolation(10);
    }
}


