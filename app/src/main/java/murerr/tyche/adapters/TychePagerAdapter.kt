package murerr.tyche.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import murerr.tyche.CurrencyFragment
import murerr.tyche.DistanceFragment

const val CURRENCY_PAGE_INDEX = 0
const val DISTANCE_PAGE_INDEX = 1

class TychePagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    /**
     * Mapping of the ViewPager page indexes to their respective Fragments
     */
    private val tabFragmentsCreators: Map<Int, () -> Fragment> = mapOf(
        CURRENCY_PAGE_INDEX to { CurrencyFragment() },
        DISTANCE_PAGE_INDEX to { DistanceFragment() }
    )

    override fun getItemCount() = tabFragmentsCreators.size

    override fun createFragment(position: Int): Fragment {
        return tabFragmentsCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}