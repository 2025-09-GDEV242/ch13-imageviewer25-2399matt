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
                int red = currColor.getRed();
                int green = currColor.getGreen();
                int blue = currColor.getBlue();
                // Same thing here, brute forcing for now for vals.
                image.setPixel(x,y, new Color(Math.min(red, 128),
                Math.max(green, 200),
                Math.min(blue, 128)));
                
            }
        }
    }
}
