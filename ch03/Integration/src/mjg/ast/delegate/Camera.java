package mjg.ast.delegate;

import java.util.ArrayList;
import java.util.List;

public class Camera {
    private List<Picture> pictures = new ArrayList<Picture>();
    
    public void takePicture() {
        pictures.add(new Picture());
    }
    
    public void removePicture(Picture p) {
        pictures.remove(p);
    }
    
    public List<Picture> getPictures() {
        return pictures;
    }
}
