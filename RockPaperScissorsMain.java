package grupparbetet;
import javax.swing.SwingUtilities;

public class RockPaperScissorsMain {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new RockPaperScissorsGame().setVisible(true));
  }
}
