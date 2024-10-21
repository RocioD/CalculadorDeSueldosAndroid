package cl.ejercicios.calculadordesueldos

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import cl.ejercicios.calculadordesueldos.ui.theme.CalculadorDeSueldosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PantallaPrincipal()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PantallaPrincipal() {

    val contexto = LocalContext.current

    Column ( modifier = Modifier
        .fillMaxSize()
        .padding(all = 30.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text= "Calculador de Sueldo Líquido",
            fontSize = 5.em,
            modifier = Modifier
                .padding(vertical = 10.dp)
        )
        Button(onClick = {
            val intent = Intent(contexto, EmpleadoHonorariosUI::class.java)
            contexto.startActivity(intent)
        },
            modifier = Modifier
                .padding(vertical = 10.dp)
        ) {
            Text("Empleado a Honorarios")
        }
        Button(onClick = {
            val intent = Intent(contexto, EmpleadoRegularUI::class.java)
            contexto.startActivity(intent)
        }) {
            Text("Empleado Regular")
        }
    }
}