package com.danshima.jsonexercise;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.JsonReader;
import android.util.JsonToken;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private String content;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text);
        textView.setMovementMethod(new ScrollingMovementMethod());
        //putting JSON data into a string
        content = " [\n" +
                "  {\n" +
                "   \"color\": \"black\",\n" +
                "   \"category\": \"hue\", \n" +
                "   \"type\": \"primary\", \n" +
                "   \"code\": {\n" +
                "   \"rgba\": [255, 255, 255, 1], \n " +
                "   \"hex\": \"#000\" \n" +
                "   }\n" +
                "   }, \n" +
                "   {\n" +
                "   \"color\": \"white\", \n" +
                "   \"category\": \"value\", \n" +
                "   \"code\": {\n" +
                "   \"rgba\": [0, 0, 0, 1], \n " +
                "   \"hex\": \"#FFF\" \n" +
                "   }\n" +
                "   }, \n" +
                "   {\n" +
                "   \"color\": \"red\", \n" +
                "   \"category\": \"value\", \n" +
                "   \"type\": \"primary\", \n" +
                "   \"code\": {\n" +
                "   \"rgba\": [255, 0, 0, 1], \n " +
                "   \"hex\": \"#FF0\" \n" +
                "   }\n" +
                "   }, \n" +
                "   {\n" +
                "   \"color\": \"blue\", \n" +
                "   \"category\": \"hue\", \n" +
                "   \"type\": \"primary\", \n" +
                "   \"code\": {\n" +
                "   \"rgba\": [0, 0, 255, 1], \n" +
                "   \"hex\": \"#00F\" \n" +
                "   }\n" +
                "   }, \n" +
                "   {\n" +
                "   \"color\": \"yellow\", \n" +
                "   \"category\": \"hue\", \n" +
                "   \"type\": \"primary\", \n" +
                "   \"code\": {\n" +
                "   \"rgba\": [255, 255, 0, 1], \n" +
                "   \"hex\": \"#FF0\" \n" +
                "   }\n" +
                "   }, \n" +
                "   {\n" +
                "   \"color\": \"green\", \n" +
                "   \"category\": \"hue\", \n" +
                "   \"type\": \"secondary\", \n" +
                "   \"code\": {\n" +
                "   \"rgba\": [0, 255, 0, 1], \n" +
                "   \"hex\": \"#0F0\" \n" +
                "   }\n" +
                "   } \n" +
                "  ] ";
    }

    /**
     * writes into the textView a string consisting of the concatenation of the color field (i.e. black) of the colors having green component equal to 255.
     * @param view The TextView
     * @throws JSONException
     */
 public void list(View view) throws JSONException {
     try {
         JSONArray colors = (JSONArray) new JSONTokener(content).nextValue();
         String printOut="";
         for(int i = 0;i < colors.length();i++) {
             JSONObject color = colors.getJSONObject(i);
             JSONObject colorCode = color.getJSONObject("code");
             JSONArray rgba = (JSONArray) colorCode.get("rgba");
             String component = Integer.toString(rgba.getInt(1));
             if (component.equals("255"))
                 printOut = printOut + ", "+ color.get("color");
         }
         textView.setText("Color Field: " + printOut);
     } catch (JSONException e) {
         e.printStackTrace();
     }
 }

    /**
     * writes into the textView the number of colors having green component equal to 255.
     * @param view The TextView
     * @throws JSONException
     */
    public void count(View view) throws JSONException
    {
        try {
            JSONArray colors = (JSONArray) new JSONTokener(content).nextValue();
            int countGreen = 0;
            for(int i=0;i<colors.length();i++) {
                JSONObject color = colors.getJSONObject(i);
                JSONObject colorCode = color.getJSONObject("code");
                JSONArray rgba = (JSONArray) colorCode.get("rgba");
                if (rgba.getInt(1) == 255)
                    countGreen++;
            }
            textView.setText("The number of colors having green component: " + Integer.toString(countGreen));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    /**
     * adding a new color (color: orange, category: hue, rgba: 255,165,0,1, hex: #FA0),
     * then serializes the JSON data to a string and writes it into the textView.
     * @param view
     * @throws JSONException
     */
    public void modify(View view) throws JSONException
    {
        try {
            JSONArray colors = (JSONArray) new JSONTokener(content).nextValue();
            JSONObject color = new JSONObject();
            color.put("color", "orange");
            color.put("category","hue");

            JSONObject code = new JSONObject();
            JSONArray rgba = new JSONArray();

            rgba.put(255);
            rgba.put(165);
            rgba.put(0);
            rgba.put(1);

            code.put("rgba",rgba);
            code.put("hex","#FA0");
            color.put("code", code);

            colors.put(color); //add to existing array
            String printOut = colors.toString(2);
            textView.setText(printOut);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }






















    }

