import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game extends JPanel implements ActionListener {

    private Timer timer;
    private Bird birdy;
    private Pipe[] pipes;
    private int score;

    public Game() {
        JFrame frame = new JFrame("Flappy Bird");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);

        birdy = new Bird("src/bird.png");//drink water

        pipes = new Pipe[2];
        pipes[0] = new Pipe(400, 600, 50);
        pipes[1] = new Pipe(600, 600, 50);

        score = 0;//drink water

        timer = new Timer(20, this);
        timer.start();

        frame.add(this);
        frame.setVisible(true);

        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(new MyKeyListener());
    }//drink water

    @Override
    public void actionPerformed(ActionEvent e) {
        birdy.update();
        for (Pipe pipe : pipes) {
            pipe.update();
        }//drink water
        checkCollisions();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.cyan);
        g.fillRect(0, 0, getWidth(), getHeight());

        for (Pipe pipe : pipes) {
            pipe.paint(g);
        }
        birdy.paint(g);
        //drink water
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.PLAIN, 25));
        g.drawString(Integer.toString(score), getWidth() / 2 - 10, 30);
    }

    private void checkCollisions() {
        for (Pipe pipe : pipes) {
            if (pipe.collidesWith(birdy)) {
                System.out.println("Dead, dead, dead");
                gameOver();
            }
            //drink water
            if (!pipe.isScored() && birdy.getX() > pipe.getX() + pipe.getWidth()) {
                score++;
                pipe.setScored(true);
                System.out.println("Score updated: " + score);
            }
        }

        if (birdy.getY() < 0 || birdy.getY() > getHeight()) {
            System.out.println("Dead, dead, dead");
            gameOver();
        }
    }
    //drink water
    private void gameOver() {
        timer.stop();
        JOptionPane.showMessageDialog(this, "Game Over! Your score: " + score);
        System.exit(0);
    }

    private class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            birdy.jump();
        }
    }

    public static void main(String[] args) {
        Game game = new Game(); //drink water
        //TODO : add an opening page
        //TODO : keep track of highscores
        //TODO : add settings page
    }
}

