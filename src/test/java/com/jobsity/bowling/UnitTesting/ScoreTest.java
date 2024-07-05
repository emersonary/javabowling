package com.jobsity.bowling.UnitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jobsity.bowling.models.Game.Frame;

public class ScoreTest {

  @Test
  public void openFrameTest() throws Exception {

    Frame previousFrame = new Frame("Emerson", null, 0);
    Frame frame = new Frame("Emerson", previousFrame, 1);

    previousFrame.addScore(0, "5");

    frame.addScore(0, "9");
    assertEquals(9, frame.Score());
    assertEquals(5, previousFrame.Score());

  }

  @Test
  public void strikeTest() throws Exception {

    Frame previousFrame = new Frame("Emerson", null, 0);
    Frame frame = new Frame("Emerson", previousFrame, 1);

    previousFrame.addScore(0, "10");

    frame.addScore(0, "9");
    frame.addScore(0, "1");
    assertEquals(10, frame.Score());
    assertEquals(20, previousFrame.Score());

  }

  @Test
  public void spareTest() throws Exception {

    Frame previousFrame = new Frame("Emerson", null, 0);
    Frame frame = new Frame("Emerson", previousFrame, 1);

    previousFrame.addScore(0, "6");
    previousFrame.addScore(0, "4");

    frame.addScore(0, "9");
    frame.addScore(0, "1");
    assertEquals(10, frame.Score());
    assertEquals(19, previousFrame.Score());

  }

}
