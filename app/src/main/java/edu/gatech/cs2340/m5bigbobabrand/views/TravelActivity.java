package edu.gatech.cs2340.m5bigbobabrand.views;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;

import edu.gatech.cs2340.m5bigbobabrand.R;


public class TravelActivity extends AppCompatActivity {
    private CircleMenu circleMenu;
    private CircleMenu demoMenu;
    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);
        circleMenu = (CircleMenu) findViewById(R.id.circle_menu);
        demoMenu = (CircleMenu) findViewById(R.id.demo_menu);
        builder = new AlertDialog.Builder(this);
        circleMenu.setMainMenu(Color.parseColor("#FF6A00"), R.mipmap.republic, R.mipmap.icon_cancel)
                .addSubMenu(Color.parseColor("#258CFF"), R.mipmap.republic)
                .addSubMenu(Color.parseColor("#30A400"), R.mipmap.republic)
                .addSubMenu(Color.parseColor("#FF4B32"), R.mipmap.republic)
                .addSubMenu(Color.parseColor("#8A39FF"), R.mipmap.republic)
                .addSubMenu(Color.parseColor("#CDCDCD"), R.mipmap.republic)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {

                    @Override
                    public void onMenuSelected(int index) {
                        switch(index) {

                            case 4:
                                builder.setMessage("Do you want to travel to Planet 1?")
                                        .setCancelable(false)
                                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                finish();
                                                Toast.makeText(getApplicationContext(),"you choose yes action for alertbox",
                                                        Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                //  Action for 'NO' Button
                                                dialog.cancel();
                                                Toast.makeText(getApplicationContext(),"you choose no action for alertbox",
                                                        Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                //Creating dialog box
                                AlertDialog alert = builder.create();
                                //Setting the title manually
                                alert.setTitle("AlertDialogExample");
                                alert.show();

                                Toast.makeText(TravelActivity.this, "Planet 1 Button Clicked", Toast.LENGTH_SHORT).show();
                                break;
                            case 3:
                                builder.setMessage("Do you want to travel to Planet 2?")
                                        .setCancelable(false)
                                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                finish();
                                                Toast.makeText(getApplicationContext(),"you choose yes action for alertbox",
                                                        Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                //  Action for 'NO' Button
                                                dialog.cancel();
                                                Toast.makeText(getApplicationContext(),"you choose no action for alertbox",
                                                        Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                //Creating dialog box
                                AlertDialog alert2 = builder.create();
                                //Setting the title manually
                                alert2.setTitle("AlertDialogExample");
                                alert2.show();

                                Toast.makeText(TravelActivity.this, "Planet 2 Button Clicked", Toast.LENGTH_SHORT).show();
                                break;
                            case 2:
                                builder.setMessage("Do you want to travel to Planet 3?")
                                        .setCancelable(false)
                                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                finish();
                                                Toast.makeText(getApplicationContext(),"you choose yes action for alertbox",
                                                        Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                //  Action for 'NO' Button
                                                dialog.cancel();
                                                Toast.makeText(getApplicationContext(),"you choose no action for alertbox",
                                                        Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                //Creating dialog box
                                AlertDialog alert3 = builder.create();
                                //Setting the title manually
                                alert3.setTitle("AlertDialogExample");
                                alert3.show();
                                Toast.makeText(TravelActivity.this, "Planet 3 Button Clicked", Toast.LENGTH_SHORT).show();
                                break;
                            case 1:
                                builder.setMessage("Do you want to travel to Planet 4?")
                                        .setCancelable(false)
                                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                finish();
                                                Toast.makeText(getApplicationContext(),"you choose yes action for alertbox",
                                                        Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                //  Action for 'NO' Button
                                                dialog.cancel();
                                                Toast.makeText(getApplicationContext(),"you choose no action for alertbox",
                                                        Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                //Creating dialog box
                                AlertDialog alert4 = builder.create();
                                //Setting the title manually
                                alert4.setTitle("AlertDialogExample");
                                alert4.show();
                                Toast.makeText(TravelActivity.this, "Planet 4 Button Clicked", Toast.LENGTH_SHORT).show();
                                break;
                            case 0:
                                builder.setMessage("Do you want to travel to Planet 5?")
                                        .setCancelable(false)
                                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                finish();
                                                Toast.makeText(getApplicationContext(),"you choose yes action for alertbox",
                                                        Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                //  Action for 'NO' Button
                                                dialog.cancel();
                                                Toast.makeText(getApplicationContext(),"you choose no action for alertbox",
                                                        Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                //Creating dialog box
                                AlertDialog alert5 = builder.create();
                                //Setting the title manually
                                alert5.setTitle("AlertDialogExample");
                                alert5.show();
                                Toast.makeText(TravelActivity.this, "Planet 5 Button Clicked", Toast.LENGTH_SHORT).show();
                                break;

                        }
                    }

                }).setOnMenuStatusChangeListener(new OnMenuStatusChangeListener() {

            @Override
            public void onMenuOpened() {
                Toast.makeText(TravelActivity.this, "Menu Opened", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onMenuClosed() {
                Toast.makeText(TravelActivity.this, "Menu Closed", Toast.LENGTH_SHORT).show();
            }

        });

        demoMenu.setMainMenu(Color.parseColor("#FF6A00"), R.mipmap.order, R.mipmap.icon_cancel)
                .addSubMenu(Color.parseColor("#00FFD8"), R.mipmap.order)
                .addSubMenu(Color.parseColor("#FF007B"), R.mipmap.order)
                .addSubMenu(Color.parseColor("#0026FF"), R.mipmap.order)
                .addSubMenu(Color.parseColor("#EEFF00"), R.mipmap.order)
                .addSubMenu(Color.parseColor("#9DFF00"), R.mipmap.order)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {

                    @Override
                    public void onMenuSelected(int index) {
                        switch(index) {

                            case 4:
                                builder.setMessage("Do you want to travel to Planet 6?")
                                        .setCancelable(false)
                                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                finish();
                                                Toast.makeText(getApplicationContext(),"you choose yes action for alertbox",
                                                        Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                //  Action for 'NO' Button
                                                dialog.cancel();
                                                Toast.makeText(getApplicationContext(),"you choose no action for alertbox",
                                                        Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                //Creating dialog box
                                AlertDialog alert6 = builder.create();
                                //Setting the title manually
                                alert6.setTitle("AlertDialogExample");
                                alert6.show();
                                Toast.makeText(TravelActivity.this, "Planet 6 Clicked", Toast.LENGTH_SHORT).show();
                                break;
                            case 3:
                                builder.setMessage("Do you want to travel to Planet 7?")
                                        .setCancelable(false)
                                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                finish();
                                                Toast.makeText(getApplicationContext(),"you choose yes action for alertbox",
                                                        Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                //  Action for 'NO' Button
                                                dialog.cancel();
                                                Toast.makeText(getApplicationContext(),"you choose no action for alertbox",
                                                        Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                //Creating dialog box
                                AlertDialog alert7 = builder.create();
                                //Setting the title manually
                                alert7.setTitle("AlertDialogExample");
                                alert7.show();
                                Toast.makeText(TravelActivity.this, "Planet 7 Clicked", Toast.LENGTH_SHORT).show();
                                break;
                            case 2:
                                builder.setMessage("Do you want to travel to Planet 8?")
                                        .setCancelable(false)
                                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                finish();
                                                Toast.makeText(getApplicationContext(),"you choose yes action for alertbox",
                                                        Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                //  Action for 'NO' Button
                                                dialog.cancel();
                                                Toast.makeText(getApplicationContext(),"you choose no action for alertbox",
                                                        Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                //Creating dialog box
                                AlertDialog alert8 = builder.create();
                                //Setting the title manually
                                alert8.setTitle("AlertDialogExample");
                                alert8.show();
                                Toast.makeText(TravelActivity.this, "Planet 8 Clicked", Toast.LENGTH_SHORT).show();
                                break;
                            case 1:
                                builder.setMessage("Do you want to travel to Planet 9?")
                                        .setCancelable(false)
                                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                finish();
                                                Toast.makeText(getApplicationContext(),"you choose yes action for alertbox",
                                                        Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                //  Action for 'NO' Button
                                                dialog.cancel();
                                                Toast.makeText(getApplicationContext(),"you choose no action for alertbox",
                                                        Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                //Creating dialog box
                                AlertDialog alert9 = builder.create();
                                //Setting the title manually
                                alert9.setTitle("AlertDialogExample");
                                alert9.show();
                                Toast.makeText(TravelActivity.this, "Planet 9 Clicked", Toast.LENGTH_SHORT).show();
                                break;
                            case 0:
                                builder.setMessage("Do you want to travel to Planet 10?")
                                        .setCancelable(false)
                                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                finish();
                                                Toast.makeText(getApplicationContext(),"you choose yes action for alertbox",
                                                        Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                //  Action for 'NO' Button
                                                dialog.cancel();
                                                Toast.makeText(getApplicationContext(),"you choose no action for alertbox",
                                                        Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                //Creating dialog box
                                AlertDialog alert10 = builder.create();
                                //Setting the title manually
                                alert10.setTitle("AlertDialogExample");
                                alert10.show();
                                Toast.makeText(TravelActivity.this, "Planet 10 Clicked", Toast.LENGTH_SHORT).show();
                                break;

                        }
                    }

                }).setOnMenuStatusChangeListener(new OnMenuStatusChangeListener() {

            @Override
            public void onMenuOpened() {
                Toast.makeText(TravelActivity.this, "Menu Opened", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onMenuClosed() {
                Toast.makeText(TravelActivity.this, "Menu Closed", Toast.LENGTH_SHORT).show();
            }

        });
    }

}
