package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class EasyAi implements DifficultyAi {

  /** Produces random number between 0 and 5. */
  @Override
  public int doStrat(
      int oddCounter, int evenCounter, Choice choice, int roundIterator, boolean previousWinner) {
    AiHand aiHand = new AiHand();
    aiHand.setStrategy(new RandomStrat());
    return aiHand.implementStrategy(oddCounter, evenCounter, choice);
  }
}
