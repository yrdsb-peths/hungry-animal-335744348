import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title Screen
 * 
 * Alex V
 * May 19th, 2022
 */
public class TitleScreenWorld extends World
{

    /**
     * Constructor for objects of class TitleScreenWorld.
     * 
     */
    public TitleScreenWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        Label titleLabel = new Label("Hungry Turtle", 75);
        addObject(titleLabel, 300, 200);
        Label instructions = new Label ("Move with WASD, press space to start", 40);
        addObject(instructions, 300, 280);
        prepare();
    }

    public void act()
    {
        if (Greenfoot.isKeyDown("space"))
        {
            MyWorld world = new MyWorld();
            Greenfoot.setWorld(world);
        }
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Turtle turtle = new Turtle(3);
        addObject(turtle,375,85);
        turtle.setLocation(315,143);
        turtle.setLocation(218,131);
    }
}
