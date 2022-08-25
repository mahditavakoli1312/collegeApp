package com.example.fragment_test

import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit

class FragmentTransaction {
    companion object {
        fun replaceFragment(
            fragment: Fragment,
            supportFragmentManager: FragmentManager,
            fragmentHolderId: Int
        ) {
            supportFragmentManager.commit {
                replace(fragmentHolderId, fragment)
            }
        }

        fun addFragment(
            fragment: Fragment,
            supportFragmentManager: FragmentManager,
            fragmentHolderId: Int
        ) {
            supportFragmentManager.commit {
                add(fragmentHolderId, fragment)
            }
        }

        fun replaceFragmentWithAddToBackStack(
            fragment: Fragment,
            supportFragmentManager: FragmentManager,
            fragmentHolderId: Int,
            backStackName: String? = null
        ) {
            supportFragmentManager.commit {
                replace(fragmentHolderId, fragment)
                addToBackStack(backStackName)
            }
        }

        fun addFragmentWithAddToBackStack(
            fragment: Fragment,
            supportFragmentManager: FragmentManager,
            fragmentHolderId: Int,
            backStackName: String? = null
        ) {
            supportFragmentManager.commit {
                replace(fragmentHolderId, fragment)
                addToBackStack(backStackName)

            }
        }
    }
}