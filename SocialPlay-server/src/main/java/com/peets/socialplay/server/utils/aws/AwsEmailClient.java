package com.peets.socialplay.server.utils.aws;

import java.io.IOException;
import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;

public class AwsEmailClient {
    static final String FROM = "";  // enter the system mailbox to send activation email here
    
    static final String AWS_ACCESS_KEY="";	// enter the key of the associated AWS account
    static final String AWS_SECRET_KEY="";	// enter the key secret here
  

    public static boolean sendEmail(String toAddress, String subject, String body) throws IOException {    	
                
        // Construct an object to contain the recipient address.
        Destination destination = new Destination().withToAddresses(toAddress);
        
        // Create the subject and body of the message.
        Content contentSubject = new Content().withData(subject);
        Content textBody = new Content().withData(body); 
        Body contentBody = new Body().withText(textBody);
        
        // Create a message with the specified subject and body.
        Message message = new Message().withSubject(contentSubject).withBody(contentBody);
        
        // Assemble the email.
        SendEmailRequest request = new SendEmailRequest().withSource(FROM).withDestination(destination).withMessage(message);
        
        try
        {        
            System.out.println("Attempting to send an email through Amazon SES by using the AWS SDK for Java...");
        
            BasicAWSCredentials awsCreds = new BasicAWSCredentials(AWS_ACCESS_KEY, AWS_SECRET_KEY);
            AmazonSimpleEmailServiceClient client = new AmazonSimpleEmailServiceClient(awsCreds);
               
            // Choose the AWS region of the Amazon SES endpoint you want to connect to. Note that your production 
            // access status, sending limits, and Amazon SES identity-related settings are specific to a given 
            // AWS region, so be sure to select an AWS region in which you set up Amazon SES. Here, we are using 
            // the US East (N. Virginia) region. Examples of other regions that Amazon SES supports are US_WEST_2 
            // and EU_WEST_1. For a complete list, see http://docs.aws.amazon.com/ses/latest/DeveloperGuide/regions.html 
            Region REGION = Region.getRegion(Regions.US_EAST_1);
            client.setRegion(REGION);
       
            // Send the email.
            client.sendEmail(request);  
            System.out.println("Email sent!");
            
            return true;
        }
        catch (Exception ex) 
        {
            System.out.println("The email was not sent.");
            System.out.println("Error message: " + ex.getMessage());
            
            return false;
        }
    }
}
