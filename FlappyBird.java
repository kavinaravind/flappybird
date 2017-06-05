import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class FlappyBird extends Actor
{
    private double dy = 0;
    private double gravity = .55;
    private double BOOST_SPEED = -5;

    private GreenfootImage upWing;
    private GreenfootImage straightWing;
    private GreenfootImage downWing;

    private int animFrame;

    /**
     * Creates a new FlappyBird object.
     */
    public FlappyBird()
    {
        animFrame = 5;
        
        upWing = new GreenfootImage("flappybird1.png");
        straightWing = new GreenfootImage("flappybird2.png");
        downWing = new GreenfootImage("flappybird3.png");

        this.setImage(straightWing);
    }

    private void displayGameOver()
    {
        GameOver gameOver = new GameOver();
        this.getWorld().addObject(gameOver, this.getWorld().getWidth() / 2, this.getWorld().getHeight() / 2);
        Greenfoot.stop();
    }

    private void setAnimation()
    {
        if (animFrame >= 1 && animFrame <= 3)
        {
            this.setImage(upWing);
        }
        if (animFrame >= 4 && animFrame <= 6)
        {
            this.setImage(straightWing);
        }
        if (animFrame >= 7 && animFrame <= 9)
        {
            this.setImage(downWing);
        }
    }

    private void rotateFlappyBird()
    {
        if (dy > 3 && dy <= 8)
        {
            this.setRotation(0);
        }
        else if (dy > 8 && dy <= 10)
        {
            this.setRotation(30);
        }
        else if (dy > 10 && dy <= 12)
        {
            this.setRotation(60);
        }
        else if (dy > 12 && dy < 15)
        {
            this.setRotation(90);
        }
        else if (dy > -2 && dy <= 3)
        {
            this.setRotation(-12);
        }
        else if (dy < -2)
        {
            this.setRotation(-25);
        }
    }

    public void act()
    {
        animFrame++;
        this.setAnimation();
        if (animFrame > 9)
        {
            animFrame = 0;
        }
        if (((FlappyWorld)(getWorld())).isPaused == false)
        {
            if (this.getOneIntersectingObject(Pipe.class) != null)
            {
                this.displayGameOver();
            }
    
            this.rotateFlappyBird();
            this.setLocation( this.getX(), (int)(this.getY() + dy));
    
            if (Greenfoot.isKeyDown("up") == true || Greenfoot.mouseClicked(World.class) == true)
            {
                dy = BOOST_SPEED;
            }
    
            if (this.getY() > getWorld().getHeight() - 59)
            {
                this.displayGameOver();
            }
    
            dy = dy + gravity;
        }
    }

}