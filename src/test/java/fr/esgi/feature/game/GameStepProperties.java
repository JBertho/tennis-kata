package fr.esgi.feature.game;

import fr.esgi.Game;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class GameStepProperties {
    private final Game game;

    public GameStepProperties(Game game) {
        this.game = game;
    }

    @Given("start game properties are used")
    public void startGamePropertiesAreUsed() {
        game.getPlayerOne().setScore(0);
        game.getPlayerTwo().setScore(0);
    }

    @And("score is set to deuce")
    public void setScoreToDeuce() {
        game.getPlayerTwo().setScore(3);
        game.getPlayerOne().setScore(3);
    }

    @And("score is set to advantage for {string}")
    public void setScoreToDeuce(String name) {
        game.getPlayerOne().setScore(game.getPlayerOne().getName().equals(name) ? 5 : 4);
        game.getPlayerTwo().setScore(game.getPlayerTwo().getName().equals(name) ? 5 : 4);

    }

    @When("{string} score a point")
    public void playerScoreAPoint(String name) {
        game.addPointTo(name);
    }

    @When("{string} score two points in a row")
    public void playerScoreTwoPointsInARow(String name) {
        game.addPointTo(name);
        game.addPointTo(name);
    }



    @Then("{string} should win the game")
    public void playerWinTheGame(String name) {
        String result = game.getResult();
        String expectedString = "Victory of " + name;
        Assertions.assertEquals(expectedString, result);
    }

    @Then("score should be deuce")
    public void scoreIsDeuce() {
        String result = game.getResult();
        String expectedString = "Deuce";
        Assertions.assertEquals(expectedString, result);
    }

    @Then("score should be advantage for {string}")
    public void scoreIsAdvantageFor(String name) {
        String result = game.getResult();
        String expectedString = "Advantage for " + name;
        Assertions.assertEquals(expectedString, result);
    }
    @Then("score should be {string}")
    public void currentScoreIs(String currentScore) {
        String result = game.getResult();
        Assertions.assertEquals(currentScore, result);
    }

}
