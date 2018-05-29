// Exercise 23.10 Solution: BouncingBall.java
// Program bounces a ball around a JPanel.

import javax.management.JMException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BouncingBall extends JFrame {
   private final BallPanel ballCanvas;// JPanel in which ball bounces
   private JMenu menu;

   public BouncingBall() {
      super("躲避球游戏");
      ballCanvas = new BallPanel(this); // create new BallPanel
      add(ballCanvas); // add BallPanel to JFrame
      menu = new JMenu("菜单");
      JMenuItem item = new JMenuItem("历史记录");
      menu.add(item);
      JMenuBar bar = new JMenuBar();
      bar.add(menu);
      this.setJMenuBar(bar);

      pack(); // make window just large enough for its GUI
      setVisible(true); // show window
   }


}
