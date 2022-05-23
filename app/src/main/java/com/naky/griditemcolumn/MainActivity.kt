package com.naky.griditemcolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.naky.griditemcolumn.ui.theme.GridItemColumnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridItemColumnTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    LazyColumn(modifier = Modifier.fillMaxSize()){
                        gridItems(
                            count = 6,
                            columnCount = 2
                        ){
                            CardAchivmentRun(nameAchivment = "lazy", statusAchivment = true)
                        }

                        item {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentHeight()
                            ) {
                                gridItems(
                                    count = 6,
                                    columnCount = 2
                                ){
                                    CardAchivmentRun(nameAchivment = "colum", statusAchivment = true)
                                }
                            }
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GridItemColumnTheme {
        Greeting("Android")
    }
}

@Composable
fun CardAchivmentRun(
    nameAchivment : String,
    statusAchivment : Boolean,
){
    val ctx = LocalContext.current
    val currentHeight = ctx.resources.displayMetrics.heightPixels.dp/ LocalDensity.current.density
    val currentWidth = ctx.resources.displayMetrics.widthPixels.dp/ LocalDensity.current.density

    Column(
        modifier = Modifier
            .width(currentWidth / 3.2f)
            .height(currentHeight / 8f),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = nameAchivment,
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Medium,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
    }
}