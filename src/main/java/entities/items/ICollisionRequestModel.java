package entities.items;



/** Interface for communicating relevant information for collision checking. */
public interface ICollisionRequestModel {
    /** Get the x position of the player. */
    int getPlayerX();
    /** Get the y position of the player. */
    int getPlayerY();
}
