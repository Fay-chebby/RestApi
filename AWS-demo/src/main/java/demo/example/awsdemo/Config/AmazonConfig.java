package demo.example.awsdemo.Config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonConfig {
    @Bean
    public AmazonS3 s3(){
        AWSCredentials awsCredentials=new BasicAWSCredentials(
                accessKey:"addfghuu77",
        secretKey:"nbbbb"
        );
        AmazonS3ClientBuilder standard = AmazonS3ClientBuilder.standard()
        .withCredentials(new AWSCredentialsProvider(awsCredentials));
        return standard
        .build();
    }
}
