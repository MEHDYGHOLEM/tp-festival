package festi.is.vall.com.au.AppliMobi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity
{
    Festival_info selectedShape;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSelectedShape();
        setValues();

    }

    private void getSelectedShape()
    {
        Intent previousIntent = getIntent();
        String parsedStringID = previousIntent.getStringExtra("id");
        selectedShape = MainActivity.shapeList.get(Integer.valueOf(parsedStringID));
    }

    private void setValues()
    {
        TextView tv = (TextView) findViewById(R.id.Nomfest);
        TextView tv1 = (TextView) findViewById(R.id.TextDetail);
        TextView tv2 = (TextView) findViewById(R.id.textviewJour);
        TextView tv3 = (TextView) findViewById(R.id.textviewScene);

        ImageView iv = (ImageView) findViewById(R.id.shapeImage);

        tv.setText(selectedShape.getName());
        tv1.setText(selectedShape.getInfo());
        tv2.setText(selectedShape.getjour());
        tv3.setText(selectedShape.getScene());
        iv.setImageResource(selectedShape.getImage());
    }
}