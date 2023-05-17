package kr.co.company.smart_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class List_Activity extends AppCompatActivity {

    EditText name, amount, caution;
    Button insert, view;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        name =findViewById(R.id.name);
        amount=findViewById(R.id.amount);
        caution = findViewById(R.id.caution);
        insert = findViewById(R.id.btnInsert);
        view = findViewById(R.id.btnView);

        db = new DBHelper(this);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(List_Activity.this, Userlist.class));
            }
        });

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String amountTXT = amount.getText().toString();
                String cautionTXT = caution.getText().toString();

                Boolean checkinsertdata = db.insertList(nameTXT, amountTXT, cautionTXT);
                if(checkinsertdata==true)
                {
                    Toast.makeText(List_Activity.this, "리스트에 추가됨", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(List_Activity.this, "리스트 추가 실패", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId ()) {
            case android.R.id.home: //툴바 뒤로가기버튼 눌렸을 때 동작
                finish ();
                return true;
            default:
                return super.onOptionsItemSelected (item);
        }
    }
}