package org.sheridan.fragments_review

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import org.sheridan.fragments_review.databinding.FragmentListBinding

class ListFrag : Fragment() {

    private lateinit var binding: FragmentListBinding

    private fun getCapt(ship: String): String {
        if (ship.toLowerCase().contains("enterprise")) {
            return "Johnathan Archer"
        }
        if (ship.toLowerCase().contains("star trek")) {
            return "James T. Kirk"
        }
        if (ship.toLowerCase().contains("next generation")) {
            return "Jean-Luc Picard"
        }
        if (ship.toLowerCase().contains("deep space 9")) {
            return "Benjamin Sisko"
        }
        return if (ship.toLowerCase().contains("voyager")) {
            "Kathryn Janeway"
        } else "???"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        if (this::binding.isInitialized) {
            var listAdapter=binding.LVList

            val values = arrayOf("Enterprise",
                "Star Trek Original",
                "Next Generation",
                "Deep Space 9",
                "Voyager")
            val adapter =
                activity?.let { ArrayAdapter(requireActivity(), android.R.layout.simple_list_item_1, values) }
            listAdapter.adapter=adapter

            listAdapter.onItemClickListener = object : AdapterView.OnItemSelectedListener,
                AdapterView.OnItemClickListener {
                override fun onItemSelected(
                    p0: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    TODO("Not yet implemented")
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

                override fun onItemClick(
                    p0: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val item = listAdapter.adapter!!.getItem(position) as String
                    val frag =
                        requireFragmentManager().findFragmentById(R.id.frag_capt) as DetailFrag?
                    if (frag != null && frag.isInLayout) {
                        frag.setText(getCapt(item))
                    }
                }
            }
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }
}