
/**
 * Flipped Warhol image filter. 
 *
 * @author Matt Witham
 * @version 11.30.25
 */
public class FlippedWarholFilter extends Filter
{
    
    public FlippedWarholFilter(String name) {
        super(name);
    }
    
    @Override
    public void apply(OFImage image) {
        int halfWidth = image.getWidth() / 2;
        int halfHeight = image.getHeight() / 2;
        OFImage red = new OFImage(image);
        OFImage green = new OFImage(image);
        OFImage blue = new OFImage(image);
        // brute forcing still, modify if there's time.
        new RedTintFilter("").apply(red);
        new GreenTintFilter("").apply(green);
        new BlueTintFilter("").apply(blue);
        copy(image, image, 0, 0, halfWidth, halfHeight, Quadrant.ONE);
        copy(red, image, halfWidth, 0, halfWidth, halfHeight, Quadrant.TWO);
        copy(green, image, 0, halfHeight, halfWidth, halfHeight, Quadrant.THREE);
        copy(blue, image, halfWidth, halfHeight, halfWidth, halfHeight, Quadrant.FOUR);
    }
    
    private void copy(OFImage original, OFImage newImage, int xOffset, int yOffset, int targetWidth, int targetHeight, Quadrant quad) {
        switch(quad) {
            case ONE -> {
                for(int x = 0; x < targetWidth; x++) {
                    for(int y = 0; y < targetHeight; y++) {
                        int srcX = x * original.getWidth() / targetWidth;
                        int srcY = y * original.getHeight() / targetHeight;
                        newImage.setPixel(x + xOffset, y + yOffset, original.getPixel(srcX, srcY));
                    }
                }
            }
            case TWO -> {
                for(int x = 0; x < targetWidth; x++) {
                    for(int y = 0; y < targetHeight; y++) {
                        int srcX = x * original.getWidth() / targetWidth;
                        int srcY = y * original.getHeight() / targetHeight;
                        srcX = original.getWidth() - 1 - srcX;
                        newImage.setPixel(x+xOffset, y+yOffset,original.getPixel(srcX, srcY));                        
                    }
                }
            }
            case THREE -> {
                for(int x = 0; x < targetWidth; x++) {
                    for(int y = 0; y < targetHeight; y++) {
                        int srcX = x * original.getWidth() / targetWidth;
                        int srcY = y * original.getHeight() / targetHeight;
                        srcY = original.getHeight() - 1 - srcY;
                        newImage.setPixel(x+xOffset, y+yOffset, original.getPixel(srcX, srcY));
                    }
                }
            }
            case FOUR -> {
                for(int x = 0; x < targetWidth; x++) {
                    for(int y = 0; y < targetHeight; y++) {
                        int srcX = x * original.getWidth() / targetWidth;
                        int srcY = y * original.getHeight() / targetHeight;
                        srcX = original.getWidth() - 1 - srcX;
                        srcY = original.getHeight() - 1 - srcY;
                        newImage.setPixel(x+xOffset, y+yOffset, original.getPixel(srcX, srcY));
                    }
                }
            }
        }
    }
}
