package com.jobsity.bowling.models.Scoreboard;

import java.util.ArrayList;
import java.util.List;

import com.jobsity.bowling.enums.EnumStatusFrame;
import com.jobsity.bowling.interfaces.FrameInterface;
import com.jobsity.bowling.utils.StringUtils;

class ScoreboardColumn implements FrameInterface {

  public ScoreboardColumn(int totalRolls) {
    this.totalRolls = totalRolls;
    rolls = new int[TotalRolls()];
  }

  int[] rolls;
  int totalRolls = 0;
  boolean isSpecialFrame = false;
  boolean strike = false;
  boolean spare = false;
  int score = 0;
  int firstRoll = 0;
  int secondRoll = 0;
  int frameIndex = 0;
  EnumStatusFrame status = EnumStatusFrame.sfValid;
  int allowedRolls = 0;
  int totalScore = 0;

  public void setAllowedRolls(int allowedRolls) {
    this.allowedRolls = allowedRolls;
  }

  public void setTotalRolls(int totalRolls) {
    this.totalRolls = totalRolls;
  }

  public void setSpecialFrame(boolean isSpecialFrame) {
    this.isSpecialFrame = isSpecialFrame;
  }

  public void setTotalScore(int totalScore) {
    this.totalScore = totalScore;
  }

  public void setStrike(boolean strike) {
    this.strike = strike;
  }

  public void setSpare(boolean spare) {
    this.spare = spare;
  }

  public void setRollsPoints(int rollIndex, int rollPoints) {
    this.rolls[rollIndex - 1] = rollPoints;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public void setFirstRoll(int firstRoll) {
    this.firstRoll = firstRoll;
  }

  public void setSecondRoll(int secondRoll) {
    this.secondRoll = secondRoll;
  }

  public void setFrameIndex(int frameIndex) {
    this.frameIndex = frameIndex;
  }

  public void setStatus(EnumStatusFrame status) {
    this.status = status;
  }

  @Override
  public int RollPoints(int rollIndex) {
    return rolls[rollIndex - 1];
  }

  public int TotalScore() {
    return totalScore;
  }

  @Override
  public EnumStatusFrame Status() {
    return status;
  }

  @Override
  public int FrameIndex() {
    return frameIndex;
  }

  public int TotalRolls() {
    return totalRolls;
  }

  public boolean IsSpecialFrame() {
    return isSpecialFrame;
  }

  public boolean Strike() {
    return strike;
  }

  public boolean Spare() {
    return spare;
  }

  public int Score() {
    return score;
  }

  public int getFirstChange() {
    return firstRoll;
  }

  public int getSecondChange() {
    return secondRoll;
  }

  @Override
  public int AllowedRolls() {
    return allowedRolls;
  }

  private String Symbol(int index, int score) {

    if (score == 10) {
      return "X";
    } else {
      if (index == 2) {
        if (Strike()) {
          return " ";
        } else {
          if (Spare()) {
            return "/";
          } else {
            return String.valueOf(score);
          }
        }
      } else {
        return String.valueOf(score);
      }
    }

  }

  @Override
  public String toString() {

    String result = StringUtils.Filler(2, ' ') + "|";

    for (int i = 1; i <= TotalRolls(); i++) {

      result += Symbol(i, RollPoints(i)) + "|";

    }

    return result;

  }

}

public class Scoreboard {

  private List<ScoreboardPlayer> players = new ArrayList<>();

  public ScoreboardPlayer addScoreBoardPlayer(String person) {

    ScoreboardPlayer scoreboardPlayer = new ScoreboardPlayer(person);

    players.add(scoreboardPlayer);

    return scoreboardPlayer;

  };

  private String getHeader() {

    String result;

    if (players.size() > 0) {

      result = "|" + StringUtils.padRight("Player", 10, ' ') + "|";

      ScoreboardPlayer scoreboardPlayer = players.get(0);

      for (ScoreboardColumn scoreboardColumn : scoreboardPlayer.getColumns()) {

        int len = 6;

        if (scoreboardColumn.isSpecialFrame) {
          len = 8;
        }

        result += StringUtils.padLeft(String.valueOf(scoreboardColumn.FrameIndex()), len, ' ') + "|";

      }

    } else {

      return "Empty Scoreboard";

    }

    return result;

  }

  @Override
  public String toString() {

    String header = getHeader();
    String border = StringUtils.Filler(header.length(), '-');

    for (ScoreboardPlayer scoreboardPlayer : players) {

      header += "\n" + scoreboardPlayer.toString();

    }

    return border + "\n" + header + "\n" + border;

  }

}
