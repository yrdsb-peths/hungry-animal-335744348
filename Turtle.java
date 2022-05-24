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
    int imageIndex = 0;
    GreenfootImage[] walkRight = new GreenfootImage[4];
    GreenfootImage[] walkLeft = new GreenfootImage[4];
    private boolean isFacingRight = true;
    
    public Turtle(int speed)
    {
        this.speed = speed;
        for (int i = 0; i < 4; i ++)
        {
            walkLeft[i] = new GreenfootImage("images/turtle walk/walk" + i + ".png");
            walkLeft[i].scale(110,70);
            walkRight[i] = new GreenfootImage("images/turtle walk/walk" + i + ".png");
            walkRight[i].mirrorHorizontally();
            walkRight[i].scale(110,70);   
        }
        setImage(walkRight[0]);
        walkTimer = new SimpleTimer();
        walkTimer.mark();
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("d"))
        {
            move(speed);
            isFacingRight = true;
        }
        if(Greenfoot.isKeyDown("a"))
        {
            move(speed*-1);
            isFacingRight = false;
        }
        eat();
        animateTurtle();
    }
    
    //animation of turtle actor
    
    public void animateTurtle()
    {
        
        if(walkTimer.millisElapsed() > 120)
        {
            if (isFacingRight == true)
            {
                setImage(walkRight[imageIndex]);
                imageIndex = (imageIndex + 1) % 4;
            }
            else 
            {
                setImage(walkLeft[imageIndex]);
                imageIndex = (imageIndex + 1) % 4;
            }
            walkTimer.mark();
        }
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
}
