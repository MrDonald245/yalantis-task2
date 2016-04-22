package eugene.yalantistask2.presenter;

import java.util.Arrays;
import java.util.List;

import eugene.yalantistask2.model.DebtIssue;
import eugene.yalantistask2.model.DismantlingIssue;
import eugene.yalantistask2.model.Issue;
import eugene.yalantistask2.model.LiftIssue;
import eugene.yalantistask2.model.SanitaryIssue;
import eugene.yalantistask2.view.fragments.InWorkFragment;

/**
 * Presenter for InWorkFragment.
 */
public class InWorkFragmentPresenter {
    private InWorkFragment mView;

    /**
     * Constructor of DoneFragmentPresenter.
     *
     * @param view DoneFragment attach to PresenterMain.
     */
    public InWorkFragmentPresenter(InWorkFragment view) {
        mView = view;
    }


    public void detachView() {
        mView = null;
    }


    public List<Issue> getIssues() {
        Issue[] issues = new Issue[]{
                new DismantlingIssue(43, 14, "21.06.2015", "Вул. Вадима Гетьмана, 42"),
                new DebtIssue(43, 14, "21.06.2015", "Вул. Вадима Гетьмана, 42"),
                new LiftIssue(43, 14, "21.06.2015", "Вул. Вадима Гетьмана, 42"),
                new SanitaryIssue(43, 14, "21.06.2015", "Вул. Вадима Гетьмана, 42")
        };

        return Arrays.asList(issues);
    }

}
