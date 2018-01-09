package service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

import entity.CustomerOrder;
import service.capi.EmailService;

@Component
public class DefaultEmailService implements EmailService {

	@Autowired
	public JavaMailSender emailSender;

	@Autowired
	VelocityEngine velocityEngine;

	@Override
	public void sendOrderStatusChangeEmail(CustomerOrder order) {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo("pitbulldoche@gmail.com");
				message.setSubject("Order Status change");

				Map model = new HashMap();
				model.put("order", order);
				model.put("customer", order.getCustomerId());
				String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
						"velocity/emails/orderStatusChange.vm", model);
				message.setText(text, true);
			}
		};

		emailSender.send(preparator);
	}

}