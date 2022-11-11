package use_cases.login_leaderboard;

import use_cases.login_leaderboard.IDataAccessInterface;

public class RegisterUser implements IDataAccessInterface {
    // Register the user by creating a user object of the user.
    // If the user password is invalid (PasswordStrengthChecker), allow user to re-enter
    // a password.
    // If the user password is valid, update the CSV with the user info, let the user know
    // they have been registered.

    // Methods: registered_user (bool), update_csv_file (void), and valid_password (bool)
}
