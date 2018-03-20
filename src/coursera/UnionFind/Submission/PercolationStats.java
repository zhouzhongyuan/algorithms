public class PercolationStats {
    private double[] x;
    private int T;
    private double sampleMean;
    private double sampleStandardDeviation;
    private double statsConfidenceLo;
    private double statsConfidenceHi;
    public PercolationStats(int n, int trials)    // perform trials independent experiments on an n-by-n grid
    {
        T = trials;
        x = new double[trials];
        for (int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(n);
            int j = 0;
            while(!percolation.precolates()){
                int row = StdRandom.uniform(n);
                int col = StdRandom.uniform(n);
                if (percolation.isOpen(row, col)) {
                    continue;
                }
                percolation.open(row, col);
                j++;
//                StdOut.println( "" + row +", " + col);
//                StdOut.println( " times:" + j);
//                if(percolation.precolates()){
////                    StdOut.println( " IS precolate");
//                }
            }
            double threshold = (double)(j-1)/(n*n);
            StdOut.println( "trials is " + threshold);
            x[i] = threshold;
        }





    }
    public double mean()                          // sample mean of percolation threshold
    {
        double sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += x[i];
        }
        double averge = sum / x.length;
        sampleMean = averge;
        return averge;

    }

    public double stddev()                        // sample standard deviation of percolation threshold
    {
        double standardDeviation = 0;
        for (int i = 0; i < x.length; i++) {
            standardDeviation += (standardDeviation - x[i]) * (standardDeviation - x[i]);
        }
        standardDeviation = standardDeviation/(x.length - 1);
        standardDeviation = Math.sqrt(standardDeviation);

        sampleStandardDeviation = standardDeviation;
        return standardDeviation;
    }
    public double confidenceLo()                  // low  endpoint of 95% confidence interval
    {
        double low = sampleMean - 1.96* sampleStandardDeviation/Math.sqrt(T);
        return low;

    }
    public double confidenceHi()                  // high endpoint of 95% confidence interval
    {
        double low = sampleMean + 1.96* sampleStandardDeviation/Math.sqrt(T);
        return low;
    }
    public static void main(String[] args)        // test client (described below)
    {
        PercolationStats percolationStats = new PercolationStats(200, 100);
        StdOut.println( "mean                      = " + percolationStats.mean());
        StdOut.println( "stddev                    = " + percolationStats.stddev());
        StdOut.println( "95% confidence interval   = [" + percolationStats.confidenceLo() + ", " + percolationStats.confidenceHi() + "]");

    }

}
