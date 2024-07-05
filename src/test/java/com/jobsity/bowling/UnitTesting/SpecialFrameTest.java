package com.jobsity.bowling.UnitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jobsity.bowling.enums.EnumStatusFrame;
import com.jobsity.bowling.exceptions.*;
import com.jobsity.bowling.models.Game.SpecialFrame;

public class SpecialFrameTest {

  @Test
  public void specialFrameTestOpen() throws Exception {

    SpecialFrame specialFrame = new SpecialFrame("Emerson", null);

    assertEquals(specialFrame.getPerson(), "Emerson");
    assertEquals(specialFrame.Status(), EnumStatusFrame.sfEmpty);
    assertEquals(specialFrame.AllowedRolls(), 2);
    assertEquals(specialFrame.addScore(0, "6"), 0);
    assertEquals(specialFrame.Status(), EnumStatusFrame.sfIncomplete);
    assertEquals(specialFrame.AllowedRolls(), 2);
    assertEquals(specialFrame.addScore(0, "3"), 0);
    assertEquals(specialFrame.Status(), EnumStatusFrame.sfValid);
    assertEquals(specialFrame.AllowedRolls(), 2);
    assertFalse(specialFrame.Strike());
    assertFalse(specialFrame.Spare());

    try {

      specialFrame.addScore(0, "2");
      fail("Exceptoin was supposed to be thrown!");

    } catch (Exception e) {

      assertEquals(ParseGameRollOverflow.class, e.getClass());
    }

  }

  @Test
  public void specialFrameTest2RowsScore10() throws Exception {

    SpecialFrame specialFrame = new SpecialFrame("Emerson", null);

    assertEquals(specialFrame.getPerson(), "Emerson");
    assertEquals(specialFrame.Status(), EnumStatusFrame.sfEmpty);
    assertEquals(specialFrame.AllowedRolls(), 2);
    assertEquals(specialFrame.addScore(0, "6"), 0);
    assertEquals(specialFrame.Status(), EnumStatusFrame.sfIncomplete);
    assertEquals(specialFrame.AllowedRolls(), 2);
    assertEquals(specialFrame.addScore(0, "4"), 0);
    assertEquals(specialFrame.Status(), EnumStatusFrame.sfIncomplete);
    assertEquals(specialFrame.AllowedRolls(), 3);
    assertFalse(specialFrame.Strike());
    assertFalse(specialFrame.Spare());
    assertEquals(specialFrame.addScore(0, "4"), 1);

    try {

      specialFrame.addScore(0, "2");
      fail("Exceptoin was supposed to be thrown!");

    } catch (Exception e) {

      assertEquals(ParseGameRollOverflow.class, e.getClass());
    }

  }

  @Test
  public void specialFrameTest1RowScore10() throws Exception {

    SpecialFrame specialFrame = new SpecialFrame("Emerson", null);

    assertEquals(specialFrame.getPerson(), "Emerson");
    assertEquals(specialFrame.Status(), EnumStatusFrame.sfEmpty);
    assertEquals(specialFrame.AllowedRolls(), 2);
    assertEquals(specialFrame.addScore(0, "10"), 0);
    assertEquals(specialFrame.Status(), EnumStatusFrame.sfIncomplete);
    assertEquals(specialFrame.AllowedRolls(), 3);
    assertEquals(specialFrame.addScore(0, "4"), 0);
    assertEquals(specialFrame.Status(), EnumStatusFrame.sfIncomplete);
    assertEquals(specialFrame.AllowedRolls(), 3);
    assertFalse(specialFrame.Strike());
    assertFalse(specialFrame.Spare());
    assertEquals(specialFrame.addScore(0, "4"), 1);

    try {

      specialFrame.addScore(0, "2");
      fail("Exceptoin was supposed to be thrown!");

    } catch (Exception e) {

      assertEquals(ParseGameRollOverflow.class, e.getClass());
    }

  }

  @Test
  public void frameScoreOverFlow1() throws Exception {

    SpecialFrame specialFrame = new SpecialFrame("Emerson", null);

    assertEquals(specialFrame.getPerson(), "Emerson");
    assertEquals(specialFrame.Status(), EnumStatusFrame.sfEmpty);
    assertEquals(specialFrame.AllowedRolls(), 2);
    assertEquals(specialFrame.addScore(0, "6"), 0);
    assertEquals(specialFrame.Status(), EnumStatusFrame.sfIncomplete);
    assertEquals(specialFrame.AllowedRolls(), 2);
    assertEquals(specialFrame.addScore(0, "5"), 0);
    assertEquals(specialFrame.Status(), EnumStatusFrame.sfPointsOveflow);
    assertEquals(specialFrame.AllowedRolls(), 3);
    assertFalse(specialFrame.Strike());
    assertFalse(specialFrame.Spare());

    try {

      specialFrame.addScore(0, "2");
      fail("Exceptoin was supposed to be thrown!");

    } catch (Exception e) {

      assertEquals(ParseGameScoreOverFlow.class, e.getClass());
    }

  }

}
