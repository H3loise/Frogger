import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Image {
    public BufferedImage Frog;
    public BufferedImage Car_LTR;
    public BufferedImage Car_RTL;
    public BufferedImage Star;
    public BufferedImage Death;
    public BufferedImage FrogInv;
    public BufferedImage Safe;


    public Image(){
        this.Frog=ChargeImage("Frog");
        this.Car_LTR=ChargeImage("Car_LTR");
        this.Car_RTL=ChargeImage("Car_RTL");
        this.Star=ChargeImage("star");
        this.Death=ChargeImage("death");
        this.FrogInv=ChargeImage("frogInv");
        this.Safe=ChargeImage("Safe");
    }



    public static BufferedImage ChargeImage(String filename) {
        try {
            return ImageIO.read(new File("src/" + filename + ".png"));
        } catch (IOException io) {
            System.out.println(filename);
            throw new RuntimeException(io);
        }
    }
}
