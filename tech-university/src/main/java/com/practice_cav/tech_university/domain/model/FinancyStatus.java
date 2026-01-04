package com.practice_cav.tech_university.domain.model;

public class FinancyStatus {

    private boolean hasDebt;
    private String externalCheckId;

    public FinancyStatus() {
    }

    public FinancyStatus(boolean hasDebt, String externalCheckId) {
        this.hasDebt = hasDebt;
        this.externalCheckId = externalCheckId;
    }

    public boolean isHasDebt() {
        return hasDebt;
    }

    public void setHasDebt(boolean hasDebt) {
        this.hasDebt = hasDebt;
    }

    public String getExternalCheckId() {
        return externalCheckId;
    }

    public void setExternalCheckId(String externalCheckId) {
        this.externalCheckId = externalCheckId;
    }
}
