// Exercise 23.10 Solution: BouncingBall.java
// Program bounces a ball around a JPanel.

import javax.swing.*;

public class BouncingBall extends JFrame {
   private final BallPanel ballCanvas;// JPanel in which ball bounces
   //private JLabel scoreLabel;

   public BouncingBall() {
      super("弹球游戏");
      ballCanvas = new BallPanel(this); // create new BallPanel
      add(ballCanvas); // add BallPanel to JFrame

      pack(); // make window just large enough for its GUI
      setVisible(true); // show window
   }

}
