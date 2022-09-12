package org.sheridan.fragments_review

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.sheridan.fragments_review.databinding.FragmentDetailBinding


open class DetailFrag : Fragment() {

    private lateinit var binding:FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        setText("Hi")

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    // this method update the captain text field
    fun setText(item: String) {
        binding.captain.setText(item)  // UPDATE text for the captain name in detail_fragment.xml
    }
}