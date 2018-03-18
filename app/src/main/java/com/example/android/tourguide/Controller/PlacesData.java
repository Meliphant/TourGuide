package com.example.android.tourguide.Controller;

import android.content.Context;
import com.example.android.tourguide.Model.Card;
import com.example.android.tourguide.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Meliphant on 18.03.2018.
 */

public class PlacesData {

    public static List<Card> placeDataFirstTab(Context context){
        List<Card> cardList = new ArrayList<>();
        if (cardList.isEmpty()) {
            Card card;
            for(int i = 0; i < context.getResources().getStringArray(R.array.places_name).length; i++){
                card = new Card(context.getResources().getStringArray(R.array.places_name)[i], context.getResources().getStringArray(R.array.places_pic)[i]);
                cardList.add(card);
            }
        }
        return cardList;
    }
    public static List<Card> placeDataSecondTab(Context context){
        List<Card> cardList = new ArrayList<>();
        if (cardList.isEmpty()) {
            Card card;
            for(int i = 0; i < context.getResources().getStringArray(R.array.events_name).length; i++){
                card = new Card(context.getResources().getStringArray(R.array.events_name)[i], context.getResources().getStringArray(R.array.events_pic)[i]);
                cardList.add(card);
            }
        }
        return cardList;
    }
    public static List<Card> placeDataThirdTab(Context context){
        List<Card> cardList = new ArrayList<>();
        if (cardList.isEmpty()) {
            Card card;
            for(int i = 0; i < context.getResources().getStringArray(R.array.food_name).length; i++){
                card = new Card(context.getResources().getStringArray(R.array.food_name)[i], context.getResources().getStringArray(R.array.food_pic)[i]);
                cardList.add(card);
            }
        }
        return cardList;
    }
    public static List<Card> placeDataFourthTab(Context context){
        List<Card> cardList = new ArrayList<>();
        if (cardList.isEmpty()) {
            Card card;
            for(int i = 0; i < context.getResources().getStringArray(R.array.drinks_name).length; i++){
                card = new Card(context.getResources().getStringArray(R.array.drinks_name)[i], context.getResources().getStringArray(R.array.drinks_pic)[i]);
                cardList.add(card);
            }
        }
        return cardList;
    }
}