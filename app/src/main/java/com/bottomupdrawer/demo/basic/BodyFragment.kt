package com.bottomupdrawer.demo.basic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bottomupdrawer.demo.databinding.FragmentBodyBinding
import com.bottomupdrawer.demo.databinding.FragmentTitleBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BodyFragment : Fragment() {
    private var _binding: FragmentBodyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBodyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}