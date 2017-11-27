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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.text);
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



 public void list(View view) throws JSONException {
        JSONArray printout = (JSONArray) new JSONTokener(content).nextValue();
        JSONObject print = printout.getJSONObject(0);

     Toast.makeText(this, "Result" + print, Toast.LENGTH_SHORT).show();

 }




        public void count(View view) throws JSONException {
            TextView textView = findViewById(R.id.text);
            JSONObject jsonObject = new JSONObject(content);

            JSONArray colorArray = jsonObject.getJSONArray("colors");


            String textToPrint = "";
            for (int i =0; i< colorArray.length(); i++) {
                JSONObject message = (JSONObject) colorArray.getJSONObject(i);
                textToPrint += (message.get("rgba")) + "\n";
            }

            Toast.makeText(this, textToPrint, Toast.LENGTH_SHORT).show();

           JSONObject message = (JSONObject)colorArray.get(1);
            JSONObject user = (JSONObject) message.get("user");
            String name = (String) user.get("name");

            while (colorArray.hasNext()) {
                String name = reader.nextName();
                if (name.equals("id")) {
                    message.id = reader.nextLong();
                } else if (name.equals("text")) {
                    message.text = reader.nextString();
                } else if (name.equals("geo") && reader.peek() != JsonToken.NULL) {
                    message.geo = readDoublesArray(reader);
                } else if (name.equals("user")) {
                    message.user = readUser(reader);
                } else {
                    reader.skipValue();
                }
            }
            reader.endObject();
            return message;
        }























    }

