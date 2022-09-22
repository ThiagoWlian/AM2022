package com.amye.AMEY.DTO.JSONCONVERT;

public class Education {

    private String organization;
    private String education;
    private DatasFormacao dates;

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public DatasFormacao getDatas() {
        return dates;
    }

    public void setDatas(DatasFormacao datas) {
        this.dates = datas;
    }
}
