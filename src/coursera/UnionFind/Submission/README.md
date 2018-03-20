# Percolation

## 概念
- percolation system:  建模成一个n*n格子（site）组成的grid
- site: 格子
- site 具有open/blocked性质
- full site： 一个 能被top row的open site连接的open site
- percolate: there is a full site in the bottom row

## run

Option 1

```
java -cp ./lib/stdlib.jar:./out/production/algorithms Percolation  < ./src/coursera/UnionFind/Submission/wayne98.txt
```

Option 2:
// https://stackoverflow.com/questions/42867756/intellij-idea-run-java-with-args-from-external-file/42869805#42869805
```java
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainWrapper {
  public static void main(String[] args) throws IOException {
    FileInputStream is = new FileInputStream(new File("1.txt"));
    System.setIn(is);
    Main.main(args);
  }
}

```
