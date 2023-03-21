package dc.icdc.msnotificationservice.dto;

import lombok.Data;


/**
 * Created by mfarial on 3/20/2023 10:46 AM
 */

@Data
public class NotificationRequest {
    private String id;
    private String fromAddress;
    private String toAddress;
    private String ccAddress;
    private String subject;
    private String body;
    private String attachment;
}
