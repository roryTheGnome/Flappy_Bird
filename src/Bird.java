import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Bird extends JPanel {
    private BufferedImage image;
    private int x, y;
    private int speed;

    public Bird(String imagePath) {
        try {
            this.image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.x = 100;
        this.y = 250;
        this.speed = 0;
        //drink water
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(image, x, y, 60, 60, null);//drink water
    }

    public int getX() {return x;}

    public int getY() {return y;}

    public void jump() {speed = -10;} //TODO :maybe change the image while jumping and falling??

    public void update() {
        speed += 1;
        y += speed;//drink water
    }

    public Rectangle getBounds() {return new Rectangle(x, y, 50, 50);}

}