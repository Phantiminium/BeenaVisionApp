package com.example.joseph.beenavisionapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.io.Console;
import java.io.IOException;
import java.util.Calendar;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static android.R.attr.password;
import static android.R.attr.start;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static com.example.joseph.beenavisionapp.R.drawable.back;


public class MainActivity2 extends AppCompatActivity implements Serializable{

    TextView val1;
    TextView val2;
    String[] login = new String[2];
    Button httpBtn;
    String saved;
    String info;
    String alarms;
    Intent home;
    TrainInfo trainInfo;

    public static class Wait {
        void aBit () {
            try {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /*

    public class getData {
        OkHttpClient client1 = new OkHttpClient();

        void getJSON(String url) throws IOException {
            //OkHttpClient client2 = new OkHttpClient();

            Request request = new Request.Builder()
                    .url(url)
                    .build();

            client1.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    info = "lmao";
                    e.printStackTrace();
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    if (!response.isSuccessful()) {
                        info = "no";
                        throw new IOException("Unexpected code:" + response);
                    }
                    else {
                        //info = response.body().toString();
                        info = "yes";
                    }
                }
            });



            try (Response response = client.newCall(request).execute()) {
                if (response.body() != null) {
                    info = "yes";
                }
                else {
                    info = "no";
                }
            }

        }

    }

    */

    public class PostLogin {
        public final MediaType JSON
                = MediaType.parse("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

        void post(String url, String json) throws IOException {
            RequestBody body = RequestBody.create(JSON, json);
            final Request request = new Request.Builder()
                    .url(url)
                    .method("POST", RequestBody.create(null, new byte[0]))
                    .post(body)
                    .build();

            /*
            try (Response response = client.newCall(request).execute()) {
                return response.body().string();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            */

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    if (!response.isSuccessful()) {
                        throw new IOException("Unexpected code:" + response);
                    }
                    else {
                        if (response.body().string().equals("1")) {
                            saved = "https://cmms.beenavision.com/CMMSApi/GetHealthInfo?username="
                                            + login[0] + "&password=" + login[1];
                            //saved = "https://cmms.beenavision.com/CMMSApi/GetHealthInfo?username=BNSF_BV_Admin&password=3cJHmv";
                        }
                        else {
                            saved = "";
                        }
                    }
                }
            });
        }

        void get(String url) throws IOException {
            //OkHttpClient client2 = new OkHttpClient();

            Request request = new Request.Builder()
                    .url(url)
                    .build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    //info = "lmao";
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    if (!response.isSuccessful()) {
                        throw new IOException("Unexpected code:" + response);
                    } else {
                        //info = response.body().toString();
                        //info = "yes";
                        info = response.body().string();
                    }
                }
            });

        }

        void get2(String url) throws IOException {
            //OkHttpClient client2 = new OkHttpClient();

            Request request = new Request.Builder()
                    .url(url)
                    .build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    //info = "lmao";
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    if (!response.isSuccessful()) {
                        throw new IOException("Unexpected code:" + response);
                    } else {
                        //info = response.body().toString();
                        //info = "yes";
                        alarms = response.body().string();
                    }
                }
            });

        }


        String loginJson(String username, String password) {
            return "{'Username':'" + username + "',"
                    + "'Password':'" + password + "'"
                    + "}";

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        val1 = (TextView) (findViewById(R.id.text1));
        val2 = (TextView) (findViewById(R.id.text2));
        httpBtn = (Button) (findViewById(R.id.httpBtn));

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            login = extras.getStringArray("key");
        }
        else {
            Intent back = new Intent(MainActivity2.this, Logo.class);
            back.putExtra("key", "0");
            startActivity(back);
        }
        //val1.setText(login[0]);
        //val2.setText(login[1]);



        JSONObject loginJSON = new JSONObject();
        try {
            loginJSON.put("Username", login[0]);
            //loginJSON.put("Username", "BNSF_BV_Admin");
            loginJSON.put("Password", login[1]);
            //loginJSON.put("Password", "3cJHv");
        } catch (JSONException e) {
            e.printStackTrace();
        }




        PostLogin postLogin = new PostLogin();
        String jsonLogin = postLogin.loginJson("BNSF_BV_Admin", "3cJHmv");
        try {
            //postLogin.post("https://cmms.beenavision.com/CMMSApi/login?username="
            //                + login[0] + "&password=" + login[1], jsonLogin);
            //postLogin.get("https://cmms.beenavision.com/Api/Login?username=BNSF_BV_Admin&password=3cJHmv");
            postLogin.post("https://cmms.beenavision.com/Api/Login", jsonLogin.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(1000);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        if (saved.equals("")) {
            Intent back = new Intent(MainActivity2.this, Logo.class);
            back.putExtra("key", "0");
            startActivity(back);
        }
        else {
            try {
                //postLogin.get(saved);
                postLogin.get(saved);
                Calendar c = Calendar.getInstance();
                Date d = new Date();

                postLogin.get2("https://cmms.beenavision.com/cmmsapi/getAlarms?year=" + Integer.toString(c.get(c.YEAR)) +
                        "&month=" + Integer.toString(c.get(c.MONTH) + 1) + "&day=" + Integer.toString(c.get(c.DAY_OF_MONTH)) +
                        "&username=" + login[0] + "&password=" + login[1]);

                /*
                postLogin.get2("https://cmms.beenavision.com/cmmsapi/getAlarms?year=" + Integer.toString(d.getYear()) +
                        "&month=" + Integer.toString(d.) + "&day=" + Integer.toString(d.getDate()) +
                        "&username=" + login[0] + "&password=" + login[1]);
                        */
            } catch (Exception e) {
                e.printStackTrace();
            }
        }




        try {
            Thread.sleep(1000);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        if (info.equals("\"-1\"")) {
            //info = info.substring(info.indexOf("Winona") - 5);
            home = new Intent(MainActivity2.this, Logo.class);
            home.putExtra("key", "0");
        }
        else {
            //info = alarms;
            trainInfo = new TrainInfo(info, alarms, login);
            try {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            home = new Intent(MainActivity2.this,
                    Home.class).putExtra("trains", trainInfo);
        }

        //TrainParcelable parcel = new TrainParcelable();

        //Bundle bundle = new Bundle();
        //bundle.putSerializable("trains", trainInfo.siteStatuses);

        //Test test = new Test();



        //Intent home = new Intent (MainActivity2.this, Home.class).putExtras(bundle);

        //Intent home = new Intent (MainActivity2.this, Home.class).putExtra("yes", 3);
        startActivity(home);

        //val1.setText(trainInfo.siteStatuses.get(1).SiteName);

        /*
        httpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                OkHttpClient client = new OkHttpClient();

                Request request = new Request.Builder()
                        .url("http://publicobject.com/helloworld.txt")
                        .build();

                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        if (!response.isSuccessful()) {
                            throw new IOException("Unexpected Code " + response);
                        }
                        else {
                            val3 = response.body().string().substring(0);
                            //val1.setText(login[0]);
                            //val3 = val3;
                        }
                    }
                });
                try {
                    Thread.sleep(1000);
                }
                catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                val1.setText(val3);
            }
        });

        */


    }

    /*

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.home_page_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about_id:
                //Toast.makeText(getApplicationContext(), "Info icon is selected", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity2.this, Page1.class));
                break;
            case R.id.product_id:
                //Toast.makeText(getApplicationContext(), "Setting icon is selected", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity2.this, Page2.class));
                break;
            case R.id.contact_id:
                //startActivity(new Intent(Page3.this, Page3.class));
                startActivity(new Intent(MainActivity2.this, Page3.class));
                break;
            case R.id.home_id:
                //Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
                //startActivity(new Intent(MainActivity2.this, Logo.class));
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }

    */
}
