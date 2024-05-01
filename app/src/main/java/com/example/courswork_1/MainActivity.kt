//https://drive.google.com/file/d/1mXeG-8nixJOXIETz0LlzTxgZcjbBcsRE/view?usp=sharing

package com.example.courswork_1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.example.courswork_1.ui.theme.Courswork_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //variable to track if countdown is enabled
            var countdownEnabled by remember { mutableStateOf(false) }
            //set content of the activity
            MaterialTheme{
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally

                ){
                    //switch for enable and disable the countdown timer
                    Switch(
                        checked = countdownEnabled,
                        onCheckedChange = {countdownEnabled = it},
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    //button to start guess country activity
                    Button(onClick = {
                        val intent = Intent(this@MainActivity,GuessCountryActivity::class.java) //create intent to start activity
                        intent.putExtra("countdownEnabled", countdownEnabled) //Putting an extra parameter in the intent to pass information to the GuessCountryActivity
                        startActivity(intent)   //start the activity using crated intent
                    }, modifier = Modifier.width(170.dp)
                    ) {
                        Text(text = "Guess the Country")
                    }

                    //button to start guess hint activity
                    Button(onClick = {
                        val intent = Intent(this@MainActivity,GuessHints::class.java)    //create intent to start activity
                        startActivity(intent)    //start the activity using crated intent
                    }, modifier = Modifier.width(170.dp)
                    ) {
                        Text(text = "Guess-Hint")
                    }

                    //button to start guess the flag activity
                    Button(onClick = {  //Guess Flag Button
                        val intent = Intent(this@MainActivity,GuessTheFlagButton::class.java)  //create intent to start activity
                        startActivity(intent)       //start the activity using crated intent
                    },modifier = Modifier.width(170.dp)
                    ) {
                        Text(text = "Guess Flag")
                    }

                    //button to start advance level activity
                    Button(onClick = {  //Advance Level Button
                        val intent = Intent(this@MainActivity,AdvanceLevel::class.java)   //create intent to start activity
                        startActivity(intent)       //start the activity using crated intent
                    },modifier = Modifier.width(170.dp)
                    ) {
                        Text(text = "Advance Level")
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun HomePreview() {
   MainActivity()
}