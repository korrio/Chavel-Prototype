package com.google.firebase.quickstart.database.models;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// [START post_class]
@IgnoreExtraProperties
public class Pin extends ItemPosition {

    public String pinId;
    public String uid;
    public String author;
    public String title;
    public String body;
    public String lat;
    public String lng;
    public long unixTime;
    public String pinImage;

    public int starCount = 0;
    public Map<String, Boolean> stars = new HashMap<>();

    public Pin() {
        // Default constructor required for calls to DataSnapshot.getValue(UploadPost.class)
    }

    public Pin(String pinImage) {
        this.pinImage = pinImage;
    }

    public Pin(String pinImage, String uid, String author, String title, String body, String lat, String lng, long unixTime) {
        this.uid = uid;
        this.author = author;
        this.title = title;
        this.body = body;
        this.lat = lat;
        this.lng = lng;
        this.unixTime = unixTime;
        this.pinImage = pinImage;
    }

    // [START post_to_map]
    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("author", author);
        result.put("title", title);
        result.put("body", body);
        result.put("starCount", starCount);
        result.put("stars", stars);
        result.put("lat", lat);
        result.put("lng", lng);
        result.put("unixTime",unixTime);
        result.put("postId",lastFour(unixTime+""));
        result.put("pinImage",pinImage);

        return result;
    }

    private String lastFour(String word) {
        if (word.length() == 3) {
            return word;
        } else if (word.length() > 3) {
            return word.substring(word.length() - 3);
        } else {
            // whatever is appropriate in this case
            throw new IllegalArgumentException("word has less than 3 characters!");
        }
    }
    // [END post_to_map]

}
// [END post_class]
