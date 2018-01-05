package ru.rsit.easyalertdialogsample;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import ru.rsit.easyalertdialog.EADialogManager;

/**
 * @author nikitoSha (https://github.com/nikitoSha)
 */
public class MainActivity extends AppCompatActivity {

    Context thisActivityContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        thisActivityContext = this;

        //Show standart alert dialog
        Button showStandartDialog = (Button) findViewById(R.id.showStandartDialog);
        //Show easy dialog with one button
        Button showEasyDialog_1 = (Button) findViewById(R.id.showEasyDialog_1);
        //Show easy dialog with two buttons
        Button showEasyDialog_2 = (Button) findViewById(R.id.showEasyDialog_2);
        //Show easy dialog with three buttons
        Button showEasyDialog_3 = (Button) findViewById(R.id.showEasyDialog_3);
        //Show custom dialog from background
        Button showEAActivityDialog = (Button) findViewById(R.id.showEAActivityDialog);

        showStandartDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = ThisApp.getEaDialogManager().createStandartDialog(
                        thisActivityContext, false,
                        "Standart dialog without automatic callbacks", null);
                alertDialog.setButton(DialogInterface.BUTTON_POSITIVE,
                        "Accept",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                Toast.makeText(thisActivityContext,
                                        "onClick: positive button",
                                        Toast.LENGTH_LONG).show();
                            }
                        });

                alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE,
                        "Cancel",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                Toast.makeText(thisActivityContext,
                                        "onClick: negative button",
                                        Toast.LENGTH_LONG).show();
                            }
                        });
                alertDialog.show();
            }
        });

        showEasyDialog_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThisApp.getEaDialogManager().showEADialogWithOneButton(
                        thisActivityContext, true, false,
                        "Easy dialog with automatic callbacks", "My title",
                        "OK", new EADialogManager.EADialogOneButtonClickListener() {
                            @Override
                            public void onButtonClick(DialogInterface dialogInterface) {
                                dialogInterface.dismiss();
                                Toast.makeText(thisActivityContext,
                                        "onClick: positive button",
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                );
            }
        });

        showEasyDialog_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThisApp.getEaDialogManager().showEADialogWithTwoButtons(
                        thisActivityContext, false, true,
                        "Easy dialog with automatic callbacks (2)", null,
                        "True", "False",
                        new EADialogManager.EADialogTwoButtonsClickListener() {
                            @Override
                            public void onPositiveButtonClick(DialogInterface dialogInterface) {
                                dialogInterface.dismiss();
                                Toast.makeText(thisActivityContext,
                                        "onClick: positive button",
                                        Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onNegativeButtonClick(DialogInterface dialogInterface) {
                                dialogInterface.dismiss();
                                Toast.makeText(thisActivityContext,
                                        "onClick: negative button",
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                );
            }
        });

        showEasyDialog_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThisApp.getEaDialogManager().showEADialogWithThreeButtons(
                        thisActivityContext, false, false,
                        "Easy dialog with automatic callbacks (3)", null,
                        "Okay", "No!", "What?",
                        new EADialogManager.EADialogThreeButtonsClickListener() {
                            @Override
                            public void onPositiveButtonClick(DialogInterface dialogInterface) {
                                dialogInterface.dismiss();
                                Toast.makeText(thisActivityContext,
                                        "onClick: positive button",
                                        Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onNegativeButtonClick(DialogInterface dialogInterface) {
                                dialogInterface.dismiss();
                                Toast.makeText(thisActivityContext,
                                        "onClick: negative button",
                                        Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onNeutralButtonClick(DialogInterface dialogInterface) {
                                dialogInterface.dismiss();
                                Toast.makeText(thisActivityContext,
                                        "onClick: neutral button",
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                );
            }
        });

        showEAActivityDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ThisApp.getMyServiceInstance().startTimer();
                ThisApp.startMyService();
                onBackPressed();
            }
        });
    }
}
