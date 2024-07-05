package com.jobsity.bowling.models.Game;

import com.jobsity.bowling.enums.EnumStatusFrame;
import com.jobsity.bowling.exceptions.ParseGameRollOverflow;
import com.jobsity.bowling.exceptions.ParseGameScoreOverFlow;
import com.jobsity.bowling.interfaces.FrameInterface;

public class Frame implements FrameInterface {

  private int frameIndex = 0;

  private String person = "";

  public String getPerson() {
    return person;
  }

  private Frame previousFrame;

  protected int[] rolls = new int[TotalRolls()];

  private int additionalScore = 0;

  private int currentRollFeed = -1;

  public int TotalRolls() {

    return 2;

  }

  public Frame(String person, Frame previousFrame, int frameIndex) {

    this.previousFrame = previousFrame;
    this.frameIndex = frameIndex;
    this.person = person;

    for (int i = 0; i < TotalRolls(); i++) {

      rolls[i] = 0;

    }

  }

  public boolean IsSpecialFrame() {

    return false;

  }

  public boolean Strike() {

    return rolls[0] == 10;

  }

  public boolean Spare() {

    return (!Strike() &&
        (FirstRoundScore() == 10));

  }

  public int SelfScore() {

    int score = 0;

    for (int i : rolls) {

      score += i;

    }

    return score;

  }

  protected int FirstRoundScore() {

    int score = 0;

    for (int i = 0; i <= 1; i++) {

      score += rolls[i];

    }

    return score;

  }

  public int Score() {

    return SelfScore() + additionalScore;

  }

  public int RollPoints(int rollIndex) {

    return rolls[rollIndex - 1];

  }

  private boolean checkPreviousStrike(int points) {

    if (Strike()) {

      return true;

    }

    Frame prevFrame = previousFrame;

    boolean result = false;

    while ((prevFrame != null) &&
        (prevFrame.Strike()) &&
        (currentRollFeed <= 1)) {

      prevFrame.additionalScore += points;

      prevFrame = prevFrame.previousFrame;

      result = true;

    }

    return result;

  }

  private boolean checkPreviousSpare(int points) {

    if ((previousFrame != null) &&
        (previousFrame.Spare()) &&
        (currentRollFeed == 0)) {

      previousFrame.additionalScore += points;

      return true;

    }

    return false;

  }

  public int addScore(int currentFrameFeed, String score) throws Exception {

    if (currentRollFeed == AllowedRolls() - 1) {

      throw new ParseGameRollOverflow("This frame cannot have more than " + AllowedRolls() + " rolls!");

    }

    if (Status() == EnumStatusFrame.sfPointsOveflow) {

      throw new ParseGameScoreOverFlow("First two rools cannot have more than 10 points!");

    }

    int points = Integer.valueOf(score.replace('F', '0'));

    currentRollFeed++;

    rolls[currentRollFeed] += points;

    if (!checkPreviousStrike(points)) {

      checkPreviousSpare(points);

    }

    if (((FirstRoundScore() >= 10) && (!IsSpecialFrame())) ||
        (currentRollFeed >= TotalRolls() - 1)) {

      currentFrameFeed++;

    }

    return currentFrameFeed;

  }

  public int FrameIndex() {

    return frameIndex;

  }

  public EnumStatusFrame Status() {

    if (SelfScore() > 10 && !IsSpecialFrame()) {

      return EnumStatusFrame.sfPointsOveflow;

    }

    if (registeredRolls() == 0) {

      return EnumStatusFrame.sfEmpty;

    }

    if (registeredRolls() < AllowedRolls()) {

      return EnumStatusFrame.sfIncomplete;

    }

    if (registeredRolls() > AllowedRolls()) {

      return EnumStatusFrame.sfAllowedOverflow;

    }

    return EnumStatusFrame.sfValid;

  }

  public int AllowedRolls() {

    if (rolls[0] == 10) {
      return 1;
    }

    return 2;

  }

  @Override
  public String toString() {

    String rollStr = "";

    for (int i = 0; i < rolls.length; i++) {

      rollStr += rolls[i] + "-";

    }

    return String.valueOf(rollStr.substring(0, rollStr.length() - 1)) + " (" + Score() + ")";

  }

  private int registeredRolls() {
    return currentRollFeed + 1;
  }

  public String errorMessage() {

    String pref = this.person + "/" + frameIndex;

    switch (Status()) {

      case sfPointsOveflow:
        return pref + ":Points Overflow! (" + SelfScore() + ")";
      case sfEmpty:
        return pref + ":Frame has no roll registered.";
      case sfIncomplete:
        return pref + ":Frame has incomplete rolls (Expected: " + AllowedRolls() + " - Registered: "
            + registeredRolls();
      case sfAllowedOverflow:
        return pref + ":Frame has more rolls than allowed (Expected: " + AllowedRolls() + " - Registered: "
            + registeredRolls();
      default:
        return null;

    }

  }

}
