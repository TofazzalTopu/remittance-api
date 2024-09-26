package com.rms.api.service.impl.common;

import com.rms.api.entity.RemittanceProcessMaster;
import com.rms.api.repository.RemittanceDataRepository;
import com.rms.api.repository.RemittanceProcessMasterRepository;
import com.rms.api.service.common.RemittanceProcessMasterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemittanceProcessMasterServiceImpl implements RemittanceProcessMasterService {

    private static final Logger logger = LoggerFactory.getLogger(RemittanceProcessMasterServiceImpl.class);

    @Autowired
    private RemittanceProcessMasterRepository remittanceProcessMasterRepository;

    @Override
    public RemittanceProcessMaster save(RemittanceProcessMaster master) {
        return remittanceProcessMasterRepository.save(master);
    }


}
