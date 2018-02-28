package exercise2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class Main {


  public static void main(String[] args) {

    String myString = "Default string, oh yeah default";

    Main myMain = new Main();

    // In the future file name could be taken by properties.
    myString = myMain.getFile("wordcount-test-sample_war_of_the_worlds.txt");

    MyWordCountService myWordCountService = new MyWordCountService();

    Map<String, Integer> myMap = myWordCountService.countWords(myString);

    if (myMap != null ) {
      for (String word: myMap.keySet()) {
        System.out.println("Word: " + word + " --> " + myMap.get(word) + " times");
      }
    }

  }

  private String getFile(String fileName) {

    StringBuilder result = new StringBuilder("");

    //Get file from resources folder
    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource(fileName).getFile());

    try {
      Scanner scanner = new Scanner(file);
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        result.append(line).append("\n");
      }

      scanner.close();
    }
    catch (FileNotFoundException ex)
    {
      System.out.println("Optional file " + fileName + " was not found." + ex);
    }

    return result.toString();

  }

}
