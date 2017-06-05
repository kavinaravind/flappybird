import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)



public class Score extends Actor
{
    public Score()
    {
        GreenfootImage newImage = new GreenfootImage(50, 50);
        setImage(newImage);
    }

    public void setScore(int score)
    {
        GreenfootImage newImage = getImage();
        newImage.clear();
        
        Font f = new Font("Comic Sans MS", 32);
        newImage.setFont(f);
        
        Color c = new Color(127, 127, 127, 127);
        newImage.setColor(c);
        newImage.fill();
        newImage.setColor(Color.BLACK);
        newImage.drawString("" + score, 12, 37);
        setImage(newImage);
    } 
}
