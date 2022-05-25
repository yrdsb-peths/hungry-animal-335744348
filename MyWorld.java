import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public static int score = 0;
    public Label scoreLabel = new Label(0, 70);
    int breadSpeed = 3;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);    
        score = 0;
        Turtle t = new Turtle(3);
        addObject(t, 300, 350);
        butterfly b = new butterfly("Alex", 3);
        addObject(b, 300, 150);
        
        //creating a label for the score
        addObject(scoreLabel, 50, 50);
        
        //adding bread
        addBread();
    }
    
    //new method to increase score
    public void increaseScore(int amount)
    {
        score += amount;
        scoreLabel.setValue(score);
        if (score % 5 == 0)
        {
            breadSpeed += 1;
        }
    }
    
    public void addBread()
    {
        int y = 0;
        int x = Greenfoot.getRandomNumber(600);
        int chance = Greenfoot.getRandomNumber(8);
        if (chance == 1)
        {
            GoldBread br = new GoldBread();
            br.setSpeed(breadSpeed);
            addObject(br, x, y);
        }
        else 
        {
            Bread br = new Bread();
            br.setSpeed(breadSpeed);
            addObject(br, x, y);
        }
    }
    
    public void gameOver()
    {
        GameOverWorld world = new GameOverWorld();
        Greenfoot.setWorld(world);
    }
}
