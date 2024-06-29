package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class TopStrat implements AiStrategy {

  /**
   * For the first three rounds random strat is used for the following rounds the either a random
   * odd number is chosen or a random even number is chosen, this is dependent on whether the user
   * inputs more odd or more even numbers, and their choice of odd or even.
   */
  @Override
  public int getNumber(int oddCounter, int evenCounter, Choice choice) {

    // If there is equal number of odd and even numbers chosen in prior rounds
    if (evenCounter == oddCounter) {
      return Utils.getRandomNumberRange(0, 5);
    }
    // If Choice is odd
    else if (choice.equals(Choice.ODD)) {
      // If choice is odd and more odds than even, random odd number will be returned
      if (oddCounter > evenCounter) {
        return Utils.getRandomOddNumber();
      }
      // If choice is odd and more evens than odd, random even number is returned
      else if (evenCounter > oddCounter) {
        return Utils.getRandomEvenNumber();
      }
    } else if (choice.equals(Choice.EVEN)) {
      // If choice is even and more odds than even, random even number is returned
      if (oddCounter > evenCounter) {
        return Utils.getRandomEvenNumber();
      }
      // If choice is even and more evens than odd, random odd number is returned
      else if (evenCounter > oddCounter) {
        return Utils.getRandomOddNumber();
      }
    }

    System.out.println("error");
    return -1;
  }
}
