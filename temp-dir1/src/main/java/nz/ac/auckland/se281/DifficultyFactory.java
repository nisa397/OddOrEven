package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class DifficultyFactory {

  /**
   * Puts the input from the user into the system, and generates that difficulty.
   *
   * @param difficulty the inputted difficulty by the user.
   * @return returns the difficulty chosen.
   */
  public static DifficultyAi chooseDifficulty(Difficulty difficulty) {
    // Chooses which difficulty to be set
    switch (difficulty) {
      case EASY:
        return new EasyAi();

      case MEDIUM:
        return new MediumAi();

      case HARD:
        return new HardAi();
    }
    return null;
  }
}
