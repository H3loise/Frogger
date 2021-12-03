import java.awt.*;
import java.awt.image.BufferedImage;



public class Element extends Case {
    public final BufferedImage image;

    public Element(int absc, int ord, BufferedImage images) {
        super(absc, ord);
        this.image = images;
    }
    
    public Element(Case c,BufferedImage images) {
        super(c.absc, c.ord);
        this.image = images;
    }
    
}
