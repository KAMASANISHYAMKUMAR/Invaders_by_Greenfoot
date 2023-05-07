import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy2 extends Actor
{
    /**
     * Act - do whatever the Enemy2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int timerCount;
    private static final int reloadTime=100; 
    public Enemy2(){
        getImage().scale(getImage().getWidth()/10,getImage().getHeight()/10);
    }
    public void act()
    {
        timerCount++;
        fire();
    }
    
    public void fire(){
        if(timerCount>=reloadTime){
            releaseFire();
            timerCount=0;
        }
    }
    public void releaseFire(){
        World world=getWorld();
        world.addObject(new FireE2(5),getX(),getY());
    }
}
