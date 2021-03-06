package com.example.mancalagamestate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Constructor;

/**
 * @author Rachel Madison, Henry Lee, Jordan Nakamura
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        Button runTest = findViewById(R.id.runTest);
    }

    public void onClick(View button){
        MancalaGameState firstInstance = new MancalaGameState();
        MancalaGameState secondInstance = new MancalaGameState(firstInstance);
        MancalaGameState thirdInstance = new MancalaGameState();
        MancalaGameState fourthInstance = new MancalaGameState(thirdInstance);

        TextView editText = findViewById(R.id.editText);

        // Legal move
        editText.setText(" ");
        firstInstance.selectPit(1, 5);
        editText.setText("Player one has selected pit 5");

        editText.append("\nSecond Instance:" + secondInstance.toString());

        editText.append("\nFourth Instance:" + fourthInstance.toString());

    }
}