package com.acm.njit.acm_tutoring;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.StringDef;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import java.util.Calendar;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Jesse on 11/5/2016.
 * Corresponds to tutoring_layout.xml
 */

public class Tutoring extends ListFragment {
    Tutor[] tutors;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        //gets tutors from a resource file and displays them on the screen in a list fragment
        super.onActivityCreated(savedInstanceState);

        String[] tutorsData = getResources().getStringArray(R.array.tutors);

        tutors = new Tutor[tutorsData.length];
        for(int i = 0; i < tutorsData.length; i++){
            tutorsData[i] = tutorsData[i].replace(" \n","").replace(" -", "");
            String[] tutor = tutorsData[i].split(" ");
            String name = tutor[0] + " " + tutor[1];
            int dayWorked = dayToNum(tutor[2]);
            String hoursWorked = tutor[3] + " " + tutor[4];
            tutors[i] = new Tutor(name, dayWorked, hoursWorked);
        }

        ArrayList<String> currentTutors = new ArrayList<>();
        currentTutors.add("Tutors Currently Active:");
        for(int i = 0; i < tutors.length; i++){
            if(isCurrentlyOn(tutors[i])){
                currentTutors.add("\t\t" + "-" + tutors[i].getName());
            }
        }
        String[] currentTutorsArray = new String[currentTutors.size()];
        currentTutors.toArray(currentTutorsArray);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,currentTutorsArray);
        setListAdapter(dataAdapter);

    }

    public boolean isCurrentlyOn(Tutor t){
        boolean isOn = false;
        Calendar c = Calendar.getInstance();
        int minute = c.get(Calendar.MINUTE);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int day = c.get(Calendar.DAY_OF_WEEK);
        if(t.getDayWorked() == day){
            //Structure example "10:00 16:15"
            double startHour = (double) Integer.parseInt(t.getTimeWorked().substring(0,2)) + (Integer.parseInt(t.getTimeWorked().substring(3,5)))*.01;
            double endHour = (double) Integer.parseInt(t.getTimeWorked().substring(6,8)) + (Integer.parseInt(t.getTimeWorked().substring(9,11)))*.01;
            double currentTime = (double) hour + (minute*.01);


            if(currentTime >= startHour && currentTime <= endHour){
                isOn = true;
            }
        }
        return isOn;
    }

    public int dayToNum(String day){
        int a;
        if(day.equals("Sunday")){
            a = 1;
        }else if(day.equals("Monday")){
            a = 2;
        }else if(day.equals("Tuesday")){
            a = 3;
        }else if(day.equals("Wednesday")){
            a = 4;
        }else if(day.equals("Thursday")){
            a = 5;
        }else if(day.equals("Friday")){
            a = 6;
        }else{
            a = 7;
        }
        return a;

    }

    /*public void onListItemClick(ListView l, View v, int pos, long id) {
        super.onListItemClick(l, v, pos, id);
        if(pos == 0){
            return;
        }
        Intent intent = new Intent(getActivity().getApplicationContext(), TutorProfile.class);

        String name = l.getAdapter().getItem(pos).toString().substring(3);
        String classes = "";
        ArrayList<Integer> tutorPositions = new ArrayList<Integer>();
        for(int i = 0; i < tutors.length; i++){
            if(tutors[i].getName() == name){
                tutorPositions.add(i);

            }
        }

        classes += tutors[tutorPositions.get(0)].getTutoredClasses();

        Tutor currentTutor = tutors[pos];
        intent.putExtra("name",name);
        intent.putExtra("classes", classes);
        startActivity(intent);

    }*/


}
