package com.example.cocinamos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
//import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager.widget.ViewPager

import android.view.ViewGroup

import android.content.Context

import android.widget.TextView

import androidx.viewpager.widget.PagerAdapter




class AddRecipe : AppCompatActivity() {

    private var recipeText: String = ""
//    lateinit var vp2: ViewPager2;
//    lateinit var vp_adapter: ViewPageAdapter;

/*    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recipe)

        vp2 = findViewById(R.id.vp_add_recipe)
        setupSwitches()
    }*/

/*    private fun setupSwitches() {
        val switchUrl = findViewById<Switch>(R.id.addRecipe_switch_url)
        val switchImage = findViewById<Switch>(R.id.addRecipe_switch_image)

        switchUrl.setOnClickListener(View.OnClickListener {
            val status = switchUrl.isChecked
            val editTextUrl = findViewById<EditText>(R.id.addRecipe_textInput_Url)
            if (status) {
                editTextUrl.visibility = View.VISIBLE
            } else {
                editTextUrl.visibility = View.GONE
            }
        })

        switchImage.setOnClickListener(View.OnClickListener {
            val status = switchImage.isChecked
            val linLayoutImage = findViewById<LinearLayout>(R.id.addRecipe_linLay_image)
            if (status) {
                linLayoutImage.visibility = View.VISIBLE
            } else {
                linLayoutImage.visibility = View.GONE
            }

        })
    }

    fun onRecipeClicked(view: View) {
        val inflater = LayoutInflater.from(this)
        val v: View = inflater.inflate(R.layout.recipe_text, null)
        val textView = v.findViewById<EditText>(R.id.editText_Recipe)

        textView.setText(recipeText)

        val b = AlertDialog.Builder(this)
        b.setTitle("The Recipe")
        b.setView(v)

        b.setPositiveButton("Okay", DialogInterface.OnClickListener { _, _ ->
            recipeText = textView.text.toString()
        })

        val alert = b.create()
        alert.show()
    }
    fun onIngredientsClicked(view: View) {}*/


    lateinit var pageData: Array<String> //Stores the text to swipe.

    lateinit var inflater //Used to create individual pages
            : LayoutInflater
    lateinit var vp //Reference to class to swipe views
            : ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recipe)
        //Get the data to be swiped through
        pageData = resources.getStringArray(R.array.desserts)
        //get an inflater to be used to create single pages
        inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        //Reference ViewPager defined in activity
        vp = findViewById<View>(R.id.vp_add_recipe) as ViewPager
        //set the adapter that will create the individual pages
        vp.setAdapter(MyPagesAdapter())
    }

    //Implement PagerAdapter Class to handle individual page creation
    inner class MyPagesAdapter : PagerAdapter() {
        override fun getCount(): Int {
            //Return total pages, here one for each data item
            return pageData.size
        }

        //Create the given page (indicated by position)
        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val page: View = inflater.inflate(R.layout.fragment, null)
            (page.findViewById<View>(R.id.textMessage) as TextView).setText(pageData.get(position))
            //Add the page to the front of the queue
            (container as ViewPager).addView(page, 0)
            return page
        }

        override fun isViewFromObject(arg0: View, arg1: Any): Boolean {
            //See if object from instantiateItem is related to the given view
            //required by API
            return arg0 === arg1 as View
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            var `object`: Any? = `object`
            (container as ViewPager).removeView(`object` as View?)
            `object` = null
        }
    }
}
