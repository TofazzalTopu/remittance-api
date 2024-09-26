package com.rms.api.service.impl.common;

import com.rms.api.config.ApiRequestHolder;
import com.rms.api.repository.CommonRepository;
import com.rms.api.service.common.CommonService;
import com.rms.api.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

@Service
@Transactional
public class CommonServiceImpl implements CommonService {

    public static final Logger logger = LoggerFactory.getLogger(CommonServiceImpl.class);

    @Autowired
    private CommonRepository commonRepository;


    @Override
    public Map<String, String> getAccountBranchInfo(String accountNo) {
        return commonRepository.getAccountBranchInfo(accountNo);
    }

    public Date getCurrentBusinessDate() {
        Timestamp date = commonRepository.getCurrentBusinessDate();
        return DateUtil.convertTimestampToCalendar(date).getTime();
    }

    @Override
    public boolean isAuthorizedRequest(String userId, String password) {
        boolean result = false;
        try {
            if (ApiRequestHolder.isLocal()) {
                result = true;
            } else {
                result = commonRepository.isUserExistByUserIdAndPassword(userId, password);
            }
        } catch (Exception e) {
            logger.error("Error in isAuthorizedRequest: Error = " + e);
        }

        return result;
    }

    @Override
    public void verifyAuthorization(String userId, String password) {
        if (!isAuthorizedRequest(userId, password)) {
            throw new RuntimeException("User is not authorised to proceed the request!.");
        }
    }

}
