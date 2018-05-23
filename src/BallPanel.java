// Exercise 23.10 Solution: BallPanel.java
// JPanel that creates a ball when the mouse is pressed.  Ball bounces
// around the JPanel.

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BallPanel extends JPanel {
    //final int MAX_BALL = 20;
    private Ball[] ball = new Ball[10]; // bouncing ball
    private ExecutorService threadExecutor; // for running Ball runnable
    private JFrame parentWindow; // parent window of JPanel
    private final int MAX_X = 500; // horizontal edge of JPanel
    private final int MAX_Y = 500; // vertical edge of JPanel
    private JLabel label;
    private int ballNum = 0;
    private int speed = 0;
    private RepaintTimer timer;

    public BallPanel(JFrame window) {
        parentWindow = window; // set parent window of JPanel
        threadExecutor = Executors.newCachedThreadPool();

        label = new JLabel("分数:");
        label.setFont(new Font("Dialog", Font.PLAIN, 14));
        add(label);
        /*if(ballNum == 0 || ball[ballNum - 1].getScore() >= ballNum * 5){
            createBall();
        }*/
        createBall();
        timer = new RepaintTimer(parentWindow);
        threadExecutor.execute(timer);
    }


    private void createBall() {
        if(ball[ballNum] == null){
            Random rand = new Random();
            int x = rand.nextInt(MAX_X - 40); // get x position of mouse press
            int y = rand.nextInt(MAX_Y/2); // get y position of mouse press
            ball[ballNum] = new Ball(x, y);
            threadExecutor.execute(ball[ballNum]); // set ball in motion
            ballNum++;
        }

    }

   // return minimum size of animation
     public Dimension getMinimumSize() {
        return getPreferredSize();
    }


    public Dimension getPreferredSize() {
        return new Dimension(MAX_X, MAX_Y);
    }

   // draw ball at current position
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int sc = 0;
        for(int i = 0; i < ballNum; i++){
            g.setColor(ball[i].getColor());
            g.fillOval(ball[i].getX(), ball[i].getY(), 15, 15);
            /*if(getMousePosition().x < getLocation().x){
                ball[i].setRackx(getLocation().x);
            }*/
            ball[i].setRackx(getMousePosition().x);
            ball[i].setLast(false);
            sc += ball[i].getScore();
        }

        //boolean flag = false;
        for(int i = 0; i < ballNum; i++){
            if(ball[i].isLose()){
                timer.setStop(true);
                JOptionPane.showMessageDialog(null, "对不起您输了\n您的分数是：" + sc);
                break;
            }
        }


        //ball[ballNum - 1].setLast(true);
        g.setColor(Color.black);
        g.fillRect(getMousePosition().x, MAX_Y - 20, 60, 10);
        label.setText("分数： " + sc);
        if(sc > ballNum * 5){
            createBall();
        }

    }
}

