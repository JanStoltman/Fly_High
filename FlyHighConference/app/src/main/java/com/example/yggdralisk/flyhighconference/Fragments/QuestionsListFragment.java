package com.example.yggdralisk.flyhighconference.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yggdralisk.flyhighconference.BackEnd.DataGetter;
import com.example.yggdralisk.flyhighconference.Adapters_Managers_Items.QuestionsRecyclerViewAdapter;
import com.example.yggdralisk.flyhighconference.BackEnd.GsonClasses.Presentation;
import com.example.yggdralisk.flyhighconference.BackEnd.GsonClasses.Speaker;
import com.example.yggdralisk.flyhighconference.R;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by lukasz on 03.03.16.
 */
public class QuestionsListFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.questions, container, false);

        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.questions_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        //TODO: hamburger icon


        RecyclerView.Adapter mAdapter = new QuestionsRecyclerViewAdapter(getSpeakers(), getPresentations());
            mRecyclerView.setAdapter(mAdapter);



       /*  Button drawerButton = (Button) view.findViewById(R.id.conference_drawer_button);
        drawerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).toggleDrawer();
            }
        });*/

        return view;
    }

    private Speaker[] getSpeakers(){
        return DataGetter.getSpeakers(getContext());
    }

    private Presentation[] getPresentations(){
        return DataGetter.getPresentations(getContext());
    }

}

