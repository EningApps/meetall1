package meetall.com.meetall1;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "notes")
@EntityListeners(AuditingEntityListener.class)

public class Note implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String username;

    @NotBlank
    private String randomkey;

    private String vkid;

    private String facebookid;

    private String instlogin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getVkid() {
        return vkid;
    }

    public void setVkid(String vkid) {
        this.vkid = vkid;
    }

    public String getFacebookid() {
        return facebookid;
    }

    public void setFacebookid(String facebookid) {
        this.facebookid = facebookid;
    }

    public String getInstlogin() {
        return instlogin;
    }

    public void setInstlogin(String instlogin) {
        this.instlogin = instlogin;
    }

    public String getRandomkey() {
        return randomkey;
    }

    public void setRandomkey(String randomkey) {
        this.randomkey = randomkey;
    }
}