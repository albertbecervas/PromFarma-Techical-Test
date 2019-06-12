package com.abecerra.technicaltestpromofarma.app.base

import android.support.v7.app.AppCompatActivity
import android.view.View
import com.abecerra.technicaltestpromofarma.R
import com.abecerra.technicaltestpromofarma.app.navigator.Navigator
import com.abecerra.technicaltestpromofarma.app.utils.AppSharedPreferences
import com.abecerra.technicaltestpromofarma.app.utils.extensions.toast
import kotlinx.android.synthetic.main.layout_loading.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

abstract class BaseActivity : AppCompatActivity() {
    protected val navigator: Navigator by inject { parametersOf(this) }
    protected val mPrefs: AppSharedPreferences by inject()

    protected fun showLoading() {
        loading?.visibility = View.VISIBLE
    }

    protected fun hideLoading() {
        loading?.visibility = View.GONE

    }

    protected fun showError(error: String?) {
        hideLoading()
        error?.let {
            toast(it)
        } ?: kotlin.run {
            toast(error ?: getString(R.string.general_error))
        }
    }

    companion object {
        const val PICK_FROM_CAMERA = 1438
        const val PICK_FROM_GALLERY = 1439
    }
}
