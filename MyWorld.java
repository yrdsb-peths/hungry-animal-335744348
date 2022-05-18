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
    public Label scoreLabel = new Label(0, 70);
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);         
        Turtle b = new Turtle(3);
        addObject(b, 300, 300);
        seal s = new seal("Alex", 3);
        addObject(s, 300, 150);
        
        //creating a label for the score
        addObject(scoreLabel, 50, 50);
        
        //adding bread
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
        Bread br = new Bread();
        addObject(br, x, y);
    }
    
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over!", 100);
        addObject(gameOverLabel, 300, 200);
    }
}
