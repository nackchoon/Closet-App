package com.testapp.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;


public class CameraView extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera);
        
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu view) {
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.view, view);
    	return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
        	case R.id.edit:     setContentView(R.layout.edit);/*Toast.makeText(this, "You pressed the edit button!", Toast.LENGTH_LONG).show();*/
        	
                            break;
        	case R.id.delete:     
        		AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);
                alt_bld.setMessage("Do you want to delete this clothing?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                	public void onClick(DialogInterface dialog, int id) { 
                		dialog.cancel();
                	}
                	})
                	.setNegativeButton("No", new DialogInterface.OnClickListener() {
                		public void onClick(DialogInterface dialog, int id) {
        	        	dialog.cancel();
                		}
                	});
                AlertDialog del = alt_bld.create();
                del.setTitle("Delete?");
                del.show();
        		
        		
        		
        		
        		/*Toast.makeText(this, "You pressed the delete button!", Toast.LENGTH_LONG).show();*/
                            break;
    	}
    	return true;
    }

	@Override
	public void onClick(View v) {
		Intent i = new Intent(this, AddTypeList.class);
		startActivity(i);
		
	}
    	
}