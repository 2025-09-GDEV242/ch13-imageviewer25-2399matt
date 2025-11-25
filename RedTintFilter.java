import java.awt.Color;
/**
 * Class to apply a red tint filter to an image. 
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RedTintFilter extends Filter
{
    // instance variables - replace the example below with your own
    public RedTintFilter(String name) {
        super(name);
    }
    
    public void apply(OFImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++) {
                Color currColor = image.getPixel(x,y);
                int red = currColor.getRed();
                int green = (int)(currColor.getGreen() * 0.5f);
                int blue = (int)(currColor.getBlue() * 0.5f);
                image.setPixel(x,y, new Color(red, green, blue));
            }
        }
    }
}
