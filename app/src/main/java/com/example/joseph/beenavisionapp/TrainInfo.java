package com.example.joseph.beenavisionapp;

import android.os.Parcelable;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TrainInfo implements Serializable
{
    ArrayList<SiteStatus> siteStatuses;
    ArrayList<Alarm> alarms;
    String[] combo;
    private static final long serialVersionUID = 465489764;


    private String getStringInfo (String json)
    {
        int start = json.indexOf(":") + 1;
        int end = json.indexOf(",");
        if (end < 0) end = json.indexOf("}");
        String value = json.substring(start, end);
        json = json.substring(end + 1);
        return value;
    }

    private int getIntInfo (String json)
    {
        int start = json.indexOf(":") + 1;
        int end = json.indexOf(",");
        int value = Integer.parseInt(json.substring(start, end));
        json = json.substring(end + 1);
        return value;
    }

    private int getIntInfo2 (String json)
    {
        int start = json.indexOf(":") + 1;
        int end = json.indexOf("}");
        int value = Integer.parseInt(json.substring(start, end));
        json = json.substring(end + 1);
        return value;
    }

    private long getLongInfo (String json)
    {
        int start = json.indexOf(":") + 1;
        int end = json.indexOf(",");
        long value = Long.parseLong(json.substring(start, end));
        json = json.substring(end + 1);
        return value;
    }

    private long getLongInfo2 (String json)
    {
        int start = json.indexOf(":") + 1;
        int end = json.indexOf("}");
        long value = Long.parseLong(json.substring(start, end));
        json = json.substring(end + 1);
        return value;
    }

    private float getFloatInfo (String json)
    {
        int start = json.indexOf(":") + 1;
        int end = json.indexOf(",");
        float value = Float.parseFloat(json.substring(start, end));
        json = json.substring(end + 1);
        return value;
    }

    private boolean getBoolInfo (String json)
    {
        int start = json.indexOf(":") + 1;
        int end = json.indexOf(",");
        boolean value = Boolean.parseBoolean(json.substring(start, end));
        json = json.substring(end + 1);
        return value;
    }


    private String reset (String json)
    {
        int newStart = json.indexOf(",");
        if (newStart < 0) return "";
        else return json.substring(newStart + 1);
    }

    public TrainInfo(String json, String json2, String[] login)
    {
        this.combo = login;
        json = json.replaceAll("\"", "");
        json2 = json2.replaceAll("\"", "");
        siteStatuses = new ArrayList<SiteStatus>();

        //parse the data
        while (!json.equals("")) {
            SiteStatus temp = new SiteStatus();
            temp.SiteName = getStringInfo(json);
            json = reset(json);
            temp.TotalTrain = getIntInfo(json);
            json = reset(json);
            temp.LastTrainID = getLongInfo(json);
            json = reset(json);
            temp.SystemStatuses = new ArrayList<SystemStatus>();

            String jsonSub = json.substring(json.indexOf("[") + 1, json.indexOf("]"));
            json = json.substring(json.indexOf("]") + 1);

            while (!jsonSub.equals("")) {
                SystemStatus temp2 = new SystemStatus();

                temp2.BVComponentID = getIntInfo(jsonSub);
                jsonSub = reset(jsonSub);
                temp2.NumberOfTrain = getIntInfo(jsonSub);
                jsonSub = reset(jsonSub);
                temp2.SiteName = getStringInfo(jsonSub);
                jsonSub = reset(jsonSub);
                temp2.LastSiteTrainID = getLongInfo2(jsonSub);
                jsonSub = reset(jsonSub);
                temp.SystemStatuses.add(temp2);
            }

            temp.LastTrain = new TrainSummary();
            json = reset(json);

            //jsonSub = json.substring(json.indexOf("{") + 1, last);

            temp.LastTrain = new TrainSummary();

            if (!json.substring(0, 20).contains("null")) {
                json = json.substring(json.indexOf(":") + 1);

                temp.LastTrain.AlxeCount = getIntInfo(json);
                json = reset(json);
                temp.LastTrain.Direction = getStringInfo(json);
                json = reset(json);
                temp.LastTrain.TrainLength = getFloatInfo(json);
                json = reset(json);
                temp.LastTrain.AvgTrainSpeed = getFloatInfo(json);
                json = reset(json);
                temp.LastTrain.NumberOfLocos = getIntInfo(json);
                json = reset(json);
                temp.LastTrain.NumberOfCars = getIntInfo(json);
                json = reset(json);
                temp.LastTrain.TrainSeqNum = getLongInfo(json);
                json = reset(json);
                temp.LastTrain.AEI = getBoolInfo(json);
                json = reset(json);
                temp.LastTrain.Units = getStringInfo(json);
                json = reset(json);


                if (json.substring(0, 20).contains("null")) {
                    jsonSub = "";
                    json = reset(json);
                }
                else {
                    jsonSub = json.substring(json.indexOf("[") + 1, json.indexOf("]"));
                    json = json.substring(json.indexOf("]") + 1);
                }

                temp.LastTrain.AlarmCounts = new ArrayList<AlarmCount>();

                while (!jsonSub.equals("")) {
                    AlarmCount temp2 = new AlarmCount();

                    temp2.BVCompID = getIntInfo(jsonSub);
                    jsonSub = reset(jsonSub);
                    temp2.Count = getIntInfo(jsonSub);
                    jsonSub = reset(jsonSub);
                    temp2.MaxPriority = getIntInfo(jsonSub);
                    jsonSub = reset(jsonSub);
                    temp2.TrainSeqNoAEI = getIntInfo(jsonSub);
                    jsonSub = reset(jsonSub);
                    temp2.ProcessedRate = getFloatInfo(jsonSub);
                    jsonSub = reset(jsonSub);

                    temp.LastTrain.AlarmCounts.add(temp2);
                }


                temp.LastTrain.FirstCar = new CarIdentifier();

                if (!json.substring(0, 20).contains("null")) {
                    temp.LastTrain.FirstCar.CarID = getLongInfo(jsonSub);
                    json = reset(json);
                    temp.LastTrain.FirstCar.CarInitial = getStringInfo(jsonSub);
                    json = reset(json);
                    temp.LastTrain.FirstCar.CarNumber = getStringInfo(jsonSub);
                    json = reset(json);
                    temp.LastTrain.FirstCar.CarIDDisplay = getStringInfo(jsonSub);
                    json = reset(json);
                }
                else {
                    json = reset(json);
                }

                temp.LastTrain.ImageUrlBase = getStringInfo(json);
                json = reset(json);

                temp.LastTrain.ID = getLongInfo(json);
                json = reset(json);
                temp.LastTrain.SystemTrainID = getLongInfo(json);
                json = reset(json);
                temp.LastTrain.SiteName = getStringInfo(json);
                json = reset(json);
                temp.LastTrain.TrainArrivalTimeLocal = getStringInfo(json);
                json = reset(json);
                temp.LastTrain.BVComponentID = getIntInfo(json);
                json = reset(json);
                temp.LastTrain.TrainArrivalLocal_Display = getStringInfo(json);
                json = reset(json);
            }
            else {
                json = reset(json);
            }
            siteStatuses.add(temp);
        }
        alarms = new ArrayList<Alarm>();

        if (json2.equals("[]")) json2 = "";

        while (!json2.equals("")) {
            Alarm temp = new Alarm();
            temp.SiteName = getStringInfo(json2);
            json2 = reset(json2);
            temp.BVCompID = getIntInfo(json2);
            json2 = reset(json2);
            temp.Count = getIntInfo(json2);
            json2 = reset(json2);
            temp.MaxPriority = getIntInfo2(json2);
            json2 = reset(json2);
            alarms.add(temp);
        }
    }
}
