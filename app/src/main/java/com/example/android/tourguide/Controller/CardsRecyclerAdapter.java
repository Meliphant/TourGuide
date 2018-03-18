package com.example.android.tourguide.Controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.android.tourguide.Model.Card;
import com.example.android.tourguide.R;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by Meliphant on 17.03.2018.
 */

public class CardsRecyclerAdapter extends RecyclerView.Adapter<CardsRecyclerAdapter.ViewHolder> {

    private List<Card> cardList;

    public CardsRecyclerAdapter(List<Card> card) {
        this.cardList = card;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView cardName;
        public ImageView cardImage;

        public ViewHolder(View v) {
            super(v);
            cardName = v.findViewById(R.id.card_placename);
            cardImage = v.findViewById(R.id.card_image);
        }
    }

    @Override
    public CardsRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        ViewHolder holder = new ViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Card card = cardList.get(position);
        holder.cardName.setText(card.getCardName());
        setImagePicasso(card, holder.cardImage, holder);
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    private void setImagePicasso(Card card, ImageView cardImage, ViewHolder holder) {
        Picasso.with(holder.cardImage.getContext())
                .load(card.getPicture())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.image_sample)
                .into(cardImage);
    }
}
