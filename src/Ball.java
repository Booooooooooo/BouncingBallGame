
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Ball implements Runnable {
    private int id;
   private int x; // horizontal position of ball
   private int y; // vertical position of ball
   private int dx; // change in horizontal position of ball
   private int dy;
   private int rackx;
   private int score = 0;
   private final int BALL_SIZE = 15;
   private final int MAX_X = 500; // horizontal edge of JPanel
   private final int MAX_Y = 500; // vertical edge of JPanel
    private final int RACKET_Y = MAX_Y - 20;
    private final int RACKET_HEIGHT = 10;
    private final int RACKET_WIDTH = 60;
   private static final Random generator = new Random();
   private Color color;
   private boolean isLose;
   private boolean isLast = false;


   public Ball(int xPos, int yPos) {
      dx = 2; // change in x (1-5 pixels)
      dy = 5;//dy = generator.nextInt(5) + 1; // change in y (1-5 pixels)
      x = xPos; // set ball to horizontal position of mouse press
      y = yPos; // set ball to vertical position of mouse press
      color = createRandomColor();
      rackx = MAX_X / 2;
   }

   public Color getColor() {
      return color;
   }

   private Color createRandomColor(){
      Random rand = new Random();
      return new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
   }

   // bounces ball perpetually until window is closed
   public void run() {
      while (!isLose)  {// infinite loop {
         try {
            Thread.sleep(20); // sleep for 20 milliseconds
         }
         // process InterruptedException during sleep
         catch (InterruptedException exception) {
            exception.printStackTrace();
         }

         x += dx; // determine new x-position
         y += dy; // determine new y-position

         // if bounce off left or right of JPanel
         if (x <= 0 || x >= MAX_X - BALL_SIZE) {
            dx = -dx; // reverse velocity in x direction
         }

         if(y >= RACKET_Y - BALL_SIZE && (x < rackx || x > rackx + RACKET_WIDTH)){
             isLose = true;
             break;
         }else if(y <= 0){
            dy = -dy;
         }else if(y >= RACKET_Y - BALL_SIZE && x > rackx && x <= rackx + RACKET_WIDTH){
             dy = -dy;
             score++;
         }

         /*if(isLose){
             if(isLast){
                 JOptionPane.showMessageDialog(null, "对不起，您输了，您的分数是：" + score);
             }
             break;
         }*/
      } 
   }

   // get horizontal position of ball
   public int getX() {
      return x; // return x value
   }

   // get vertical position of ball
   public int getY() {
      return y; // return y value
   }

   public int getRackx(){
       return rackx;
   }

   public void setRackx(int rx){
       rackx = rx;
   }

   public int getScore(){
      return score;
   }

    public boolean isLose() {
        return isLose;
    }

    public void setLast(boolean last) {
        isLast = last;
    }

    public void setLose(boolean lose) {
        isLose = lose;
    }

}

