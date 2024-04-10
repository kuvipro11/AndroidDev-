package com.example.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun DetailScreen(navController: NavController){
    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            modifier = Modifier
                .clickable { navController.popBackStack() },
            text = "Detail",
            fontSize = 45.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDetailScreen(){
    DetailScreen(rememberNavController())
}