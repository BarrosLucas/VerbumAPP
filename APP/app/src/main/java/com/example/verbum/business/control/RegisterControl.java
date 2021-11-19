package com.example.verbum.business.control;

import static com.example.verbum.infra.utils.ExceptionMessages.INVALID_BIRTH_DATE;
import static com.example.verbum.infra.utils.ExceptionMessages.INVALID_DATA_PASSWORD;
import static com.example.verbum.infra.utils.ExceptionMessages.INVALID_DATA_USER;
import static com.example.verbum.infra.utils.ExceptionMessages.INVALID_LENGTH_PASSWORD;
import static com.example.verbum.infra.utils.ExceptionMessages.INVALID_LENGTH_USER;
import static com.example.verbum.infra.utils.ExceptionMessages.INVALID_NAME_LENGTH;
import static com.example.verbum.infra.utils.ExceptionMessages.INVALID_PASS_COFIRM;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.example.verbum.business.control.impl.ValidatorBirthDate;
import com.example.verbum.business.control.impl.ValidatorConfirmPwd;
import com.example.verbum.business.control.impl.ValidatorName;
import com.example.verbum.business.control.impl.ValidatorPassword;
import com.example.verbum.business.control.impl.ValidatorSex;
import com.example.verbum.business.control.impl.ValidatorUsername;
import com.example.verbum.business.model.User;
import com.example.verbum.exception.ConflictException;
import com.example.verbum.exception.EmptyException;
import com.example.verbum.exception.InvalidDataException;
import com.example.verbum.exception.InvalidSexException;
import com.example.verbum.exception.LengthFieldException;
import com.example.verbum.infra.persistence.UserPersistence;
import com.example.verbum.infra.utils.MaskEdit;
import com.example.verbum.infra.utils.Verify;

import java.io.IOException;
import java.util.ArrayList;

public class RegisterControl {
    private ArrayList<User> users;
    private Context context;

    public RegisterControl(Context context) {
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
        user.setSex(sexET);

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
