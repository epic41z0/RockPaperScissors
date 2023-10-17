package grupparbetet;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RockPaperScissorsGame extends JFrame {

  // Olika klasser som går ihop med de olika knapparna
  private JButton rockButton;//
  private JButton paperButton;
  private JButton scissorsButton;
  private JButton playAgainButton;
  private JLabel resultLabel;
  private int playerScore = 0;
  private int computerScore = 0;
  private int roundsPlayed = 0;

  private static final String ROCK = "rock";
  private static final String PAPER = "paper";
  private static final String SCISSORS = "scissors";

  // Utgör titeln av programmet
  public RockPaperScissorsGame() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Rock, Paper, Scissors");
    // Placering av popup skärmen som dyker upp
    setLocationRelativeTo(null);
    // Storlek på popup skärmen
    setSize(600, 500);
    
    // Text i de olika knapparna
    rockButton = new JButton("Rock");
    paperButton = new JButton("Paper");
    scissorsButton = new JButton("Scissors");
    playAgainButton = new JButton("Play again");
    resultLabel = new JLabel("");
    
    // Knappar
    setLayout(new GridLayout(8, 5));
    add(new JLabel("Make your choice:"));
    add(rockButton);
    add(paperButton);
    add(scissorsButton);
    add(resultLabel);
    add(playAgainButton);
   
    // Knappar som används för att välja sten, sax, påse
    rockButton.addActionListener(e -> playGame(ROCK));
    paperButton.addActionListener(e -> playGame(PAPER));
    scissorsButton.addActionListener(e -> playGame(SCISSORS));

    playAgainButton.addActionListener(e -> resetGame());
    playAgainButton.setEnabled(false);
  }

  // Slumpar datorns val av sten, sax, påse vid varje spel
  private void playGame(String userChoice) {
   
    String[] choices = { ROCK, PAPER, SCISSORS };
    Random random = new Random();
    int computerIndex = random.nextInt(choices.length);
    String computerChoice = choices[computerIndex];

    String result;
    // Programmet skriver ut att användaren vann, förlora eller jämt utifrån
    // användarens inmatning med jämförelse av vad datorn hade valt av sten, sax
    // påse
    
    if (userChoice.equals(computerChoice)) {
      result = "It's a tie!";

    } else if ((userChoice.equals(ROCK) && computerChoice.equals(SCISSORS)) ||
        (userChoice.equals(PAPER) && computerChoice.equals(ROCK)) ||
        (userChoice.equals(SCISSORS) && computerChoice.equals(PAPER))) {
      result = "You got a point!";
      playerScore++;

    } else {
      result = "Computer got a point!";
      computerScore++;

    }

    // Skrivet ut inmatning från användaren jämförs med datorns val
    resultLabel.setText("You chose: " + userChoice + ".     Computer chose: " + computerChoice + ".     " + result);
    roundsPlayed++;
    resultLabel.setText(resultLabel.getText() + "     You: " + playerScore + " Computer: " + computerScore);
    

    if (roundsPlayed == 10) {
      endGame();
    }

  }

    private void endGame() {
      rockButton.setEnabled(false);
      paperButton.setEnabled(false);
      scissorsButton.setEnabled(false);

      playAgainButton.setEnabled(true);

      String gameResult;
      if (playerScore > computerScore) {
        gameResult = "Game over!      YOU WON! Congratulations! ";
      } else if (playerScore < computerScore) {
        gameResult = "Game over!      YOU LOST! better luck next time! ";

      } else {
        gameResult = "GAME over!      IT'S A TIE! ";

      }

      resultLabel.setText(gameResult + "      You: " + playerScore + " Computer: " + computerScore);
    }

      private void resetGame() {
        rockButton.setEnabled(true);
        paperButton.setEnabled(true);
        scissorsButton.setEnabled(true);

        playAgainButton.setEnabled(false);
      
        playerScore = 0;
        computerScore = 0;
        roundsPlayed = 0;
        resultLabel.setText("");
      
      }
      
}


