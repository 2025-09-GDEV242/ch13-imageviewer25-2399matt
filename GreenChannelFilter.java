import java.awt.Color;
/**
 * Class to apply a green channel filter to an image.
 *
 * @author Matt Witham
 * @version 11.24.25
 */
public class GreenChannelFilter extends Filter
{
    
    public GreenChannelFilter(String name) {
        super(name);
    }

    public void apply(OFImage image) {
        int height = image.getHeight();
        int width = image.getWidth();
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                int green = image.getPixel(x,y).getGreen();
                image.setPixel(x,y, new Color(green, green, green));
            }
        }
    }
}
