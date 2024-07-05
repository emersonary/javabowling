package com.jobsity.bowling.UnitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jobsity.bowling.enums.EnumStatusFrame;
import com.jobsity.bowling.exceptions.ParseGameRollOverflow;
import com.jobsity.bowling.models.Game.Frame;

public class FrameTest {

  @Test
  public void frameTestOpen() throws Exception {

    Frame frame = new Frame("Emerson", null, 0);

    assertEquals("Emerson", frame.getPerson());
    assertEquals(EnumStatusFrame.sfEmpty, frame.Status());
    assertEquals(2, frame.AllowedRolls());
    assertEquals(0, frame.addScore(0, "6"));
    assertEquals(EnumStatusFrame.sfIncomplete, frame.Status());
    assertEquals(2, frame.AllowedRolls());
    assertEquals(1, frame.addScore(0, "2"));
    assertEquals(EnumStatusFrame.sfValid, frame.Status());
    assertEquals(2, frame.AllowedRolls());
    assertFalse(frame.Strike());
    assertFalse(frame.Spare());

    try {

      frame.addScore(0, "2");
      fail("Exceptoin was supposed to be thrown!");

    } catch (Exception e) {

      assertEquals(ParseGameRollOverflow.class, e.getClass());
    }

  }

  @Test
  public void frameTestStrike() throws Exception {

    Frame frame = new Frame("Emerson", null, 0);

    assertEquals("Emerson", frame.getPerson());
    assertEquals(EnumStatusFrame.sfEmpty, frame.Status());
    assertEquals(2, frame.AllowedRolls());
    assertEquals(1, frame.addScore(0, "10"));
    assertEquals(EnumStatusFrame.sfValid, frame.Status());
    assertEquals(1, frame.AllowedRolls());
    assertTrue(frame.Strike());
    assertFalse(frame.Spare());

    try {

      frame.addScore(0, "2");
      fail("Exceptoin was supposed to be thrown!");

    } catch (Exception e) {

      assertEquals(ParseGameRollOverflow.class, e.getClass());
    }

  }

  @Test
  public void frameTestSpare() throws Exception {

    Frame frame = new Frame("Emerson", null, 0);

    assertEquals("Emerson", frame.getPerson());
    assertEquals(EnumStatusFrame.sfEmpty, frame.Status());
    assertEquals(2, frame.AllowedRolls());
    assertEquals(0, frame.addScore(0, "6"));
    assertEquals(EnumStatusFrame.sfIncomplete, frame.Status());
    assertEquals(1, frame.addScore(0, "4"));
    assertEquals(EnumStatusFrame.sfValid, frame.Status());
    assertEquals(2, frame.AllowedRolls());
    assertFalse(frame.Strike());
    assertTrue(frame.Spare());

    try {

      frame.addScore(0, "2");
      fail("Exceptoin was supposed to be thrown!");

    } catch (Exception e) {

      assertEquals(ParseGameRollOverflow.class, e.getClass());
    }

  }

  @Test
  public void frameScoreOverFlow() throws Exception {

    Frame frame = new Frame("Emerson", null, 0);

    assertEquals("Emerson", frame.getPerson());
    assertEquals(EnumStatusFrame.sfEmpty, frame.Status());
    assertEquals(2, frame.AllowedRolls());
    assertEquals(0, frame.addScore(0, "6"));
    assertEquals(EnumStatusFrame.sfIncomplete, frame.Status());
    assertEquals(2, frame.AllowedRolls());
    assertEquals(1, frame.addScore(0, "5"));
    assertEquals(EnumStatusFrame.sfPointsOveflow, frame.Status());
    assertEquals(2, frame.AllowedRolls());
    assertFalse(frame.Strike());
    assertFalse(frame.Spare());

    try {

      frame.addScore(0, "2");
      fail("Exceptoin was supposed to be thrown!");

    } catch (Exception e) {

      assertEquals(ParseGameRollOverflow.class, e.getClass());
    }

  }

}
