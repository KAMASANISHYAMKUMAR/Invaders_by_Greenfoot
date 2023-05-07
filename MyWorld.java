import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private GreenfootImage background;
    private int scrollSpeed = 2;
    private int scrollPosition = 0;
    private int timecount=0;
    private int delaytime=30;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1244, 700, 1);
        background = new GreenfootImage("WorldBG.png");
        Enemy1();
        carStartPos();
    }
    public void carStartPos(){
        addObject(new Car(5,5),143,350);
    }
    public void Enemy1(){
            int n = 8; // adjust n to change the size of the arrow
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < n-i; j++) {
                addObject(new Enemy1(),1185-(j*30),60+(j*40));
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                addObject(new Enemy1(),970+(j*30),400+(j*40));
            }
        }
    }
    public void act(){
        displayScore();
        nextLevel();  
    }
    public void displayScore(){
        showText("Score :"+Car.score,92,58);
    }
    public void nextLevel(){
        if(Car.score>=64){
            timecount++;
            if(timecount<=delaytime){
                setBackground("levelup.png");
            }else{
                Greenfoot.setWorld(new MyWorld1());
            }
        }
    }
}
