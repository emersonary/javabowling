package com.jobsity.bowling.controllers;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import com.jobsity.bowling.exceptions.EmptyFileException;
import com.jobsity.bowling.exceptions.ParseGameFileInvalidRowException;
import com.jobsity.bowling.exceptions.ParseGameInvalidFrame;
import com.jobsity.bowling.models.Game.Game;
import com.jobsity.bowling.models.Game.Frame;

public class GameFileReader {

  private record LineContent(String name, String result) {

    LineContent(String name, String result) {

      this.name = name.trim();
      this.result = result.trim();

    }

    public boolean filled() {

      return (name != "") && (result != "");

    }

    public String Error() {

      if (!result.matches("-?\\d+|F")) {

        return "Invalid game result: " + result;

      }

      if (result.equals("F")) {

        return "";

      }

      if (Integer.valueOf(result) < 0) {

        return "negative game result: " + result;

      }

      return "";

    }

  }

  private static LineContent lineContentFromRow(String row) {

    String[] words = row.split("\t");

    if (words.length == 2) {

      return new LineContent(words[0], words[1]);

    }

    return new LineContent("", "");

  }

  private static void validateFileContent(List<String> fileContent) throws Exception {

    AtomicInteger index = new AtomicInteger(0);

    for (String line : fileContent) {

      LineContent lineContent = lineContentFromRow(line);

      if (!lineContent.filled()) {
        throw new ParseGameFileInvalidRowException(
            "Invalid row content '" + line + "' at line " + index.incrementAndGet() + " (no tab carachter)!");
      }

      String lineContentError = lineContent.Error();

      if (!lineContentError.equals("")) {

        throw new ParseGameFileInvalidRowException(
            lineContentError + " at line " + index.incrementAndGet() + " (full row: '" + line + "')!");

      }

    }

  }

  private static Game readFromFileContent(List<String> fileContent) throws Exception {

    Game game = new Game();

    validateFileContent(fileContent);

    for (String line : fileContent) {

      LineContent lineContent = lineContentFromRow(line);

      game.addIncrementalPersonAndScore(lineContent.name, lineContent.result);

    }

    Frame frame = game.invalidFrame();

    if (frame != null) {

      throw new ParseGameInvalidFrame(frame.errorMessage());

    }

    return game;

  }

  public static Game parseFile(String filename) throws Exception {

    List<String> fileContent = Files.readAllLines(Paths.get(filename)).stream()
        .filter(line -> !line.trim().isEmpty())
        .collect(Collectors.toList()); // load non empty lines

    if (fileContent.size() == 0) {

      throw new EmptyFileException("File with no content!");

    }

    return readFromFileContent(fileContent);

  }
}
