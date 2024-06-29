package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public interface DifficultyAi {
  /*
  Chooses which strategy to do of the two strategy and how it msut be done.
   */
  int doStrat(
      int oddCounter, int evenCounter, Choice choice, int roundIterator, boolean previousWinner);
}
