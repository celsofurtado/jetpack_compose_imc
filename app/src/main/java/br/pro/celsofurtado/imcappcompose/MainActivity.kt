package br.pro.celsofurtado.imcappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.pro.celsofurtado.imcappcompose.ui.theme.IMCAppComposeTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IMCAppComposeTheme {
                Surface {
                    HomeCard()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun HomeCard() {
    Surface() {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.start_background),
            contentScale = ContentScale.Crop,
            contentDescription = "Background image"
        )
        Card(
            modifier = Modifier.fillMaxSize(),
            backgroundColor = Color.Gray.copy(alpha = 0.7f)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp),
                verticalArrangement = Arrangement.SpaceBetween

            ) {
                Column() {
                    Text(
                        text = "IMC",
                        fontSize = 48.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Text(
                        text = "Índice de Massa Corpórea",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.bmi_512),
                        contentDescription = "APP logo",
                        alignment = Alignment.CenterEnd
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Column {
                    FooterCard()
                }
            }

        }
    }
}

@Composable
fun FooterCard() {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.clip(RoundedCornerShape(16.dp)),
        backgroundColor = Color.Red.copy(alpha = 0.5f)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = "Peso e Saúde",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                modifier = Modifier.padding(16.dp),
                text = "O IMC demonstra se você está ou não em seu peso ideal.",
                color = Color.White
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green.copy(alpha = 0.5f)),
                shape = RoundedCornerShape(32.dp),
                onClick = {}) {
                Text(
                    text = "Começar agora",
                    color = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun HomeCardPreview() {
    IMCAppComposeTheme {
        HomeCard()
    }
}