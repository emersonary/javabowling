package com.jobsity.bowling.FunctionalTesting;

import org.junit.Test;

import com.jobsity.bowling.controllers.GameFileReader;
import com.jobsity.bowling.exceptions.*;

public class NegativeTest {

  @Test(expected = EmptyFileException.class)
  public void testEmptyFile() throws Exception {

    GameFileReader.parseFile(System.getProperty("user.dir") + "\\src\\test\\resources\\negative\\empty.txt");

  }

  @Test(expected = ParseGameFrameOverflow.class)
  public void testExtraScoreFile() throws Exception {

    GameFileReader.parseFile(System.getProperty("user.dir") + "\\src\\test\\resources\\negative\\extra-score.txt");

  }

  @Test(expected = ParseGameFileInvalidRowException.class)
  public void testfreeText() throws Exception {

    GameFileReader.parseFile(System.getProperty("user.dir") + "\\src\\test\\resources\\negative\\free-text.txt");

  }

  @Test(expected = ParseGameFileInvalidRowException.class)
  public void testNegative() throws Exception {

    GameFileReader.parseFile(System.getProperty("user.dir") + "\\src\\test\\resources\\negative\\negative.txt");

  }

  @Test(expected = ParseGameInvalidFrame.class)
  public void testOverFlow1() throws Exception {

    GameFileReader.parseFile(System.getProperty("user.dir") + "\\src\\test\\resources\\negative\\overflow1.txt");

  }

  @Test(expected = ParseGameInvalidFrame.class)
  public void testOverFlow2() throws Exception {

    GameFileReader.parseFile(System.getProperty("user.dir") + "\\src\\test\\resources\\negative\\overflow2.txt");

  }

  @Test(expected = ParseGameFileInvalidRowException.class)
  public void testInvalidScore() throws Exception {

    GameFileReader.parseFile(System.getProperty("user.dir") + "\\src\\test\\resources\\negative\\invalid-score.txt");

  }

  @Test(expected = ParseGameInvalidFrame.class)
  public void testIncomplete1() throws Exception {

    GameFileReader.parseFile(System.getProperty("user.dir") + "\\src\\test\\resources\\negative\\incomplete1.txt");

  }

  @Test(expected = ParseGameInvalidFrame.class)
  public void testIncomplete2() throws Exception {

    GameFileReader.parseFile(System.getProperty("user.dir") + "\\src\\test\\resources\\negative\\incomplete2.txt");

  }

  @Test(expected = ParseGameInvalidFrame.class)
  public void testIncomplete3() throws Exception {

    GameFileReader.parseFile(System.getProperty("user.dir") + "\\src\\test\\resources\\negative\\incomplete3.txt");

  }

  @Test(expected = ParseGameInvalidFrame.class)
  public void testIncomplete4() throws Exception {

    GameFileReader.parseFile(System.getProperty("user.dir") + "\\src\\test\\resources\\negative\\incomplete4.txt");

  }

  @Test(expected = ParseGameInvalidFrame.class)
  public void testIncomplete5() throws Exception {

    GameFileReader.parseFile(System.getProperty("user.dir") + "\\src\\test\\resources\\negative\\incomplete5.txt");

  }

  @Test(expected = ParseGameInvalidFrame.class)
  public void testIncomplete6() throws Exception {

    GameFileReader.parseFile(System.getProperty("user.dir") + "\\src\\test\\resources\\negative\\incomplete6.txt");

  }

  @Test(expected = ParseGameInvalidFrame.class)
  public void testIncomplete7() throws Exception {

    GameFileReader.parseFile(System.getProperty("user.dir") + "\\src\\test\\resources\\negative\\incomplete7.txt");

  }

  @Test(expected = ParseGameInvalidFrame.class)
  public void testIncomplete8() throws Exception {

    GameFileReader.parseFile(System.getProperty("user.dir") + "\\src\\test\\resources\\negative\\incomplete8.txt");

  }

  @Test(expected = ParseGameInvalidFrame.class)
  public void testIncomplete9() throws Exception {

    GameFileReader.parseFile(System.getProperty("user.dir") + "\\src\\test\\resources\\negative\\incomplete9.txt");

  }

  @Test(expected = ParseGameInvalidFrame.class)
  public void testIncomplete10() throws Exception {

    GameFileReader.parseFile(System.getProperty("user.dir") + "\\src\\test\\resources\\negative\\incomplete10.txt");

  }

}
