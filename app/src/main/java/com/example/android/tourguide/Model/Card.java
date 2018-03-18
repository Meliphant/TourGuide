package com.example.android.tourguide.Model;

/**
 * Created by Meliphant on 17.03.2018.
 */

public class Card {

    private String mCardName;
    private String mCardPicture;

    public Card(String cardName, String cardPicture){
        this.mCardName = cardName;
        this.mCardPicture = cardPicture;
    }

    public String getCardName() {
        return mCardName;
    }

    public String getPicture() {
        return mCardPicture;
    }
}
