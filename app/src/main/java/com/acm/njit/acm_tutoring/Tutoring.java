package com.acm.njit.acm_tutoring;

import android.app.Activity;
import android.content.Context;
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
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Jesse on 11/5/2016.
 * Corresponds to tutoring_layout.xml
 */

public class Tutoring extends ListFragment {
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        //gets tutors from a resource file and displays them on the screen in a list fragment
        super.onActivityCreated(savedInstanceState);

        //Instantiates Network config class with url and context, then calls volleyService
        NetworkConfig nc = new NetworkConfig("https://acmapp.000webhostapp.com/getData.php", getActivity());
        nc.volleyService(new VolleyCallback(){
            public void onSuccess(String[] result)
            {

                //Tutors data from xml file, was used previously.
                //String[] tutorsData = getResources().getStringArray(R.array.tutors);


                //Splits elements of the result array, creates new tutor objects and adds them
                //to the tutors array.
                Tutor[] tutors = new Tutor[result.length];
                for(int i = 0; i < result.length; i++){
                    result[i] = result[i].replace(" \n","").replace(" -", "");
                    String[] tutor = result[i].split(" ");
                    String name = tutor[0] + " " + tutor[1];
                    int dayWorked = dayToNum(tutor[2]);
                    String hoursWorked = tutor[3] + " " + tutor[4];
                    tutors[i] = new Tutor(name, dayWorked, hoursWorked);
                }


                //Checks for currently active tutors and adds them to the currentTutorsArray.
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
        });

    }

    public boolean isCurrentlyOn(Tutor t){
        boolean isOn = false;
        Calendar c = Calendar.getInstance();
        int minute = c.get(Calendar.MINUTE);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int day = c.get(Calendar.DAY_OF_WEEK);
        if(t.getDayWorked() == day){
            //Structure example "10:00 16:15"
            double startHour = (double) Integer.parseInt(t.getTimeWorked().substring(0,2)) /*+ (Integer.parseInt(t.getTimeWorked().substring(3,5)))*.01*/;
            double endHour = (double) Integer.parseInt(t.getTimeWorked().substring(6,8)) /*+ (Integer.parseInt(t.getTimeWorked().substring(9,11)))*.01*/;
            double currentTime = (double) hour + (minute*.01);


            if(currentTime >= startHour && currentTime <= endHour){
                isOn = true;
            }
        }
        return isOn;
    }

    public int dayToNum(String day){
        int a = 1;
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


}
