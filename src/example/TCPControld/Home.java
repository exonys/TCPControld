package example.TCPControld;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Home extends Activity {
    private static Context sContext;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //Read algs
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Algs, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner cellModeSpinner = (Spinner) findViewById(R.id.CellModeSpinner);
        Spinner wifiModeSpinner = (Spinner) findViewById(R.id.WifiModeSpinner);

        cellModeSpinner.setAdapter(adapter);
        wifiModeSpinner.setAdapter(adapter);

        //Those seem to be best yet
        cellModeSpinner.setSelection(adapter.getPosition("reno"));
        wifiModeSpinner.setSelection(adapter.getPosition("westwood"));

        //Dirty hacks
        sContext = getApplicationContext();

        Log.v("tcpcontrold", "UI ");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.DonateBtn:
                return true;
            case R.id.RequestRootBtn:
                RootHelper.ExecuteRootCommand("free");
                return true;
            case R.id.SaveBtn:
                //Save config
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //Dirty hacks
    public static Context getContext() {
        return sContext;
    }
}
