import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BallGame extends JFrame implements ActionListener {
    private JButton startGame;
    private JButton exitGame;
    private JLabel welLabel;
    private Font font;
    private final int width = 400;
    private final int height = 150;
    private BouncingBall bouncingBall;

    public BallGame(){
        super("弹球游戏");
        font = new Font("Dialog", Font.PLAIN, 14);
        welLabel = new JLabel("欢迎来到弹球游戏");
        welLabel.setFont(font);
        startGame = new JButton("开始游戏");
        startGame.setFont(font);
        exitGame = new JButton("退出");
        exitGame.setFont(font);
        startGame.addActionListener(this);
        exitGame.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(startGame);
        buttonPanel.add(exitGame);
        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.X_AXIS));
        messagePanel.add(Box.createHorizontalStrut(width / 3));
        messagePanel.add(welLabel);
        add(messagePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setSize(width, height);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event){
        if(event.getSource() == startGame){
            bouncingBall = new BouncingBall();
            bouncingBall.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            dispose();
        }
        else if(event.getSource() == exitGame){
            dispose();
        }
    }
    public static void main(String[] args){
        BallGame game = new BallGame();
        game.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
