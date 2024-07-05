package com.jobsity.bowling.utils;

public class StringUtils {

  public static String padLeft(String input, int length, char padChar) {
    if (input.length() >= length) {
      return input.substring(0, length);
    } else {
      int spacesToAdd = length - input.length();
      String padding = String.format("%" + spacesToAdd + "s", "").replace(' ', padChar);
      return padding + input;
    }
  }

  public static String padRight(String input, int length, char padChar) {
    if (input.length() >= length) {
      return input.substring(0, length);
    } else {
      int spacesToAdd = length - input.length();
      String padding = String.format("%" + spacesToAdd + "s", "").replace(' ', padChar);
      return input + padding;
    }
  }

  public static String Filler(int len, char filler) {

    return String.format("%" + len + "s", "").replace(' ', filler);

  }

}
