package dev.cacassiano.prontuario_api.entitys;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "doctor")
@Table(name = "doctor")
@Getter
@Setter
public class Doctor {
    
    @Id @Column(name = "user_id", nullable = false, unique = true)
    private String user_id;

    @OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user_Id;

    @Column(name = "specializations", nullable = false)
    private String[] specializations;
    
    @Column(name = "crm", nullable = false, unique=true)
    private String crm;

}
