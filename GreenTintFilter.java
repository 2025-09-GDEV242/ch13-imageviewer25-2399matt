import java.awt.Color;

/**
 * Class to apply a green tint filter to an image.
 *
 * @author Matt Witham
 * @version 11.24.25
 */
public class GreenTintFilter extends Filter
{
    // instance variables - replace the example below with your own
    public GreenTintFilter(String name) {
        super(name);
    }
    
    public void apply(OFImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                Color currColor = image.getPixel(x,y);
                int red = (int)(currColor.getRed() * 0.5f);
                int green = currColor.getGreen();
                int blue = (int)(currColor.getBlue() * 0.5f);
                image.setPixel(x,y, new Color(red, green, blue));
            }
        }
    }
}
