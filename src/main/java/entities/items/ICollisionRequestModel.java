package entities.items;

import java.awt.*;

/** Interface for communicating relevant information for collision checking. */
public interface ICollisionRequestModel {
    /** Get the solid area of the player. */
    Rectangle getPlayerArea();
}
