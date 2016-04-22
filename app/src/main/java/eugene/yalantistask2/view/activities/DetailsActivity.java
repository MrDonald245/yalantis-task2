package eugene.yalantistask2.view.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import eugene.yalantistask2.R;
import eugene.yalantistask2.presenter.DetailsPresenter;

public class DetailsActivity extends AppCompatActivity {

    private DetailsPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Attach activity to presenter
        mPresenter = new DetailsPresenter(this);

        mPresenter.setBackButton();
        mPresenter.recyclerViewInit();
    }

    /**
     * Close an activity when was clicked back button
     *
     * @param item which invoke this event
     * @return boolean
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Detach view from Presenter before activity will be destroyed.
     */
    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }

    /**
     * Click listener for any element on the screen,
     * to show a toast.
     */
    public void onShowToast(View view) {

        String caption = view.getClass().getSimpleName();

        Toast.makeText(this, caption, Toast.LENGTH_SHORT).show();
    }
}

