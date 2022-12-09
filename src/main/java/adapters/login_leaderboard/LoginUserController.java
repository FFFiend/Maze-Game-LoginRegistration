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


    /**
     * Class constructor.
     * @param useCaseInteractor the Login Use Case to be passed into the Controller.
     */
    public LoginUserController(ILoginUserInputBoundary useCaseInteractor){
        this.useCaseInteractor = useCaseInteractor;
    }

    /**
     * Executes the login use case.
     * @param username passed in username.
     * @param password passed in password.
     * @return returns whether the login was successful or not, acts as a
     * mini-presenter on its own.
     */
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