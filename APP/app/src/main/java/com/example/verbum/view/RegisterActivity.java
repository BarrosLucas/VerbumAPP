package com.example.verbum.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.verbum.R;
import com.example.verbum.business.control.DoLoginCommand;
import com.example.verbum.business.control.DoRegisterCommand;
import com.example.verbum.business.control.RegisterControl;
import com.example.verbum.business.control.UserFacade;
import com.example.verbum.business.control.command.Switch;
import com.example.verbum.business.model.User;
import com.example.verbum.infra.utils.Dialog;
import com.example.verbum.infra.utils.MaskEdit;

public class RegisterActivity extends AppCompatActivity {
    private AppCompatActivity context;

    private EditText name;
    private EditText user;
    private EditText password;
    private EditText confirmPwd;
    private EditText birthDate;
    private EditText sex;

    private Button registerButton;

    private UserFacade facade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Switch switchInstance = Switch.getInstance();

        context = this;

        name = (EditText) findViewById(R.id.name_et);
        user = (EditText) findViewById(R.id.user_et);
        password = (EditText) findViewById(R.id.pass_et);
        confirmPwd = (EditText) findViewById(R.id.confirm_pass_et);
        birthDate = (EditText) findViewById(R.id.birth_et);
        sex = (EditText) findViewById(R.id.sex_et);

        registerButton = (Button) findViewById(R.id.register_button);

        facade = new UserFacade(null, new RegisterControl(getBaseContext()));

        sex.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String s = editable.toString();
                if(!s.equals(s.toUpperCase()))
                {
                    s=s.toUpperCase();
                    sex.setText(s);
                    sex.setSelection(sex.length()); //fix reverse texting
                }
            }
        });
        birthDate.addTextChangedListener(MaskEdit.mask(birthDate,MaskEdit.FORMAT_DATE));

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User ret = null;
                try {
                    User u = switchInstance.storeAndExecute((new DoRegisterCommand(facade,
                            name.getText().toString(),
                            user.getText().toString(),
                            password.getText().toString(),
                            confirmPwd.getText().toString(),
                            birthDate.getText().toString(),
                            sex.getText().toString())));

                    Dialog.showDialog("Cadastro Realizado!","Cadastro efetuado com sucesso",context);
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                    Dialog.showDialog("Falha na operação",e.getMessage(),context);
                }
            }
        });
    }
}