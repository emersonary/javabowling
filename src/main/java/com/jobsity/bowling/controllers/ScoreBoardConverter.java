package com.jobsity.bowling.controllers;

import com.jobsity.bowling.models.Game.Frame;
import com.jobsity.bowling.models.Game.Game;
import com.jobsity.bowling.models.Game.Player;
import com.jobsity.bowling.models.Scoreboard.Scoreboard;
import com.jobsity.bowling.models.Scoreboard.ScoreboardPlayer;

public class ScoreBoardConverter {

  public static Scoreboard convert(Game game) {

    Scoreboard scoreboard = new Scoreboard();

    for (Player player : game.getPlayers()) {

      ScoreboardPlayer scoreboardPlayer = scoreboard.addScoreBoardPlayer(player.getPerson());

      for (Frame frame : player.getFrameList()) {

        scoreboardPlayer.addFrame(frame);

      }

    }

    return scoreboard;

  }

}
