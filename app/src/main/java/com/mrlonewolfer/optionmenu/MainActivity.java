package com.mrlonewolfer.optionmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.imgView);
        registerForContextMenu(imageView);
        imageView.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.conten_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_file:
                Toast.makeText(context, "File", Toast.LENGTH_SHORT).show();
                break;


        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        Toast.makeText(context, "Image is Selected", Toast.LENGTH_SHORT).show();
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return super.onContextItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        PopupMenu popupMenu= new PopupMenu(context,v);
        popupMenu.getMenuInflater().inflate(R.menu.conten_menu,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch(item.getItemId()){
                    case R.id.action_file:
                        Toast.makeText(context, "File", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.New:
                        Toast.makeText(context, "New", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.Exit:
                        Toast.makeText(context, "Exit", Toast.LENGTH_SHORT).show();
                        break;

                }
                return false;
            }
        });
        popupMenu.show();
    }
}
