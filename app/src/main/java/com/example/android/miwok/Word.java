package com.example.android.miwok;

/**
 * Created by mofi on 7/18/16.
 */
public class Word {
    private String miwok;
    private String defaultTranslation;
    private int imageID;
    private int audioID;
    private boolean hasImage;
    private boolean hasAudio;


    public Word(String miwok, String defaultTranslation) {
        this.miwok = miwok;
        this.defaultTranslation = defaultTranslation;
        this.hasImage = false;
        this.hasAudio = false;
    }

    public Word(String miwok, String defaultTranslation, int imageID) {
        this.miwok = miwok;
        this.defaultTranslation = defaultTranslation;
        this.imageID = imageID;
        this.hasImage = true;
        this.hasAudio = false;
    }

    public Word(int audioID, String miwok, String defaultTranslation) {
        this.miwok = miwok;
        this.defaultTranslation = defaultTranslation;
        this.audioID = audioID;
        this.hasAudio = true;
        this.hasImage = false;
    }


    public Word(int audioID, String miwok, String defaultTranslation, int imageID) {
        this.miwok = miwok;
        this.defaultTranslation = defaultTranslation;
        this.imageID = imageID;
        this.audioID = audioID;
        this.hasAudio = true;
        this.hasImage = true;
    }

    public String getDefaultTranslation() {
        return defaultTranslation;
    }

    public String getMiwok() {
        return miwok;
    }

    public int getImageID() {
        return imageID;
    }

    public int getAudioID() {
        return audioID;
    }

    public boolean hasImage() {
        return hasImage;
    }

    public boolean hasAudio() {
        return hasAudio;
    }
}
