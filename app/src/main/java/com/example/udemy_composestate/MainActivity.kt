package com.example.udemy_composestate

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.udemy_composestate.ui.theme.Udemy_ComposeStateTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val mainViewModel = viewModel<MainViewModel>()
            Udemy_ComposeStateTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val count = mainViewModel.count
                    ButtonClick(count) {
                        mainViewModel.incrementCount()
                    }
                }
            }
        }
    }
}

@Composable
fun ButtonClick(currentCount : Int, onClickUpdateCount:(Int) -> Unit) {
    val context = LocalContext.current

    Button(
        onClick = {
            onClickUpdateCount(currentCount)
        },
        contentPadding = PaddingValues(16.dp),
        border = BorderStroke(10.dp, Color.Black),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = Color.DarkGray
        )
    ) {
        Text(
            "Count : ${currentCount}",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .padding(5.dp)
        )
    }

}


