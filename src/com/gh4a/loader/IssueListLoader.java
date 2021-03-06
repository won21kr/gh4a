package com.gh4a.loader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.eclipse.egit.github.core.Issue;
import org.eclipse.egit.github.core.service.IssueService;

import android.content.Context;

import com.gh4a.Gh4Application;

public class IssueListLoader extends BaseLoader<List<Issue>> {

    private String mLogin, mRepo;
    private Map<String, String> mFilterData;

    public IssueListLoader(Context context, String login, String repo,
            Map<String, String> filterData) {
        super(context);
        this.mLogin = login;
        this.mRepo = repo;
        this.mFilterData = filterData;
    }

    @Override
    public List<Issue> doLoadInBackground() throws IOException {
        IssueService issueService = (IssueService)
                Gh4Application.get(getContext()).getService(Gh4Application.ISSUE_SERVICE);
        return issueService.getIssues(mLogin, mRepo, mFilterData);
    }
}
