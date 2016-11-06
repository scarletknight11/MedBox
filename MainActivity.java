package com.example.myapplication;

/**
 * Created by sanjitsingh on 11/6/16.
 */


        import android.app.Activity;
        import android.content.Intent;
        import android.net.Uri;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuInflater;
        import android.view.MenuItem;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.Button;
        import android.widget.ScrollView;

public class MainActivity extends Activity  {

    static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    static final String ACTION_SCAN = "com.google.zxing.client.android.SCAN";
    private Uri fileUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//takes you to Create options
        Button button1 = (Button) findViewById(R.id.scanner);

        button1.setOnClickListener(new OnClickListener(){

            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ToDoListView.class);
                startActivity(i);
            }
        });

//takes you to Scan options
        Button button2 = (Button) findViewById(R.id.scanner12);

        button2.setOnClickListener(new OnClickListener(){

            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, First.class);
                startActivity(i);
            }
        });


//takes you to View options
        Button button3 = (Button) findViewById(R.id.scanner3);

        button3.setOnClickListener(new OnClickListener(){


            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ViewOption.class);
                startActivity(i);
            }
        });

    }
    public void onCreate1(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ScrollView sView = (ScrollView)findViewById(R.id.ScrollView01);
        // Hide the Scollbar
        sView.setVerticalScrollBarEnabled(false);
        sView.setHorizontalScrollBarEnabled(false);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu1) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.testmenu, menu1);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {

            case R.id.Create:
                CreateMenuItem();
                //Click this Menu button takes you to Create file page
                setContentView(R.layout.to_do_list_view);
                Intent intent = new Intent(MainActivity.this, ToDoListView.class);
                startActivity(intent);
                return true;

            case R.id.scan:
                scanMenuItem();
                //Click this Menu button takes you to Scan Options
                setContentView(R.layout.activity_first);
                Intent intent2 = new Intent(MainActivity.this, First.class);
                startActivity(intent2);
                return true;

            case R.id.View:
                ViewMenuItem();
                //Click this Menu button takes you to View Options
                setContentView(R.layout.activity_view_option);
                Intent intent3 = new Intent(MainActivity.this, ViewOption.class);
                startActivity(intent3);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
    private void CreateMenuItem(){
//	new AlertDialog.Builder(this)
//	.setTitle("Create")
//	.setMessage("This is a create dialog")
//	.setNeutralButton("OK", new DialogInterface.OnClickListener() {
//
//		@Override
//		public void onClick(DialogInterface dialog, int which) {
//			// TODO Auto-generated method stub

    }
    //}).show();
//}

    private void scanMenuItem(){


//	Button button1 = (Button) findViewById(R.id.scan);
//
//	button1.setOnClickListener(new OnClickListener(){
//
//
//		public void onClick(View v) {
//			 Intent i = new Intent(MainActivity.this, First.class);
//			 startActivity(i);
//		}
        //});

    }

    private void ViewMenuItem(){
//	new AlertDialog.Builder(this)
//	.setTitle("View")
//	.setMessage("This is a  dialog")
//	.setNeutralButton("OK", new DialogInterface.OnClickListener() {
//
//@Override
//public void onClick(DialogInterface dialog, int which) {
//			// TODO Auto-generated method stub
//
//			}
//		}).show();
//	}
    }
}
