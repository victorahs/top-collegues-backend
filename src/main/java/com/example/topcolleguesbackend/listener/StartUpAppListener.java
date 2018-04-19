package com.example.topcolleguesbackend.listener;

import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.example.topcolleguesbackend.entite.Collegue;
import com.example.topcolleguesbackend.repository.CollegueRepository;

/**
 * @author Emmanuel
 *
 */
@Component
public class StartUpAppListener {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	CollegueRepository collegueRepository;

	@EventListener(ContextRefreshedEvent.class)
	@Transactional
	public void contextRefreshedEvent() {
		// capture du démarrage de l'application
		// à un moment où le contexte Spring est complètement créé

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("configWeb.xml");

		Stream.of(Collegue.class).flatMap(classe -> context.getBeansOfType(classe).values().stream())
				.forEach(em::persist);
		context.close();

	}
}
