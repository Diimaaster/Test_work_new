package com.khdev.test_work.ui.home

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.khdev.test_work.databinding.FragmentHomeBinding
import test_work.card_item.HelperAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    private var setSecondThread: Thread? = null
    private var runnable: Runnable? = null
    var str_Name = ArrayList<String>()
    var str_Sostav = ArrayList<String>()
    var str_Image = ArrayList<String>()
    val apiSample = "https://themealdb.com/api/json/v1/1/search.php?s"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val linearLayoutManager = LinearLayoutManager(context)
        binding.recyclerView.setLayoutManager(linearLayoutManager)

        homeViewModel.ctg1.observe(viewLifecycleOwner) {
            binding.ctg1.text = it
        }
        homeViewModel.ctg2.observe(viewLifecycleOwner) {
            binding.ctg2.text = it
        }
        homeViewModel.ctg3.observe(viewLifecycleOwner) {
            binding.ctg3.text = it
        }
        homeViewModel.ctg4.observe(viewLifecycleOwner) {
            binding.ctg4.text = it
        }

        binding.ctg1.setOnClickListener{
            binding.ctg1.setTextColor(Color.parseColor("#FD3A69"))
            binding.ctg1.setBackgroundColor(Color.parseColor("#ffd8e1"))
            binding.ctg2.setTextColor(Color.parseColor("#C3C4C9"))
            binding.ctg2.setBackgroundColor(Color.parseColor("#ffffff"))
            binding.ctg3.setTextColor(Color.parseColor("#C3C4C9"))
            binding.ctg3.setBackgroundColor(Color.parseColor("#ffffff"))
            binding.ctg4.setTextColor(Color.parseColor("#C3C4C9"))
            binding.ctg4.setBackgroundColor(Color.parseColor("#ffffff"))
            init()
        }
        binding.ctg2.setOnClickListener{
            binding.ctg2.setTextColor(Color.parseColor("#FD3A69"))
            binding.ctg2.setBackgroundColor(Color.parseColor("#ffd8e1"))
            binding.ctg1.setTextColor(Color.parseColor("#C3C4C9"))
            binding.ctg1.setBackgroundColor(Color.parseColor("#ffffff"))
            binding.ctg3.setTextColor(Color.parseColor("#C3C4C9"))
            binding.ctg3.setBackgroundColor(Color.parseColor("#ffffff"))
            binding.ctg4.setTextColor(Color.parseColor("#C3C4C9"))
            binding.ctg4.setBackgroundColor(Color.parseColor("#ffffff"))
            init()
        }
        binding.ctg3.setOnClickListener{
            binding.ctg3.setTextColor(Color.parseColor("#FD3A69"))
            binding.ctg3.setBackgroundColor(Color.parseColor("#ffd8e1"))
            binding.ctg2.setTextColor(Color.parseColor("#C3C4C9"))
            binding.ctg2.setBackgroundColor(Color.parseColor("#ffffff"))
            binding.ctg1.setTextColor(Color.parseColor("#C3C4C9"))
            binding.ctg1.setBackgroundColor(Color.parseColor("#ffffff"))
            binding.ctg4.setTextColor(Color.parseColor("#C3C4C9"))
            binding.ctg4.setBackgroundColor(Color.parseColor("#ffffff"))
            init()
        }
        binding.ctg4.setOnClickListener{
            binding.ctg4.setTextColor(Color.parseColor("#FD3A69"))
            binding.ctg4.setBackgroundColor(Color.parseColor("#ffd8e1"))
            binding.ctg2.setTextColor(Color.parseColor("#C3C4C9"))
            binding.ctg2.setBackgroundColor(Color.parseColor("#ffffff"))
            binding.ctg3.setTextColor(Color.parseColor("#C3C4C9"))
            binding.ctg3.setBackgroundColor(Color.parseColor("#ffffff"))
            binding.ctg1.setTextColor(Color.parseColor("#C3C4C9"))
            binding.ctg1.setBackgroundColor(Color.parseColor("#ffffff"))
            init()
        }
        return root
    }

    fun init() {
        runnable = Runnable { getUri() }
        setSecondThread = Thread(runnable)
        setSecondThread!!.start()
    }

    fun getCtg(){
        val handler = Handler()
        handler.postDelayed({
            val helperAdapter = HelperAdapter(
                str_Name, str_Sostav, str_Image, context)
            binding.recyclerView.setAdapter(helperAdapter)
        },0)
    }


    fun getUri() {
        str_Name.clear()
        str_Sostav.clear()
        str_Image.clear()
        val reqQueue: RequestQueue = Volley.newRequestQueue(context)
        val request = JsonObjectRequest(Request.Method.GET,apiSample, null, { res ->
            val respObj_Arr = res.getJSONArray("meals")
            for (i in 0 until respObj_Arr.length()) {
                val respObj = respObj_Arr.getJSONObject(i)
                val name = respObj.getString("strMeal")
                val sostav1 = respObj.getString("strIngredient1")
                val sostav2 = respObj.getString("strIngredient2")
                val sostav3 = respObj.getString("strIngredient3")
                val sostav4 = respObj.getString("strIngredient4")
                val sostav5 = respObj.getString("strIngredient5")
                val sostav6 = respObj.getString("strIngredient6")
                val sostav7 = respObj.getString("strIngredient7")
                val sostav8 = respObj.getString("strIngredient8")
                val sostav9 = respObj.getString("strIngredient9")
                val sostav10 = respObj.getString("strIngredient10")
                val sostav11 = respObj.getString("strIngredient11")
                val sostav12 = respObj.getString("strIngredient12")
                val sostav13 = respObj.getString("strIngredient13")
                val sostav14 = respObj.getString("strIngredient14")
                val sostav15 = respObj.getString("strIngredient15")
                val image = respObj.getString("strMealThumb")
                val ctg = respObj.getString("strCategory")
                str_Name.add(name)
                val sostav = "$sostav1 $sostav2 $sostav3 $sostav4 $sostav5 $sostav6 $sostav7 $sostav8 $sostav9 $sostav10 $sostav11 $sostav12 $sostav13 $sostav14 $sostav15"
                str_Sostav.add(sostav)
                str_Image.add(image)

            }
            Log.d("TEST_API", str_Sostav.toString())
            //Toast.makeText(context,"$str_Name\n\n$str_Image",Toast.LENGTH_LONG).show()
            getCtg()
        }, {err ->
            Log.d("Volley Sample Fail", err.message.toString())
        })
        reqQueue.add(request)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}