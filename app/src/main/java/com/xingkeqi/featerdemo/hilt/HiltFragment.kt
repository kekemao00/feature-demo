package com.xingkeqi.featerdemo.hilt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xingkeqi.featerdemo.BaseView
import com.xingkeqi.featerdemo.base.BaseFragment
import com.xingkeqi.featerdemo.databinding.FragmentHiltBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HiltFragment : BaseFragment(), HiltContract.View {

    override lateinit var presenter: HiltContract.Presenter

    private var _binding: FragmentHiltBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHiltBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}