package com.jobsity.bowling.models.Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {

  Map<String, Player> playerFrameList = new HashMap<>();

  private Player playerFromPerson(String person) {

    Player player = playerFrameList.get(person);

    if (player == null) {

      player = new Player(person);

      playerFrameList.put(person, player);

    }

    return player;

  }

  public Player Player(String person) {

    return playerFrameList.get(person);

  }

  public Frame invalidFrame() {

    for (Player player : playerFrameList.values()) {

      Frame frame = player.invalidFrame();

      if (frame != null) {

        return frame;

      }

    }

    return null;

  }

  public void addIncrementalPersonAndScore(String person, String score) throws Exception {

    playerFromPerson(person).addIncrementalScore(score);

  }

  @Override
  public String toString() {

    return playerFrameList.toString();

  }

  public List<Player> getPlayers() {

    List<Player> players = new ArrayList<>();

    for (Player player : playerFrameList.values()) {

      players.add(player);

    }

    return players;

  }

}
