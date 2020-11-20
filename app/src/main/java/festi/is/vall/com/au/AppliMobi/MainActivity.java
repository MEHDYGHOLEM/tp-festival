package festi.is.vall.com.au.AppliMobi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    public static ArrayList<Shape> shapeList = new ArrayList<Shape>();

    private ListView listView;

    private String selectedFilter = "all";

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
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText)
            {
                ArrayList<Shape> filteredShape = new ArrayList<Shape>();
                for (Shape shape: shapeList)
                {
                    if(shape.getName().toLowerCase().contains(newText.toLowerCase()))
                    {
                        filteredShape.add(shape);
                    }
                }

                ShapeAdapter adapter = new ShapeAdapter(getApplicationContext(),0 ,filteredShape);
                listView.setAdapter(adapter);
                return false;
            }
        });
    }
// les noms des festivals ***********************************************************************************************
    private void setupData()
    {
        Shape circle = new Shape("0", "MUSILAC", "Soleil, lac et musique : rendez-vous du 11 au 14 juillet à Aix-les-Bains","Jeudi","Acoustique", R.drawable.circle);
        shapeList.add(circle);

        Shape triangle = new Shape("1","ALIMENTERRE","","","", R.drawable.octagon);
        shapeList.add(triangle);

        Shape square = new Shape("2"," NEW ORLEANS","" ,"","",R.drawable.rectangle);
        shapeList.add(square);

        Shape rectangle = new Shape("3","FOLKS BLUES","" ,"","",R.drawable.square);
        shapeList.add(rectangle);

        Shape octagon = new Shape("4","festival 5","","","", R.drawable.octagon);
        shapeList.add(octagon);

        Shape circle2 = new Shape("5", "festival 6","","" ,"",R.drawable.circle);
        shapeList.add(circle2);

        Shape triangle2 = new Shape("6","BEAUGRENELLE","","","", R.drawable.triangle);
        shapeList.add(triangle2);

        Shape square2 = new Shape("7","festival 8","", "","",R.drawable.square);
        shapeList.add(square2);

        Shape rectangle2 = new Shape("8","festival 9","" ,"","",R.drawable.rectangle);
        shapeList.add(rectangle2);

        Shape octagon2 = new Shape("9","Triangle","" ,"","",R.drawable.octagon);
        shapeList.add(octagon2);
    }

    private void setUpList()
    {
        listView = (ListView) findViewById(R.id.shapesListView);

        ShapeAdapter adapter = new ShapeAdapter(getApplicationContext(), 0, shapeList);
        listView.setAdapter(adapter);
    }

    private void setUpOnclickListener()
    {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
            {
                Shape selectShape = (Shape) (listView.getItemAtPosition(position));
                Intent showDetail = new Intent(getApplicationContext(), DetailActivity.class);
                showDetail.putExtra("id",selectShape.getId());
                startActivity(showDetail);
            }
        });

    }

    private void filterliste(String status)
    {
        selectedFilter = status;

        ArrayList<Shape> filteredShape = new ArrayList<Shape>();
        for (Shape shape: shapeList)
        {
            if(shape.getName().toLowerCase().contains(status))
            {
               filteredShape.add(shape);
                // filteredShape.add(shape);
            }
    }
        ShapeAdapter adapter = new ShapeAdapter(getApplicationContext(),0 ,filteredShape);
        listView.setAdapter(adapter);
    }

    public void allFilterTapped(View view)
    {
        filterliste( "Tout les groupe ");
        ShapeAdapter adapter = new ShapeAdapter(getApplicationContext(),0 ,shapeList);
        listView.setAdapter(adapter);
    }


    public void JeudiFilterTapped(View view)
    {
        filterliste( "festival_jeudi");

    }

    public void VendrediFilterTapped(View view)
    {
        filterliste( "Vendredi");
    }

    public void octagonFilterTapped(View view)
    {
        filterliste( "octagon");

    }

    public void circleFilterTapped(View view)
    {
        filterliste( "circle");
    }
}