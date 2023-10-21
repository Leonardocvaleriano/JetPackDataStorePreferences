package com.codeplace.jetpackdatastorepreferences.ui.theme.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codeplace.jetpackdatastorepreferences.ui.theme.JetPackDataStorePreferencesTheme
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(isFirstUserAccess:Boolean,
               changePropertyStateOnClick:()-> Unit){




    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "$isFirstUserAccess")
        Spacer(modifier = Modifier.padding(top = 15.dp))
        Button(onClick = changePropertyStateOnClick) {
            Text(text = "Announce first access")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomePreview(){

    JetPackDataStorePreferencesTheme {
       // HomeScreen(onChangePropertyStateButtonClick = {}, false)
    }

}
