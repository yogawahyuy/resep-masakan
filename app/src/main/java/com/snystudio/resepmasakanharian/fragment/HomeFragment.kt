package com.snystudio.resepmasakanharian.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.JsonObject
import com.snystudio.resepmasakanharian.R
import com.snystudio.resepmasakanharian.config.ApiConfig
import com.snystudio.resepmasakanharian.model.RecipesModel
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    private lateinit var menuSugestArrayList: ArrayList<RecipesModel>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    fun dataSliderMenuSugest(){
        getMenuSugest()

    }
    fun getMenuSugest(){
        val result: Call<JsonObject> = ApiConfig.getApiService().getRecipes()
        result.enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>?, response: Response<JsonObject>?) {
                try {
                    val root: JSONObject = JSONObject(response?.body().toString())
                    val data: JSONArray =root.getJSONArray("results")
                    for (i in 0 until data.length()){

                        val recipe: JSONObject =data.getJSONObject(i)
                        val recipesModel= RecipesModel(recipe.getString("title"),recipe.getString("thumb"),
                            recipe.getString("key"),recipe.getString("times"),recipe.getString("portion"),recipe.getString("dificulty"))
                        menuSugestArrayList.add(recipesModel)
                    }
                }catch (e: JSONException){
                    e.printStackTrace()
                }
            }

            override fun onFailure(call: Call<JsonObject>?, t: Throwable?) {
                TODO("Not yet implemented")
            }

        })


    }

}