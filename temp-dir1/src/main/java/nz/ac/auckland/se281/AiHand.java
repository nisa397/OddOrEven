package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class AiHand {

  private AiStrategy strategy;

  /**
   * Sets the strategy to be used, so the AiHand knows which strategy to implement.
   *
   * @param strategy the selected strategy that needds to be set.
   */
  public void setStrategy(AiStrategy strategy) {
    this.strategy = strategy;
  }

  /**
   * Implements the strategy that has been set, and the get numbers method within that strategy.
   * Parameters are passed in to be used if the top strategy is used.
   *
   * @param oddCounter counts how many times user put in an odd input from the game class.
   * @param evenCounter counts how many times user put in an even input from the game class.
   * @param choice whether the user chose even or odd.
   * @return returns the number that was calculated by the strategy.
   */
  public int implementStrategy(int oddCounter, int evenCounter, Choice choice) {
    // Uses the strategy's method to get the number
    return strategy.getNumber(oddCounter, evenCounter, choice);
  }
}
