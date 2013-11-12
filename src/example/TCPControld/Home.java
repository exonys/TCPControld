package example.TCPControld;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Home extends Activity {
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
    }
}
