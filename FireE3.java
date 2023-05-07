import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FireE3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FireE3 extends Actor
{
    /**
     * Act - do whatever the FireE3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed;
    private static int count=0;
    public FireE3(){
        getImage().scale(getImage().getWidth()/12,getImage().getHeight()/12);
    }
    public FireE3(int speed){
        this();
        this.speed=speed;
    }
    public void act()
    {
        move(-speed);
        destroy();
    }
    public void destroy(){
        Car2 car=(Car2)getOneIntersectingObject(Car2.class);
        if(car!=null){
            World world=getWorld();
            world.removeObject(car);
            Car.score=0;
            count++;
            if(count>=1){
                Greenfoot.setWorld(new GameOver());
            }
        }else if(isAtEdge()){
            World world=getWorld();
            world.removeObject(this);
        }
        
    }
}
