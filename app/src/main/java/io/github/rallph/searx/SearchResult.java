package io.github.rallph.searx;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResult {

    @SerializedName("engine")
    private String mEngine;
    @SerializedName("category")
    private String mCategory;
    @SerializedName("engines")
    private List<String> mEngines;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("url")
    private String mUrl;
    @SerializedName("positions")
    private List<Integer> mPositions;
    @SerializedName("parsed_url")
    private List<String> mParsedUrl;
    @SerializedName("content")
    private String mContent;
    @SerializedName("pretty_url")
    private String mPrettyUrl;
    @SerializedName("score")
    private int mScore;

    public  SearchResult(String engine, String category, List<String> engines, String title, String url, List<Integer> positions, List<String> parsed_url, String content, String pretty_url, int score) {
        mEngine = engine;
        mCategory = category;
        mEngines = engines;
        mTitle = title;
        mUrl = url;
        mPositions = positions;
        mParsedUrl = parsed_url;
        mContent = content;
        mPrettyUrl = pretty_url;
        mScore = score;
    }

    public String getmEngine() {
        return mEngine;
    }

    public void setmEngine(String mEngine) {
        this.mEngine = mEngine;
    }

    public String getmCategory() {
        return mCategory;
    }

    public void setmCategory(String mCategory) {
        this.mCategory = mCategory;
    }

    public List<String> getmEngines() {
        return mEngines;
    }

    public void setmEngines(List<String> mEngines) {
        this.mEngines = mEngines;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public List<Integer> getmPositions() {
        return mPositions;
    }

    public void setmPositions(List<Integer> mPositions) {
        this.mPositions = mPositions;
    }

    public List<String> getmParsedUrl() {
        return mParsedUrl;
    }

    public void setmParsedUrl(List<String> mParsedUrl) {
        this.mParsedUrl = mParsedUrl;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public String getmPrettyUrl() {
        return mPrettyUrl;
    }

    public void setmPrettyUrl(String mPrettyUrl) {
        this.mPrettyUrl = mPrettyUrl;
    }

    public int getmScore() {
        return mScore;
    }

    public void setmScore(int mScore) {
        this.mScore = mScore;
    }
}
