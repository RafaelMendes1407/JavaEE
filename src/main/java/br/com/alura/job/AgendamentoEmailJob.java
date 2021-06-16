package br.com.alura.job;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

import br.com.alura.servico.AgendamentoEmailServico;

@Singleton
public class AgendamentoEmailJob {

//	private static AgendamentoEmailJob instance;
//	
//	private AgendamentoEmailJob() {}
//	
//	public synchronized static AgendamentoEmailJob getInstance() {
//		if(instance == null) {
//			instance = new AgendamentoEmailJob();
//		}
//		return instance;
//	}

	@Inject
	private AgendamentoEmailServico agendamentoEmailServico;

	@Inject
	@JMSConnectionFactory("java:jboss/DefaultJMSConnectionFactory")
	private JMSContext context;

	@Resource(mappedName = "java:/jms/queue/EmailQueue")
	private Queue queue;

	@Schedule(hour = "*", minute = "*", second = "*/10")
	public void enviarEmail() {
		var emails = agendamentoEmailServico.listarporNaoAgendado();
		emails.forEach(emailNaoEnviado -> {
			context.createProducer().send(queue, emailNaoEnviado);
			agendamentoEmailServico.alterar(emailNaoEnviado);
		});
	}

}
