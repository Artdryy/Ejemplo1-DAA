package com.example.ejemplopractica2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color

import com.example.ejemplopractica2.ui.theme.EjemploPractica2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EjemploPractica2Theme {
                Suma()
            }
        }
    }
}

@Composable
fun Suma() {
    var valor1 by remember { mutableStateOf(TextFieldValue("")) }
    var valor2 by remember { mutableStateOf(TextFieldValue("")) }
    var resultado by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.mathpic),
            contentDescription = "Imagen Superior",
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        )

        OutlinedTextField(
            value = valor1,
            onValueChange = { valor1 = it },
            label = { Text("Valor 1") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Text(text = "+", modifier = Modifier.padding(8.dp))
        OutlinedTextField(
            value = valor2,
            onValueChange = { valor2 = it },
            label = { Text("Valor 2") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Button(
            onClick = {
                val num1 = valor1.text.toDoubleOrNull() ?: 0.0
                val num2 = valor2.text.toDoubleOrNull() ?: 0.0
                resultado = (num1 + num2).toString()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF9800),
                contentColor = Color.Black
            )
        ) {
            Text(text = "Calcular")
        }

        if (resultado.isNotEmpty()) {
            Text(text = "Resultado: $resultado", style = MaterialTheme.typography.headlineSmall)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSuma() {
    EjemploPractica2Theme {
        Suma()
    }
}








