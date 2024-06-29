package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class MediumAi implements DifficultyAi {

  /**
   * First three rounds it will choose random strategy After the first three rounds it will use top
   * strategy.
   */
  @Override
  public int doStrat(
      int oddCounter, int evenCounter, Choice choice, int roundIterator, boolean previousWinner) {
    AiHand aiHand = new AiHand();
    if (roundIterator < 4) {
      // For the first three rounds, uses random strategy
      aiHand.setStrategy(new RandomStrat());
      return aiHand.implementStrategy(oddCounter, evenCounter, choice);
    } else {
      // Uses after round 3
      aiHand.setStrategy(new TopStrat());
      return aiHand.implementStrategy(oddCounter, evenCounter, choice);
    }
  }
}
