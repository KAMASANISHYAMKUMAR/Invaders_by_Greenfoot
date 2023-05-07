import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NewWorld2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NewWorld2 extends World
{

    /**
     * Constructor for objects of class NewWorld2.
     * 
     */
    private int timecount=0;
    private static int delaytime=30;
    public NewWorld2()
    {    
        super(1244, 700, 1); 
        carStartPos();
        Enemy2();
    }
    public void carStartPos(){
        addObject(new Car2(10,5),143,350);
    }
    public void Enemy2(){
            int n = 8; // adjust n to change the size of the arrow
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < n-i; j++) {
                addObject(new Enemy3(),1185-(j*30),60+(j*40));
                addObject(new Enemy3(),1085-(j*40),40+(j*10));
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                addObject(new Enemy3(),970+(j*30),400+(j*40));
                addObject(new Enemy3(),850+(j*40),600+(j*10));
            }
        }
    }
    public void act(){
        displayScore();
        nextLevel();
    }
    public void displayScore(){
        showText("Score :"+Car.score,200,200);
    }
    public void nextLevel(){
        if(Car.score>=64){
            timecount++;
            if(timecount<=delaytime){
                setBackground("LevelUp.png");
            }else{
                Greenfoot.setWorld(new MyWorld1());
            }
        }
    }
}
