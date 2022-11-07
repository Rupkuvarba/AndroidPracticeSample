package com.app.jetpackcompose

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//Has to be type view model fo android lifecycle
class MainViewModel :ViewModel(){

   val textFieldState = MutableLiveData("")

    fun onTextChanged(newText:String){
        textFieldState.value = newText
    }
}