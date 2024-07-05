package com.jobsity.bowling;

import com.jobsity.bowling.controllers.GameFileReader;
import com.jobsity.bowling.controllers.ScoreBoardConverter;
import com.jobsity.bowling.exceptions.ExecParameterRequired;
import com.jobsity.bowling.models.Game.Game;
import com.jobsity.bowling.models.Scoreboard.Scoreboard;

public class App {

    public static void main(String[] args) throws Exception {

        if (args.length == 0) {

            throw new ExecParameterRequired("Command line should have one parameter, which is the file to open.");

        }

        if (args.length > 1) {

            throw new ExecParameterRequired("Command line should have one parameter only, which is the file to open.");

        }

        Game game = GameFileReader
                .parseFile(args[0]);

        Scoreboard scoreboard = ScoreBoardConverter.convert(game);

        System.out.println(scoreboard);

    }

}
