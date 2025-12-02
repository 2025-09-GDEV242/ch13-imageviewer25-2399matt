
/**
 * Warhol filter class for images.
 *
 * @author Matt Witham
 * @version 11.30.25
 */
public class WarholFilter extends Filter
{

    public WarholFilter(String name) {
        super(name);
    }

    @Override
    public void apply(OFImage image) {

        int halfWidth = image.getWidth() / 2;
        int halfHeight = image.getHeight() / 2;

        OFImage red   = new OFImage(image);
        OFImage green = new OFImage(image);
        OFImage blue  = new OFImage(image);
        // horrid, create helper method with switch for tints if there is time. 
        new RedTintFilter("").apply(red);
        new GreenTintFilter("").apply(green);
        new BlueTintFilter("").apply(blue);
        //brute forcing can be fun.
        //reading/writing same image, why is this even working?
        copy(image, image, 0, 0, halfWidth, halfHeight);
        copy(red, image, halfWidth, 0, halfWidth, halfHeight);
        copy(green, image, 0, halfHeight, halfWidth, halfHeight);
        copy(blue, image, halfWidth, halfHeight, halfWidth, halfHeight);
    }

    private void copy(OFImage og, OFImage newImage, int xOffset, int yOffset, int targetWidth, int targetHeight) {
        for (int x = 0; x < targetWidth; x++) {
            for (int y = 0; y < targetHeight; y++) {
                int srcX = x * og.getWidth() / targetWidth;
                int srcY = y * og.getHeight() / targetHeight;
                newImage.setPixel(x + xOffset, y + yOffset, og.getPixel(srcX, srcY));
            }
        }
    }
}
