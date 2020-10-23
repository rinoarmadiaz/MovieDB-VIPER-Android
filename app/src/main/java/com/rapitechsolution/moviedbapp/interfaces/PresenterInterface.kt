package com.rapitechsolution.moviedbapp.interfaces

import androidx.appcompat.app.AppCompatActivity

interface PresenterInterface {
    fun onResume()
    fun onCreate(activity: AppCompatActivity)
    fun onDestroy()
}