package com.example.quizapp;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void main_btn(View view) {
        int viewId = view.getId();

        if (viewId == R.id.btn_play) {
            startActivity(new Intent(MainActivity.this, PlayActivity.class));
        } else if (viewId == R.id.btn_setting) {
            startActivity(new Intent(MainActivity.this, SettingActivity.class));
        } else if (viewId == R.id.btn_exit) {
            this.finishAffinity();
        }
    }
}
