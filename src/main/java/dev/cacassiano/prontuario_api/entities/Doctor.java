package dev.cacassiano.prontuario_api.entities;

import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "doctor")
@Table(name = "doctor")
@Getter
@Setter
@NoArgsConstructor
public class Doctor {
    
    @Id @Column(name = "user_id", nullable = false, unique = true)
    private UUID user_id;

    @OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user_Id;

    public User getUser() {
        return user_Id;
    }
    public void setUser(User user) {
        this.user_Id = user;
    }

    @Column(name = "specializations", nullable = false)
    private String[] specialtys;
    
    @Column(name = "crm", nullable = false, unique=true)
    private String crm;

}
