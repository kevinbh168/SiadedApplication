package com.brena.siadedapplication.Activities;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.brena.siadedapplication.R;

public class StartAppActivity extends AppCompatActivity {

    private Button btnColegio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_app);

        btnColegio=findViewById(R.id.btnBuscarColegio);

        btnColegio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StartAppActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
