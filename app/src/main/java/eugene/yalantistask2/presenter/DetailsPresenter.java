package eugene.yalantistask2.presenter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import eugene.yalantistask2.R;
import eugene.yalantistask2.utils.adapters.ImageAdapter;
import eugene.yalantistask2.view.activities.DetailsActivity;

/**
 * Presenter for DetailsActivity.
 */
public class DetailsPresenter {

    private DetailsActivity mView;


    /**
     * Constructor of PresenterMain.
     *
     * @param view MainActivity attach to PresenterMain.
     */
    public DetailsPresenter(DetailsActivity view) {
        mView = view;
    }


    public void detachView() {
        mView = null;
    }


    /**
     * Recycler view initialization.
     * Recycler view contents photos witch represents form arrays.xml,
     * photo_links parameter
     */
    public void recyclerViewInit() {

        String[] photoLinks = mView.getResources().getStringArray(R.array.photo_links);

        LinearLayoutManager layoutManager = new LinearLayoutManager(mView,
                RecyclerView.HORIZONTAL, false);

        RecyclerView recyclerView = (RecyclerView) mView.findViewById(R.id.rvPhotos);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new ImageAdapter(photoLinks, mView));
    }


    /**
     * Set back button to the activity.
     */
    public void setBackButton() {

        // set back button to action bar
        if (mView.getSupportActionBar() != null) {
            mView.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}
