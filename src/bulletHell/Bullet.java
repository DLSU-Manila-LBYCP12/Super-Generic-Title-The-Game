/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bulletHell;
import acm.graphics.GImage;


/**
 *
 * @author Paolo
 */
public class Bullet {
    Object shooter = null;
    boolean isfromplayer=false;
    BHImage image = new BHImage();
    String imgfile = "";
    double xvelocity = 0;
    double xlocation = 0;
    double yvelocity = 0;
    double ylocation = 0;
    double direction = 0; //in degrees
    
    double sizex = 0;
    double sizey = 0;
    
    public void setShooter(Enemy gun){
        shooter = gun;
    }
    
    public void setfromplayer(){
        isfromplayer=true;
    }
    
    public boolean isFromPlayer(){
        return isfromplayer;
    }
    
    public Object getShooter(){
        return shooter;
    }
    
    public void setVelocity(double new_velocity){
        double rads = (3.14/180)*direction;
        xvelocity = new_velocity * Math.cos(rads);
        yvelocity = new_velocity * Math.sin(rads)*(-1);
    }
    
    public void setVelocity(double newx, double newy){
        xvelocity = newx;
        yvelocity = newy;
    }
    
    public void setXVelocity(double newx){
        xvelocity = newx;
    }
    public void setYVelocity(double newy){
        yvelocity = newy;
    }
    public double getXVelocity(){
        return xvelocity;
    }
    public double getYVelocity(){
        return yvelocity;
    }
    /**sets the direction in degrees*/
    public void setDirectionDegrees(double degree){
        direction = degree;
        double velocity = Math.hypot(xvelocity, yvelocity);
        xvelocity = velocity * Math.cos(direction);
        yvelocity = velocity * Math.sin(direction)*(-1);
        
    }
    
    public double getX(){
        return xlocation;
    }
    
    public double getY(){
        return ylocation;
    }
    
    /**set image using the filename found in src/images */
    public void setImage(String filename){
        imgfile = filename;
        image.setImage(new GImage(filename));
        sizex = image.getImage().getWidth();
        sizey = image.getImage().getWidth();
    }
    
    /*public void setImage(GImage img){
        image = img;
        sizex = image.getWidth();
        sizey = image.getWidth();
    }*/
    
    public void setImage(String filename, double sizex, double sizey){
        imgfile = filename;
        image.setImage(new GImage(filename));
        image.getImage().setSize(sizex, sizey);
        this.sizex = sizex;
        this.sizey = sizey;
    }
    
    /*public void setImage(GImage img, double sizex, double sizey){
        image = img;
        image.setSize(sizex, sizey);
        this.sizex = sizex;
        this.sizey = sizey;
    }*/
    
    public void setImageSize(double sizex, double sizey){
        image.getImage().setSize(sizex, sizey);
        this.sizex = sizex;
        this.sizey = sizey;
    }
    
    public GImage getImage(){
        return image.getImage();
    }
    
    public String getImageFile(){
        return imgfile;
    }
    
    public double getXsize(){
        return sizex;
    }
    
    public double getYsize(){
        return sizey;
    }
    
    public void setLocation(double x, double y){
        xlocation = x;
        ylocation = y;
    }
    
    public void updateLocation(double time){
        xlocation+=(xvelocity*time/1000);
        ylocation+=(yvelocity*time/1000);
    }
    
}
