package com.example.onlineshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class Clothes extends AppCompatActivity {
    Integer images[]={R.drawable.redshirt,R.drawable.shirt,R.drawable.kurtas,R.drawable.jeans,R.drawable.trousers};
    String name[]={"T-Shirts","Shirts","Kurtas","Jeans","Trousers"};
    String price[]={"350","400","800","1200","1000"};
    Button b1,b2,b3;
    Intent i;
    ArrayList<String> nameList=new ArrayList<>();
    ArrayList<String> priceList=new ArrayList<>();
    ArrayList<Integer> imageList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes);
        Intent data=getIntent();
        ListView lv=(ListView)findViewById(R.id.lv);
        CustomList cl=new CustomList(this,name,price,images);
        lv.setAdapter(cl);
        Toast.makeText(getApplicationContext(),"size" +cl.getName().size() + " and final " + nameList.size(),Toast.LENGTH_SHORT).show();
        nameList=cl.getName();
        priceList=cl.getPrice();
        imageList=cl.getImage();
        nameList.addAll(data.getStringArrayListExtra("name"));
        priceList.addAll(data.getStringArrayListExtra("price"));
        imageList.addAll(data.getIntegerArrayListExtra("image"));
        b1=(Button)findViewById(R.id.back);
        b2=(Button)findViewById(R.id.cart);
        b3=(Button)findViewById(R.id.home);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                intent.putStringArrayListExtra("name",nameList);
                intent.putStringArrayListExtra("price",priceList);
                intent.putIntegerArrayListExtra("image",imageList);
                setResult(0,intent);
                finish();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(String na:nameList)
                    Toast.makeText(getApplicationContext(),na+nameList.size(), Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(),Cart.class);
                intent.putStringArrayListExtra("name",nameList);
                intent.putStringArrayListExtra("price",priceList);
                intent.putIntegerArrayListExtra("image",imageList);
                startActivity(intent);
            }
        });

         b3.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                 startActivity(intent);
                 finish();
             }
         });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_select, menu);
        return true;
    }
    private boolean MenuChoice(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menu1:
                i=new Intent(getApplicationContext(),Clothes.class);
                i.putStringArrayListExtra("name",nameList);
                i.putStringArrayListExtra("price",priceList);
                i.putIntegerArrayListExtra("image",imageList);
                startActivityForResult(i,0);
                return true;
            case R.id.menu2:
                return  true;
            case R.id.submenu1:
                i=new Intent(getApplicationContext(),Shoes.class);
                i.putStringArrayListExtra("name",nameList);
                i.putStringArrayListExtra("price",priceList);
                i.putIntegerArrayListExtra("image",imageList);
                startActivityForResult(i,0);
                return true;
            case R.id.submenu2:
                i=new Intent(getApplicationContext(),Watch.class);
                i.putStringArrayListExtra("name",nameList);
                i.putStringArrayListExtra("price",priceList);
                i.putIntegerArrayListExtra("image",imageList);
                startActivityForResult(i,0);
                return true;
            case R.id.menu3:
                i=new Intent(getApplicationContext(),Gadget.class);
                i.putStringArrayListExtra("name",nameList);
                i.putStringArrayListExtra("price",priceList);
                i.putIntegerArrayListExtra("image",imageList);
                startActivityForResult(i,0);
                return true;
            case R.id.menu4:
                i=new Intent(getApplicationContext(),Mobile.class);
                i.putStringArrayListExtra("name",nameList);
                i.putStringArrayListExtra("price",priceList);
                i.putIntegerArrayListExtra("image",imageList);
                startActivityForResult(i,0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return MenuChoice(item);
    }
}
