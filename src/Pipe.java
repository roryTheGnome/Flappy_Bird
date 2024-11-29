import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Pipe {
    private int x;
    private int y;
    private int width;
    private int height;
    private int speed;
    private boolean scored;

    public Pipe(int x, int screenHeight, int width) {
        reset(x, screenHeight);
        this.speed = 3;
        this.width = width;
        this.scored = false;
    }

    public void update() {
        x -= speed;

        if (x + width < 0) {
            reset(400, 600);
        }
    }

    public void reset(int startX, int screenHeight) {
        this.height = 150 + (int) (Math.random() * (screenHeight / 2 - 150));//maybe change it to 100 not 150??
        //drink water
        int rando = (int) (Math.random() * 2);
        if (rando == 0) {
            this.y = 0;
        } else {
            this.y = screenHeight - this.height;
        }

        this.x = startX;
        this.scored = false;
    }
    //drink water
    public boolean collidesWith(Bird bird) {
        Rectangle birdBounds = bird.getBounds();
        Rectangle pipeBounds = getBounds();
        return birdBounds.intersects(pipeBounds);
    }

    public Rectangle getBounds() {return new Rectangle(x, y, width, height);}

    public void paint(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, width, height);
    }//drink water

    public int getX() {return x;}

    public int getY() {return y;}

    public int getWidth() {return width;}//drink water

    public boolean isScored() {return scored;}

    public void setScored(boolean scored) {this.scored = scored;}

}
