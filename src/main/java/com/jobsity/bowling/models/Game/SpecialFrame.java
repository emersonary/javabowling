package com.jobsity.bowling.models.Game;

import com.jobsity.bowling.enums.EnumStatusFrame;

public class SpecialFrame extends Frame {

  public SpecialFrame(String person, Frame previousFrame) {

    super(
        person,
        previousFrame,
        10);

  }

  @Override
  public boolean IsSpecialFrame() {

    return true;

  }

  @Override
  public int TotalRolls() {

    return 3;

  }

  @Override
  public EnumStatusFrame Status() {

    if (rolls[0] == 10) {

      if (rolls[1] > 10 || rolls[2] > 10) {

        return EnumStatusFrame.sfPointsOveflow;

      }

    } else {

      if (FirstRoundScore() > 10 || rolls[2] > 10) {

        return EnumStatusFrame.sfPointsOveflow;

      }

    }

    return super.Status();

  }

  @Override
  public int AllowedRolls() {

    if (rolls[0] == 10 || FirstRoundScore() >= 10) {

      return 3;

    } else {

      return 2;

    }

  }

  @Override
  public boolean Strike() {

    return false;

  }

  @Override
  public boolean Spare() {

    return false;

  }

}
