package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class HardAi implements DifficultyAi {
  // Whether randstratused was used prior or not, intilizaed to be zero
  boolean randStratUsed = false;

  /**
   * Does the strategy that is required by this difficulty, will stay at random strategy for the
   * first three rounds and then switch after, choosing the strategy that wins last.
   */
  @Override
  public int doStrat(
      int oddCounter, int evenCounter, Choice choice, int roundIterator, boolean previousWinner) {
    AiHand aiHand = new AiHand();
    // Sets strategy to random strategy if number of rounds is less than 3
    if (roundIterator < 4) {
      aiHand.setStrategy(new RandomStrat());
      // Random strategy is used, so this is set to true
      randStratUsed = true;
      return aiHand.implementStrategy(oddCounter, evenCounter, choice);
    } else {
      // If random strat was used previously and the previous winner was AI
      // Random strat is used
      if (randStratUsed && previousWinner) {
        randStratUsed = true;
        aiHand.setStrategy(new RandomStrat());
        return aiHand.implementStrategy(oddCounter, evenCounter, choice);
      }
      // If random strat wasn't used previously and the previous winner was AI,
      // Top strat is used
      else if (!randStratUsed && previousWinner) {
        randStratUsed = false;
        aiHand.setStrategy(new TopStrat());
        return aiHand.implementStrategy(oddCounter, evenCounter, choice);
      }
      // If random strat is used and the previous winner wasn't AI
      // Top Strat is used
      else if (randStratUsed && !previousWinner) {
        randStratUsed = false;
        aiHand.setStrategy(new TopStrat());
        return aiHand.implementStrategy(oddCounter, evenCounter, choice);
      }
      // If random strat isn't used and the previous winner wasn't AI
      // Random strat is used
      else if (!randStratUsed && !previousWinner) {
        randStratUsed = true;
        aiHand.setStrategy(new RandomStrat());
        return aiHand.implementStrategy(oddCounter, evenCounter, choice);
      }
    }
    return 0;
  }
}
