package adapters.login_leaderboard;

import use_cases.login_leaderboard.ILoginUserInputBoundary;

/**
 * Entry point of the login user use case, passes information into LoginUser
 * use case.
 */
public class LoginUserController {

    /**
     * LoginUser input boundary attribute.
     */
    private final ILoginUserInputBoundary useCaseInteractor;

    public LoginUserController(ILoginUserInputBoundary useCaseInteractor){
        this.useCaseInteractor = useCaseInteractor;
    }

    public void performUseCase(String username, String password){
        this.useCaseInteractor.detailChecker(username, password);
    }
}