import javax.imageio.ImageIO;
import java.io.IOException;

public class ObjBlackhole extends SuperObject {
    public ObjBlackhole() {
        setName("Blackhole");
        try {
            setImage(ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/blackhole.png")));
        } catch(IOException e) {
            e.printStackTrace();
        }
        setCollisionTrue();
    }

}
