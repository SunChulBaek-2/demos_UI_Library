package it.neokree.materialtabtest;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.balysv.materialmenu.MaterialMenuDrawable;

import java.util.ArrayList;

import static com.balysv.materialmenu.MaterialMenuDrawable.DEFAULT_PRESSED_DURATION;
import static com.balysv.materialmenu.MaterialMenuDrawable.DEFAULT_SCALE;
import static com.balysv.materialmenu.MaterialMenuDrawable.DEFAULT_TRANSFORM_DURATION;

/**
 * Created by neokree on 30/12/14.
 */
public class MainActivity extends Activity implements AdapterView.OnItemClickListener {
    private MaterialMenuDrawable materialMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_tabs);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        materialMenu = new MaterialMenuDrawable(this,
                Color.WHITE,
                MaterialMenuDrawable.Stroke.THIN,
                DEFAULT_SCALE,
                DEFAULT_TRANSFORM_DURATION,
                DEFAULT_PRESSED_DURATION);
        materialMenu.setIconState(MaterialMenuDrawable.IconState.ARROW);
        toolbar.setNavigationIcon(materialMenu);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        toolbar.setTitle("MaterialTab");
        toolbar.setTitleTextColor(Color.WHITE);

        ListView lvListView = (ListView) findViewById(R.id.lvListView);

        ArrayList<String> list = new ArrayList<String>();

        list.add("Text Tab");
        list.add("Swipable Text Tabs (more than 3)");
        list.add("Icon Tab");
        list.add("Swipable Icon Tab (more than 5)");

        lvListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list));
        lvListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent;
        switch(position) {
            case 0:
                intent = new Intent(this,TextTabActivity.class);
                break;
            case 1:
                intent = new Intent(this,SwipableTextTabActivity.class);
                break;
            case 2:
                intent = new Intent(this,IconTabActivity.class);
                break;
            case 3:
                intent = new Intent(this,SwipableIconTabActivity.class);
                break;
            default:
                intent = null;
        }
        startActivity(intent);
    }
}
