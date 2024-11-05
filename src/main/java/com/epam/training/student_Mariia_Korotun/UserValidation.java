package com.epam.training.student_Mariia_Korotun;

public class UserValidation {
    public boolean validationOfUser(User user){
        return "standard_user".equals(user.getUsername())&& "secret_sauce".equals(user.getPassword());
    }
}
