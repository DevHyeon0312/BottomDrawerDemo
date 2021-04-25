package com.bottomupdrawer.demo.googlemap

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bottomupdrawer.demo.databinding.FragmentGooglemapBinding

class GoogleMapFragment : Fragment() {
    private var _binding: FragmentGooglemapBinding? = null
    private val binding get() = _binding!!


    interface OnClickListener {
        fun onClicked()
    }

    var listener: OnClickListener? = null


    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as? OnClickListener
        if (listener == null) {
            throw ClassCastException("$context must implement OnArticleSelectedListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGooglemapBinding.inflate(inflater, container, false)

        binding.button4.setOnClickListener {
            listener?.onClicked()
        }

        return binding.root
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}