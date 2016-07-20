/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;
    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    private AudioManager.OnAudioFocusChangeListener audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            switch (focusChange) {
                case AudioManager.AUDIOFOCUS_GAIN:
                    mediaPlayer.start();
                    break;
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                    mediaPlayer.pause();
                    mediaPlayer.seekTo(0);
                    break;
                case AudioManager.AUDIOFOCUS_LOSS:
                    releaseMediaPlayer();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word(R.raw.phrase_where_are_you_going, "minto wukus", "where are you going?"));
        words.add(new Word(R.raw.phrase_what_is_your_name, "tinn∂ oyaase'n∂", "what is your name"));
        words.add(new Word(R.raw.phrase_my_name_is, "oyaaset...", "my name is..."));
        words.add(new Word(R.raw.phrase_how_are_you_feeling, "mich∂ks∂s?", "how are you feeling?"));
        words.add(new Word(R.raw.phrase_im_feeling_good, "kuchi achit", "i am feeling good"));
        words.add(new Word(R.raw.phrase_are_you_coming, "∂∂n∂s'aa", "are you coming?"));
        words.add(new Word(R.raw.phrase_yes_im_coming, "h∂∂'∂∂n∂m", "yes, I'm coming"));
        words.add(new Word(R.raw.phrase_im_coming, "∂∂n∂m", "I'm coming"));
        words.add(new Word(R.raw.phrase_lets_go, "yoowutis", "let's go"));
        words.add(new Word(R.raw.phrase_come_here, "∂nni'nem", "come here"));


        WordAdapter itemAdapter = new WordAdapter(this, words, R.color.category_phrases);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (words.get(position).hasAudio()) {
                    releaseMediaPlayer();
                    int result = audioManager.requestAudioFocus(audioFocusChangeListener,
                            AudioManager.STREAM_MUSIC,
                            AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                    if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                        mediaPlayer = MediaPlayer.create(PhrasesActivity.this, words.get(position).getAudioID());
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(onCompletionListener);
                    }

                } else {
                    Toast.makeText(PhrasesActivity.this, "No Audio File Found", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    public void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
