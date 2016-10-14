package com.example.android.northsouthfrags;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by hernandez on 10/14/2016.
 */
public class MenuFragment extends Fragment {

    Fragment frag1, frag2, fragClear;

    FragmentTransaction fragTransaction1, fragTransaction2;

    FragmentManager fm;

    private Button north_button, south_button;

    public MenuFragment(){


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        north_button = (Button) view.findViewById(R.id.north_button);
        south_button = (Button) view.findViewById(R.id.south_button);


        north_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fm = getFragmentManager();
                fragTransaction1 = fm.beginTransaction();
                frag1 = new NorthFragment();
                fragClear = new ClearFragment();
                fragTransaction1.add(R.id.container_north, frag1);
                fragTransaction1.add(R.id.container_south, fragClear);
                fragTransaction1.addToBackStack("f1");
                fragTransaction1.commit();


            }
        });

        south_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fm = getFragmentManager();
                fragTransaction2 = fm.beginTransaction();
                frag2 = new SouthFragment();
                fragClear = new ClearFragment();
                fragTransaction2.add(R.id.container_north, fragClear);
                fragTransaction2.add(R.id.container_south, frag2);
                fragTransaction2.addToBackStack("f2");
                fragTransaction2.commit();
            }
        });



        return view;
    }
}
