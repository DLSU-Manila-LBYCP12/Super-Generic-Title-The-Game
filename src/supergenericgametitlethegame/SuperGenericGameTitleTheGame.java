/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supergenericgametitlethegame;
import bulletHell.*;
import acm.program.*;
import javax.swing.JLabel;
import java.io.*;
import java.util.logging.Logger;
import sun.audio.*;
/**
 *
 * @author Paolo
 */
public class SuperGenericGameTitleTheGame extends Program implements SuperGenericGameTitleTheGameConstants{
    private Bullet samplebullet = new Bullet();
    private GameCanvas canvas = new GameCanvas();
    private JLabel Score = new JLabel("Placeholder");
    private ObjectTracker tracker = new ObjectTracker();
    private Level level = null;
    private Player Player = new Player();
    int x = 0;
    int currentlevel = 1;
    InputStream music;
    /**
     * @param args the command line arguments
     */
    
    public void init(){
        
        add(Score, NORTH);
        add(canvas);
        canvas.addbg(1);
        try {
            music();
        } catch (IOException ex) {
            Logger.getLogger(SuperGenericGameTitleTheGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
    }
    public void run(){
        tracker.setBounds(getWidth(), getHeight());
        demo();
        //canvas.placeholder();
        while(true){
            
            tracker.updateObjects();
            canvas.drawFrame(tracker.getBullets(), tracker.getEnemies());
            pause(FRAME_PAUSE);
            tracker.addEnemy(level.spawnEnemies(FRAME_PAUSE).iterator());
            
        }
    }
    public void music() throws FileNotFoundException, IOException{
        music=new FileInputStream(new File("src\\audio\\unowen.wav"));
        AudioStream audios=new AudioStream(music);
        AudioPlayer.player.start(audios); 
        
    }
    
    public void demo(){
        /*
        Bullet bullet2 = new Bullet();
        Bullet bullet = new Bullet();
        bullet.setLocation(50, 50);
        bullet.setDirectionDegrees(290);
        bullet.setVelocity(200);
        bullet.setImage("bluebullet.png");
        tracker.addProjectile(bullet);
        bullet = new Bullet();
        bullet.setLocation(200, 200);
        bullet.setDirectionDegrees(x);
        bullet.setVelocity(75);
        bullet.setImage("redbullet.png");
        tracker.addProjectile(bullet);
        
        Enemy enemy = new Enemy(getWidth(), getHeight()); 
        for(int i=0;i!=10;i++){
        bullet = new Bullet();    
        bullet.setLocation(200, 200);
        bullet.setDirectionDegrees(30*i);
        bullet.setVelocity(600);
        bullet.setImage("redbullet.png");
        enemy.addBulletSpawn(bullet, 90, 10, i*100);
        }
        //tracker.addProjectile(bullet);
        
        enemy.setLocation(50, 50);
        enemy.setVelocity(10, 100);
        enemy.setImage("centrifuge.png");
        enemy.setImageSize(100, 100);
        tracker.addEnemy(enemy);
        */
        //tracker.addEnemy(spawnclockwisespinner(50,50,0,0));
        wiper(350,50,0,0);
        laser(350,50,-50,0,270);
        
        level = new Level();
        level.addEnemySpawn(spawnclockwisespinner(50,50,50,50), 1000);
        
    }
    public Enemy spawnclockwisespinner(int xloc, int yloc, int xvel, int yvel){
        Bullet bullet;
        Enemy enemy = new Enemy(getWidth(), getHeight()); 
        for(int i=0;i!=12;i++){
        bullet = new Bullet();    
        bullet.setLocation(200, 200);
        bullet.setDirectionDegrees(30*i);
        bullet.setVelocity(600);
        bullet.setImage("redbullet.png");
        enemy.addBulletSpawn(bullet, 90, 10, i*100);
        }
        //tracker.addProjectile(bullet);
        
        enemy.setLocation(xloc,yloc);
        enemy.setVelocity(xvel, yvel);
        enemy.setImage("centrifuge.png");
        enemy.setImageSize(30, 30);
        return enemy;
    }
    public Enemy spawncounterspinner(int xloc, int yloc, int xvel, int yvel){
        Bullet bullet = new Bullet();
        Enemy enemy = new Enemy(getWidth(), getHeight()); 
        for(int i=0;i!=12;i++){
        bullet = new Bullet();    
        bullet.setLocation(200, 200);
        bullet.setDirectionDegrees(120+(-i*30));
        bullet.setVelocity(600);
        bullet.setImage("redbullet.png");
        enemy.addBulletSpawn(bullet, 90, 10, i*100);
        }
        //tracker.addProjectile(bullet);
        
        enemy.setLocation(xloc,yloc);
        enemy.setVelocity(xvel, yvel);
        enemy.setImage("centrifuge.png");
        enemy.setImageSize(30, 30);
        return enemy;
    }
    public void wiper(int xloc, int yloc, int xvel, int yvel){
        
        Bullet bullet = new Bullet();
        Enemy enemy = new Enemy(getWidth(), getHeight()); 
        for(int i=1;i!=18;i++){
        bullet = new Bullet();    
        bullet.setLocation(200, 200);
        bullet.setDirectionDegrees(-i*10);
        bullet.setVelocity(200);
        bullet.setImage("redbullet.png");
        enemy.addBulletSpawn(bullet, 90, 10, i*100);
        }
        for(int i=1;i!=18;i++){
        bullet = new Bullet();    
        bullet.setLocation(200, 200);
        bullet.setDirectionDegrees(180+(i*10));
        bullet.setVelocity(200);
        bullet.setImage("redbullet.png");
        enemy.addBulletSpawn(bullet, 90, 10, 1800+(i*100));
        }
        //tracker.addProjectile(bullet);
        
        enemy.setLocation(xloc,yloc);
        enemy.setVelocity(xvel, yvel);
        enemy.setImage("centrifuge.png");
        enemy.setImageSize(30, 30);
        tracker.addEnemy(enemy);
    }
    public void laser(int xloc, int yloc, int xvel, int yvel,int angle){
        
        Bullet bullet = new Bullet();
        Enemy enemy = new Enemy(getWidth(), getHeight()); 
        
        bullet = new Bullet();    
        bullet.setLocation(200, 200);
        bullet.setDirectionDegrees(angle);
        bullet.setVelocity(400);
        bullet.setImage("redbullet.png");
        enemy.addBulletSpawn(bullet, 90, 10, 100);
       
        //tracker.addProjectile(bullet);
        
        enemy.setLocation(xloc,yloc);
        enemy.setVelocity(xvel, yvel);
        enemy.setImage("centrifuge.png");
        enemy.setImageSize(30, 30);
        tracker.addEnemy(enemy);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        new SuperGenericGameTitleTheGame().start(args);
    }
    
}
