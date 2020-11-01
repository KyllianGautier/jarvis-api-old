package jarvisapi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserDevice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch= FetchType.LAZY)
    private UserSecurity userSecurity;

    @Column(name = "public_ip")
    private String publicIp;

    @Column(name = "type")
    private String type;

    @Column(name = "authorized")
    private boolean authorized = false;

    @OneToOne(cascade = CascadeType.ALL)
    public SingleUseToken verificationToken;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userDevice", fetch = FetchType.LAZY)
    private List<DeviceConnection> connections;

    public UserDevice(String publicIp, String type) {
        this.publicIp = publicIp;
        this.type = type;
    }
}
