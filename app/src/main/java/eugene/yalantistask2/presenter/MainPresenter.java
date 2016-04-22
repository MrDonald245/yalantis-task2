package eugene.yalantistask2.presenter;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;

import eugene.yalantistask2.R;
import eugene.yalantistask2.utils.adapters.ViewPagerAdapter;
import eugene.yalantistask2.utils.listeners.ToolbarNavigationOnClickListener;
import eugene.yalantistask2.view.activities.MainActivity;
import eugene.yalantistask2.view.fragments.DoneFragment;
import eugene.yalantistask2.view.fragments.InWorkFragment;
import eugene.yalantistask2.view.fragments.NotDoneFragment;

/**
 * Presenter for main activity
 */
public class MainPresenter {

    private MainActivity mView;


    /**
     * Constructor of PresenterMain.
     *
     * @param view MainActivity attach to PresenterMain.
     */
    public MainPresenter(MainActivity view) {
        mView = view;
    }


    public void detachView() {
        mView = null;
    }


    /**
     * Setup adapter to ViewPager
     */
    public ViewPagerAdapter getViewPagerAdapter() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(mView.getSupportFragmentManager());
        adapter.addFragment(new InWorkFragment(), mView.getResources().getString(R.string.tab_in_work));
        adapter.addFragment(new DoneFragment(), mView.getResources().getString(R.string.tab_done));
        adapter.addFragment(new NotDoneFragment(), mView.getResources().getString(R.string.tab_not_done));

        return adapter;
    }


    /**
     * Create and setup ActionBarDrawerToggle
     *
     * @return Created ActionBarDrawerToggle
     */
    public ActionBarDrawerToggle createActionBarDrawerToggle(
            DrawerLayout drawerLayout, Toolbar toolbar) {

        // Create toggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                mView,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        toggle.setDrawerIndicatorEnabled(false); // disable default icon for NavigationView
        // in toolbar to set custom one
        // Set custom icon
        toggle.setHomeAsUpIndicator(R.drawable.ic_menu);

        // Click Listener for navigation toolbar
        toggle.setToolbarNavigationClickListener(
                new ToolbarNavigationOnClickListener(drawerLayout));

        // Synchronize the state of the drawer indicator/affordance with the linked DrawerLayout
        toggle.syncState();

        return toggle;
    }
}