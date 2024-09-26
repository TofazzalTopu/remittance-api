package com.rms.api.service.impl.common;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.transaction.Transactional;

import com.rms.api.service.common.ApiTraceService;
import com.rms.api.service.common.RemittanceDataService;
import com.rms.api.service.common.RemittanceProcessMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.api.entity.RemittanceData;
import com.rms.api.entity.RemittanceProcessMaster;
import com.rms.api.entity.StopRemittanceData;
import com.rms.api.repository.CommonRepository;
import com.rms.api.repository.StopRemittanceDataRepository;

@Service
public class RemittanceDataProcessServiceImpl {

    @Autowired
    private CommonRepository commonRepository;

    @Autowired
    private ApiTraceService apiTraceService;

    @Autowired
    private RemittanceProcessMasterService remittanceProcessMasterService;

    @Autowired
    private RemittanceDataService remittanceDataService;

    @Autowired
    private StopRemittanceDataRepository stopRemittanceDataRepository;


//    @Transactional
    public List<RemittanceData> processDownloadData(List<RemittanceData> remittanceDataList, String exchangeCode, String exchangeName) {
        List<RemittanceData> remittanceDataArrayList = new ArrayList<>();
        if (!remittanceDataList.isEmpty()) {
            RemittanceProcessMaster master = null;
            RemittanceProcessMaster masterRecord = commonRepository.getRemitProcMasterByApiData(remittanceDataList.get(0).getProcessDate(),
                    exchangeCode, 1, "OPEN");

            if (masterRecord != null) {
                master = masterRecord;
            }
            long eftCount = remittanceDataList.stream().filter(d -> d.getRemittanceMessageType().equals("EFT")).count();
            long beftnCount = remittanceDataList.stream().filter(d -> d.getRemittanceMessageType().equals("BEFTN")).count();
            long mobileCount = remittanceDataList.stream().filter(d -> d.getRemittanceMessageType().equals("MOBILE")).count();

            if (master == null) {
                master = new RemittanceProcessMaster();
                master.setCommon(true);
                master.setExchangeHouseCode(exchangeCode);
                master.setFileName(exchangeName);
                master.setApiData(1);
                master.setManualOpen(0);
                master.setProcessByUser("CBSRMS");
                master.setProcessDate(remittanceDataList.get(0).getProcessDate());
                master.setProcessStatus("OPEN");
                master.setTotalBeftn(beftnCount);
                master.setTotalEft(eftCount);
                master.setTotalMobile(mobileCount);
                master.setTotalSpot(0);
                master.setTotalWeb(0);
            } else {
                master.setTotalBeftn(master.getTotalBeftn() + beftnCount);
                master.setTotalEft(master.getTotalEft() + eftCount);
                master.setTotalMobile(master.getTotalMobile() + mobileCount);
            }
            master = remittanceProcessMasterService.save(master);

            for (RemittanceData data : remittanceDataList) {
                data.setRemittanceProcessMaster(master);
            }
            long time = System.currentTimeMillis();
            System.out.println("Saving started...");
            remittanceDataArrayList = remittanceDataService.saveAll(remittanceDataList);
            long milis = System.currentTimeMillis() - time;
            System.out.println("Total Time: " + TimeUnit.MILLISECONDS.toSeconds(milis));
        }
        return remittanceDataArrayList;
    }

    @Transactional
    public void processCancelData(List<StopRemittanceData> listData) {
        for (StopRemittanceData stopRemittanceData : listData) {

            RemittanceData remittanceData = null;

            List<RemittanceData> remDataList = commonRepository.getRemittancebyReference(
                    stopRemittanceData.getReferenceNo(), stopRemittanceData.getExchangeCode());
            if (remDataList != null && !remDataList.isEmpty()) {
                if (remDataList.size() == 1) {
                    remittanceData = remDataList.get(0);
                } else {

                    for (RemittanceData data : remDataList) {
                        if (data.getProcessStatus() != null && (data.getProcessStatus().equals(RemittanceData.POSTED)
                                || data.getProcessStatus().equals(RemittanceData.COMPLETED))) {
                            remittanceData = data;
                            break;
                        }
                    }
                    if (remittanceData == null) {
                        for (RemittanceData data : remDataList) {
                            if (data.getProcessStatus() != null && (data.getProcessStatus().equals(RemittanceData.VALID)
                                    || data.getProcessStatus().equals(RemittanceData.OPEN))) {
                                remittanceData = data;
                                break;
                            }
                        }
                    }

                    if (remittanceData == null) {
                        for (RemittanceData data : remDataList) {
                            if (data.getProcessStatus() != null
                                    && (data.getProcessStatus().equals(RemittanceData.INVALID))) {
                                if (!data.getReasonForInvalid().equals("Reference already exist")) {
                                    remittanceData = data;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if (remittanceData == null) {
                stopRemittanceData.setProcessStatus(StopRemittanceData.REJECT_REQUEST);
                stopRemittanceData.setMessage("No Records Found!");
                stopRemittanceData.setExchangeStatus(StopRemittanceData.REJECT_NOT_FOUND);
            } else if (remittanceData.getProcessStatus().equals(RemittanceData.POSTED)
                    || remittanceData.getProcessStatus().equals(RemittanceData.COMPLETED)) {
                stopRemittanceData.setProcessStatus(StopRemittanceData.REJECT_REQUEST);
                stopRemittanceData.setMessage("Can't be Stopped.Record already processed.");
                stopRemittanceData.setExchangeStatus(StopRemittanceData.REJECT_ALREADY_PAID);
            } else {
                remittanceData.setReturnedMsg(1);
                remittanceData.setReturnedDate(apiTraceService.getCurrentBusinessDate());
                remittanceData.setReturnedBy("REM_API");
                remittanceData.setStopPayReason("Stopped through API");
                remittanceData.setFinalStatus("20"); // MESSAGE_RETURN
                remittanceData.setProcessStatus(RemittanceData.COMPLETED);
                remittanceDataService.save(remittanceData);

                stopRemittanceData.setProcessStatus(StopRemittanceData.ACCEPT_REQUEST);
            }
            stopRemittanceDataRepository.save(stopRemittanceData);
        }
    }

    @Transactional
    public void updateCancelData(StopRemittanceData data) {
        stopRemittanceDataRepository.save(data);
    }

    @Transactional
    public void updateRemittanceData(RemittanceData data) {
        remittanceDataService.save(data);
    }

    @Transactional
    public List<RemittanceData> saveAll(List<RemittanceData> remittanceDataList){
        return remittanceDataService.saveAll(remittanceDataList);
    }



}
