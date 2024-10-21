package cl.ejercicios.calculadordesueldos

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import cl.ejercicios.calculadordesueldos.ui.theme.CalculadorDeSueldosTheme

class EmpleadoHonorariosUI : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EmpleadoHonorarios()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EmpleadoHonorarios() {
    var sueldoBruto by remember { mutableStateOf("") }
    var sueldoLiquido by remember { mutableStateOf("") }
    val contexto = LocalContext.current

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(all = 30.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text= "Calculador de Sueldo Líquido Empleado a Honorarios",
            fontSize = 5.em
        )
        TextField(
            value = sueldoBruto,
            onValueChange = { sueldoBruto = it },
            label = { Text(text = "Sueldo Bruto")},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
                .padding(vertical = 20.dp)
        )
        Button(onClick = {
            var sueldoBrutoNumero = sueldoBruto.toDoubleOrNull() ?:0.0
            var sueldoFinal = EmpleadoHonorarios(sueldoBrutoNumero).calcularLiquido()
            sueldoLiquido = "Sueldo Líquido a pagar: $sueldoFinal"
        }) {
            Text(text = "Calcular Sueldo")
        }
        Text(text = sueldoLiquido)
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = {
            val intent = Intent(contexto, MainActivity::class.java)
            contexto.startActivity( intent )
        }) {
            Text( "<-Volver")
        }
    }
}