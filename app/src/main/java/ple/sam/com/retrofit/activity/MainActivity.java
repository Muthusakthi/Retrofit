package ple.sam.com.retrofit.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ple.sam.com.retrofit.BuildConfig;
import ple.sam.com.retrofit.R;
import ple.sam.com.retrofit.adapter.EmployeeAdapter;
import ple.sam.com.retrofit.model.Apires;
import ple.sam.com.retrofit.model.EmptyRecyclerView;
import ple.sam.com.retrofit.network.GetEmployeeDataService;
import ple.sam.com.retrofit.network.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EmployeeAdapter adapter;
    private EmptyRecyclerView recyclerView;
    EditText editTextSearch;
    TextView emptyResult;

    int textlength = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  //URl : http://mobileappdatabase.in/retrofit/getuser.php
        editTextSearch = (EditText) findViewById(R.id.editTextSearch);
        /*Create handle for the RetrofitInstance interface*/
        GetEmployeeDataService service = RetrofitInstance.getRetrofitInstance().create(GetEmployeeDataService.class);

        /*Call the method with parameter in the interface to get the employee data*/
        Call<List<Apires>> call = service.getEmployeeData();//100);

        /*Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<List<Apires>>() {

            @Override
            public void onResponse(Call<List<Apires>> call, Response<List<Apires>> response) {
                generateEmployeeList(response.body());
            }

            @Override
            public void onFailure(Call<List<Apires>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
                Log.wtf("error", t.toString() + "" + BuildConfig.VERSION_NAME);

            }
        });
    }

    /*Method to generate List of employees using RecyclerView with custom adapter*/
    private void generateEmployeeList(final List<Apires> empDataList) {
         recyclerView = (EmptyRecyclerView) findViewById(R.id.recycler_view_employee_list);

        adapter = new EmployeeAdapter(empDataList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);

        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                charSequence = charSequence.toString().toLowerCase();

                final List<Apires> filteredList = new ArrayList<>();

                for (int h = 0; h < empDataList.size(); h++) {

                    final String text = empDataList.get(h).toLowerCase();
                    if (text.contains(charSequence)) {

                        filteredList.add(empDataList.get(h));
                    }
                }

                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                adapter = new EmployeeAdapter(filteredList);
                recyclerView.setAdapter(adapter);
               // recyclerView.setEmptyView(emptyResult);
                recyclerView.setEmptyView(findViewById(R.id.emptyElement));
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });




    }
}
