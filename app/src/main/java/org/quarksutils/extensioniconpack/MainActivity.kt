package org.quarksutils.extensioniconpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.quarksutils.extensioniconpack.ui.theme.ExtensionIconPackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExtensionIconPackTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    IconPreview(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun IconPreview(modifier: Modifier){
    var expanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf(ExtensionIcon.HTML) }

    Box (
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {


        Button(
            onClick = { expanded = true },
            modifier = Modifier.fillMaxWidth()
                .padding(top=50.dp , start = 10.dp , end = 10.dp)
                .align(Alignment.TopCenter)
        )
        {
            Text(text = selectedItem.label)
        }



        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.background(Color.LightGray).fillMaxWidth() .align(Alignment.TopCenter)
        ) {
            ExtensionIcon.values().forEach { item ->
                 DropdownMenuItem(
                     text = {
                         Text(text = item.label , color = Color.Black , modifier=Modifier.align(Alignment.CenterHorizontally))
                     },
                     onClick = {
                         selectedItem = item
                         expanded = false
                     },

                 )
            }
        }



     Icon(
         painter = painterResource(getIcon(selectedItem)),
         tint =  Color.Unspecified,
         contentDescription = "",
         modifier = Modifier.padding(top=100.dp).size(200.dp) .align(Alignment.TopCenter)
     )


    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExtensionIconPackTheme {
          IconPreview(modifier = Modifier.fillMaxSize())
    }
}