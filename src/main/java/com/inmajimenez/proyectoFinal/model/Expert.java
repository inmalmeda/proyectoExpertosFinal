package com.inmajimenez.proyectoFinal.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "experts")
public class Expert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Clave primaria tipo Long")
    private Long id;

    @ApiModelProperty("Nombre completo del experto")
    private String name;

    @ApiModelProperty("Fecha de creación de la etiqueta")
    private LocalDate created_at;

    @ApiModelProperty("Fecha de modificación de la etiqueta")
    private LocalDate updated_at;

    @Column(name="state_reason")
    @ApiModelProperty("Estado del motivo de descarte")
    private String stateReason;

    @ApiModelProperty("Disponibilidad del experto")
    private String availability;

    @ApiModelProperty("Modalidad del experto")
    private String modality;

    @ApiModelProperty("Experto autónomo true/false")
    private Boolean freelance;

    @Column(name="contact_phone")
    @ApiModelProperty("Teléfono de contacto")
    private String contactPhone;

    @Column(name="contact_email")
    @ApiModelProperty("Email de contacto")
    private String contactEmail;

    @Column(name="contact_town")
    @ApiModelProperty("Ciudad del contacto")
    private String contactTown;

    @Column(name="contact_linkedin")
    @ApiModelProperty("Linkedin del experto")
    private String contactLinkedin;

    @Column(name="conditions_percentage")
    @ApiModelProperty("Porcentaje de condiciones")
    private String conditionsPercentage;

    @Column(name="conditions_price")
    @ApiModelProperty("Condición de precio por hora")
    private String conditionsPrice;

    @ApiModelProperty("Puntuación del experto")
    private Integer score;

    @ApiModelProperty("NIF del experto")
    private String nif;

    @Column(name="credentials_email")
    @ApiModelProperty("Credenciales del correo")
    private String credentialsEmail;

    @Column(name="credentials_email_password")
    @ApiModelProperty("Contraseña del correo")
    private String credentialsEmailPassword;

    @Column(name="credentials_zoom")
    @ApiModelProperty("Credenciales de zoom")
    private String credentialsZoom;

    @Column(name="credentials_zoom_password")
    @ApiModelProperty("Contraseña de zoom")
    private String credentialsZoomPassword;

    @Column(name="file_photo")
    @ApiModelProperty("Ruta del fichero de la fotografía")
    private String filePhoto;

    @Column(name="file_cv")
    @ApiModelProperty("Ruta del fichero del curriculum")
    private String fileCv;

    @ApiModelProperty("Observaciones sobre el experto")
    private String observations;

    @ApiModelProperty("Origen")
    private String origin;

    @ApiModelProperty("Estado del experto")
    private String state;

    public Expert() {
    }

    public Expert(Long id, String name, LocalDate created_at, LocalDate updated_at, String stateReason,
                  String availability, String modality, Boolean freelance, String contactPhone, String contactEmail,
                  String contactTown, String contactLinkedin, String conditionsPercentage, String conditionsPrice,
                  Integer score, String nif, String credentialsEmail, String credentialsEmailPassword, String credentialsZoom,
                  String credentialsZoomPassword, String filePhoto, String fileCv, String observations, String origin,
                  String state) {
        this.id = id;
        this.name = name;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.stateReason = stateReason;
        this.availability = availability;
        this.modality = modality;
        this.freelance = freelance;
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
        this.contactTown = contactTown;
        this.contactLinkedin = contactLinkedin;
        this.conditionsPercentage = conditionsPercentage;
        this.conditionsPrice = conditionsPrice;
        this.score = score;
        this.nif = nif;
        this.credentialsEmail = credentialsEmail;
        this.credentialsEmailPassword = credentialsEmailPassword;
        this.credentialsZoom = credentialsZoom;
        this.credentialsZoomPassword = credentialsZoomPassword;
        this.filePhoto = filePhoto;
        this.fileCv = fileCv;
        this.observations = observations;
        this.origin = origin;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public LocalDate getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDate updated_at) {
        this.updated_at = updated_at;
    }

    public String getStateReason() {
        return stateReason;
    }

    public void setStateReason(String stateReason) {
        this.stateReason = stateReason;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getModality() {
        return modality;
    }

    public void setModality(String modality) {
        this.modality = modality;
    }

    public Boolean getFreelance() {
        return freelance;
    }

    public void setFreelance(Boolean freelance) {
        this.freelance = freelance;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactTown() {
        return contactTown;
    }

    public void setContactTown(String contactTown) {
        this.contactTown = contactTown;
    }

    public String getContactLinkedin() {
        return contactLinkedin;
    }

    public void setContactLinkedin(String contactLinkedin) {
        this.contactLinkedin = contactLinkedin;
    }

    public String getConditionsPercentage() {
        return conditionsPercentage;
    }

    public void setConditionsPercentage(String conditionsPercentage) {
        this.conditionsPercentage = conditionsPercentage;
    }

    public String getConditionsPrice() {
        return conditionsPrice;
    }

    public void setConditionsPrice(String conditionsPrice) {
        this.conditionsPrice = conditionsPrice;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getCredentialsEmail() {
        return credentialsEmail;
    }

    public void setCredentialsEmail(String credentialsEmail) {
        this.credentialsEmail = credentialsEmail;
    }

    public String getCredentialsEmailPassword() {
        return credentialsEmailPassword;
    }

    public void setCredentialsEmailPassword(String credentialsEmailPassword) {
        this.credentialsEmailPassword = credentialsEmailPassword;
    }

    public String getCredentialsZoom() {
        return credentialsZoom;
    }

    public void setCredentialsZoom(String credentialsZoom) {
        this.credentialsZoom = credentialsZoom;
    }

    public String getCredentialsZoomPassword() {
        return credentialsZoomPassword;
    }

    public void setCredentialsZoomPassword(String credentialsZoomPassword) {
        this.credentialsZoomPassword = credentialsZoomPassword;
    }

    public String getFilePhoto() {
        return filePhoto;
    }

    public void setFilePhoto(String filePhoto) {
        this.filePhoto = filePhoto;
    }

    public String getFileCv() {
        return fileCv;
    }

    public void setFileCv(String fileCv) {
        this.fileCv = fileCv;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Expert{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", stateReason='" + stateReason + '\'' +
                ", availability='" + availability + '\'' +
                ", modality='" + modality + '\'' +
                ", freelance=" + freelance +
                ", contactPhone='" + contactPhone + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", contactTown='" + contactTown + '\'' +
                ", contactLinkedin='" + contactLinkedin + '\'' +
                ", conditionsPercentage='" + conditionsPercentage + '\'' +
                ", conditionsPrice='" + conditionsPrice + '\'' +
                ", score=" + score +
                ", nif='" + nif + '\'' +
                ", credentialsEmail='" + credentialsEmail + '\'' +
                ", credentialsEmailPassword='" + credentialsEmailPassword + '\'' +
                ", credentialsZoom='" + credentialsZoom + '\'' +
                ", credentialsZoomPassword='" + credentialsZoomPassword + '\'' +
                ", filePhoto='" + filePhoto + '\'' +
                ", fileCv='" + fileCv + '\'' +
                ", observations='" + observations + '\'' +
                ", origin='" + origin + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
