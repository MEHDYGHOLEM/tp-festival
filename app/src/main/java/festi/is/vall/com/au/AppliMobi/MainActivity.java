package festi.is.vall.com.au.AppliMobi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{



    public static ArrayList<Festival_info> shapeList = new ArrayList<Festival_info>();

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupData();
        initSearchWidgets();
        setUpList();
        setUpOnclickListener();
    }
    private void initSearchWidgets()
    {
        SearchView searchView = (SearchView) findViewById(R.id.shapeListeSearchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s)

            {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s)
            {
                ArrayList<Festival_info> filterfestival = new ArrayList<Festival_info>();
                for (Festival_info shape: shapeList)
                {
                    if(shape.getjour().toLowerCase().contains(s.toLowerCase()))
                    {
                            filterfestival.add(shape);
                    }

                    if(shape.getScene().toLowerCase().contains(s.toLowerCase()))
                    {
                        filterfestival.add(shape);
                    }
                }

                FestAdapter adapter = new FestAdapter(getApplicationContext(),0 ,filterfestival);
                listView.setAdapter(adapter);
                return false;
            }
        });
    }
// les noms des festivals ***********************************************************************************************
    private void setupData()
    {
        Festival_info fest1 = new Festival_info("0", "MUSILAC", "Aix-les-Bains","Jeudi","Acoustique", R.drawable.circle);
        shapeList.add(fest1);

        Festival_info fest2 = new Festival_info("1","ALIMENTERRE","hello word","Vendredi","Acoustique", R.drawable.octagon);
        shapeList.add(fest2);

        Festival_info fest3 = new Festival_info("2"," NEW ORLEANS","" ,"Jeudi","Emplifier",R.drawable.rectangle);
        shapeList.add(fest3);

        Festival_info fest4 = new Festival_info("3","FOLKS BLUES","" ,"Vendredi","Emplifier",R.drawable.square);
        shapeList.add(fest4);

        Festival_info fest5 = new Festival_info("4","festival 5","","","", R.drawable.octagon);
        shapeList.add(fest5);

        Festival_info fest6 = new Festival_info("5", "festival 6","","" ,"",R.drawable.circle);
        shapeList.add(fest6);

        Festival_info fest7 = new Festival_info("6","BEAUGRENELLE","","","", R.drawable.triangle);
        shapeList.add(fest7);

        Festival_info fest8 = new Festival_info("7","festival 8","", "","",R.drawable.square);
        shapeList.add(fest8);

        Festival_info fest9 = new Festival_info("8","festival 9","" ,"Jeudi","",R.drawable.rectangle);
        shapeList.add(fest9);

        Festival_info fest10 = new Festival_info("9","festival 10","" ,"lundi","",R.drawable.octagon);
        shapeList.add(fest10);
    }

    private void setUpList()
    {
        listView = (ListView) findViewById(R.id.shapesListView);

        FestAdapter adapter = new FestAdapter(getApplicationContext(), 0, shapeList);
        listView.setAdapter(adapter);
    }

    private void setUpOnclickListener()
    {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
            {
                Festival_info selectShape = (Festival_info) (listView.getItemAtPosition(position));
                Intent showDetail = new Intent(getApplicationContext(), DetailActivity.class);
                showDetail.putExtra("id",selectShape.getId());
                startActivity(showDetail);
            }
        });

    }
// filter les recherches // créer une boucle pour filter tout les festival

    private void filterliste(String status)

    {
        ArrayList<Festival_info> filterfestival = new ArrayList<Festival_info>();
        for (Festival_info shape: shapeList)
        {
            if(shape.getjour().toLowerCase().contains(status))
            {
               filterfestival.add(shape);

            }
    }
        FestAdapter adapter = new FestAdapter(getApplicationContext(),0 ,filterfestival);
        listView.setAdapter(adapter);
    }

    public void allFilterTapped(View view)
    {
        filterliste( "all");
        FestAdapter adapter = new FestAdapter(getApplicationContext(),0 ,shapeList);
        listView.setAdapter(adapter);
    }
    //créer une boucle pour une filtration personnalisée

    public void JeudiFilterTapped(View view)
    {
        filterliste( "jeudi") ;
    }
    public void VendrediFilterTapped(View view)

    {
        filterliste( "vendredi") ;

    }

    public void AcoustiqueFilterTapped(View view)

    {
        filterliste( "") ;

    }

    public void EmplifierFilterTapped(View view)

    {
        filterliste( "") ;
    }



}