package com.jobsity.bowling.exceptions;

import java.io.IOException;

public class EmptyFileException extends IOException {
  public EmptyFileException(String msg) {
    super(msg);
  }
}