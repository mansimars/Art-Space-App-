package com.example.art_space_app_

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.art_space_app_.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Main()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainPreview()
{
    Main()
}

@Composable
fun Main()
{


    var stateCheck by remember { mutableStateOf(1)}



    ArtSpaceAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {


                //Logic
                when(stateCheck){
                    1 -> {
                        Wall(R.drawable.digital_photo_1)
                        Spacer(modifier = Modifier.height(20.dp))
                        Description(R.string.title1,R.string.text1,R.string.year1)
                        Spacer(modifier = Modifier.height(20.dp))
                        ShowButton(onPreviousButtonClick = {
                            stateCheck=5
                        },onNextButtonClick={
                            stateCheck=2
                        })
                    }
                    2 -> {
                        Wall(R.drawable.digital_photo_2)
                        Spacer(modifier = Modifier.height(20.dp))
                        Description(R.string.title2,R.string.text2,R.string.year2)
                        Spacer(modifier = Modifier.height(20.dp))
                        ShowButton(onPreviousButtonClick = {
                            stateCheck=1
                        },onNextButtonClick={
                            stateCheck=3
                        })
                    }
                    3 -> {
                        Wall(R.drawable.digital_photo_3)
                        Spacer(modifier = Modifier.height(20.dp))
                        Description(R.string.title3,R.string.text3,R.string.year3)
                        Spacer(modifier = Modifier.height(20.dp))
                        ShowButton(onPreviousButtonClick = {
                            stateCheck=2
                        },onNextButtonClick={
                            stateCheck=4
                        })
                    }
                    4 -> {
                        Wall(R.drawable.digital_photo_4)
                        Spacer(modifier = Modifier.height(20.dp))
                        Description(R.string.title4,R.string.text4,R.string.year4)
                        Spacer(modifier = Modifier.height(20.dp))
                        ShowButton(onPreviousButtonClick = {
                            stateCheck=3
                        },onNextButtonClick={
                            stateCheck=5
                        })
                    }
                    5 -> {
                        Wall(R.drawable.digital_photo_5)
                        Spacer(modifier = Modifier.height(20.dp))
                        Description(R.string.title5,R.string.text5,R.string.year5)
                        Spacer(modifier = Modifier.height(20.dp))
                        ShowButton(onPreviousButtonClick = {
                            stateCheck=4
                        },onNextButtonClick={
                            stateCheck=1
                        })
                    }
                }


            }
        }
    }
}


@Composable
fun Wall(image: Int)
{

    Surface(modifier = Modifier
        .size(350.dp, 450.dp)) {



        Image(modifier = Modifier
            .wrapContentSize()
            .border(BorderStroke(2.dp, Color.Black))
            .padding(30.dp),
            contentScale = ContentScale.Inside,
            painter = painterResource(id = image),
            contentDescription = null)

    }

}

@Composable
fun Description(title: Int, text: Int, year: Int)
{
    Column(modifier = Modifier
        .shadow(1.dp, RectangleShape, clip = true)
        .padding(25.dp)) {

        Text(text = stringResource(title),
            fontSize = 30.sp)
        Row() {
            Text(text = stringResource(text),
                fontSize = 15.sp, fontWeight = FontWeight.Bold)
            Text(text = stringResource(year),
                fontSize = 15.sp)
        }

    }

}


@Composable
fun ShowButton(onPreviousButtonClick: () -> Unit,onNextButtonClick: () -> Unit )
{
    Row() {
        
        Button(modifier = Modifier
            .height(40.dp)
            .width(130.dp),
            
            onClick = onPreviousButtonClick) {
            
            Text(text = "Previous")
        }
        Spacer(modifier = Modifier.width(5.dp))
        Button(modifier = Modifier
            .height(40.dp)
            .width(130.dp),

            onClick = onNextButtonClick ) {


            Text(text = "Next")
        }
    }
}