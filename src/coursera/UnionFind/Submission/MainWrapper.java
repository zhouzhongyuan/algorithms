import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainWrapper {
    public static void main(String[] args) throws IOException {
        FileInputStream is = new FileInputStream(new File("./src/coursera/UnionFind/Submission/wayne98.txt"));
        System.setIn(is);
        Percolation.main(args);
    }
}
