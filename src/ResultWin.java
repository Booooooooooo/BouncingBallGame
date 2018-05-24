import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultWin extends JFrame implements ActionListener {
    private JLabel result;
    private JButton restart;
    private JButton exit;
    private int score;
    private final int width = 400;
    private final int height = 150;
    private BouncingBall bouncingBall;

    public ResultWin(int score){
        super("啊哦");
        this.score = score;

        result = new JLabel("对不起，您输了\n您的分数是：" + score);
        //restart = new JButton("重新开始");
        exit = new JButton("退出");
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(Box.createHorizontalStrut(width / 3));
        //buttonPanel.add(restart);
        buttonPanel.add(exit);
        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.X_AXIS));
        messagePanel.add(Box.createHorizontalStrut(width / 6));
        messagePanel.add(result);
        add(messagePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setSize(width, height);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event){
        if(event.getSource() == exit){
            dispose();
        }
    }
}
