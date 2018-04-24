package com.example.topcolleguesbackend.controller;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.topcolleguesbackend.entite.AjoutCollegue;
import com.example.topcolleguesbackend.entite.Collegue;
import com.example.topcolleguesbackend.entite.Vote;
import com.example.topcolleguesbackend.repository.CollegueRepository;
import com.example.topcolleguesbackend.service.CollegueService;

import coml.example.topcolleguesbackend.utils.JsonReader;

@CrossOrigin
@RestController
@RequestMapping("/collegues")
public class CollegueController {

	@Autowired
	private CollegueRepository collegueRepository;

	@GetMapping
	public List<Collegue> listerCollegues() {
		return this.collegueRepository.findAll();
	}

	@PatchMapping("/{nomCollegue}")
	public Collegue updateAvis(@PathVariable(value = "nomCollegue") String pseudoCollegue, @RequestBody Vote vote) {

		Collegue collegue = new Collegue();

		if (collegueRepository.existsByPseudo(pseudoCollegue)) {

			collegue = this.collegueRepository.findByPseudo(pseudoCollegue);

			collegue.setScore(collegue.getScore() + CollegueService.getResultat(vote.getAction()));

		}

		collegueRepository.save(collegue);

		return collegue;

	}

	// TODO ajouter erreur
	@GetMapping("/{nomCollegue}")
	public Collegue getCollegue(@PathVariable(value = "nomCollegue") String pseudoCollegue) {

		Collegue collegue = new Collegue();

		if (collegueRepository.existsByPseudo(pseudoCollegue)) {
			collegue = collegueRepository.findByPseudo(pseudoCollegue);

		}

		return collegue;

	}

	@PostMapping("/ajouter")
	public AjoutCollegue sendCollegue(@RequestBody AjoutCollegue ajoutCollegue) throws IOException, JSONException {
		AjoutCollegue ac = new AjoutCollegue();
		ac.setMatricule(ajoutCollegue.getMatricule());
		ac.setPseudo(ajoutCollegue.getPseudo());
		ac.setUrl(ajoutCollegue.getUrl());

		Collegue collegue = new Collegue();

		collegue = JsonReader.getSingleCollegueFromJson(
				"http://collegues-api.cleverapps.io/collegues?matricule=" + ajoutCollegue.getMatricule());
		collegue.setPseudo(ajoutCollegue.getPseudo());
		if (collegue.getNom() != null) {

		collegueRepository.save(collegue);

		}


		return ac;

	}
}
