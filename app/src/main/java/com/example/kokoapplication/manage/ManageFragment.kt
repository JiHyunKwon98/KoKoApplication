package com.example.kokoapplication.manage

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.kokoapplication.R
import com.example.kokoapplication.databinding.FragmentManageBinding

class ManageFragment : Fragment(R.layout.fragment_manage) {

    val versionList = ArrayList<Versions>( )
    private var binding: FragmentManageBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentManageBinding = FragmentManageBinding.bind(view)
        binding = fragmentManageBinding

        initData()

        val versionAdapter = VersionAdapter(versionList)
        fragmentManageBinding.recyclerView.adapter =  versionAdapter
        fragmentManageBinding.recyclerView.setHasFixedSize(true)

    }


    private fun initData() {
        versionList.add(Versions(
            "스쿼트 100회",
            "학습",
            "2021-11-01 - 2021-11-30",
            "00:00 - 00:00",
            "100회"
        ))
    }

}