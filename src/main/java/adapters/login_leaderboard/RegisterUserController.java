package adapters.login_leaderboard;

import use_cases.login_leaderboard.IRegisterUserInputBoundary;

import java.util.Objects;

/**
 * Transforms the information from RegisterScreen to be accessible for RegisterUser.
 * Passes username, password, and email address.
 */
public class RegisterUserController {

    /**
     * adds in the use case to be processed as an attribute.
     */
    private final IRegisterUserInputBoundary useCaseInteractor;

    /**
     * Constructor for the class. Self explanatory.
     * @param useCaseInteractor the current use case to be performed.
     */
    public RegisterUserController(IRegisterUserInputBoundary useCaseInteractor) {
        this.useCaseInteractor = useCaseInteractor;
    }

    /**
     * @param username entered username
     * @param email entered email
     * @param password entered password.
     */
    public String performUseCase(String username, String email, String password) {
        this.useCaseInteractor.UserSetter(username, email, password);
        String result = this.useCaseInteractor.createUser();
        if (Objects.equals(result, "yes")){
            return "yes";

        }
        return "no";
    }
}
