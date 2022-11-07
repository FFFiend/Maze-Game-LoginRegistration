import entities.Maze;
import entities.object.ObjBlackhole;
import entities.object.ObjPhotons;

public class ObjectSetter {
    private final Maze maze;
    public ObjectSetter(Maze maze) {
        this.maze = maze;
    }

    public void setObject() {

        maze.obj[1] = new ObjBlackhole();
        maze.obj[1].setX(14 * maze.tileSize);
        maze.obj[1].setY(10 * maze.tileSize);

        maze.obj[3] = new ObjPhotons();
        maze.obj[3].setX(4 * maze.tileSize);
        maze.obj[3].setY(8 * maze.tileSize);
    }
}
