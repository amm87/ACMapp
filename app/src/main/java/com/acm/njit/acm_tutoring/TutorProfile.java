package com.acm.njit.acm_tutoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TutorProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_profile);
        Intent intent = getIntent();

        String tutorName = intent.getStringExtra("name");
        String tutorClasses = intent.getStringExtra("classes");


        TextView name = (TextView) findViewById(R.id.tutorName);
        TextView courses = (TextView) findViewById(R.id.tutorCourses);

        name.setText(tutorName);
        courses.setText(tutorClasses);


    }

    public void onBackClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
