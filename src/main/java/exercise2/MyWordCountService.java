package exercise2;

import java.util.HashMap;
import java.util.Map;

// Note: StringBuilder should be use if there is any performance issue.

public class MyWordCountService implements WordCountService {
  public Map<String, Integer> countWords(String text) {

    Map<String, Integer> myMap = new HashMap<String, Integer>();

    // Replace punctuation by spaces.
    text = text.replaceAll( "(\\.+|,+|;+|-+)" , " ").trim();

    // Replace multiple spaces for just one space
    text = text.replaceAll("\\s+"," ");

    // Not case sensitive count, Hello = hello = HEllo
    text = text.toLowerCase();

    // Check for no words then return null
    if(! (text.matches(".*[a-z].*") || text.matches(".*[0-9].*")) )
      return null;

    // Load words into an array
    String[] arrStrWords =  text.split("\\s+");

    for (String word : arrStrWords) {
      if (! myMap.containsKey(word))
        myMap.put(word,1);
      else
        myMap.put(word, myMap.get(word) + 1);
    }

    return myMap;
  }
}
