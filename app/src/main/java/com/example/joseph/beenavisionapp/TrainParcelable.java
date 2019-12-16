package com.example.joseph.beenavisionapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Joseph on 6/16/2017.
 */

public class TrainParcelable {
    private int mData;

    /* everything below here is for implementing Parcelable */

    // 99.9% of the time you can just ignore this
    //@Override
    public int describeContents() {
        return 0;
    }

    // write your object's data to the passed-in Parcel
    //@Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(mData);
    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<TrainParcelable> CREATOR = new Parcelable.Creator<TrainParcelable>() {
        public TrainParcelable createFromParcel(Parcel in) {
            return new TrainParcelable(in);
        }

        public TrainParcelable[] newArray(int size) {
            return new TrainParcelable[size];
        }
    };

    // example constructor that takes a Parcel and gives you an object populated with it's values
    private TrainParcelable(Parcel in) {
        mData = in.readInt();
    }
}
