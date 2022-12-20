package com.example.myapplication.util.navigation

import androidx.lifecycle.ViewModel

open class NavigationViewModel : ViewModel() {
    /**
     * Live Data that handles passing Navigation Events
     */
    val navigationLiveDataField = LiveNavigationField<Navigation.NavigationEvent>()
    /**
     * Helper function for navigating to the [destination] fragment from the current one
     */
    fun navigateTo(destination: Navigation.NavigationDestination) {
        navigationLiveDataField.latestValue = destination.buildEvent()
    }
}