package collection;

import java.util.List;
import java.util.stream.Collectors;

/**
 * You should complete the function in this class
 * <p>
 * Feel free to define any method and / or class you want
 */
class CollectionTest {

  /**
   * operation : x -> ((x * 2) + 3) ^ 5
   * 
   * @param input
   * @return
   *         map a list of integer and return
   *         a list of power of all integer
   */
  public static List<Double> compute1(List<Integer> input) {
    return input.stream().map(t -> {
      try {
        return Math.pow((t * 2) + 3, 5);
      } catch (NullPointerException ex) {
        throw new NullPointerException("null value not allowed");
      }
    })
        .collect(Collectors.toList());
  }

  /**
   * 
   * @param t
   * @return
   *         return a String with is first letter in uppercase
   *         such as: student -> Student
   */
  static String getString(String t) {
    try {
      return t.equals("") ? t : t.substring(0, 1).toUpperCase() + t.substring(1, t.length());
    } catch (NullPointerException ex) {
      throw new NullPointerException("null value not allowed");
    }
  }

  /**
   * operation : abc -> AbcAbc
   * 
   * @param input
   * @return
   *         map a list of String and return a list of string
   *         due to the given operation
   */
  public static List<String> compute2(List<String> input) {
    return input.stream()
        .map(t -> getString(t))
        .map(t -> t + t)
        .collect(Collectors.toList());
  }

}
