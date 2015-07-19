package main.lavo713;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.text.ParseException;

/**
 * Created by Lotan on 7/16/2015.
 */
public class SignUp extends ActionBarActivity {
    Button signup;
    EditText username;
    EditText password;
    EditText email;
    EditText passwordretype;
    String usernamestring;
    String passwordstring;
    String emailstring;
    String retypepasswordstring;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        signup = (Button) findViewById(R.id.signupbutton);
        username = (EditText) findViewById(R.id.usernamesignup);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.passwordsignup);
        passwordretype = (EditText) findViewById(R.id.passwordretype);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve the text entered from the EditText
                usernamestring = username.getText().toString();
                passwordstring = password.getText().toString();
                emailstring = email.getText().toString();
                retypepasswordstring = passwordretype.getText().toString();
                // Force user to fill up the form
                if (usernamestring.equals("") && passwordstring.equals("") && emailstring.equals("")) {
                    Toast.makeText(getApplicationContext(),
                            "Please complete the sign up form",
                            Toast.LENGTH_LONG).show();

                } else {
                    // Save new user data into Parse.com Data Storage
                    ParseUser user = new ParseUser();
                    user.setUsername(usernamestring);
                    user.setPassword(passwordstring);
                    user.setEmail(emailstring);
                    user.signUpInBackground(new SignUpCallback() {
                        public void done(ParseException e) {
                            if (e == null) {
                                // Show a simple Toast message upon successful registration
                                Toast.makeText(getApplicationContext(),
                                        "Successfully Signed up, please log in.",
                                        Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(getApplicationContext(),
                                        "Sign up Error", Toast.LENGTH_LONG)
                                        .show();
                            }
                        }

                        @Override
                        public void done(com.parse.ParseException e) {

                        }
                    });
                }
            }
                });





    }
}


