package com.amye.AMEY.DTO.JSONCONVERT;

import com.amye.AMEY.DTO.JSONCONVERT.DatasExperienciaDto;

public class ExperienciaProfissionalDto {
	
    private String id;
    private String jobTitle;
    private String organization;

	private String jobDescription;
    private DatasExperienciaDto dates;

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public DatasExperienciaDto getDates() {
		return dates;
	}

	public void setDates(DatasExperienciaDto dates) {
		this.dates = dates;
	}
}
