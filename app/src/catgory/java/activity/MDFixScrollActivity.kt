package activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import com.demo.swt.mystudyappshop.R
import fragment.EmptyFragment
import kotlinx.android.synthetic.main.md_fix_scroll_activity.*


/**
 * 介绍：这里写介绍
 * 作者：sunwentao
 * 邮箱：wentao.sun@yintech.cn
 * 时间: 3/5/18
 */
class MDFixScrollActivity : AppCompatActivity() {
    var fragmentlist = arrayListOf<Fragment>()
    private val mTitles = arrayOf("社团介绍", "活动", "讨论区")
    private var imgList: MutableList<Any>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.md_fix_scroll_activity)
        initView()
    }


    private fun initView() {

        for (i in 1..3) {
            var fragment = EmptyFragment()
            fragmentlist.add(fragment)
        }

        vp_club_main.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment {
                return fragmentlist.get(position)
            }

            override fun getCount(): Int {
                return fragmentlist.size
            }

            override fun getPageTitle(position: Int): CharSequence {
                return mTitles.get(position)
            }

        }
        tab_layout_club_main.setupWithViewPager(vp_club_main)
    }
}