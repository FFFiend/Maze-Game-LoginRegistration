package use_cases.login_leaderboard;
import entities.login_leaderboard.User;

/**
 * Register the user by creating a user object of the user.
 * If the user password is invalid (PasswordStrengthChecker), allow user to try again with a new password.
 * If the user password is valid, update the CSV with the user info, let the user know
 * they have been registered.
 */
public class RegisterUser implements IRegisterUserInputBoundary {

    final IRegisterUserOutputBoundary userPresenter;
    private String username;
    private String email;
    private String password;

    public RegisterUser(IRegisterUserOutputBoundary userPresenter) {
        this.userPresenter = userPresenter;
    }

    /**
     * Checks whether the password passed in from the UserInputBoundary is valid.
     * @return boolean that states whether the user's registered password is correct or not.
     */
    public boolean isValid(){
        return PasswordStrengthChecker.check(this.password);
    }

    /**
     * Initializes and saves the user's details to later initialize a User entity.
     * @param username String user's username
     * @param email String user's email
     * @param password String user's password.
     */
    @Override
    public void UserSetter(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }

    /**
     * Actually creates the user, and also initiates the process of writing
     * to the user data csv file.
     */
    @Override
    public void createUser(){
        if (isValid() && !UserAlreadyExists()){
            User current_user =  new User(this.username, this.email, this.password);
            // write to file
            // TODO
            userPresenter.PrepareView("You have been registered.");
        }
        else if(!isValid()){
            userPresenter.PrepareView("Your password is not valid");

        }
        else if(UserAlreadyExists()){
            userPresenter.PrepareView("This user already exists");
        }

    }

    /***
     * Checks if the user already exists by calling on the hashmap
     * of users created by the FileUser class.
     * @return boolean depending on whether user exists or not.
     */
    public boolean UserAlreadyExists(){
        // checks in the database.
        // still unimplemented.
        return false;
    }
}
