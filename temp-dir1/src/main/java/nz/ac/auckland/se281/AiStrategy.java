package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public interface AiStrategy {
  /*
   * Gets the random number from whichever strategy.
   */
  int getNumber(int oddCounter, int evenCounter, Choice choice);
}
