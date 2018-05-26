package com.example.dell.tg;
        import android.content.Intent;
        import android.graphics.drawable.AnimationDrawable;
        import android.support.constraint.ConstraintLayout;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatDelegate;
        import android.text.InputType;
        import android.view.View;
        import android.widget.Button;
        import android.widget.CheckBox;
        import android.widget.CompoundButton;
        import android.widget.EditText;
        import android.widget.TextClock;
        import android.widget.TextView;
        import android.widget.Toast;


public class login extends AppCompatActivity {
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
    CheckBox checkBox;
    EditText edPass,edEmail;
    TextView forgotPass;
    Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ConstraintLayout constraintLayout=(ConstraintLayout)findViewById(R.id.login_lay);
        AnimationDrawable animationDrawable=(AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();

        checkBox=(CheckBox) findViewById(R.id.checkBox);
        edEmail=(EditText)findViewById(R.id.email_login);
        edPass=(EditText) findViewById(R.id.pass_login);
        loginBtn=(Button) findViewById(R.id.login_btn);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    edPass.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }else {
                    edPass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });

    }

    public void forgotPass(View view) {
        Intent fogPass=new Intent(this,Activity2.class);
        startActivity(fogPass);
    }

    public void signup(View view) {
        Intent fogPass=new Intent(this,SignUpActivity.class);
        startActivity(fogPass);
    }

    public void login(View view) {
        if(edEmail.getText().length()>0){
            if (edPass.getText().length()>0){
                Toast.makeText(login.this,"Success",Toast.LENGTH_LONG).show();
            }else {
                edPass.setError("Please Enter Password");
            }
        }else{
            edEmail.setError("Please Enter Email");
        }
    }
}
