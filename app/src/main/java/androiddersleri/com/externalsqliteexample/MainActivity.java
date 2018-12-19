package androiddersleri.com.externalsqliteexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import androiddersleri.com.externalsqliteexample.Adapters.RecyclerviewAdapter;
import androiddersleri.com.externalsqliteexample.Database.MyDatabase;
import androiddersleri.com.externalsqliteexample.Modals.Country;

public class MainActivity extends AppCompatActivity {
    List<Country> countryList;
    RecyclerView recyclerView;
    RecyclerviewAdapter recyclerviewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        XmlElements();
        FillToList();
    }

    public void XmlElements() {
        recyclerView = findViewById(R.id.recyclerView_id);
    }

    public void FillToList() {
        countryList = MyDatabase.getInstance(getApplicationContext()).getAllData();
        recyclerviewAdapter = new RecyclerviewAdapter(getApplicationContext(), countryList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerviewAdapter);
        Log.i("deneme", countryList.get(0).getCountry());
    }

    @Override
    protected void onResume() {
        super.onResume();
        FillToList();
    }
}
