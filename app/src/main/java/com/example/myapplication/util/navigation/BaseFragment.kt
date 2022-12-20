package com.example.myapplication.util.navigation

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

abstract class BaseFragment : Fragment() {
    /**
     * Sets up the fragment to listen for navigation events from [navigationLiveDataField]
     */
    protected fun configureNavigationListener(navigationLiveDataField: LiveNavigationField<Navigation.NavigationEvent>) {
        navigationLiveDataField.observe(viewLifecycleOwner, Observer { it?.let { it1 -> navigate(it1) } })
    }

    private fun navigate(event: Navigation.NavigationEvent) {
        findNavController().navigate(event.navId, event.navigationArguments)
    }
}