package com.uniquename.customadapter;
/*
 Dans les cas ou nous souhaitons afficher une liste simple d'un tableau de chaines de caracteres, un simple ArrayAdapter suffira. Cependant, nous pouvons souvent nous retrouver dans des situations ou nous allons vouloir faire plus que d'afficher un tableau simple d'une liste de chaine de caracteres. Prenons un example tout simple, nous voulons afficher une liste de restaurants fast food. Nous voulons precier la ville, le titre, la description le menu etc. Logiquement noter restaurant fast food ne sera plus un tableau de simple chaines de caracteres mais deviendra un objet. Pour afficher les proprietés differentes d'un objet, nous allons besoin de creer une classe pour faire ceci. Appelons la FastFoodAdapter
*/

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.uniquename.customadapter.javaclass.FastFood;

import java.util.ArrayList;

public class FastFoodAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<FastFood> fastFoods;

    TextView mTitleView;
    TextView mDescriptionView;

    ImageView mImage;


    /*j'instancie ma classe FastFoodAdapter en precisant le contexte ainsi que les données que cette classe va traiter (dans ce cas ca sera un ArrayList d'instances de FastFood)
     */
    public FastFoodAdapter(Context context, ArrayList <FastFood> fastFoods){
        this.context=context;
        this.fastFoods=fastFoods;
    }
    // La classe BaseAdapter en Java est une classe abstraite. Nous allons donc devoir utiliser certaines methodes de cette classees dans notre classe FastFoodAdapter etant donnée que nous etendons cette classe
    public int getCount(){

        return fastFoods.size();
    }

    public Object getItem(int position){
        return fastFoods.get(position);
    }

    public long getItemId(int position){
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        /*
          L'objet convertView est un grand objet qui nous permet de gerer des layouts (View) lors que nous sommes pas directement dans nos Accitivtés .
        */

        if(convertView == null){
            /*
                Cette ligne est un peu compliqué mais ce que nous sommes en train de dire ici c'est qui nous voulons associé notre vue (fast_food_layout) a la vue de notre parent (qui est la vue associé a mainActivity etant donnée que notre context correpond a MainActivity). Donc nous sommes en train d'associer la Vue fast_food_layout a la vue de notre parent (qui dans ce cas sera la vue associé a MainActivity etant donnée notre contexte)
             */
            convertView= LayoutInflater.from(this.context).inflate(R.layout.fast_food_layout,parent,false);
        }
        // je recupere mon objet actuelle en utilisant le parametre position qui va nous renvoyer l'index actuelle
        FastFood fastFood=this.fastFoods.get(position);

        // je defini mes TextViews dans mon fast_food_layout par rapport aux valuers de mes id
        mTitleView=convertView.findViewById(R.id.title_text);
        mDescriptionView=convertView.findViewById(R.id.description_text);
        mImage=convertView.findViewById(R.id.fast_food_photo);

        // ici je defini le contenu textuelle de mes TextViews que j'ai recuperé
        mTitleView.setText(fastFood.getTitle());
        mDescriptionView.setText(fastFood.getDescription());

        // ici si j'ai bien une photo defini sur mon objet je vais l'afficher
        if(fastFood.getPhoto()!=0){
            mImage.setImageResource(fastFood.getPhoto());
        }
        // A la fin on retourne cette vue
        return convertView;
    }
}
