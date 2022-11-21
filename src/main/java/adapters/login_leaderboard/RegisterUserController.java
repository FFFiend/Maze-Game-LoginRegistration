package adapters.login_leaderboard;

import use_cases.login_leaderboard.IInputBoundary;

/**
 * Transforms the information from RegisterScreen to be accessible for RegisterUser.
 * Passes username, password, and email address.
 */
public class RegisterUserController {
    private final IInputBoundary useCaseInteractor;
    public RegisterUserController(IInputBoundary useCaseInteractor) {
        this.useCaseInteractor = useCaseInteractor;
    }

    public void performUseCase(String username, String password, String email) {
        this.useCaseInteractor.setters(username, email, password);
        this.useCaseInteractor.createUser();
    }
}