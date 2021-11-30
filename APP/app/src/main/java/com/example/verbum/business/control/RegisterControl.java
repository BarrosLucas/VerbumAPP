package com.example.verbum.business.control;

import android.content.Context;

import com.example.verbum.business.control.factory.SexFactory;
import com.example.verbum.business.control.impl.validators.ValidatorBirthDate;
import com.example.verbum.business.control.impl.validators.ValidatorConfirmPwd;
import com.example.verbum.business.control.impl.validators.ValidatorName;
import com.example.verbum.business.control.impl.validators.ValidatorPassword;
import com.example.verbum.business.control.impl.validators.ValidatorSex;
import com.example.verbum.business.control.impl.validators.ValidatorUsername;
import com.example.verbum.business.model.User;
import com.example.verbum.infra.persistence.UserPersistence;

import java.io.IOException;
import java.util.ArrayList;

public class RegisterControl {
    private ArrayList<User> users;
    private Context context;

    public RegisterControl(Context context) {
        this.context = context;
    }


    public User createNewUser(
            String nameET,
            String emailET,
            String passwordET,
            String confirmPassET,
            String birthDateET,
            String sexET

    ) throws Exception {
        ValidatorConfirmPwd validatorConfirmPwd = new ValidatorConfirmPwd();
        ValidatorUsername validatorUsername = new ValidatorUsername();

        Validator.validate(nameET, new ValidatorName());
        Validator.validate(emailET, validatorUsername);
        Validator.validate(passwordET, new ValidatorPassword());
        Validator.validate(confirmPassET, validatorConfirmPwd);
        Validator.validate(birthDateET, new ValidatorBirthDate());
        Validator.validate(sexET, new ValidatorSex());

        validatorConfirmPwd.isEqualsPasswords(passwordET, confirmPassET);

        updateList();
        validatorUsername.alreadyExists(emailET, users);


        User user = new User();
        user.setUsername(emailET);
        user.setName(nameET);
        user.setBirthDate(birthDateET);
        user.setPassword(passwordET);
        user.setSex(new SexFactory().getSexByText(sexET));

        users.add(user);

        newUser();

        return user;
    }

    private void updateList() throws IOException, ClassNotFoundException {
        UserPersistence userPersistence = new UserPersistence();
        users = userPersistence.load(context);
        if (users == null) {
            users = new ArrayList<>();
        }
    }

    private void newUser() throws IOException {
        UserPersistence userPersistence = new UserPersistence();
        userPersistence.save(users, context);
    }
}
