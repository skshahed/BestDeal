package com.example.forever.bestdeal.UserProfile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.forever.bestdeal.ModelClass.UserModel;
import com.example.forever.bestdeal.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {
    private DatabaseReference databaseReference;
    EditText userFullNameET;
    EditText userSignupEmailET;
    EditText userPasswordET;
    EditText userPhoneNumberET;
    EditText userRegistrationBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        userFullNameET      = (EditText) findViewById(R.id.userFullNameET);
        userSignupEmailET   = (EditText) findViewById(R.id.userSignupEmailET);
        userPasswordET      = (EditText) findViewById(R.id.userPasswordET);
        userPhoneNumberET   = (EditText) findViewById(R.id.userPhoneNumberET);
    }

    public void signUpProcess(View view) {
        String fullName     = userFullNameET.getText().toString();
        String uEmail       = userSignupEmailET.getText().toString();
        String uPassword    = userPasswordET.getText().toString();
        String uPhoneNumber = userPhoneNumberET.getText().toString();

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("PublicUser");
        String key = databaseReference.push().getKey();
        UserModel userModel = new UserModel(key,fullName,uEmail,uPassword,uPhoneNumber);
        databaseReference.push().setValue(userModel);
    }
}
