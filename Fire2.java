import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fire2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fire2 extends Actor
{
    /**
     * Act - do whatever the Fire2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed;
    public Fire2(int speed){
        this.speed=speed;
        getImage().scale(getImage().getWidth()/8,getImage().getHeight()/8);
    }
    public void act()
    {
        move(speed);
        destroy();
    }
    public void destroy(){
        Enemy3 enemy=(Enemy3)getOneIntersectingObject(Enemy3.class);
        FireE3 firee3=(FireE3)getOneIntersectingObject(FireE3.class);
        if(enemy!=null){
            Greenfoot.playSound("impact.wav");
            World world=getWorld();
            world.removeObject(enemy);
            world.removeObject(this);
            Car.score++;
        }else if(firee3!=null){
            World world=getWorld();
            world.removeObject(firee3);
        }else if(isAtEdge()){
            World world=getWorld();
            world.removeObject(this);
        }
        
    }
}
