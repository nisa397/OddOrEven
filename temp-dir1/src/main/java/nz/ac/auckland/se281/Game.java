package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/* This class represents the Game is the main entry point. */
public class Game {

  // Initializing values
  private int roundIterator = 0;
  private String name = "";
  private Difficulty difficulty;
  private Choice choice;
  private String botName = "HAL-9000";
  private int oddCounter = 0;
  private int evenCounter = 0;
  private int aiWins = 0;

  // If previousWinner or currentWinner was a bot, equals true, false otherwise
  private boolean previousWinner = false;
  private boolean currentWinner = false;

  /**
   * Creates a new game, and adds the parameters to the system so it is used later When this is
   * called again, the parameters(odd counter, even counter, aiWins) become empty and set to default
   * again.
   *
   * @param difficulty difficulty of the game, easy,medium or hard.
   * @param choice Odd or even.
   * @param options the name of the user.
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0] is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    this.name = options[0];
    this.difficulty = difficulty;
    this.choice = choice;
    // Resets everything when a new game is created
    oddCounter = 0;
    evenCounter = 0;
    roundIterator = 0;
    previousWinner = false;
  }

  /**
   * Starts the actual game, iterates the round, takes input of the user and generates number from
   * the AI bot implements the chosen difficulty and that corresponding difficulty.
   */
  public void play() {

    // Prints error message if no name is present, so new game is empty
    if (name.isEmpty()) {
      MessageCli.GAME_NOT_STARTED.printMessage();
    } else {

      roundIterator += 1;
      int sum;
      int botHand;
      // Prints start of round
      MessageCli.START_ROUND.printMessage(Integer.toString(roundIterator));

      // Asks user for number of fingers and takes input
      MessageCli.ASK_INPUT.printMessage();
      String noOfFingers = Utils.scanner.nextLine();

      // While the input is invalid, it will keep asking for an appropriate input
      while (Integer.parseInt(noOfFingers) < 0 || Integer.parseInt(noOfFingers) > 5) {
        MessageCli.INVALID_INPUT.printMessage();
        MessageCli.ASK_INPUT.printMessage();
        noOfFingers = Utils.scanner.nextLine();
      }

      MessageCli.PRINT_INFO_HAND.printMessage(name, noOfFingers);

      // Puts the chosen difficulty into the factory to be created
      DifficultyAi difficultyAi = DifficultyFactory.chooseDifficulty(difficulty);
      // Does the AI strategy that corresponds to that difficulty
      botHand =
          difficultyAi.doStrat(oddCounter, evenCounter, choice, roundIterator, previousWinner);
      MessageCli.PRINT_INFO_HAND.printMessage(botName, Integer.toString(botHand));
      // Finds the sum of AI hand + user input
      sum = botHand + Integer.parseInt(noOfFingers);
      // User input is Even
      if (this.choice.equals(Choice.EVEN)) {
        // If sum is even
        if (Utils.isEven(sum)) {
          MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), "EVEN", name);
          currentWinner = false;
        }
        // If sum is odd
        else {
          MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), "ODD", botName);
          currentWinner = true;
          aiWins++;
        }
      }
      // User input is Odd
      else if (this.choice.equals(Choice.ODD)) {
        // If sum is odd
        if (!Utils.isEven(sum)) {
          MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), "ODD", name);
          currentWinner = false;
        }
        // If sum is even
        else {
          MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), "EVEN", botName);
          currentWinner = true;
          aiWins++;
        }
      }

      // Counts how many is odd or even
      if (Utils.isEven(Integer.parseInt(noOfFingers))) {
        evenCounter++;
      } else if (!Utils.isEven(Integer.parseInt(noOfFingers))) {
        oddCounter++;
      }
      // Stores who won the previous game
      previousWinner = currentWinner;
      currentWinner = false;
    }
  }

  /**
   * Ends the actual game and shows who won, cannot be executed if a new game hasnt been created.
   */
  public void endGame() {

    // Checks if name is empty, if name is empty than no new game has been created
    // , so command cant be run
    if (!name.isEmpty()) {
      // Prints how many the player won
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          name, Integer.toString(roundIterator - aiWins), Integer.toString(aiWins));
      // Prints how many the AI won
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          botName, Integer.toString(aiWins), Integer.toString(roundIterator - aiWins));

      // If there is a tie
      if (aiWins == (roundIterator - aiWins)) {

        MessageCli.PRINT_END_GAME_TIE.printMessage();
      }
      // If AI wins
      else if (aiWins > (roundIterator - aiWins)) {
        MessageCli.PRINT_END_GAME.printMessage(botName);
      }
      // If user wins
      else if ((roundIterator - aiWins) > aiWins) {
        MessageCli.PRINT_END_GAME.printMessage(name);
        oddCounter = 0;
        evenCounter = 0;
        roundIterator = 0;
        previousWinner = false;
        name = "";
      }
    }
    // If user input is empty
    else if (name.isEmpty()) {
      MessageCli.GAME_NOT_STARTED.printMessage();
    }
  }

  /**
   * Shows stats only while the game is playing, checking whether the name is empty or not to
   * determine if a game has started.
   */
  public void showStats() {
    // Checks if name is empty to see if a new game has been created
    if (!name.isEmpty()) {
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          name, Integer.toString(roundIterator - aiWins), Integer.toString(aiWins));
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          botName, Integer.toString(aiWins), Integer.toString(roundIterator - aiWins));
    } else {
      MessageCli.GAME_NOT_STARTED.printMessage();
    }
  }
}
