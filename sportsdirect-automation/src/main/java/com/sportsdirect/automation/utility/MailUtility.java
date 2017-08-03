package com.sportsdirect.automation.utility;

import javax.mail.*;
import java.util.Properties;

public class MailUtility {

    public static String result;

    public static String retrieveRecoveryLink(String host, String storeType, String user, String password) {
        try {
            Thread.sleep(10000); //canceling delay, it takes time till pop3 finds new mail
            Properties properties = new Properties();

            properties.put("mail.pop3.host", host);
            properties.put("mail.pop3.port", "995");
            properties.put("mail.pop3.starttls.enable", "true");
            Session emailSession = Session.getDefaultInstance(properties);

            Store store = emailSession.getStore("pop3s");
            store.connect(host, user, password);

            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            Message[] messages = emailFolder.getMessages();
            System.out.println("messages.length---" + messages.length);

            for (int i = 0, n = messages.length; i < n; i++) {
                Message message = messages[i];
                Multipart mp = (Multipart) message.getContent();
                for (int j = 0; j < mp.getCount(); j++) {
                    BodyPart bodyPart = mp.getBodyPart(j);
                    if (bodyPart.isMimeType("text/*")) {
                        String s = (String) bodyPart.getContent();
                        if (s.contains("href")) {
                            result = s.substring(s.indexOf("'") + 1, s.indexOf("'>"));
                        }
                    }
                }
            }
            emailFolder.close(false);
            store.close();

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
