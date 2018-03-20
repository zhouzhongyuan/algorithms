import java.util.Arrays;

public class QuickFindUF {
    private int[] id;
    private int count;
    public QuickFindUF(int N)
    {
        count = N;
        id = new int[N];
        for(int i = 0; i < N; i++){
            id[i] = i;
        }
    }
    public int count(){
        return count;
    }
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }
    // quick-find
    public int find(int p){
        return id[p];
    }
    public void union(int p, int q){
        int pID = find(p);
        int qID = find(q);
        if(pID == qID){
            return ;
        }
        for (int i = 0; i < id.length; i++) {
            if(id[i] == pID){
                id[i] = qID;
            }
        }
        count--;
    }
    public static void main(String[] args){
        int N = StdIn.readInt();
        StdOut.println(N + " " + N);
        QuickFindUF quickFindUF = new QuickFindUF(N);
        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            StdOut.println(p + " " + q);
            if(quickFindUF.connected(p, q)){
                continue;
            }
            quickFindUF.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(quickFindUF.count() + " components");
    }

}
