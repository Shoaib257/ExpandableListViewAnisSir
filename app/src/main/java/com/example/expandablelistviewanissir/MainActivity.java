package com.example.expandablelistviewanissir;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    List<String> listDataHeader;
    HashMap<String,List<String>> listDataChild;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepareListData();
        expandableListView=findViewById(R.id.expandableListViewId);
        customAdapter=new CustomAdapter(this,listDataHeader,listDataChild);

    }

    private void prepareListData() {
        String[] hederString=getResources().getStringArray(R.array.abbreviations_list_header);
        String[] childString=getResources().getStringArray(R.array.abbreviation_list_child);

        listDataHeader=new ArrayList<>();
        listDataChild=new HashMap<>();

        for (int i=0;i<listDataHeader.size();i++){
            //adding header data

            listDataHeader.add(hederString[i]);

            List<String> child=new ArrayList<>();
            child.add(childString[i]);

            listDataChild.put(listDataHeader.get(i),child);
        }
    }
}
