package kma.online_exam.models;
// Generated Oct 9, 2020 11:19:13 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Dethi generated by hbm2java
 */
@Entity
@Table(name="dethi"
    ,catalog="onlineexam"
)
public class Dethi  implements java.io.Serializable {


     private int id;
     private int de;
     private Set<DethiCauhoi> dethiCauhois = new HashSet<DethiCauhoi>(0);
     private Set<DethiLop> dethiLops = new HashSet<DethiLop>(0);
     private Set<Ketqua> ketquas = new HashSet<Ketqua>(0);
     private Date endtime;
     private int kho;
     private Monhoc monhoc;
     private String name;
     private Nhanvien nhanvien;
     private boolean random;
     private Date starttime;
     private int tb;
     private int time;
     private int tong;
     private boolean type;

    public Dethi() {
    }

	
    public Dethi(int de, int kho, Monhoc monhoc, String name, Nhanvien nhanvien, boolean random, int tb, int time, int tong, boolean type) {
        this.de = de;
        this.kho = kho;
        this.monhoc = monhoc;
        this.name = name;
        this.nhanvien = nhanvien;
        this.random = random;
        this.tb = tb;
        this.time = time;
        this.tong = tong;
        this.type = type;
    }
    public Dethi(int de, Set<DethiCauhoi> dethiCauhois, Set<DethiLop> dethiLops, Date endtime, int kho, Monhoc monhoc, String name, Nhanvien nhanvien, boolean random, Date starttime, int tb, int time, int tong, boolean type) {
       this.de = de;
       this.dethiCauhois = dethiCauhois;
       this.dethiLops = dethiLops;
       this.endtime = endtime;
       this.kho = kho;
       this.monhoc = monhoc;
       this.name = name;
       this.nhanvien = nhanvien;
       this.random = random;
       this.starttime = starttime;
       this.tb = tb;
       this.time = time;
       this.tong = tong;
       this.type = type;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="de", nullable=false)
    public int getDe() {
        return this.de;
    }
    
    public void setDe(int de) {
        this.de = de;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="dethi")
    public Set<DethiCauhoi> getDethiCauhois() {
        return this.dethiCauhois;
    }
    
    public void setDethiCauhois(Set<DethiCauhoi> dethiCauhois) {
        this.dethiCauhois = dethiCauhois;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="dethi")
    public Set<DethiLop> getDethiLops() {
        return this.dethiLops;
    }
    
    public void setDethiLops(Set<DethiLop> dethiLops) {
        this.dethiLops = dethiLops;
    }
    
@OneToMany(fetch=FetchType.LAZY, mappedBy="dethi")
    public Set<Ketqua> getKetquas() {
        return this.ketquas;
    }
    
    public void setKetquas(Set<Ketqua> ketquas) {
        this.ketquas = ketquas;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="endtime", length=23)
    public Date getEndtime() {
        return this.endtime;
    }
    
    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    
    @Column(name="kho", nullable=false)
    public int getKho() {
        return this.kho;
    }
    
    public void setKho(int kho) {
        this.kho = kho;
    }

@ManyToOne()
    @JoinColumn(name="idmon", nullable=false)
    public Monhoc getMonhoc() {
        return this.monhoc;
    }
    
    public void setMonhoc(Monhoc monhoc) {
        this.monhoc = monhoc;
    }

    
    @Column(name="name", nullable=false)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

@ManyToOne()
    @JoinColumn(name="usernameGV", nullable=false)
    public Nhanvien getNhanvien() {
        return this.nhanvien;
    }
    
    public void setNhanvien(Nhanvien nhanvien) {
        this.nhanvien = nhanvien;
    }

    
    @Column(name="random", nullable=false)
    public boolean isRandom() {
        return this.random;
    }
    
    public void setRandom(boolean random) {
        this.random = random;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="starttime", length=23)
    public Date getStarttime() {
        return this.starttime;
    }
    
    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    
    @Column(name="tb", nullable=false)
    public int getTb() {
        return this.tb;
    }
    
    public void setTb(int tb) {
        this.tb = tb;
    }

    
    @Column(name="time", nullable=false)
    public int getTime() {
        return this.time;
    }
    
    public void setTime(int time) {
        this.time = time;
    }

    
    @Column(name="tong", nullable=false)
    public int getTong() {
        return this.tong;
    }
    
    public void setTong(int tong) {
        this.tong = tong;
    }

    
    @Column(name="type", nullable=false)
    public boolean isType() {
        return this.type;
    }
    
    public void setType(boolean type) {
        this.type = type;
    }




}


