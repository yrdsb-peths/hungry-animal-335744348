import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public int score = 0;
    Label scoreLabel;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);         
        bear b = new bear("Jim", 3);
        addObject(b, 300, 300);
        seal s = new seal("Alex", 3);
        addObject(s, 300, 150);
        
        //creating a label for the score
        scoreLabel = new Label(0, 70);
        addObject(scoreLabel, 50, 50);
        
        addBread();
    }
    
    //new method to increase score
    public void increaseScore()
    {
        score ++;
        scoreLabel.setValue(score);
    }
    
    public void addBread()
    {
        int y = 0;
        int x = Greenfoot.getRandomNumber(600);
        bread br = new bread();
        addObject(br, x, y);
    }
}
