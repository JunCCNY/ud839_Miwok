package com.example.android.miwok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


/**
 * Created by mofi on 7/18/16.
 */
public class WordAdapter extends ArrayAdapter<Word> {
    public WordAdapter(Context context, List<Word> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok);
        miwokTextView.setText(currentWord.getMiwok());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.english);
        defaultTextView.setText(currentWord.getDefaultTranslation());

        return listItemView;
    }
}
