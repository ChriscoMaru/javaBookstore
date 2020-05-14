  
import java.util.*;
import java.util.stream.*;
import java.nio.file.*;
import java.io.*;

public class utils {
    
    public static void loadStringsToArray(ArrayList<String> arrList) throws IOException {
    Path path = Paths.get("BookTitles.txt");
    arrList.clear();

    // The stream file will also be closed here
    try (Stream<String> lines = Files.lines(path))
    {
      Object[] arr = lines.toArray();

      for(Object t: arr)
      {
        arrList.add(t.toString());
      }
    }
  }
}