package fr.esgi;

import java.util.*;

public class Game {
    public static final String VICTORY_OF = "Victory of ";
    public static final String ADVANTAGE_FOR = "Advantage for ";
    private static final String DEUCE = "Deuce";
    public static final List<String> SCORES = List.of("Love","Fifteen","Thirty","Forty");

    private final Player playerOne;
    private final Player playerTwo;

    public Game() {
        this.playerOne = new Player("Jimmy",0);
        this.playerTwo = new Player("Maxime",0);
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public Player getPlayerByName(String name){
        if (playerOne.getName().equals(name)) {
            return playerOne;
        } else if (playerTwo.getName().equals(name)) {
            return playerTwo;
        } else {
            throw new IllegalArgumentException("Player do not exist");
        }
    }

    public void addPointTo(String name) {
        Player player = getPlayerByName(name);
        player.gainPoint();
    }

    public String getResult() {
        int playerOneScore = playerOne.getScore();
        int playerTwoScore = playerTwo.getScore();
        
        if (isDeuce()) {
            return DEUCE;
        }
        Player winningPlayer = playerOneScore > playerTwoScore ? playerOne : playerTwo;
        
        if (IsGameWon()){
            return VICTORY_OF + winningPlayer.getName();
        }
        if (isAdvantageForAPlayer()) {
            return ADVANTAGE_FOR + winningPlayer.getName();
        }
        if (playerOneScore > playerTwoScore) {
            return SCORES.get(playerOneScore) + " - " + SCORES.get(playerTwoScore) + " for " + playerOne.getName();
        } else if (playerTwoScore > playerOneScore) {
            return SCORES.get(playerTwoScore) + " - " + SCORES.get(playerOneScore) + " for " + playerTwo.getName();
        } else {
            return SCORES.get(playerTwoScore) + " - " + SCORES.get(playerOneScore);
        }
    }

    private boolean isAdvantageForAPlayer() {
        return playerOne.getScore() >= 3 && playerTwo.getScore() >= 3 &&
                Math.max(playerOne.getScore() - playerTwo.getScore(), playerTwo.getScore() - playerOne.getScore()) == 1;
    }

    private boolean IsGameWon() {
        int playerOneScore = playerOne.getScore();
        int playerTwoScore = playerTwo.getScore();
        return (playerOneScore >= 4 && playerTwoScore <= (playerOneScore - 2))
                || (playerTwoScore >= 4 && playerOneScore <= playerTwoScore - 2);
    }

    private boolean isDeuce() {
        int forty = SCORES.indexOf("Forty");
        int playerOneScore = playerOne.getScore();
        int playerTwoScore = playerTwo.getScore();
        
        return playerTwoScore >= forty && playerOneScore == playerTwoScore;
    }
}
