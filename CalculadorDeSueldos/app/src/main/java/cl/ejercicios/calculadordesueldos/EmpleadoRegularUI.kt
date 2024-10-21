package cl.ejercicios.calculadordesueldos

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EmpleadoRegularUI : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_empleado_regular_ui)

        val tvTitulo = findViewById<TextView>(R.id.tvTitulo)
        val etSueldoBruto = findViewById<EditText>(R.id.etSueldoBruto)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val btnVolver = findViewById<Button>(R.id.btnVolver)

        btnCalcular.setOnClickListener{
            val sueldoBruto = etSueldoBruto.text.toString().toDoubleOrNull() ?:0.0
            val sueldoLiquido = EmpleadoRegular(sueldoBruto).calcularLiquido()
            tvResultado.text = "Sueldo Líquido a pagar: $sueldoLiquido"
        }
        btnVolver.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity( intent )

        }
    }
}