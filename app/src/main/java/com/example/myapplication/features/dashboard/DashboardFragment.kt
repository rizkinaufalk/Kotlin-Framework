package com.example.myapplication.features.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myapplication.binding.FragmentDataBindingComponent
import com.example.myapplication.AppExecutors
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentDashboardBinding
import com.example.myapplication.di.component.Injectable
import com.example.myapplication.util.autoCleared
import com.example.myapplication.viewmodel.MyAppViewModelFactory
import javax.inject.Inject

class DashboardFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: MyAppViewModelFactory
    @Inject
    lateinit var appExecutors: AppExecutors
    var binding by autoCleared<FragmentDashboardBinding>()
    var dataBindingComponent: DataBindingComponent = FragmentDataBindingComponent(this)

    private val dashboardViewModel: DashboardViewModel by viewModels {
        viewModelFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val dataBinding = DataBindingUtil.inflate<FragmentDashboardBinding>(
            inflater,
            R.layout.fragment_dashboard,
            container,
            false,
            dataBindingComponent
        )
        binding = dataBinding
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
    }

}