package com.example.android.tourguide.Controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.tourguide.Model.Card;
import com.example.android.tourguide.R;
import java.util.List;

/**
 * Created by Meliphant on 17.03.2018.
 */

public class PageFragment extends Fragment {

    private static final String PAGE_NUMBER = "section_number";
    int pageNumber;

    public static PageFragment newInstance(int page) {
        PageFragment pageFragment = new PageFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(PAGE_NUMBER, page);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments().getInt(PAGE_NUMBER);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);

        RecyclerView mRecyclerView = rootView.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        CardsRecyclerAdapter mAdapter = new CardsRecyclerAdapter(getCardList(pageNumber));
        mRecyclerView.setAdapter(mAdapter);
        return mRecyclerView;
    }

    private List<Card> getCardList(int position){
        switch (position) {
            case 0:
                return PlacesData.placeDataFirstTab(getContext());
            case 1:
                return PlacesData.placeDataSecondTab(getContext());
            case 2:
                return PlacesData.placeDataThirdTab(getContext());
            case 3:
                return PlacesData.placeDataFourthTab(getContext());
            default:
                return null;
        }
    }
}
