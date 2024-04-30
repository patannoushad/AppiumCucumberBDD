package com.qa.utils;


import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

    public class EmailUtils {
        public static void sendEmailWithAttachment(String to) {

            // Sender's email ID needs to be mentioned
            String from = "patannoushad1998@gmail.com";
            String password = "zkebobjlvldeewyu";

            // Assuming you are sending email from localhost
            String host = "smtp.gmail.com"; // Use appropriate SMTP server

            // Get system properties
            Properties properties = System.getProperties();

            // Setup mail server
            properties.setProperty("mail.smtp.host", host);
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.ssl.enable","true");
            properties.put("mail.smtp.port", "465"); // Use appropriate port

            // Get the default Session object
            Session session = Session.getInstance(properties, new jakarta.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, password);
                }
            });

            try {
                // Create a default MimeMessage object
                MimeMessage message = new MimeMessage(session);

                // Set From: header field of the header
                message.setFrom(new InternetAddress(from));

                // Set To: header field of the header
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

                String subject = "Automated Test Case Report for ABC - "+CommonUtils.dateTime();

                // Set Subject: header field
                message.setSubject(subject);

                // Create the message part
                BodyPart messageBodyPart = new MimeBodyPart();

                String body = "Hello Good day, Please find attached the automated test case report for eatOS POS conducted on "+ CommonUtils.dateTime() +". " +
                        "The report includes detailed analysis and results of the automated tests performed.";

                // Now set the actual message
                messageBodyPart.setText(body);

                // Create a multipart message
                Multipart multipart = new MimeMultipart();

                // Set text message part
                multipart.addBodyPart(messageBodyPart);


                String attachmentPath = PropertyManager.getProperty("attachmentPath");

                // Part two is attachment
//                messageBodyPart = new MimeBodyPart();
//                DataSource source = new FileDataSource(attachmentPath);
//                messageBodyPart.setDataHandler(new DataHandler(source));
//                messageBodyPart.setFileName("AutomationPdf");

                MimeBodyPart fileMime = new MimeBodyPart();
                File file = new File(System.getProperty("user.dir")+"\\test-output\\PdfReport\\AutomationPdf.pdf");
                fileMime.attachFile(file);

                multipart.addBodyPart(fileMime);

                // Send the complete message parts
                message.setContent(multipart);

                // Send message
                Transport.send(message);
                System.out.println("Sent message successfully....");
            } catch (MessagingException mex) {
                mex.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }


