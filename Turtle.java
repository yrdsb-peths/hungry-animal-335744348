import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bear here.
 */
public class Turtle extends Actor
{
    /**
     * Act - do whatever the bear wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed;
    private SimpleTimer walkTimer;
    private int delay = 0;
    
    GreenfootImage[] walk = new GreenfootImage[4];
    public Turtle(int speed)
    {
        this.speed = speed;
        for (int i = 0; i < walk.length; i ++)
        {
            walk[i] = new GreenfootImage("images/turtle walk/walk" + i + ".png");
            walk[i].scale(160,100);
        }
        setImage(walk[0]);
        walkTimer = new SimpleTimer();
    }
    
    //animation of turtle actor
    int imageIndex = 0;
    
    public void animateTurtle()
    {
        setImage(walk[imageIndex]);
        imageIndex = (imageIndex + 1) % walk.length;
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("d"))
        {
            move(speed);
        }
        if(Greenfoot.isKeyDown("a"))
        {
            move(speed*-1);
        }
        if(Greenfoot.isKeyDown("w"))
        {
            setLocation(getX(), getY()-speed);
        }
        if(Greenfoot.isKeyDown("s"))
        {
            setLocation(getX(), getY()+speed);
        }
        eat();
        animateTurtle();
    }
    
    public void eat()
    {
        if(isTouching(Bread.class))
        {
            removeTouching(Bread.class);
            MyWorld world = (MyWorld) getWorld();
            world.addBread();
            world.increaseScore();
        }
    }
}
