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
        move(speed);
        if(this.isAtEdge())
        {
            speed = speed * -1;
        }
    }
}
