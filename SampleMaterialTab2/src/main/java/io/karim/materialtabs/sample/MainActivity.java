package io.karim.materialtabs.sample;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import kr.pe.ssun.mylibrary.BaseActivity;


public class MainActivity extends BaseActivity
        implements android.widget.Toolbar.OnMenuItemClickListener, android.support.v7.widget.Toolbar.OnMenuItemClickListener {
    /**
     * Holds references to fragments from the time they are attached to Activity until they are dettached.
     */
    private ArrayList<ResettableFragment> mFragments = new ArrayList<>();

    /**
     * Intent used to start {@link TabsActivity}.
     */
    public Intent startTabsActivityIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setToolbarTitle("MaterialTab");
        setMenu(R.menu.menu_main, this);
        setToolbarIconState(IconState.ARROW);
        setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishProperly();
            }
        });

        FragmentManager fm = getFragmentManager();
        fm.beginTransaction()
                .add(R.id.content, new MainFragment())
                .commit();

        startTabsActivityIntent = new Intent(this, TabsActivity.class);
    }

    /**
     * Resets default values of all the settings in both {@link TabsSettingsFragment} and {@link RippleSettingsFragment}.
     */
    private void resetDefaults() {
        for (ResettableFragment f : mFragments) {
            f.setupAndReset();
        }
    }

    /**
     * Add fragment to {@link #mFragments} when attached to Activity.
     */
    public void addFragment(ResettableFragment f) {
        mFragments.add(f);
    }


    /**
     * Remove fragment from {@link #mFragments} when detached to Activity.
     */
    public void removeFragment(ResettableFragment f) {
        mFragments.remove(f);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        // Handle action bar item clicks here. The action bar will automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        if (item.getItemId() == R.id.action_me) {
            DialogFragment newFragment = new MainFragment.MeDialogFragment();
            newFragment.show(getFragmentManager(), "dialog");
            return true;
        } else if (item.getItemId() == R.id.action_reset) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("Reset everything to default?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            resetDefaults();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            // show it
            alertDialog.show();
            return true;
        } else if (item.getItemId() == R.id.action_go) {
            startActivity(startTabsActivityIntent);
            return true;
        }

        return false;
    }
}
