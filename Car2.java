import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Car2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Car2 extends Actor
{
    /**
     * Act - do whatever the Car2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed;
    private int distance;
    private int timerCount;
    private static final int reloadTime=5;
    private int rotation;
    public Car2(int speed,int rotation){
        getImage().scale(getImage().getWidth()/3,getImage().getHeight()/3);
        this.speed=speed;
        this.rotation=rotation;
    }
    public void act()
    {
        timerCount++;
        move(speed);
        fire();
        rotateCW();
        rotateACW();
    }
    public void move(int distance){
        if(Greenfoot.isKeyDown("right")){
            setLocation(getX()+distance,getY());
        }
        if(Greenfoot.isKeyDown("left")){
            setLocation(getX()-distance,getY());
        }
        if(Greenfoot.isKeyDown("up")){
            setLocation(getX(),getY()-distance);
        }
        if(Greenfoot.isKeyDown("down")){
            setLocation(getX(),getY()+distance);
        }
        if(getX()==1243){
            setLocation(0,getY());
        }
        if(getY()==0){
            setLocation(getX(),700);
        }else if(getY()==699){
            setLocation(getX(),0);
        }
    }
    public void fire(){
        if(timerCount>=reloadTime){
            if(Greenfoot.isKeyDown("space")){
                releaseFire();
                timerCount=0;
            }
        }
    }
    public void releaseFire(){
        Greenfoot.playSound("fire.wav");
        World world=getWorld();
        Fire2 fire2=new Fire2(10);
        world.addObject(fire2,getX(),getY());
        fire2.setRotation(getRotation());
    }
    public void rotateCW(){
        if(Greenfoot.isKeyDown("q")){
            turn(rotation);
        }
    }
    public void rotateACW(){
        if(Greenfoot.isKeyDown("w")){
            turn(-rotation);
        }
    }
}
