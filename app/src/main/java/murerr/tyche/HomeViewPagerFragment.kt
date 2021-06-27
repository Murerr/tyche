/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import murerr.tyche.R
import murerr.tyche.adapters.*
import murerr.tyche.databinding.FragmentViewPagerBinding


class HomeViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        val tabLayout = binding.tabs
        val viewPager = binding.viewPager

        viewPager.adapter = TychePagerAdapter(this)

        // Set the icon and text for each tab
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.setIcon(getTabIcon(position))
            tab.text = getTabTitle(position)
        }.attach()

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

        return binding.root
    }

   private fun getTabIcon(position: Int): Int {
        return when (position) {
            CURRENCY_PAGE_INDEX -> R.drawable.garden_tab_selector
            DISTANCE_PAGE_INDEX -> R.drawable.plant_list_tab_selector
            SPEED_PAGE_INDEX -> R.drawable.plant_list_tab_selector
            TEMPERATURE_PAGE_INDEX -> R.drawable.plant_list_tab_selector
            else -> throw IndexOutOfBoundsException()
        }
   }

    private fun getTabTitle(position: Int): String? {
        return when (position) {
            CURRENCY_PAGE_INDEX -> getString(R.string.currency_title)
            DISTANCE_PAGE_INDEX -> getString(R.string.distance_title)
            SPEED_PAGE_INDEX -> getString(R.string.speed_title)
            TEMPERATURE_PAGE_INDEX -> getString(R.string.temperature_title)
            else -> null
        }
    }
}
