package com.snystudio.resepmasakanharian.fragment

import android.media.Image
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.gson.JsonObject
import com.snystudio.resepmasakanharian.R
import com.snystudio.resepmasakanharian.config.ApiConfig
import com.snystudio.resepmasakanharian.model.RecipesModel
import com.squareup.picasso.Picasso
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import com.synnapps.carouselview.ViewListener
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
    var menuSugestArrayList= ArrayList<RecipesModel>()
    private lateinit var viewOfLayout:View
    private lateinit var carouselView:CarouselView
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        viewOfLayout= inflater.inflate(R.layout.fragment_home, container, false)
        getMenuSugest()
        return viewOfLayout
    }

    override fun onResume() {
        dataSliderMenuSugest()
        super.onResume()
    }
    fun dataSliderMenuSugest(){
        carouselView=viewOfLayout.findViewById(R.id.slider)
        carouselView.setViewListener(viewListener)
        carouselView.pageCount=menuSugestArrayList.size
    }
    var viewListener:ViewListener = object :ViewListener{
        override fun setViewForPosition(position: Int): View {
            val customViewListener:View= activity?.layoutInflater!!.inflate(R.layout.view_listener_menu_sugest,null)
            val imageView=customViewListener.findViewById(R.id.menu_sugest_home) as ImageView
            val textView=customViewListener.findViewById(R.id.title_menu_sugest_home) as TextView
            val relativeLayout=customViewListener.findViewById(R.id.rel_menu_sugest) as RelativeLayout
            textView.text=menuSugestArrayList.get(position).title
            relativeLayout.bringToFront()
            Picasso.get().load(menuSugestArrayList.get(position).thumbs).into(imageView)
            return customViewListener
        }

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
                    Log.d("Home Fragments", "setImageForPosition: "+menuSugestArrayList.size)
                    dataSliderMenuSugest()
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