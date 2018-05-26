package com.example.dell.tg;

        import android.content.Intent;
        import android.graphics.drawable.AnimationDrawable;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Patterns;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.RelativeLayout;
        import android.widget.TextView;
        import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    EditText etmail,etcmail,pass;
    String email,cemail;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        RelativeLayout relativeLayout=(RelativeLayout)findViewById(R.id.layoutSignup);
        AnimationDrawable animationDrawable= (AnimationDrawable) relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();

        submit=(Button)findViewById(R.id.submit_signup);
        submit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                initialize();

                if(!validate()){
                    Toast.makeText(SignUpActivity.this,"Failed",Toast.LENGTH_LONG).show();
                }else {
                    submite();
                }
            }
        });
    }

    private boolean validate() {
        boolean valid=true;
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            valid=false;
            etmail.setError("Please Enter A valid Email");
        }if (!Patterns.EMAIL_ADDRESS.matcher(cemail).matches()){
            valid=false;
            etcmail.setError("Please Enter A valid Email");
        }if (cemail == email ) {
            valid = true;
        }else {
            valid=false;
            etcmail.setError("doesnt matches");
        }
        return valid;
    }

    public void initialize() {
        etmail=(EditText) findViewById(R.id.email_signup);
        etcmail=(EditText) findViewById(R.id.email_confirm_signup);
        pass=(EditText) findViewById(R.id.password_signup);
        email=etmail.getText().toString().trim();
        cemail=etcmail.getText().toString().trim();

    }

    public void submite() {
        if (etmail.getText().toString().length() > 0 && etcmail.getText().toString().length() > 0 && pass.getText().toString().length() > 0) {
            Toast.makeText(SignUpActivity.this, "Success", Toast.LENGTH_LONG).show();
        } else if (etmail.getText().toString().length() > 0 && etcmail.getText().toString().length() > 0) {
            pass.setError("Set Some Password For Your Account");
        }else if (etcmail.getText().toString().length() > 0 && pass.getText().toString().length() > 0){
            etmail.setError("Enter Your Email");
        }else if (etmail.getText().toString().length() > 0 && pass.getText().toString().length() > 0){
            etcmail.setError("Confirm Your Email");
        }else {
            pass.setError("Set Some Password For Your Account");
            etmail.setError("Enter Your Email");
            etcmail.setError("Confirm Your Email");
        }
    }
}
