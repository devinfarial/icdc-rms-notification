package dc.icdc.msnotificationservice.controller;

import dc.icdc.msnotificationservice.dto.BaseResponse;
import dc.icdc.msnotificationservice.dto.NotificationRequest;
import dc.icdc.msnotificationservice.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by mfarial on 3/20/2023 10:46 AM
 */

@RestController
@RequestMapping("notifications/v1.0")
public class MainController {

    @Autowired
    SendEmailService sendEmailService;

    @PostMapping
    public ResponseEntity<BaseResponse> sendEmail(@RequestBody NotificationRequest request){

        return ResponseEntity.ok(null);
    }

}
