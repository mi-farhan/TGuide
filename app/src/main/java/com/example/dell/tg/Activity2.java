package com.example.dell.tg;

        import android.content.Intent;
        import android.graphics.drawable.AnimationDrawable;
        import android.support.constraint.ConstraintLayout;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.view.animation.AnimationUtils;
        import android.widget.Button;
        import android.widget.RelativeLayout;

public class Activity2 extends AppCompatActivity {
    Button login,signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        RelativeLayout constraintLayout=findViewById(R.id.act2);
        AnimationDrawable animationDrawable=(AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();

        login=(Button)findViewById(R.id.login_btn);
        signup=(Button)findViewById(R.id.signup_btn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent log=new Intent(Activity2.this, login.class);
                startActivity(log);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signnup=new Intent(Activity2.this,SignUpActivity.class);
                startActivity(signnup);
            }
        });


    }
}
