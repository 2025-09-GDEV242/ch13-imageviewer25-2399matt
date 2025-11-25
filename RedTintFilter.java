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
                int green = currColor.getGreen();
                int blue = currColor.getBlue();
                // unnecesary function calls here, change it later.
                image.setPixel(x,y, 
                new Color(Math.max(red, 200), 
                Math.min(green, 128), Math.min(blue, 128)));
            }
        }
    }
}
