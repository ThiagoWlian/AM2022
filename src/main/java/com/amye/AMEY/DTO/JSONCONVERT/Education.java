package com.amye.AMEY.DTO.JSONCONVERT;

public class Education {

    private String organization;
    private Accreditation accreditation;
    private DatasFormacao dates;

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public DatasFormacao getDatas() {
        return dates;
    }

    public void setDatas(DatasFormacao datas) {
        this.dates = datas;
    }

    public Accreditation getAccreditation() {
        return accreditation;
    }

    public void setAccreditation(Accreditation accreditation) {
        this.accreditation = accreditation;
    }
}
