package com.example.android.miwok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;


/**
 * Created by mofi on 7/18/16.
 */
public class WordAdapter extends ArrayAdapter<Word> {
    private int colorID;

    public WordAdapter(Context context, List<Word> objects, int colorID) {
        super(context, 0, objects);
        this.colorID = colorID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        final Word currentWord = getItem(position);
        LinearLayout linearLayout = (LinearLayout) listItemView.findViewById(R.id.text_container);
        linearLayout.setBackgroundResource(colorID);



        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok);
        miwokTextView.setText(currentWord.getMiwok());


        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.english);
        defaultTextView.setText(currentWord.getDefaultTranslation());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        if (currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageID());
        } else {
            imageView.setVisibility(View.GONE);
        }

        ImageView playButton = (ImageView) listItemView.findViewById(R.id.playButton);

        if (!currentWord.hasAudio()) {
            playButton.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
