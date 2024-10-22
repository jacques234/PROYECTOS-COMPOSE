package com.example.jetpackcomposecatalogo

import android.app.AlertDialog
import android.app.Dialog
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog


@Composable
fun MySimpleCustomDialog(
    modifier: Modifier = Modifier,
    show: Boolean = false,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    Dialog(onDismissRequest = { /*TODO*/ }) {
        Text(text = "Esto es un ejemplo")
    }
}

@Composable
fun MyDialog(
    modifier: Modifier = Modifier,
    show: Boolean = false,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    if (show) {
        AlertDialog(onDismissRequest = { onDismiss() }, title = {
            Text(text = "Titulo")
        }, text = {
            Text(text = "Hola, Esto es una descripcion")
        }, confirmButton = {
            TextButton(onClick = { onConfirm() }) {
                Text(text = "Confirmar")
            }
        }, dismissButton = {
            TextButton(onClick = { onDismiss() }) {
                Text(text = "Cancelar")
            }
        })
    }
}