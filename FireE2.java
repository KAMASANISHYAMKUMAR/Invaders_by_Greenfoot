import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FireE2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FireE2 extends Actor
{
    /**
     * Act - do whatever the FireE2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed;
    private static int count=0;
    public FireE2(){
        getImage().scale(getImage().getWidth()/12,getImage().getHeight()/12);
    }
    public FireE2(int speed){
        this();
        this.speed=speed;
    }
    public void act()
    {
        move(-speed);
        destroy();
    }
    public void destroy(){
        Car1 car=(Car1)getOneIntersectingObject(Car1.class);
        FireE2 firee2=(FireE2)getOneIntersectingObject(FireE2.class);
        if(car!=null){
            World world=getWorld();
            world.removeObject(car);
            Car.score=0;
            count++;
            if(count>=1){
                Greenfoot.setWorld(new GameOver());
            }
        }
        else if(isAtEdge()){
            World world=getWorld();
            world.removeObject(this);
        }
        
    }
}
