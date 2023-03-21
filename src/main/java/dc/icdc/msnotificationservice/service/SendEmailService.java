package dc.icdc.msnotificationservice.service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.*;
import dc.icdc.msnotificationservice.dto.NotificationRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


/**
 * Created by mfarial on 3/20/2023 10:46 AM
 */

@Service
public class SendEmailService {
    @Value("${aws.access.key.id}")
    private String AWS_ACCESS_KEY_ID;

    @Value("${aws.access.key.id}")
    private String AWS_SECRET_ACCESS_KEY;
    private final String REGION = Regions.AP_SOUTHEAST_1.getName();

    public void sendEmail(NotificationRequest notificationRequest) {
        // Set up the AWS credentials
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(AWS_ACCESS_KEY_ID, AWS_SECRET_ACCESS_KEY);

        // Create an Amazon SES client
        AmazonSimpleEmailService client = AmazonSimpleEmailServiceClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .withRegion(Regions.fromName(REGION))
                .build();

        // Create the email request
        SendEmailRequest request = new SendEmailRequest()
                .withDestination(new Destination().withToAddresses(notificationRequest.getToAddress()).withCcAddresses(notificationRequest.getCcAddress()))
                .withMessage(new Message()
                        .withBody(new Body().withHtml(new Content().withCharset("UTF-8").withData(notificationRequest.getBody())))
                        .withSubject(new Content().withCharset("UTF-8").withData(notificationRequest.getSubject())))
                .withSource(notificationRequest.getFromAddress());

        // Send the email
        SendEmailResult result = client.sendEmail(request);
        System.out.println("Email sent to " + notificationRequest.getToAddress() + " with message ID " + result.getMessageId());
    }

}
