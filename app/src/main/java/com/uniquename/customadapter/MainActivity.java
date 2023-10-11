package com.uniquename.customadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.uniquename.customadapter.javaclass.FastFood;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView mListFastFoods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ici je fais appel a la fonction setFastFoodAdapter
        setFastFoodAdapter();
    }

    public void setFastFoodAdapter(){
        // je recupere mes fastfoods
        ArrayList <FastFood> getFastFoods=buildFastFoods();
        // je construit mon Adapter en lui precisant les arguments pertinant
        FastFoodAdapter newFastFoodApapter=new FastFoodAdapter(MainActivity.this,getFastFoods);
        // ici je defini ma ListView mListFastFoods
        mListFastFoods=findViewById(R.id.list_fast_foods);
        // ici je defini l'adapteur de cette vue
        mListFastFoods.setAdapter(newFastFoodApapter);

    }

    // ici je construit et je retourne une liste de fastFoods
    public ArrayList<FastFood> buildFastFoods(){

        ArrayList<FastFood> fastFoods=new ArrayList<>();

        FastFood fastFood1=new FastFood("DoMac","The Healthiest Fast Food You Can find");
        FastFood fastFood2=new FastFood("KFC","Colonel Sanders started this restaurant at the young age of 63 and now it serves the healthiest fried chicken in town");
        FastFood fastFood3=new FastFood("O'tacos","Les mieulleures tacos francais que il y a. Reccomandé si vous voulez vous alimenter sienement !");

        fastFood1.setPhoto(R.drawable.fast_food_photo);
        fastFood2.setPhoto(R.drawable.fast_food_photo);
        fastFood3.setPhoto(R.drawable.fast_food_photo);


        fastFoods.add(fastFood1);
        fastFoods.add(fastFood2);
        fastFoods.add(fastFood3);

        return fastFoods;
    }
}