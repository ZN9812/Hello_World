package com.example.pizzaorder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView img_pizza_main;
    EditText edit_cola_count;
    CheckBox chk_agree;
    TextView txt_pizza_price;
    TextView txt_size_price;
    TextView txt_cola_price;
    TextView txt_total_pay;

    int val_pizza_price=10000;
    int val_size_price=0;

    int val_cola_count=1;
    int val_cola_price=1000;
    int val_total_pay=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_pizza_main=findViewById(R.id.img_pizza_main);
        edit_cola_count=findViewById(R.id.edit_cola_count);
        chk_agree=findViewById(R.id.chk_agree);
        txt_total_pay=findViewById(R.id.txt_total_pay);
        txt_size_price=findViewById(R.id.txt_size_price);
        txt_cola_price=findViewById(R.id.txt_cola_price);
        txt_pizza_price=findViewById(R.id.txt_pizza_price);

        findViewById(R.id.pizza1).setOnClickListener(this);
        findViewById(R.id.pizza2).setOnClickListener(this);
        findViewById(R.id.pizza3).setOnClickListener(this);
        findViewById(R.id.large).setOnClickListener(this);
        findViewById(R.id.medium).setOnClickListener(this);
        findViewById(R.id.btn_minus).setOnClickListener(this);
        findViewById(R.id.btn_plus).setOnClickListener(this);
        findViewById(R.id.btn_pay).setOnClickListener(this);
    }

    public void SumTotal(){
        val_total_pay = val_cola_price * val_cola_count + val_size_price + val_pizza_price;

        txt_pizza_price.setText(val_pizza_price+"");
        txt_cola_price.setText(val_cola_price+"");
        txt_size_price.setText(val_size_price+"");
        txt_total_pay.setText(val_total_pay+"");
        edit_cola_count.setText(val_cola_count+"");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.pizza1:
                img_pizza_main.setImageResource(R.drawable.menu_pizza1);
                val_pizza_price=10000;
                break;
            case R.id.pizza2:
                img_pizza_main.setImageResource(R.drawable.menu_pizza2);
                val_pizza_price=20000;
                break;
            case R.id.pizza3:
                img_pizza_main.setImageResource(R.drawable.menu_pizza3);
                val_pizza_price=30000;
                break;
            case R.id.large:
                val_size_price=5000;
                break;
            case R.id.medium:
                val_size_price=0;
                break;
            case R.id.btn_minus:
                if(val_cola_count<=0)
                    Toast.makeText(getApplicationContext(), "최소 수량은 0개 입니다.", Toast.LENGTH_SHORT).show();
                else
                    val_cola_count-=1;
                break;
            case R.id.btn_plus:
                if(val_cola_count>=5)
                    Toast.makeText(getApplicationContext(), "최대 수량은 5개 입니다.", Toast.LENGTH_SHORT).show();
                else
                    val_cola_count+=1;
                break;
            case R.id.btn_pay:
                if(chk_agree.isChecked()==false)
                    Toast.makeText(getApplicationContext(), "먼저 구매 약관에 동의 해주세요.", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "가격은 "+val_total_pay+"원 입니다.", Toast.LENGTH_SHORT).show();
                break;
        }
        SumTotal();
    }
}