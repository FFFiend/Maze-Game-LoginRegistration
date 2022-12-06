package adapters.login_leaderboard;

import use_cases.login_leaderboard.ILoginUserInputBoundary;

import java.util.Objects;

/**
 * Entry point of the login user use case, passes information into LoginUser
 * use case.
 */
public class LoginUserController {

    /**
     * LoginUser input boundary attribute.
     */
    public final ILoginUserInputBoundary useCaseInteractor;

    public LoginUserController(ILoginUserInputBoundary useCaseInteractor){
        this.useCaseInteractor = useCaseInteractor;
    }

    public String performUseCase(String username, String password){
        String result = this.useCaseInteractor.detailChecker(username, password);
        if(Objects.equals(result,"yes")){
            return "yes";
        }
        else if(Objects.equals(result,"no")){
            return "no";
        }
        return null;
    }
}