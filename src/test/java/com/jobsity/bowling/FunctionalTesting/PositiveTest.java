package com.jobsity.bowling.FunctionalTesting;

import java.nio.file.NoSuchFileException;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jobsity.bowling.controllers.GameFileReader;
import com.jobsity.bowling.models.Game.Game;
import com.jobsity.bowling.models.Game.Player;

public class PositiveTest {

  @Test
  public void FilenotFound() {

    try {
      GameFileReader.parseFile(System.getProperty("user.dir") + "\\src\\test\\resources\\positive\\nofile");
    } catch (Exception e) {
      assertEquals(NoSuchFileException.class, e.getClass());
    }

  }

  @Test
  public void testValidGame() throws Exception {

    Game game = GameFileReader
        .parseFile(System.getProperty("user.dir") + "\\src\\test\\resources\\positive\\scores.txt");

    Player player = game.Player("John");

    assertNotNull(player);
    assertEquals(141, player.Score());

  }

  @Test
  public void testPerfectGame() throws Exception {

    Game game = GameFileReader
        .parseFile(System.getProperty("user.dir") + "\\src\\test\\resources\\positive\\perfect.txt");

    Player player = game.Player("Carl");

    assertNotNull(player);
    assertEquals(300, player.Score());

  }

  @Test
  public void testAlmostPerfectGame1() throws Exception {

    Game game = GameFileReader
        .parseFile(System.getProperty("user.dir") + "\\src\\test\\resources\\positive\\almostperfect1.txt");

    Player player = game.Player("Carl");

    assertNotNull(player);
    assertEquals(270, player.Score());

  }

  @Test
  public void testAlmostPerfectGame2() throws Exception {

    Game game = GameFileReader
        .parseFile(System.getProperty("user.dir") + "\\src\\test\\resources\\positive\\almostperfect2.txt");

    Player player = game.Player("Carl");

    assertNotNull(player);
    assertEquals(266, player.Score());

  }

  @Test
  public void testAllZero() throws Exception {

    Game game = GameFileReader
        .parseFile(System.getProperty("user.dir") + "\\src\\test\\resources\\positive\\allzero.txt");

    Player player = game.Player("Carl");

    assertNotNull(player);
    assertEquals(0, player.Score());

  }

  @Test
  public void testAllFault() throws Exception {

    Game game = GameFileReader
        .parseFile(System.getProperty("user.dir") + "\\src\\test\\resources\\positive\\allfault.txt");

    Player player = game.Player("Carl");

    assertNotNull(player);
    assertEquals(0, player.Score());

  }

}
