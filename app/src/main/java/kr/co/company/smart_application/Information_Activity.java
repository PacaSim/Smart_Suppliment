package kr.co.company.smart_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Information_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        //툴바
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //리스트뷰
        ListView listview;
        ListViewAdapter adapter;

        adapter = new ListViewAdapter();


        listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a_parent, View a_view, int a_position, long a_id) {
                if(a_position==9) {
                    Toast.makeText(Information_Activity.this, "특히 6세 이하는 과량 섭취하지 않도록 주의", Toast.LENGTH_LONG).show();
                    }
                if(a_position==12){
                    Toast.makeText(Information_Activity.this, "반드시 충분한 물과 함께 섭취할 것(액상제외)", Toast.LENGTH_LONG).show();
                }
                if(a_position==13){
                    Toast.makeText(Information_Activity.this, "특정 단백질에 알레르기를 나타내는 경우에는 섭취 주의", Toast.LENGTH_LONG).show();
                }
            }
        });

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.vitamin_a),
                "비타민A", "1. 어두운 곳에서 시각 적응\n" +"2. 피부와 점막을 형성하고 기능을 유지\n"
        + "3. 상피세포의 성장과 발달", "일일섭취량 : 210~1,000 ug Re");

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.vitamin_b1),
                "비타민B1", "1. 탄수화물과 에너지 대사에 필요","일일섭취량 : 0.36~100 mg");

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.vitamin_b2),
                "비타민B2", "1. 체내 에너지 생성에 필요","일일섭취량 : 0.42~40 mg");

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.vitamin_c),
                "비타민C", "1. 결합조직 형성과 기능유지\n" + "2. 철의 흡수\n" + "3. 유해산소로부터 세포를 보호",
                "일일섭취량 : 30~1,000 mg");

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.vitamin_d),
                "비타민 D", "1. 칼슘과 인이 흡수되고 이용되는데 필요\n" + "2. 뼈의 형성과 유지\n" +
                        "3. 골다공증 발생 위험 감소에 도움을 줌", "일일섭취량 : 1.5~10 μg");

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.vitamin_e),
                "비타민 E", "1. 유해산소로부터 세포를 보호하는데 필요", "일일섭취량 : 3.3~400 mg α-TE");

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.vitamin_k),
                "비타민 K", "1. 정상적인 혈액응고에 필요\n" + "2. 뼈의 구성에 필요", "일일섭취량 : 21~1,000 μg");

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ca),
                "칼슘", "1. 뼈와 치아 형성\n" + "2. 신경과 근육 기능 유지\n" + "3. 정상적인 혈액응고에 필요\n"
                + "4. 골다공증 발생 위험 감소에 도움을 줌", "일일섭취량 : 210~800 mg");

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.mg),
                "마그네슘", "1. 에너지 이용에 필요\n" + "2. 신경과 근육 기능 유지", "일일섭취량 : 94.5~250 mg");

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.fe),
                "철", "1. 체내 산소운반과 혈액생성에 필요\n" + "2.  에너지 생성", "일일섭취량 : 3.6~15 mg");

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.k),
                "칼륨", "1. 체내 물과 전해질 균형에 필요" , "일일섭취량 : 1.05~3.7 g");

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.iodine),
                "요오드", "1. 갑상선 호르몬의 합성\n" + "2. 에너지 생성\n" + "3. 신경발달에 필요" ,
                "일일섭취량 : 45~150 μg");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.dietaryfiber),
                "식이섬유", "1. 식이섬유 보충\n", "일일섭취량 : 식이섬유로서 5 g 이상");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.protein),
                "단백질", "1. 근육, 결합조직 등\n신체조직의 구성성분\n" + "2. 효소, 호르몬, 항체의 구성\n" +
                        "3. 체내 필수 영양성분이나 활성물질의\n 운반과 저장에 필요\n" + "4. 체액, 산-염기의 균형 유지\n"+
                "5. 에너지, 포도당, 지질의 합성\n", "일일섭취량 : 45~150 μg");
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