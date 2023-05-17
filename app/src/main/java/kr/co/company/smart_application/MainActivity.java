package kr.co.company.smart_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.company.smart_application.data.Item;
import kr.co.company.smart_application.data.Result;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private List<Item> mItems;
    private EditText et_name;

    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        et_name = (EditText) findViewById(R.id.et_name);

        recyclerView = (RecyclerView) findViewById(R.id.rv_item);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater ().inflate (R.menu.main_menu, menu);
        return true;
    }
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId ()) {
            case R.id.alarm:
                startActivity (new Intent(this, Alarm_Activity.class));
                return true;
            case R.id.list:
                startActivity (new Intent(this, List_Activity.class));
                return true;
            case R.id.information:
                startActivity (new Intent(this, Information_Activity.class));
                return true;
            default:
                return super.onOptionsItemSelected (item);
        }
    }

    public void mOnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_Search:
                if(et_name.getText().toString().length() == 0){
                    Toast.makeText(MainActivity.this, "건강기능식품명을 입력하세요!", Toast.LENGTH_SHORT).show();
                } else {
                    info();
                }
                break;
        }

    }
    void info() {

        Info_API service = ServiceGenerator.getRetrofit().create(Info_API.class);

        Map<String, String> data = new HashMap<>();

        String prdlst_nm = et_name.getText().toString();
        data.put("prdlst_nm", prdlst_nm);

        Call<Result> call = service.getretrofit(data);
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                mItems = response.body().getBody().getItems();
                recyclerView.setVisibility(View.VISIBLE);
                recyclerAdapter = new RecyclerAdapter(MainActivity.this, mItems);
                if (recyclerAdapter.getItemCount() == 0) {
                    Toast.makeText(MainActivity.this, "검색결과가 없습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    recyclerView.setAdapter(recyclerAdapter);
                }

            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Toast.makeText(MainActivity.this, "network failure", Toast.LENGTH_SHORT).show();
            }
        });

    }
}