package dc.icdc.msnotificationservice.dto;

import lombok.Data;

/**
 * Created by mfarial on 3/20/2023 10:46 AM
 */

@Data
public class BaseResponse {
    private String errorCode;
    private String errorMessage;
}
