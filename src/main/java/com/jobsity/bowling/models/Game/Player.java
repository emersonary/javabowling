package com.jobsity.bowling.models.Game;

import java.util.ArrayList;
import java.util.List;

import com.jobsity.bowling.enums.EnumStatusFrame;
import com.jobsity.bowling.exceptions.ParseGameFrameOverflow;

public class Player {

  private String person;

  public String getPerson() {

    return person;

  }

  private List<Frame> frameList;

  int currentFrameFeed = 0;

  Player(String person) {

    this.person = person;

    frameList = buildFrames();

  }

  private List<Frame> buildFrames() {

    List<Frame> list = new ArrayList<>();

    Frame previousFrame = null;

    for (int i = 1; i < 10; i++) {

      Frame newFrame = new Frame(person, previousFrame, i);
      previousFrame = newFrame;

      list.add(newFrame);

    }

    list.add(new SpecialFrame(person, previousFrame));

    return list;

  }

  public List<Frame> getFrameList() {

    return frameList;

  }

  public void addIncrementalScore(String score) throws Exception {

    if (currentFrameFeed < frameList.size()) {
      currentFrameFeed = frameList.get(currentFrameFeed).addScore(currentFrameFeed, score);
    } else {
      throw new ParseGameFrameOverflow("Chances overflow!");
    }

  }

  public int Score() {

    int result = 0;

    for (Frame frame : frameList) {

      result += frame.Score();

    }

    return result;

  }

  public Frame invalidFrame() {

    for (Frame frame : frameList) {

      if (frame.Status() != EnumStatusFrame.sfValid) {

        return frame;

      }

    }

    return null;

  }

  @Override
  public String toString() {
    return frameList.toString();
  }

}
