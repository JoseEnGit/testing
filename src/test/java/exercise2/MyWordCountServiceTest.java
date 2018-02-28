package exercise2;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class MyWordCountServiceTest {
  @Test
  public void countWords() throws Exception {

    // Objects needed
    MyWordCountService myWordCountService = new MyWordCountService();

    Map<String, Integer> calledMap;

    Map<String, Integer> expectedMap = new HashMap<String, Integer>();

    ///////////////////////////
    // Test type: Basic
    /////////////////////////
    String stringTested = "Simple example, simple sentence ";

    expectedMap.put("simple", 2);
    expectedMap.put("example", 1);
    expectedMap.put("sentence", 1);

    calledMap = myWordCountService.countWords(stringTested);

    //Test equal, ignore order
    assertThat(calledMap, is(expectedMap));

    /////////////////////////
    // Test type: Empty input
    /////////////////////////
    stringTested = "";

    calledMap = myWordCountService.countWords(stringTested);

    assertNull("Should be null",calledMap);

    ///////////////////////////////
    // Test type: Invalid strings 1
    ///////////////////////////////
    stringTested = "  ";

    calledMap = myWordCountService.countWords(stringTested);

    assertNull("Should be null",calledMap);

    ///////////////////////////////
    // Test type: Invalid strings 2
    ///////////////////////////////
    stringTested = " ;;-.";

    calledMap = myWordCountService.countWords(stringTested);

    assertNull("Should be null",calledMap);


    /////////////////////////////////////////////
    // Test type: Random punctuation between words
    /////////////////////////////////////////////
    stringTested = "This ,, is   .. -   a ,;; test, a good test";

    expectedMap.clear();
    expectedMap.put("this", 1);
    expectedMap.put("is", 1);
    expectedMap.put("a", 2);
    expectedMap.put("test", 2);
    expectedMap.put("good", 1);

    calledMap = myWordCountService.countWords(stringTested);

    //Test equal, ignore order
    assertThat(calledMap, is(expectedMap));

    /////////////////////////////////////////////
    // Test type: Not case sensitive words. Ex. Hello = hello
    /////////////////////////////////////////////
    stringTested = "This ,, is   .. -   A ,;; tEst, a good Test";

    expectedMap.clear();
    expectedMap.put("this", 1);
    expectedMap.put("is", 1);
    expectedMap.put("a", 2);
    expectedMap.put("test", 2);
    expectedMap.put("good", 1);

    calledMap = myWordCountService.countWords(stringTested);

    //Test equal, ignore order
    assertThat(calledMap, is(expectedMap));

    /////////////////////////////////////////////
    // Test type: Check numbers with words
    /////////////////////////////////////////////
    stringTested = "This ,, is   .. -  55 A ,;; tEst, 55 a good Test";

    expectedMap.clear();
    expectedMap.put("this", 1);
    expectedMap.put("is", 1);
    expectedMap.put("a", 2);
    expectedMap.put("test", 2);
    expectedMap.put("good", 1);
    expectedMap.put("55", 2);

    calledMap = myWordCountService.countWords(stringTested);

    //Test equal, ignore order
    assertThat(calledMap, is(expectedMap));

    /////////////////////////////////////////////
    // Test type: Check just numbers
    /////////////////////////////////////////////
    stringTested = " 111 2 44 2";

    expectedMap.clear();
    expectedMap.put("111", 1);
    expectedMap.put("2", 2);
    expectedMap.put("44", 1);

    calledMap = myWordCountService.countWords(stringTested);

    //Test equal, ignore order
    assertThat(calledMap, is(expectedMap));


  }

}