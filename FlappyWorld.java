import greenfoot.*;
import java.util.Random;

public class FlappyWorld extends World
{
    private int pipeCounter;
    private int PIPE_SPACING = 180;
    private int score = 0;
    private int FIRST_PIPE = 240;
    private int flappyCounter = 0;
    private Score scoreObject = null;
    public boolean isPaused;

    private Start start;
    private Guide guide;
    private Title title;
    private Pause pause;
    private Ground ground1;
    private Ground ground2;

    /**
     * Creates a new FlappyWorld object.
     */
    public FlappyWorld()
    {
        super(600, 400, 1, false);

        pipeCounter = 0;
        isPaused = true;

        this.setPaintOrder(GameOver.class, Score.class, Pause.class, FlappyBird.class, Ground.class, Pipe.class);

        FlappyBird flappy = new FlappyBird();
        this.addObject(flappy, 100, this.getHeight()/2); 

        start = new Start();
        this.addObject(start, this.getWidth()/2, this.getHeight()/2 + 143); 

        guide = new Guide();
        this.addObject(guide, this.getWidth()/2, this.getHeight()/2 - 50); 

        title = new Title();
        this.addObject(title, this.getWidth()/2, this.getHeight()/2 - 170);

        pause = new Pause();
        this.addObject(pause, 20, 20);

        ground1 = new Ground();
        this.addObject(ground1, this.getWidth() / 2, this.getHeight() - 10);
        ground2 = new Ground();
        this.addObject(ground2, this.getWidth() + this.getWidth() / 2, this.getHeight() - 10);

        scoreObject = new Score();
        scoreObject.setScore(0);
        this.addObject(scoreObject, this.getWidth() - 30, 30);
    }

    public FlappyWorld(int value)
    {
        super(600, 400, 1, false);

        pipeCounter = value;

        FlappyBird flappy = new FlappyBird();
        this.addObject(flappy, 100, this.getHeight() / 2); 
    }

    public void createPipes()
    {
        Pipe topPipe = new TopPipe();
        Pipe botPipe = new BottomPipe();

        GreenfootImage image = topPipe.getImage();

        Random random = new Random();
        int randomValue = random.nextInt(229) - 75;

        this.addObject(botPipe, this.getWidth(), this.getHeight()/2 + image.getHeight()/2 + randomValue); 
        this.addObject(topPipe, this.getWidth(), image.getHeight() / 2 - PIPE_SPACING + randomValue); 
    }

    public void startGame()
    {
        if(Greenfoot.mouseClicked(start) == true)
        {
            isPaused = false;
            this.removeObject(start);
            this.removeObject(guide);
            this.removeObject(title);
        }
    }

    public void pauseGame()
    {
        if(Greenfoot.mouseClicked(pause) == true)
        {
            if (isPaused == true)
            {
                isPaused = false;
            }
            else
            {
                isPaused = true;
            }
        } 
    }

    public void act()
    {
        this.startGame();
        this.pauseGame();
        
        if (ground1.getX() == (this.getWidth() / 2) * - 1)
        {
            ground1.setLocation(this.getWidth() + this.getWidth() / 2, this.getHeight() - 10);
        }
        
       if (ground2.getX() == (this.getWidth() / 2) * - 1)
       {
            ground2.setLocation(this.getWidth() + this.getWidth() / 2, this.getHeight() - 10);
       }
        
        if (isPaused == false)
        {
            pipeCounter++;
            if (pipeCounter % 100 == 0)
            {
                this.createPipes();
            }
            if (pipeCounter >= FIRST_PIPE)
            {
                if (flappyCounter % 100 == 0)
                {
                    score++;
                    scoreObject.setScore(score);
                }
                flappyCounter++;
            }
        }
    }
}