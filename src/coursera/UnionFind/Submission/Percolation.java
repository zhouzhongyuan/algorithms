public class Percolation {
    public int n;
    private int[] id;
    private int[][] grid;
    private int number;
    public Percolation(int N){
        n = N;
        id = new int[n*n];
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = 0;
                int order = i*n+j;
                id[order] = order;
            }
        }

    }

    public boolean connected(int row1, int col1, int row2, int col2){
        return find(row1,col1) == find(row2,col2);
    }

    public int find(int row, int col){
        return id[row*grid[0].length + col];
    }
    public void union(int row1, int col1, int row2, int col2){
        if(row1 < 0 || row1 >= n || col1 < 0 || col1 >= n || row2 < 0 || row2 >= n || col2 < 0 || col2 >= n ){
            return;
        }
        if(grid[row1][col1] == 0){
            return;
        }
        int pID = find(row1, col1);
        int qID = find(row2, col2);
        if(pID == qID){
            return ;
        }
        for (int i = 0; i < id.length; i++) {
            if(id[i] == pID){
                id[i] = qID;
            }
        }
    }


    // open site (row, col) if it is not open already
    public void open(int row, int col){
        if(!isOpen(row, col)){
            grid[row][col] = 1;
            //紧邻的四个点union
            union((row-1),col,row,col);
            union((row+1),col,row,col);
            union(row,(col-1),row,col);
            union(row,(col+1),row,col);
            number++;
        }

    }
    // is site (row, col) open?
    public boolean isOpen(int row, int col){
//        StdOut.println( " grid (" + row + "," + col + ") = " + grid[row][col] );
        return grid[row][col] == 1 ? true: false;

    }
    // is site (row, col) full?
    public boolean isFull(int row, int col){
        if (isOpen(row,col) == false) {
            return false;
        }
        // 第一行的点与此点有没有连通
        boolean isFull = false;
        for (int i = 0; i < grid[0].length ; i++) {
            if(connected((0),i,row,col)){
                isFull = true;
                break;
            }
        }
//        StdOut.println( " full ?" + isFull );
        return isFull;

    }
    // number of open sites
    public int numberOfOpenSites(){
        return number;
    }
    // does the system percolate?
    public boolean precolates(){
        boolean isPercolate = false;
        for (int i = 0; i < n; i++) {
            if(isFull((n-1),i)){
                isPercolate = true;
                break;
            }
        }
        return isPercolate;
    }
    // test client (optional)
    public static void main(String[] args){
/*        int N = StdIn.readInt();
        Percolation percolation = new Percolation(N);


        while (!StdIn.isEmpty()) {
            int row = StdIn.readInt() - 1;
            int col = StdIn.readInt() -1;
            if (percolation.isOpen(row, col)) {
                continue;
            }
            percolation.open(row, col);
        }
        if(percolation.precolates()){
            StdOut.println( " IS precolate");
        }else{
            StdOut.println( " NOT precolate");
        }
        StdOut.println(percolation.numberOfOpenSites() + " components");*/
    }
}
