package org.example.project.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class regRunnerViewModel : ViewModel() {
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var secondPassword by mutableStateOf("")
    var name by mutableStateOf("")
    var lastname by mutableStateOf("")
    var gender by mutableStateOf("")
    var country by mutableStateOf("")
    var photo by mutableStateOf("")
    var dateBirthday by mutableStateOf("")
}