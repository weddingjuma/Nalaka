package com.example.otvisa.nalaka;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import com.example.otvisa.nalaka.amica.AmicaHandler;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.otvisa.nalaka.Restaurant.*;


/**
 * Created by otvisa on 11.9.2017.
 */

public class MealListFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private AmicaHandler ah;
    private int mPage;
    RecyclerView rv;

    public static MealListFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        MealListFragment fragment = new MealListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ah = new AmicaHandler(getActivity());
        Restaurant[] restaurants = Restaurant.values();
        rv = new RecyclerView(getContext());
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        String restaurantName = restaurants[mPage].getName();

        switch (restaurantName) {
            case "Snellmania":
                getAmica(SNELLMANIA.getKitchenId());
                break;

            case "Tietoteknia":
                getAmica(TIETOTEKNIA.getKitchenId());
                break;

            case "Mediteknia":
                getAmica(MEDITEKNIA.getKitchenId());
                break;

            case "Canthia":
                getAmica(CANTHIA.getKitchenId());
                break;
        }

        return rv;
}

    public void getAmica(String kitchenId) {
        ah.fetchJson(kitchenId, new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                RecyclerAdapter ra = new RecyclerAdapter(ah.getMealsList(response.body()), getActivity());
                rv.setAdapter(ra);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }
}

