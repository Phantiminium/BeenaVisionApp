package com.example.joseph.beenavisionapp;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Joseph on 6/14/2017.
 */

public class SiteStatus implements Serializable
{
    public String SiteName;
    public int TotalTrain;
    public long LastTrainID;
    public List<SystemStatus> SystemStatuses;
    public TrainSummary LastTrain;

}