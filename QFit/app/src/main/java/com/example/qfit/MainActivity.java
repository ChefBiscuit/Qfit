package com.example.qfit;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.MediaController;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    int workoutDiff = 0;
    int workoutSelection = 0;

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_workouts, R.id.nav_stats)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

    public void onConfirmClick(View v) {
        if (workoutSelection == 1) {
            if (workoutDiff == 1) {
                Intent intent = new Intent(this, WorkoutsArmsEasy.class);
                startActivity(intent);
            }
            else if(workoutDiff ==2 ){
                Intent intent = new Intent(this, WorkoutsArmsMed.class);
                startActivity(intent);
            }
            else if(workoutDiff ==3 ){
                Intent intent = new Intent(this, WorkoutsArmsMed.class);
                startActivity(intent);
            }
        }
        else if (workoutSelection == 2) {
            if (workoutDiff == 1) {
                Intent intent = new Intent(this, WorkoutsCoreEasy.class);
                startActivity(intent);
            }
            else if(workoutDiff ==2 ){
                Intent intent = new Intent(this, WorkoutsCoreMed.class);
                startActivity(intent);
            }
            else if(workoutDiff ==3 ){
                Intent intent = new Intent(this, WorkoutsCoreHard.class);
                startActivity(intent);
            }
        } else if (workoutSelection == 3) {
            if (workoutDiff == 1) {
                Intent intent = new Intent(this, WorkoutsLegEasy.class);
                startActivity(intent);
            }
            else if(workoutDiff ==2 ){
                Intent intent = new Intent(this, WorkoutsLegMed.class);
                startActivity(intent);
            }
            else if(workoutDiff ==3 ){
                Intent intent = new Intent(this, WorkoutsLegHard.class);
                startActivity(intent);
            }
        } else {
            Toast.makeText(this, "Please Select",
                    Toast.LENGTH_SHORT).show();
        }

    }

    public void onRadDiffClick(View v) {
        boolean checked = ((RadioButton) v).isChecked();

        // Check which radio button was clicked
        switch (v.getId()) {
            case R.id.radEasy:
                if (checked)
                    workoutDiff = 1;
                break;
            case R.id.radMed:
                if (checked)
                    workoutDiff = 2;
                break;
            case R.id.radHard:
                if (checked)
                    workoutDiff = 3;
                break;
        }
    }

    public void onRadWorkoutClick(View v) {
        boolean checked = ((RadioButton) v).isChecked();

        // Check which radio button was clicked
        switch (v.getId()) {
            case R.id.radArms:
                if (checked)
                    workoutSelection = 1;
                break;
            case R.id.radCore:
                if (checked)
                    workoutSelection = 2;
                break;
            case R.id.radLegs:
                if (checked)
                    workoutSelection = 3;
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}