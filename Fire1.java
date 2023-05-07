import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fire1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fire1 extends Actor
{
    /**
     * Act - do whatever the Fire1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed;
    public Fire1(int speed){
        this.speed=speed;
        getImage().scale(getImage().getWidth()/8,getImage().getHeight()/8);
    }
    public void act()
    {
        move(speed);
        destroy();
    }
    public void destroy(){
        Enemy2 enemy=(Enemy2)getOneIntersectingObject(Enemy2.class);
        FireE2 firee2=(FireE2)getOneIntersectingObject(FireE2.class);
        if(enemy!=null){
            Greenfoot.playSound("impact.wav");
            World world=getWorld();
            world.removeObject(enemy);
            world.removeObject(this);
            Car.score++;
        }else if(firee2!=null){
            World world=getWorld();
            world.removeObject(firee2);
        }else if(isAtEdge()){
            World world=getWorld();
            world.removeObject(this);
        }
    }
}
