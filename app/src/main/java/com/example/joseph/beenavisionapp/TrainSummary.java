package com.example.joseph.beenavisionapp;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Joseph on 6/14/2017.
 */

public class TrainSummary implements Serializable
{
    public int AlxeCount;
    public String Direction;
    public float TrainLength;
    public float AvgTrainSpeed;
    public int NumberOfLocos;
    public int NumberOfCars;
    public long TrainSeqNum;
    public boolean AEI;
    public String Units;

    public List<AlarmCount> AlarmCounts;

    public CarIdentifier FirstCar;

    public String ImageUrlBase;

    public long ID;
    public long SystemTrainID;
    public String SiteName;
    public String TrainArrivalTimeLocal;
    public int BVComponentID;
    public String TrainArrivalLocal_Display;
}
