package ftptest

import org.jft.FtpInbound
import org.springframework.integration.support.MessageBuilder
import org.springframework.integration.Message;

class FtpFileTransferService {

    def ftpChannel
    def outFtpChannel

    def download() {

        Message<?> message1 = ftpChannel.receive();
        return message1.getPayload()
    }

    def upload(File[] files) {
        String response = " "
        files.each {
            final Message<File> messageA = MessageBuilder.withPayload(it).build();
            response += "${messageA.getPayload()} : ${outFtpChannel.send(messageA) ? "Transfered successfully" : "failed"}<br>"
        }
        return response
    }

}
