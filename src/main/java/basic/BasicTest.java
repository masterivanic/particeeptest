package basic;

import io.vavr.control.Option;

/**
 * For this basic test, you should not use any library. e.g. you should not use
 * Math.pow for power method
 */
public class BasicTest {

  static double pow(double base, double x) {
    if (x == 0)
      return 1;
    return (base * pow(base, x - 1));
  }

  /**
   * return i ^ n for positive Integer, None otherwise
   * alse return None in case of errors
   */
  public static Option<Integer> power(Integer i, Integer n) {
    double value = 0;
    Option<Integer> optionPower = null;

    try {
      value = pow(i, n);
    } catch (StackOverflowError ex) {
      value = -1;
    }

    try {
      if (value == 0) {
        optionPower = Option.of((int) value);
      } else if (value > 0) {
        optionPower = Option.of((int) value);
      } else {
        optionPower = Option.none();
      }

    } catch (Exception ex) {
      optionPower = Option.none();
    }
    return optionPower;
  }
}
