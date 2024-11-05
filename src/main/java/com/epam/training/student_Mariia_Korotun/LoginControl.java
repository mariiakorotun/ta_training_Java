package com.epam.training.student_Mariia_Korotun;

public class LoginControl {
    private final UserValidation validateUser;
    public LoginControl(){
        this.validateUser = new UserValidation();
    }
    public boolean login(User user){
        return validateUser.validationOfUser(user);
    }
}
