package com.jobsity.bowling.interfaces;

import com.jobsity.bowling.enums.EnumStatusFrame;

public interface FrameInterface {

  public int TotalRolls();

  public int AllowedRolls();

  public boolean IsSpecialFrame();

  public boolean Strike();

  public boolean Spare();

  public int Score();

  public int RollPoints(int rollIndex);

  public EnumStatusFrame Status();

  public int FrameIndex();

}
