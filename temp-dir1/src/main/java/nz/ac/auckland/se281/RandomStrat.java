package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class RandomStrat implements AiStrategy {

  private int randNum;

  /**
   * Choosing random number between 0 and 5. Utilizes the getRandomNumberRange method from Utils
   * class.
   */
  @Override
  public int getNumber(int oddCounter, int evenCounter, Choice choice) {

    this.randNum = Utils.getRandomNumberRange(0, 5);
    return randNum;
  }
}
