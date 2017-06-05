import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Pipe extends Actor
{
    private int PIPE_SPEED = -4;

    /**
     * Act - do whatever the Pipe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */ 
    public void act() 
    { 
        if (((FlappyWorld)(getWorld())).isPaused == false)
        {
            this.setLocation( getX() + PIPE_SPEED, getY());
        }    
    }
}
