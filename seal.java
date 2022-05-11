import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bear2 here.
 */
public class seal extends Actor
{
    /**
     * Act - do whatever the bear2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    String name;
    int speed;
    
    public seal(String name, int speed)
    {
        this.name = name;
        this.speed = speed;
    }
    public void act()
    {
        move(speed);
        if(this.isAtEdge())
        {
            speed = speed * -1;
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
