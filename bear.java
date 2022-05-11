import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bear here.
 */
public class bear extends Actor
{
    /**
     * Act - do whatever the bear wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    String name;
    int speed;
    
    public bear(String name, int speed)
    {
        this.name = name;
        this.speed = speed;
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
