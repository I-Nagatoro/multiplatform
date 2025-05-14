//package org.example.project.ViewModel
//
//import android.app.DatePickerDialog
//import android.widget.DatePicker
//import androidx.compose.material.OutlinedTextField
//import androidx.compose.material.Text
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.DateRange
//import androidx.compose.runtime.*
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.Modifier
//import androidx.compose.foundation.clickable
//import androidx.compose.material.Icon
//import java.util.*
//
//@Composable
//actual fun DatePickerField(
//    onDateSelected: (String) -> Unit,
//    trigger: Boolean,
//    onDismissRequest: () -> Unit
//) {
////    val context = LocalContext.current
////    val calendar = Calendar.getInstance()
////
////    val datePickerDialog = remember {
////        DatePickerDialog(
////            context,
////            { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
////                val formatted = "%02d.%02d.%04d".format(dayOfMonth, month + 1, year)
////                onDateSelected(formatted)
////            },
////            calendar.get(Calendar.YEAR),
////            calendar.get(Calendar.MONTH),
////            calendar.get(Calendar.DAY_OF_MONTH)
////        )
////    }
////
////    OutlinedTextField(
////        value = selectedDate,
////        onValueChange = {},
////        label = { Text("Выберите дату") },
////        trailingIcon = { Icon(Icons.Default.DateRange, contentDescription = null) },
////        readOnly = true,
////        modifier = modifier.clickable { datePickerDialog.show() }
////    )
//}

package org.example.project.ViewModel

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import java.util.*

@Composable
actual fun DatePickerField(
    onDateSelected: (String) -> Unit,
    trigger: Boolean,
    onDismissRequest: () -> Unit
) {
    val context = LocalContext.current

    if (trigger) {
        LaunchedEffect(Unit) {
            val calendar = Calendar.getInstance()
            DatePickerDialog(
                context,
                { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
                    val formatted = "%02d.%02d.%04d".format(dayOfMonth, month + 1, year)
                    onDateSelected(formatted)
                    onDismissRequest()
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }
}