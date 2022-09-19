package com.amye.AMEY.DTO.JSONCONVERT;

import java.util.ArrayList;

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
}
