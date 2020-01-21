package utils;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author huyvi
 */
public class ImageUtil {
    private static String DEFAULT_IMAGE_PATH = "";
    
    public static ImageIcon loadImageIcon(String path, int width, int height){
        Image image = loadImage(path).getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }
    
    public static ImageIcon loadImageIcon(String path){
        Image image = loadImage(path);
        return new ImageIcon(image);
    }
    
    public static Image loadImage(String path){
        if(path == null || path.isEmpty()){
            path = DEFAULT_IMAGE_PATH;
        }
        
        return new ImageIcon(path).getImage();
    }
}
