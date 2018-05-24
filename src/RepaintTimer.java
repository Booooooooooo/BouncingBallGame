// Exercise 23.10 Solution: RepaintTimer.java
// Repaints the JPanel with bouncing balls.

import javax.swing.*;

public class RepaintTimer implements Runnable {
   private final JFrame repaintComponent;
   private boolean stop = false;

   public RepaintTimer(JFrame frame) {
      // specify component to be repainted
      repaintComponent = frame;
   }
   
   public void run() {
      while (stop == false) {
         try {
            Thread.sleep(20);
         }
         catch (InterruptedException ex) {
            ex.printStackTrace();
         }
         
         repaintComponent.repaint(); // repaint the component
     }
   }

   public void setStop(boolean stop) {
      this.stop = stop;
   }

   public boolean isStop() {
      return stop;
   }
}

