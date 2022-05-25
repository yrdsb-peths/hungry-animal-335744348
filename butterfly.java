import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bear2 here.
 */
public class butterfly extends Actor
{
    /**
     * Act - do whatever the bear2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    String name;
    int speed;
    GreenfootImage[] flyRight = new GreenfootImage[3];
    GreenfootImage[] flyLeft = new GreenfootImage[3];
    private SimpleTimer flyTimer;
    private int delay = 0;
    int imageIndex = 0;
    public boolean isFacingRight = true;
    
    public butterfly(String name, int speed)
    {
        this.name = name;
        this.speed = speed;
        for (int i = 0; i < 3; i ++)
        {
            flyLeft[i] = new GreenfootImage("images/butterfly/fly" + i + ".png");
            flyLeft[i].mirrorHorizontally();
            flyLeft[i].scale(50,50);
            flyRight[i] = new GreenfootImage("images/butterfly/fly" + i + ".png");
            flyRight[i].scale(50,50);   
        }
        setImage(flyRight[0]);
        flyTimer = new SimpleTimer();
        flyTimer.mark();
        setImage(flyLeft[0]);
    }
    public void act()
    {
        move(speed);
        if(this.isAtEdge())
        {
            speed = speed * -1;
        }
        if (speed > 0)
        {
            isFacingRight = true;
        }
        else
        {
            isFacingRight = false;
        }
        eat();
        animate();
    }
    
    public void eat()
    {
        if(isTouching(Bread.class))
        {
            removeTouching(Bread.class);
            MyWorld world = (MyWorld) getWorld();
            world.addBread();
            world.increaseScore(1);
        }
        if(isTouching(GoldBread.class))
        {
            removeTouching(GoldBread.class);
            MyWorld world = (MyWorld) getWorld();
            world.addBread();
            world.increaseScore(5);
        }
    }
    
    public void animate()
    {
        if(flyTimer.millisElapsed() > 120)
        {
            if (isFacingRight == true)
            {
                setImage(flyRight[imageIndex]);
                imageIndex = (imageIndex + 1) % 3;
            }
            else 
            {
                setImage(flyLeft[imageIndex]);
                imageIndex = (imageIndex + 1) % 3;
            }
            flyTimer.mark();
        }
    }
}
