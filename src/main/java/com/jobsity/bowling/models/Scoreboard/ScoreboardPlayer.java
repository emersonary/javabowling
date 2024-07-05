package com.jobsity.bowling.models.Scoreboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.lang.model.util.ElementScanner14;

import com.jobsity.bowling.interfaces.FrameInterface;
import com.jobsity.bowling.utils.StringUtils;

public class ScoreboardPlayer {

  private int totalScore = 0;

  public ScoreboardPlayer(String person) {

    this.person = person;

  }

  private String person;

  private List<ScoreboardColumn> columns = new ArrayList<>();

  public List<ScoreboardColumn> getColumns() {

    return columns;

  }

  public String toString() {

    String line1 = "|" + StringUtils.padRight(person, 10, ' ') + "|";
    String line2 = "|" + StringUtils.padRight("", 10, ' ') + "|";

    for (ScoreboardColumn scoreboardColumn : columns) {

      int len = 7;

      if (scoreboardColumn.isSpecialFrame) {
        len = 9;
      }

      line1 += StringUtils.padLeft(scoreboardColumn.toString(), len, ' ');
      line2 += StringUtils.padLeft(String.valueOf(scoreboardColumn.TotalScore()), len - 1, ' ') + "|";

    }

    return StringUtils.Filler(line1.length(), '-') + "\n" + line1 + "\n" + line2;

  }

  public void addFrame(FrameInterface frame) {

    ScoreboardColumn scoreboardColumn = new ScoreboardColumn(frame.TotalRolls());

    int score = frame.Score();

    totalScore += score;

    scoreboardColumn.setFrameIndex(frame.FrameIndex());
    scoreboardColumn.setScore(score);
    scoreboardColumn.setSpare(frame.Spare());
    scoreboardColumn.setStrike(frame.Strike());
    scoreboardColumn.setSpecialFrame(frame.IsSpecialFrame());
    scoreboardColumn.setStatus(frame.Status());
    scoreboardColumn.setAllowedRolls(frame.AllowedRolls());
    scoreboardColumn.setTotalScore(totalScore);

    for (int i = 1; i <= frame.TotalRolls(); i++) {
      scoreboardColumn.setRollsPoints(i, frame.RollPoints(i));
    }

    columns.add(scoreboardColumn);

  }

}
