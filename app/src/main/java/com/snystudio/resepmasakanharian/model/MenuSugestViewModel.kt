package com.snystudio.resepmasakanharian.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.snystudio.resepmasakanharian.config.ApiConfig
import kotlinx.coroutines.launch

class MenuSugestViewModel : ViewModel() {
    val responeRecipeList:MutableLiveData<List<RecipesModel>> = MutableLiveData()

    fun getMenuSugest(){
        viewModelScope.launch {
           // responeRecipeList.value=ApiConfig.getApiService().getRecipes()
        }
    }
}