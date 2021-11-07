package com.example.cocinamos.addRecipeFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.cocinamos.R

class HowToCookThis : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        viewGroup: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val page: View = inflater.inflate(R.layout.fragment_text_input, viewGroup, false)
        (page.findViewById<EditText>(R.id.editText_fragment)).hint =
            resources.getString(R.string.textInputEnterRecipe)
        return page
    }
}