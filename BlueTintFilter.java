import java.awt.*;

public class BlueTintFilter extends Filter{

    public BlueTintFilter(String name) {
        super(name);
    }

    @Override
    public void apply(OFImage image) {
        int width =  image.getWidth();
        int height = image.getHeight();
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                Color currColor = image.getPixel(x,y);
                int red = (int)(currColor.getRed() * 0.5f);
                int green = (int)(currColor.getGreen() * 0.5f);
                int blue = currColor.getBlue();
                image.setPixel(x,y, new Color(red, green, blue));
            }
        }
    }
}
