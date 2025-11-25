import java.awt.Color;
/**
 * Class to apply a red-channel filter to an image.
 *
 * @author Matt Witham
 * @version 11.24.25
 */
public class RedChannelFilter extends Filter
{
   
    public RedChannelFilter(String name) {
        super(name);
    }
    
    public void apply(OFImage image) {
        int height = image.getHeight();
        int width = image.getWidth();
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                int red = image.getPixel(x,y).getRed();
                image.setPixel(x,y, new Color(red, red, red));
            }
        }
    }
}
