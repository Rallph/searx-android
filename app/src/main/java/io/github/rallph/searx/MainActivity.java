package io.github.rallph.searx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    final String url = "https://searx.prvcy.eu/";
    RequestQueue queue;
    SearchView mSearchBox;
    TextView mResultsView;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        queue = Volley.newRequestQueue(this);
        mSearchBox = findViewById(R.id.search_box);
        mResultsView = findViewById(R.id.results_box);



        mSearchBox.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {

                String queryUrl = url + "?q=" + query + "&format=json";
                Log.d(TAG, "Query is " + query);
                Log.d(TAG, "Query URL is " + queryUrl);

                Toast.makeText(getApplicationContext(), "Searched", Toast.LENGTH_SHORT).show();
                getResults(queryUrl);
                return false;
            }


            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }


    public void getResults(String queryUrl) {




        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, queryUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Toast.makeText(getApplicationContext(), "response received", Toast.LENGTH_SHORT).show();
                try {

                    JSONArray results = response.getJSONArray("results");

                    for (int i = 0; i < results.length(); i++) {

                        JSONObject result = (JSONObject) results.get(i);

                        Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();

                        String entry = result.getString("title") + "\n" + result.getString("url") + "\n";

                        if (result.has("content")) {
                            entry += result.getString("content");
                        }

                        entry += "\n\n";

                        mResultsView.append(entry);



                    }

                } catch (JSONException e) {

                    Toast.makeText(getApplicationContext(), "shit fucked up in the json", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "shit fucked up in volley", Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(request);
    }
}
