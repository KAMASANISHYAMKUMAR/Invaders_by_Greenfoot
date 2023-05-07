import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Car extends Actor
{
    private int speed;
    private int distance;
    private int timerCount;
    private static final int reloadTime=25;
    public static int score=0;
    private int rotation;
    public Car(int speed,int rotation){
        getImage().scale(getImage().getWidth()/2,getImage().getHeight()/2);
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
    public void fire(){
        if(timerCount>=reloadTime){
            if(Greenfoot.isKeyDown("space")){
                releaseFire();
                timerCount=0;
            }
        }
    }
    public void releaseFire(){
        World world=getWorld();
        Fire fire=new Fire(10);
        world.addObject(fire,getX(),getY());
        fire.setRotation(getRotation());
        Greenfoot.playSound("fire.wav");
    }
    public void score(){
        
    }
}
