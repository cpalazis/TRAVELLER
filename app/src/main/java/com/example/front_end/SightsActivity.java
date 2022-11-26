package com.example.front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SightsActivity extends AppCompatActivity {
    private ImageView Museums_Image;
    private ImageView Banks_Image;
    private ImageView Hotel_Image;
    private ImageView Caffe_Image;
    private ImageView Restaurants_Image;

    private TextView TextView_M;
    private TextView TextView_B;
    private TextView TextView_H;
    private TextView TextView_C;
    private TextView TextView_R;


    private List <String> Sight_Name=new ArrayList<>();
    private List <String> Image_View=new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sights);
        Museums_Image=findViewById(R.id.Museums_image);
        Museums_Image=findViewById(R.id.Banks_Image);
        Museums_Image=findViewById(R.id.Hotel_Image);
        Museums_Image=findViewById(R.id.Caffe_Image);
        Museums_Image=findViewById(R.id.Restaurants_Image);

        TextView_M=findViewById(R.id.textView_M);
        TextView_M=findViewById(R.id.textView_H);
        TextView_M=findViewById(R.id.textView_B);
        TextView_M=findViewById(R.id.textView_C);
        TextView_M=findViewById(R.id.textView_R);

        citiesResult();

    }

    public void citiesResult()  {
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest response = new StringRequest(Request.Method.GET, "http://localhost:3000/sights",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            int count=jsonArray.length();      //fere to plithos poy apanthse to api
                            if (jsonArray.length() > 5) {          // ean h apantisi toy api einai>5 tote ayta poy tha emfaniseis einai ta prota 5
                                count=5;
                            }
                            for (int i = 0; i < count ; i++){
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                Sight_Name.add(jsonObject.getString("name"));     //pernei onomata apo to api
                                JSONArray images_array=jsonObject.getJSONArray("images");
                                Image_View.add(images_array.getString(0));        // pairnw panta proti foto
                            }
                            displayResults();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
    }

    private void displayResults() {
        Picasso.get().load(Image_View.get(0)).into(Museums_Image);
        Picasso.get().load(Image_View.get(1)).into(Banks_Image);
        Picasso.get().load(Image_View.get(2)).into(Hotel_Image);
        Picasso.get().load(Image_View.get(3)).into(Caffe_Image);
        Picasso.get().load(Image_View.get(4)).into(Restaurants_Image);

        TextView_M.setText(Sight_Name.get(0));
        TextView_B.setText(Sight_Name.get(1));
        TextView_H.setText(Sight_Name.get(2));
        TextView_C.setText(Sight_Name.get(3));
        TextView_R.setText(Sight_Name.get(4));

    }
}