package com.example.android.miwok;

/**
 * Created by mofi on 7/18/16.
 */
public class Word {
    private String miwok;
    private String defaultTranslation;

    public Word(String miwok, String defaultTranslation) {
        this.miwok = miwok;
        this.defaultTranslation = defaultTranslation;
    }

    public String getDefaultTranslation() {
        return defaultTranslation;
    }

    public String getMiwok() {
        return miwok;
    }
}
