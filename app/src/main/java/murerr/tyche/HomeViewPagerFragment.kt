import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
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
            tab.text = getTabTitle(position);
        }.attach()

        //viewPager.registerOnPageChangeCallback(TabLayoutOnPageChangeListener(tabLayout))

        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val tabEditText = getTabEditText(tab.position, viewPager) // ?: throw Exception("Could not find EditText")
                if (tabEditText != null){
                    tabEditText.requestFocus()
                    showKeyboard()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                val tabEditText = getTabEditText(tab.position, viewPager) //?: throw Exception("Could not find EditText")
                if (tabEditText != null) {
                    tabEditText.clearFocus()
                    hideKeyboard(tabEditText)
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                val tabEditText = getTabEditText(tab.position, viewPager) // ?: throw Exception("Could not find EditText")
                if (tabEditText != null){
                    tabEditText.requestFocus()
                    showKeyboard()
                }
            }
        })

        return binding.root
    }

   private fun getTabIcon(position: Int): Int {
        return when (position) {
            CURRENCY_PAGE_INDEX -> R.drawable.currency_tab_selector
            DISTANCE_PAGE_INDEX -> R.drawable.distance_tab_selector
            SPEED_PAGE_INDEX -> R.drawable.speed_tab_selector
            TEMPERATURE_PAGE_INDEX -> R.drawable.temperature_tab_selector
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

    private fun getTabEditText(position: Int, viewPager: ViewPager2): EditText? {
        val tab = viewPager.findViewWithTag("tab$position") as ViewGroup? ?: return null
        return when (position) {
            CURRENCY_PAGE_INDEX -> {
                null //tab.findViewById(R.id.editTextDistance)
            }
            DISTANCE_PAGE_INDEX -> {
                tab.findViewById(R.id.editTextDistance)
            }
            SPEED_PAGE_INDEX -> {
                null //tab.findViewById(R.id.editTextDistance)
            }
            TEMPERATURE_PAGE_INDEX -> {
                null //tab.findViewById(R.id.editTextDistance)
            }
            else -> null
        }
    }

    private fun showKeyboard(){
        val inputMethodManager = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
    }

    private fun hideKeyboard(editText: EditText){
        val imm = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(editText.windowToken, 0)
    }
}
