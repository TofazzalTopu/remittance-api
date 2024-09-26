package com.rms.api.controller;

import com.rms.api.model.ApiResponse;
import com.rms.api.service.common.CommonService;
import com.rms.api.service.instantCash.ICPaymentReceiveService;
import com.rms.api.service.instantCash.ICRetrievePaymentStatusService;
import com.rms.api.service.instantCash.ICUnlockRemittanceService;
import com.rms.api.util.ApiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

import static com.rms.api.util.Constants.*;

@CrossOrigin
@RestController
@RequestMapping("/instantCash")
public class InstantCashController {

    @Autowired
    private ICPaymentReceiveService icPaymentReceiveService;

    @Autowired
    private ICRetrievePaymentStatusService icRetrievePaymentStatusService;
    @Autowired
    private ICUnlockRemittanceService icUnlockRemittanceService;

    @Autowired
    private CommonService commonService;

    @GetMapping(value = "/receive-payment")
    public ResponseEntity<ApiResponse> receivePayment(@RequestHeader @NotNull String userId, @RequestHeader @NotNull String password, @RequestParam @NotNull String reference) {
        commonService.verifyAuthorization(userId, password);
        return ResponseEntity.ok().body(new ApiResponse<>(HttpStatus.OK.value(), PAYMENT_RECEIVE_SUCCESSFULLY, icPaymentReceiveService.paymentReceive(ApiUtil.getICExchangeProperties(), reference)));
    }

    @GetMapping(value = "/status")
    public ResponseEntity<ApiResponse> retrievePaymentStatus(@RequestHeader @NotNull String userId, @RequestHeader @NotNull String password, @RequestParam @NotNull String reference) {
        commonService.verifyAuthorization(userId, password);
        return ResponseEntity.ok().body(new ApiResponse<>(HttpStatus.OK.value(), STATUS_RETRIEVE_SUCCESSFULLY, icRetrievePaymentStatusService.retrievePaymentStatus(reference, ApiUtil.getICExchangeProperties())));
    }

    @PostMapping(value = "/unlock")
    public ResponseEntity<ApiResponse> unlockRemittance(@RequestHeader @NotNull String userId, @RequestHeader @NotNull String password, @RequestBody @NotNull String reference) {
        commonService.verifyAuthorization(userId, password);
        return ResponseEntity.ok().body(new ApiResponse<>(HttpStatus.OK.value(), PAYMENT_UNLOCK_SUCCESSFULLY, icUnlockRemittanceService.unlockICOutstandingRemittance(reference, ApiUtil.getICExchangeProperties())));
    }

}
