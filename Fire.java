import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fire here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fire extends Actor
{
    private int speed;
    public Fire(int speed){
        this.speed=speed;
        getImage().scale(getImage().getWidth()/8,getImage().getHeight()/8);
    }
    public void act()
    {
        move(speed);
        destroy();
    }
    public void destroy(){
        Enemy1 enemy=(Enemy1)getOneIntersectingObject(Enemy1.class);
        FireE1 firee1=(FireE1)getOneIntersectingObject(FireE1.class);
        if(enemy!=null){
            World world=getWorld();
            world.removeObject(enemy);
            world.removeObject(this);
            Greenfoot.playSound("impact.wav");
            Car.score++;
        }else if(firee1!=null){
            World world=getWorld();
            world.removeObject(firee1);
        }else if(isAtEdge()){
            World world=getWorld();
            world.removeObject(this);
        }
    }
}
