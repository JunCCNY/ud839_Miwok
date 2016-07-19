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

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("minto wukus", "where are you going?"));
        words.add(new Word("tinn∂ oyaase'n∂", "what is your name"));
        words.add(new Word("oyaaset...", "my name is..."));
        words.add(new Word("mich∂ks∂s?", "how are you feeling?"));
        words.add(new Word("kuchi achit", "i am feeling good"));
        words.add(new Word("∂∂n∂s'aa", "are you coming?"));
        words.add(new Word("h∂∂'∂∂n∂m", "yes, I'm coming"));
        words.add(new Word("∂∂n∂m", "I'm coming"));
        words.add(new Word("yoowutis", "let's go"));
        words.add(new Word("∂nni'nem", "come here"));


        WordAdapter itemAdapter = new WordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemAdapter);
    }
}
