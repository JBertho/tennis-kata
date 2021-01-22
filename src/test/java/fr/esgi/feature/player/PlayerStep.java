package fr.esgi.feature.player;

import fr.esgi.Game;
import fr.esgi.Player;
import io.cucumber.java.en.And;
import org.junit.jupiter.api.Assertions;


public class PlayerStep {
    private final Game game;

    public PlayerStep(final Game game) {
        this.game = game;
    }

    @And("{string} have {string}")
    public void playerScoreHave(String name, String score) {
        Player player = game.getPlayerByName(name);
        int newScore = Game.SCORES.indexOf(score);
        player.setScore(newScore);
    }

    @And("{string} score is {string}")
    public void playerScoreIs(String name, String score) {
        Player player = game.getPlayerByName(name);
        Assertions.assertEquals(score, Game.SCORES.get(player.getScore()));
    }


}
