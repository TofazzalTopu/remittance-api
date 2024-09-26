package com.rms.api.service.common;

import java.util.Date;
import java.util.Map;

public interface CommonService {

    Map<String, String> getAccountBranchInfo(String accountNo);
    Date getCurrentBusinessDate();

    boolean isAuthorizedRequest(String userId, String password);
    void verifyAuthorization(String userId, String password);
}
