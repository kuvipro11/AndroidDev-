@file:Suppress("UNUSED_EXPRESSION")

package com.example.tutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tutorial.ui.theme.TutorialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MarksAnalyze()
                }
            }
        }
    }
}

@Composable
fun MarksAnalyze(){
    var add by remember { mutableStateOf(true) }
    var marks by remember { mutableStateOf("") }
    var aMarks by remember { mutableStateOf("") }
    var bMarks by remember { mutableStateOf("") }
    var cMarks by remember { mutableStateOf("") }
    var sMarks by remember { mutableStateOf("") }
    var fMarks by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Mathematics Marks Analyze",
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            fontWeight = MaterialTheme.typography.titleLarge.fontWeight,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Italic,
            fontFamily = FontFamily.Cursive
        )

        while(add) {
            Row(
                modifier = Modifier
                    .animateContentSize(
                        animationSpec = tween(
                            durationMillis = 400,
                            easing = LinearOutSlowInEasing
                        )
                    )
                    .padding(
                        top = 15.dp,
                        bottom = 15.dp
                    )
            ){
                OutlinedTextField(
                    value = marks,
                    onValueChange = {marks = it},
                    placeholder = { Text(text = "Type marks here ...")},
                    label = { Text(text = "Marks")},
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    )
                )
                Icon(
                    modifier = Modifier
                        .padding(
                            start = 15.dp,
                            end = 15.dp
                        )
                        .clickable { add = !add },
                    imageVector = Icons.Default.Done,
                    contentDescription = "Done_Icon"
                )
                Icon(
                    modifier = Modifier
                        .padding(
                            start = 15.dp,
                            end = 15.dp
                        )
                        .clickable { add },
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add_Icon"
                )

                if (marks.toInt() >= 20){
                    sMarks += 1
                }else{
                    if(marks.toInt() >= 35){
                        cMarks += 1
                    }else {
                        if (marks.toInt() >= 55){
                            bMarks += 1
                        }else {
                            if (marks.toInt() >= 75){
                                aMarks += 1
                            }else {
                                fMarks += 1
                            }
                        }
                    }
                }
            }
        }
    }
    Column (
        modifier = Modifier
            .padding(25.dp),
        horizontalAlignment = Alignment.Start
    ){
        Text(
            text = "F = $fMarks",
            fontSize = MaterialTheme.typography.bodyMedium.fontSize,
            fontWeight = MaterialTheme.typography.bodyMedium.fontWeight
        )
        Text(
            text = "S = $sMarks",
            fontSize = MaterialTheme.typography.bodyMedium.fontSize,
            fontWeight = MaterialTheme.typography.bodyMedium.fontWeight
        )
        Text(
            text = "C = $cMarks",
            fontSize = MaterialTheme.typography.bodyMedium.fontSize,
            fontWeight = MaterialTheme.typography.bodyMedium.fontWeight
        )
        Text(
            text = "B = $bMarks",
            fontSize = MaterialTheme.typography.bodyMedium.fontSize,
            fontWeight = MaterialTheme.typography.bodyMedium.fontWeight
        )
        Text(
            text = "A = $aMarks",
            fontSize = MaterialTheme.typography.bodyMedium.fontSize,
            fontWeight = MaterialTheme.typography.bodyMedium.fontWeight
        )
    }
}

@Preview(showBackground = true, name = "TutorialPreview")
@Composable
fun BirthdayCardPreview() {
    TutorialTheme {
        MarksAnalyze()
    }
}
