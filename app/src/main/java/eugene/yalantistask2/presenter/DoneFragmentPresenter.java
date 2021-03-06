package eugene.yalantistask2.presenter;


import java.util.Arrays;
import java.util.List;

import eugene.yalantistask2.model.DebtIssue;
import eugene.yalantistask2.model.DismantlingIssue;
import eugene.yalantistask2.model.Issue;
import eugene.yalantistask2.view.fragments.DoneFragment;

/**
 * Presenter for DoneFragment.
 */
public class DoneFragmentPresenter {

    private DoneFragment mView;

    /**
     * Constructor of DoneFragmentPresenter.
     *
     * @param view DoneFragment attach to PresenterMain.
     */
    public DoneFragmentPresenter(DoneFragment view) {
        mView = view;
    }


    public void detachView() {
        mView = null;
    }

    public List<Issue> getIssues() {
        Issue[] issues = new Issue[]{
                new DismantlingIssue(43, 20, "14.06.2015", "Вул. Вадима Гетьмана, 42"),
                new DebtIssue(43, 19, "15.06.2015", "Вул. Вадима Гетьмана, 42"),
                new DebtIssue(43, 19, "15.06.2015", "Вул. Вадима Гетьмана, 42"),
                new DebtIssue(43, 19, "15.06.2015", "Вул. Вадима Гетьмана, 42"),
                new DebtIssue(43, 19, "15.06.2015", "Вул. Вадима Гетьмана, 42")
        };

        return Arrays.asList(issues);
    }
}
