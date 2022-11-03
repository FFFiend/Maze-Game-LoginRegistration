package hazards;

/** Interface for communicating relevant information for hazard checking. */
public interface IHazardRequestModel {
    /** Get the x position of the player. */
    int getPlayerX();
    /** Get the y position of the player. */
    int getPlayerY();
}
