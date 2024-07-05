package com.jobsity.bowling.exceptions;

import java.io.IOException;

public class ParseGameFileInvalidRowException extends IOException {

  public ParseGameFileInvalidRowException(String msg) {
    super(msg);
  }

}
