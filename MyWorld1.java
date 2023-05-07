import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld1 extends World
{

    /**
     * Constructor for objects of class MyWorld1.
     * 
     */
    private int timecount=0;
    private static int delaytime=30;
    public MyWorld1()
    {    
        super(1244, 700, 1); 
        carStartPos();
        Enemy2();//192
    }
    public void carStartPos(){
        addObject(new Car1(10,5),143,350);
    }
    public void Enemy2(){
            int n = 8; // adjust n to change the size of the arrow
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < n-i; j++) {
                addObject(new Enemy2(),1185-(j*30),60+(j*40));
                addObject(new Enemy2(),1085-(j*40),40+(j*10));
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                addObject(new Enemy2(),970+(j*30),400+(j*40));
                addObject(new Enemy2(),850+(j*40),600+(j*10));
            }
        }
    }
    public void act(){
        displayScore();
        //nextLevel();
    }
    public void displayScore(){
        showText("Score :"+Car.score,200,200);
    }
    public void nextLevel(){
        if(Car.score>=192){
            timecount++;
            if(timecount<=delaytime){
                setBackground("levelup.png");
            }else{
                Greenfoot.setWorld(new NewWorld2());
            }
        }
    }
}
