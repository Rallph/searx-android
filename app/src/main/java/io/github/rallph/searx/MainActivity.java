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

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    final String url = "https://searx.prvcy.eu/";
    RequestQueue queue;
    SearchView mSearchBox;
    TextView mResultsView;

    final String TAG = "Main Activity";

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
                Log.d(TAG,"Query is " + query);
                Log.d(TAG, "Query URL is " + queryUrl);

                Toast.makeText(getApplicationContext(), "Submitted", Toast.LENGTH_SHORT).show();


                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, queryUrl, null,new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        Log.d(TAG, "Response received");
                        mResultsView.append(response.toString());


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();;
                    }
                });

                queue.add(request);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }
}
