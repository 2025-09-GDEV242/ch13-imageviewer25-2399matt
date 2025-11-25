import java.awt.Color;
/**
 * Class to apply a blue channel filter to an image.
 *
 * @author Matt Witham
 * @version 11.24.25
 */
public class BlueChannelFilter extends Filter
{
    
    public BlueChannelFilter(String name) {
        super(name);
    }
    
    public void apply(OFImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                int blue = image.getPixel(x,y).getBlue();
                image.setPixel(x,y, new Color(blue, blue, blue));
            }
        }
    }
}
