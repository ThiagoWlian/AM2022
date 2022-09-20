package com.amye.AMEY.DTO.JSONCONVERT;

import com.amye.AMEY.MODEL.ExperienciaModel;
import com.amye.AMEY.MODEL.FormacoesModel;
import com.amye.AMEY.MODEL.HabilidadeModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
	private ArrayList<ExperienciaProfissionalDto> workExperience;
	private ArrayList<Education> education;
	private ArrayList<Skills> skills;
	private String profession;
	
	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public ArrayList<Education> getEducation() {
		return education;
	}

	public void setEducation(ArrayList<Education> education) {
		this.education = education;
	}

	public ArrayList<ExperienciaProfissionalDto> getWorkExperience() {
		return workExperience;
	}

	public void setWorkExperience(ArrayList<ExperienciaProfissionalDto> workExperience) {
		this.workExperience = workExperience;
	}

	public ArrayList<Skills> getSkills() {
		return skills;
	}

	public void setSkills(ArrayList<Skills> skills) {
		this.skills = skills;
	}

	public List<HabilidadeModel> converteParaHabilidadesModel() {
		return skills.stream().map(e -> new HabilidadeModel(e.getName())).collect(Collectors.toList());
	}

	public List<FormacoesModel> converteParaFormacoesModel() {
		return education.stream().map(e -> new FormacoesModel(e)).collect(Collectors.toList());
	}

	public List<ExperienciaModel> converteParaExperienciaModel() {
		return workExperience.stream().map(e -> new ExperienciaModel(e)).collect(Collectors.toList());
	}
}
